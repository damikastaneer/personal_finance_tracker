package nl.dami.fintrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nl.dami.fintrack.service.AuthService;

public class RegisterController {
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label messageLabel;

    private final AuthService authService = new AuthService();

    @FXML
    public void handleRegister(){
        boolean succes = authService.register(
                firstNameField.getText(),
                lastNameField.getText(),
                usernameField.getText(),
                emailField.getText(),
                passwordField.getText(),
                confirmPasswordField.getText()
        );

        if (succes){
            messageLabel.setText("Account created successfully.");
        } else {
            messageLabel.setText("Registration failed. Check your input.");
        }
    }
}
