package nl.dami.fintrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nl.dami.fintrack.model.User;
import nl.dami.fintrack.service.AuthService;
import nl.dami.fintrack.util.SceneManager;
import nl.dami.fintrack.util.SessionManager;

public class LoginController {
    @FXML
    private TextField identifierField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    private final AuthService authService = new AuthService();


    @FXML
    private HBox windowBar;

    private double xOffset;
    private double yOffset;

    @FXML
    public void initialize() {
        windowBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        windowBar.setOnMouseDragged(event -> {
            Stage stage = (Stage) windowBar.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        windowBar.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                handleMaximize();
            }
        });
    }

    @FXML
    private void handleClose() {
        Stage stage = (Stage) windowBar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleMinimize() {
        Stage stage = (Stage) windowBar.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void handleMaximize() {
        Stage stage = (Stage) windowBar.getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }

    @FXML
    public void handleLogin(){

        User user = authService.login(identifierField.getText(), passwordField.getText());


        if (user != null){
            SessionManager.setCurrentUser(user);
            SceneManager.switchTo("/fxml/main-view.fxml");
        } else{
            messageLabel.setText("Login failed.");
        }
    }

    @FXML
    public void goToRegister(){
        SceneManager.switchTo("/fxml/register-view.fxml");
    }
}
