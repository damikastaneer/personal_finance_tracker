package nl.dami.fintrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nl.dami.fintrack.service.AuthService;
import nl.dami.fintrack.util.SceneManager;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    private final AuthService authService = new AuthService();

    @FXML
    public void handleLogin(){

        boolean succes = authService.login(
            emailField.getText(),
            passwordField.getText()
        );

        if (succes){
            messageLabel.setText("Logged in successfully.");
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
