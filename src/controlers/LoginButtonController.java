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
import javafx.stage.Stage;
import main.ScreenSaver;

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

        String result = null;
        Scene scene = null;
        String user = userName.getText();
        String pass = password.getText();
        if (event.getSource() == login_btn) {
            stage = (Stage) login_btn.getScene().getWindow();
            result = authentication(user, pass);
            if(Constants.FAILED_LOGIN_RESPONSE.equals(result) || Constants.EMPTY_FIELDS_LOGIN_RESPONSE.equals(result)){
                infoLabelLogin.setText("");
                infoLabelLogin.setText(result);
            } else {
                scene = userSceneSelection(result);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    private String authentication(String userName, String password){
        if(userName.isEmpty() || password.isEmpty()){
            return Constants.EMPTY_FIELDS_LOGIN_RESPONSE;
        }
        for(Map.Entry<String, String> map: Constants.usersMap.entrySet()){
            if((userName.equals(map.getKey())) && (password.equals(map.getValue()))){
                return userName;
            }
        }
        return Constants.FAILED_LOGIN_RESPONSE;
    }

    private Scene userSceneSelection(String result) throws IOException {
        Parent root = null;
        Scene scene = null;
        root = FXMLLoader.load(getClass().getResource("../layouts/" + result + "Layout.fxml"));
        scene = new Scene(root);
        if(ScreenSaver.getScene()!=null) {
            for (Map.Entry<String, Scene> map : ScreenSaver.getScenesList().entrySet()) {
                String key = map.getKey().toLowerCase();
                if (key.equals(result)) {
                    root = map.getValue().getRoot();
                    scene = map.getValue();
                } else {

                }
            }
        }

        return scene;
    }
}
