package main;

import javafx.scene.Scene;
import java.util.HashMap;

/**
 * Created by Matus on 26.11.2016.
 */
public class ScreenSaver{

    private static Scene scene;
    private static HashMap<String,Scene> scenesList = new HashMap<String, Scene>();

    public static Scene getScene() {
        return scene;
    }

    public static void setScene( String username, Scene scene) {
        ScreenSaver.scene = scene;
        scenesList.put(username, scene);
    }

    public static HashMap<String, Scene> getScenesList() {
        return scenesList;
    }
}
