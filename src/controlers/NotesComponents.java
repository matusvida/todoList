package controlers;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * Created by Matus on 24.11.2016.
 */
public class NotesComponents {

    private TextArea note;
    private Button editBtn;
    private Button saveBtn;
    private Button deleteBtn;

    public NotesComponents(){
        note = createNote();
        editBtn = createButton("EDIT");
        saveBtn = createButton("SAVE");
        deleteBtn = createButton("DELETE");
    }
    private final TextArea createNote() {
        TextArea textArea = new TextArea();
        return textArea;
    }

    private final Button createButton(String text){
        return new Button(text);
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
}
