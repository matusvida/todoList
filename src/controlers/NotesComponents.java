package controlers;

import com.sun.javafx.css.Style;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by Matus on 24.11.2016.
 */
public class NotesComponents {

    private int index;
    private TextArea note;
    private HBox hBox;
    private DatePicker datePicker;
    private Button editBtn;
    private Button saveBtn;
    private Button deleteBtn;

    public NotesComponents(int index){
        this.index = index;
        note = createNote();
        datePicker = createDatePicker();
        editBtn = createButton("Edit", "edit_btn");
        saveBtn = createButton("Save", "save_btn");
        deleteBtn = createButton("Delete", "delete_btn");
        hBox = createHBox();
    }
    private final TextArea createNote() {
        TextArea textArea = new TextArea();
        textArea.setId("textArea"+index);
        textArea.setPrefWidth(200.0);
        textArea.setWrapText(true);
        return textArea;
    }

    private final Button createButton(String text, String name){
        Button button = new Button(text);
        button.setId(name+index);
        button.getStyleClass().add("control-buttons");
        return button;
    }

    private final DatePicker createDatePicker(){
        DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setId("datePicker"+index);
        datePicker.getStyleClass().add("date-picker");
        return datePicker;
    }

    private final HBox createHBox(){
        HBox hBox = new HBox(15.0);
        hBox.setId("hBox"+index);
        hBox.getStyleClass().add("hbox");
        hBox.getChildren().add(datePicker);
        hBox.getChildren().add(saveBtn);
        hBox.getChildren().add(editBtn);
        hBox.getChildren().add(deleteBtn);
        hBox.setMargin(datePicker, new Insets(0,20,0,-22));
        return hBox;
    }
    private boolean checkComponentsLimit(GridPane grid){
        return true;
    }

    public TextArea getNote() {
        return note;
    }

    public void setNote(TextArea note) {
        this.note = note;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public Button getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(Button editBtn) {
        this.editBtn = editBtn;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public void setSaveBtn(Button saveBtn) {
        this.saveBtn = saveBtn;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public HBox gethBox() {
        return hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }
}
