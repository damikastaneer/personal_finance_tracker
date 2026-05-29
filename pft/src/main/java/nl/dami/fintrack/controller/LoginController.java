package nl.dami.fintrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
