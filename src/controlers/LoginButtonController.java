package controlers;

import constants.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.Map;

public class LoginButtonController {

    private String user;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @FXML
    private Label infoLabelLogin;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, AuthenticationException {
        Stage stage = null;
        Parent root = null;
        String result = null;
        String user = userName.getText();
        String pass = password.getText();
        if (event.getSource() == login_btn) {
            stage = (Stage) login_btn.getScene().getWindow();
            result = authentication(user, pass);
//            if(Constants.FAILED_LOGIN_RESPONSE.equals(user)){
//                infoLabelLogin.setText(Constants.FAILED_LOGIN_RESPONSE);
//            } else{
//                result = authentication(user, password);
//            }
            root = FXMLLoader.load(getClass().getResource("../layouts/"+result+"Layout.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private String authentication(String userName, String password){
        for(Map.Entry<String, String> map: Constants.usersMap.entrySet()){
            if((userName.equals(map.getKey())) && (password.equals(map.getValue()))){
                return userName;
            }
        }
        return Constants.FAILED_LOGIN_RESPONSE;
    }
}
