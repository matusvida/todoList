package controlers;

import constants.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.NotesComponents;
import main.ScreenSaver;
import java.io.IOException;
import java.util.ArrayList;

public class UserController{

    private String styles = getClass().getResource("../layouts/style.css").toExternalForm();
    private ArrayList<NotesComponents> listOfNotes = new ArrayList<NotesComponents>();
    private Scene scene;
    private Stage stage;
    private int rowIndex;
    private ScreenSaver screenSaver;

    @FXML
    private Button add_btn;

    @FXML
    private Button logOut_btn;

    @FXML
    private GridPane user1Grid;

    @FXML
    private Label infoLabel;

    @FXML
    private Label title_label;


    @FXML
    private void handleAddButtonAction(ActionEvent event) throws IOException{

        if (event.getSource() == add_btn) {
            try {
                rowIndex = getRowIndex(listOfNotes);
            } catch (Exception e) {
                infoLabel.setText(e.getMessage());
                return;
            }
            stage = (Stage) add_btn.getScene().getWindow();
            Parent root = stage.getScene().getRoot();
            scene = root.getScene();
            scene.getStylesheets().add(styles);

            NotesComponents notesComponents = new NotesComponents();

            listOfNotes.add(notesComponents);

            user1Grid.add(notesComponents.getNote(),0,rowIndex,3,1);
            user1Grid.add(notesComponents.gethBox(),3, rowIndex, 4,1);
            notesComponents.getSaveBtn().setOnAction(this::handleSaveButtonAction);
            notesComponents.getEditBtn().setOnAction(this::handleEditButtonAction);
            notesComponents.getDeleteBtn().setOnAction(this::handleDeleteButtonAction);
        }
    }

    @FXML
    private void handleLogOutButtonAction(ActionEvent event) throws IOException{
        Parent root = null;
        ScreenSaver.setScene(getLabelTextFromParent() ,stage.getScene());
        if (event.getSource() == logOut_btn) {
            stage = (Stage) logOut_btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../layouts/loginLayout.fxml"));
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        infoLabel.setText("");
        TextArea textArea = getNoteFromParent(event, 0);
        DatePicker datePicker = getDatePickerFromParent(event);
        if(textArea.getText().isEmpty()){
            infoLabel.setText(Constants.FAILED_SAVE_EMPTY_NOTE);
        } else {
            textArea.setEditable(false);
            datePicker.setEditable(false);
            datePicker.setDisable(true);
            textArea.setStyle("-fx-background-color: #7cb8ff");
        }
    }

    @FXML
    private void handleEditButtonAction(ActionEvent event){
        TextArea textArea = getNoteFromParent(event, 0);
        DatePicker datePicker = getDatePickerFromParent(event);
        textArea.setEditable(true);
        datePicker.setEditable(true);
        datePicker.setDisable(false);
        textArea.setStyle("-fx-background-color: inherit");
    }

    @FXML
    private void handleDeleteButtonAction(ActionEvent event){
        String ind = ((Control)event.getSource()).getId().substring(10);
        TextArea textArea = getNoteFromParent(event, Constants.DELETE_BUTTON_SUBSTRING_INDEX);
        HBox hBox = getHBoxFromParent(event, Constants.DELETE_BUTTON_SUBSTRING_INDEX);
        listOfNotes.removeIf(s->s.getNote().getId().contains(String.valueOf(ind)));

        user1Grid.getChildren().remove(textArea);
        user1Grid.getChildren().remove(hBox);

        System.out.println(listOfNotes);
    }


    private int getRowIndex(ArrayList<NotesComponents> listOfNotes) throws Exception{
        int rowIndex;
        if(listOfNotes.size() == 0){
            rowIndex = Constants.MIN_ROW_INDEX;
        } else if(listOfNotes.size() < Constants.MAXIMUM_NOTES) {
            rowIndex = listOfNotes.size() + Constants.MIN_ROW_INDEX;
        } else {
            throw new Exception(Constants.NUMBER_OF_NOTES_ERROR);
        }
        return rowIndex;
    }

    private TextArea getNoteFromParent(ActionEvent event, int substringIndex){
        String uid = ((Control) event.getSource()).getId().substring(8 + substringIndex);
        TextArea textArea = null;
        for(Node node: user1Grid.getChildren()){
            if((node instanceof TextArea)&&(node.getId().contains(uid))){
                textArea = (TextArea) node;
                break;
            }
        }
        return textArea;
    }

    private HBox getHBoxFromParent(ActionEvent event, int substringIndex){
        String uid = event.getSource().toString().substring(Constants.SUBSTRING_START + substringIndex, Constants.SUBSTRING_END + substringIndex);
        uid = ((Control) event.getSource()).getId().substring(8 + substringIndex);
        HBox hBox = null;
        for(Node node: user1Grid.getChildren()){
            if((node instanceof HBox)&&(node.getId().contains(uid))){
                hBox = (HBox) node;
                break;
            }
        }
        return hBox;
    }
    private DatePicker getDatePickerFromParent(ActionEvent event){
        String uid = event.getSource().toString().substring(Constants.SUBSTRING_START, Constants.SUBSTRING_END);
        uid = ((Control) event.getSource()).getId().substring(18);
        DatePicker datePicker = null;
        for(Node node: user1Grid.getChildren()){
            if((node instanceof HBox)){
                for(Node nestedNote: ((HBox) node).getChildren()){
                    if((nestedNote instanceof DatePicker)&&(nestedNote.getId().contains(uid))){
                        datePicker = (DatePicker) nestedNote;
                        return datePicker;
                    }
                }
            }
        }
        return datePicker;
    }

    private String getLabelTextFromParent(){
        for(Node node: user1Grid.getChildren()){
            if(node instanceof Label){
                return ((Label) node).getText();
            }
        }
        return null;
    }
}