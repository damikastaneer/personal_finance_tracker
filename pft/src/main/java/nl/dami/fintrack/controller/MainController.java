package nl.dami.fintrack.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.dami.fintrack.model.Transaction;
import nl.dami.fintrack.util.SceneManager;
import nl.dami.fintrack.service.TransactionService;

import java.util.List;

public class MainController {
    private final TransactionService transactionService = new TransactionService();

    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String> dateColumn;
    @FXML private TableColumn<Transaction, String> typeColumn;
    @FXML private TableColumn<Transaction, String> categoryColumn;
    @FXML private TableColumn<Transaction, Double> amountColumn;
    @FXML private TableColumn<Transaction, String> descriptionColumn;


    @FXML
    private void goToAddTransaction(){
        SceneManager.switchTo("/fxml/add-transaction-view.fxml");
    }

    @FXML
    public void initialize() {

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );

        typeColumn.setCellValueFactory(
                new PropertyValueFactory<>("type")
        );

        categoryColumn.setCellValueFactory(
                new PropertyValueFactory<>("category")
        );

        amountColumn.setCellValueFactory(
                new PropertyValueFactory<>("amount")
        );

        descriptionColumn.setCellValueFactory(
                new PropertyValueFactory<>("description")
        );

        loadTransactions();
    }

    private void loadTransactions() {

        List<Transaction> transactions =
                transactionService.getCurrentUserTransactions();

        transactionTable.setItems(
                FXCollections.observableArrayList(transactions)
        );
    }
}
