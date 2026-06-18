package nl.dami.fintrack.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage stage;

    public static void setStage(Stage primaryStage){
        stage = primaryStage;
    }

    public static void switchTo(String fxmlPath){
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
