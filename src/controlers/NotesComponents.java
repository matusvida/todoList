package controlers;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import java.rmi.server.UID;
import java.time.LocalDate;

/**
 * Created by Matus on 24.11.2016.
 */
public class NotesComponents {

    private UID uid;
    private TextArea note;
    private HBox hBox;
    private DatePicker datePicker;
    private Button editBtn;
    private Button saveBtn;
    private Button deleteBtn;

    public NotesComponents(){
        uid = createUid();
        note = createNote();
        datePicker = createDatePicker();
        editBtn = createButton("Edit", "edit_btn");
        saveBtn = createButton("Save", "save_btn");
        deleteBtn = createButton("Delete", "delete_btn");
        hBox = createHBox();
    }
    private UID createUid(){
        return new UID();
    }

    private final TextArea createNote() {
        TextArea textArea = new TextArea();
        textArea.setId("textArea"+uid);
        textArea.setPrefWidth(200.0);
        textArea.setWrapText(true);
        return textArea;
    }

    private final Button createButton(String text, String name){
        Button button = new Button(text);
        button.setId(name+uid);
        button.getStyleClass().add("control-buttons");
        return button;
    }

    private final DatePicker createDatePicker(){
        DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setId("datePicker"+uid);
        datePicker.getStyleClass().add("date-picker");
        return datePicker;
    }

    private final HBox createHBox(){

        HBox hBox = new HBox(15.0);
        hBox.setId("hBox"+uid);
        hBox.getStyleClass().add("hbox");
        hBox.getChildren().add(datePicker);
        hBox.getChildren().add(saveBtn);
        hBox.getChildren().add(editBtn);
        hBox.getChildren().add(deleteBtn);
        hBox.setMargin(datePicker, new Insets(0,20,0,-22));
        return hBox;
    }

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
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
