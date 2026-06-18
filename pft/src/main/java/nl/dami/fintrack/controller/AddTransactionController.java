package nl.dami.fintrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nl.dami.fintrack.service.TransactionService;

public class AddTransactionController {

    @FXML
    private TextField amountField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private TextField descriptionField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label messageLabel;

    private final TransactionService transactionService = new TransactionService();

    @FXML
    private HBox windowBar;

    private double xOffset;
    private double yOffset;

    @FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Income", "Expense");

        categoryComboBox.getItems().addAll(
                "Groceries",
                "Rent",
                "Transportation",
                "Entertainment",
                "Subscriptions",
                "Healthcare",
                "Education",
                "Salary",
                "Miscellaneous"
        );

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

    private void closeWindow() {
        Stage stage = (Stage) amountField.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleSaveTransaction() {
        try {
            if (datePicker.getValue() == null) {
                messageLabel.setText("Please select a date.");
                return;
            }

            double amount = Double.parseDouble(amountField.getText());

            boolean success = transactionService.addTransaction(
                    amount,
                    typeComboBox.getValue(),
                    categoryComboBox.getValue(),
                    descriptionField.getText(),
                    datePicker.getValue().toString()
            );

            if (success) {
                closeWindow();
            } else {
                messageLabel.setText("Could not save transaction.");
            }

        } catch (Exception e) {
            messageLabel.setText("Please fill in all fields correctly.");
        }
    }

    @FXML
    private void goToDashboard() {
        Stage stage = (Stage) amountField.getScene().getWindow();
        stage.close();
    }

    private void clearFields() {
        amountField.clear();
        typeComboBox.setValue(null);
        categoryComboBox.setValue(null);
        descriptionField.clear();
        datePicker.setValue(null);
    }
}