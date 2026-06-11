package nl.dami.fintrack.controller;

import javafx.fxml.FXML;
import nl.dami.fintrack.util.SceneManager;

public class MainController {
    @FXML
    private void goToAddTransaction(){
        SceneManager.switchTo("/fxml/add-transaction-view.fxml");
    }
}
