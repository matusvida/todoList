package controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginButtonController {

    @FXML
    private Button login_btn;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == login_btn) {
            //get reference to the button's stage
            stage = (Stage) login_btn.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("../layouts/user1Layout.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
