package nl.dami.fintrack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import nl.dami.fintrack.service.TransactionService;
import nl.dami.fintrack.util.SceneManager;

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
    }

    @FXML
    private void handleSaveTransaction() {
        try {
            double amount = Double.parseDouble(amountField.getText());

            boolean success = transactionService.addTransaction(
                    amount,
                    typeComboBox.getValue(),
                    categoryComboBox.getValue(),
                    descriptionField.getText(),
                    datePicker.getValue().toString()
            );

            if (success) {
                messageLabel.setText("Transaction saved.");
                clearFields();
            } else {
                messageLabel.setText("Could not save transaction.");
            }

        } catch (Exception e) {
            messageLabel.setText("Please fill in all fields correctly.");
        }
    }

    @FXML
    private void goToDashboard() {
        SceneManager.switchTo("/fxml/main-view.fxml");
    }

    private void clearFields() {
        amountField.clear();
        typeComboBox.setValue(null);
        categoryComboBox.setValue(null);
        descriptionField.clear();
        datePicker.setValue(null);
    }
}