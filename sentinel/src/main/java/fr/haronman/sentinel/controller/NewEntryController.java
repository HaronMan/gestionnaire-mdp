package fr.haronman.sentinel.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;

public class NewEntryController {
    
    @FXML
    public TextField titre, login;
    @FXML
    public PasswordField mdp, confirmMdp;
    @FXML
    public TextField url;
    @FXML
    public TextArea note;

    public Label errorMDP;
    @FXML
    public Button cancel, validate;
    
    
    @FXML
    public void initialize() {
        titre.setOnKeyTyped(e -> handleValidate());
        login.setOnKeyTyped(e -> handleValidate());
        mdp.setOnKeyTyped(e -> {handleMDP(); handleValidate(); });
        confirmMdp.setOnKeyTyped(e -> {handleMDP(); handleValidate(); });
    }

    

    @FXML
    public void closeForm() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void submit() {
        // TODO Submit
    }

    
    public void handleMDP() {
        errorMDP.setVisible( !verifMdp() );
        // TODO ProgressBar
    }

    
    public void handleConfirmMDP() {
        errorMDP.setVisible( !verifMdp() );
    }


    public void handleValidate() {
        boolean verifChamps = hasText(titre) && hasText(login) && hasText(mdp) && hasText(confirmMdp);
        validate.setDisable( !(verifChamps && verifMdp()) );
    }

    private boolean verifMdp() {
        return mdp.getText().equals(confirmMdp.getText());
    }

    private boolean hasText(TextInputControl entree) {
        return entree.getText() != null && !entree.getText().trim().isEmpty();
    }
}
