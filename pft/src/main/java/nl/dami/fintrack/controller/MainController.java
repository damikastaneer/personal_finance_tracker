package nl.dami.fintrack.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import nl.dami.fintrack.model.Transaction;
import nl.dami.fintrack.util.SceneManager;
import nl.dami.fintrack.service.TransactionService;
import nl.dami.fintrack.util.SessionManager;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.List;

public class MainController {
    private final TransactionService transactionService = new TransactionService();

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private HBox windowBar;
    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String> dateColumn;
    @FXML private TableColumn<Transaction, String> typeColumn;
    @FXML private TableColumn<Transaction, String> categoryColumn;
    @FXML private TableColumn<Transaction, Double> amountColumn;
    @FXML private TableColumn<Transaction, String> descriptionColumn;
    @FXML
    private LineChart<String, Number> financialChart;


    @FXML
    private void handleClose() {
        Stage stage = (Stage) transactionTable.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleMaximize() {

        Stage stage = (Stage) windowBar.getScene().getWindow();

        stage.setMaximized(!stage.isMaximized());
    }

    @FXML
    private void handleMinimize() {
        Stage stage = (Stage) transactionTable.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void goToAddTransaction(){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/add-transaction-view.fxml")
            );

            Parent root = loader.load();

            Stage popupStage = new Stage();

            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.initModality(Modality.APPLICATION_MODAL);

            popupStage.setScene(new Scene(root));
            popupStage.setResizable(false);
            popupStage.showAndWait();

            loadTransactions();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout() {
        SessionManager.logout();
        SceneManager.switchTo("/fxml/login-view.fxml");
    }

    private void loadFinancialChart() {
        XYChart.Series<String, Number> incomeSeries = new XYChart.Series<>();
        incomeSeries.setName("Income");

        incomeSeries.getData().add(new XYChart.Data<>("Jan", 1200));
        incomeSeries.getData().add(new XYChart.Data<>("Feb", 1600));
        incomeSeries.getData().add(new XYChart.Data<>("Mar", 1400));
        incomeSeries.getData().add(new XYChart.Data<>("Apr", 2100));

        XYChart.Series<String, Number> expenseSeries = new XYChart.Series<>();
        expenseSeries.setName("Expenses");

        expenseSeries.getData().add(new XYChart.Data<>("Jan", 700));
        expenseSeries.getData().add(new XYChart.Data<>("Feb", 900));
        expenseSeries.getData().add(new XYChart.Data<>("Mar", 850));
        expenseSeries.getData().add(new XYChart.Data<>("Apr", 1100));

        financialChart.getData().clear();
        financialChart.getData().addAll(incomeSeries, expenseSeries);
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
        loadFinancialChart();

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

    private void loadTransactions() {

        List<Transaction> transactions =
                transactionService.getCurrentUserTransactions();

        transactionTable.setItems(
                FXCollections.observableArrayList(transactions)
        );
    }


}
