package nl.dami.fintrack.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.dami.fintrack.database.DatabaseManager;
import nl.dami.fintrack.util.SceneManager;


public class MainApplication extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        DatabaseManager.initializeDatabase();

        FXMLLoader fxmlLoader = new FXMLLoader(
                MainApplication.class.getResource("/fxml/login-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("FinTrack");
        stage.setScene(scene);
        SceneManager.setStage(stage);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
