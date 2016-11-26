package main;

import constants.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(Constants.LAYOUT_LOGIN));
        primaryStage.setTitle("TODO List");
        primaryStage.setScene(new Scene(root, 780, 630));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
