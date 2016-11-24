package controlers;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import constants.Constants;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class UserController {

    private String styles = getClass().getResource("../layouts/style.css").toExternalForm();
    private ArrayList<NotesComponents> listOfNotes = new ArrayList<NotesComponents>();
    private int rowIndex;

    @FXML
    private Button add_btn;

    @FXML
    private Button logOut_btn;

    @FXML
    private GridPane user1Grid;

    @FXML
    private Label infoLabel;

    @FXML
    private void handleAddButtonAction(ActionEvent event) throws IOException{

        if (event.getSource() == add_btn) {
            try {
                rowIndex = getRowIndex(listOfNotes);
            } catch (Exception e) {
                infoLabel.setText(e.getMessage());
                return;
            }
            Stage stage = (Stage) add_btn.getScene().getWindow();
            Parent root = stage.getScene().getRoot();
            Scene scene = root.getScene();
            scene.getStylesheets().add(styles);

            NotesComponents notesComponents = new NotesComponents();
            listOfNotes.add(notesComponents);

            user1Grid.add(notesComponents.getNote(),0,rowIndex,3,1);
            user1Grid.add(notesComponents.getSaveBtn(),3,rowIndex);
            user1Grid.add(notesComponents.getEditBtn(),4,rowIndex);
            user1Grid.add(notesComponents.getDeleteBtn(),5,rowIndex);
            user1Grid.setGridLinesVisible(true);
        }
    }

    @FXML
    private void handleLogOutButtonAction(ActionEvent event) throws IOException{
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == logOut_btn) {
            //get reference to the button's stage
            stage = (Stage) logOut_btn.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("../layouts/loginLayout.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void hoverStyleForButtons(ActionEvent event) throws IOException{
        System.out.println("something");
        FadeTransition ft = new FadeTransition(Duration.millis(3000));
        ft.setNode(add_btn);
        ft.setFromValue(1.0);
        ft.setToValue(0.2);
        ft.play();
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


}