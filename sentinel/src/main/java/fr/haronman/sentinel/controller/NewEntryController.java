package fr.haronman.sentinel.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NewEntryController {

    public Button cancel;
    
    @FXML
    public void handleMDP() {

    }

    @FXML
    public void handleConfirmMDP() {
        
    }

    @FXML
    public void closeForm() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
