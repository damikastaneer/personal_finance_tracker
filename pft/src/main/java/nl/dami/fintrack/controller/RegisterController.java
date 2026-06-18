package nl.dami.fintrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nl.dami.fintrack.service.AuthService;
import nl.dami.fintrack.util.SceneManager;

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
            goToLogin();
        } else {
            messageLabel.setText("Registration failed. Check your input.");
        }
    }

    @FXML
    public void goToLogin(){
        SceneManager.switchTo("/fxml/login-view.fxml");
    }
}
