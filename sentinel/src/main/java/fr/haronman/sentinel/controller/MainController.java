package fr.haronman.sentinel.controller;

import java.io.File;
import java.io.IOException;

import fr.haronman.sentinel.FichierUtils;
import fr.haronman.sentinel.model.MotDePasse;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
    @FXML
    public Button openMDP;
    @FXML
    public Button newMDP;
    @FXML
    public Button editMDP;
    @FXML
    public Button deleteMDP;

    @FXML
    public TableView table;
    @FXML
    private TableColumn<MotDePasse, String> titre;
    @FXML
    private TableColumn<MotDePasse, String> login;
    @FXML
    private TableColumn<MotDePasse, String> mdp;
    @FXML
    private TableColumn<MotDePasse, String> url;
    @FXML
    private TableColumn<MotDePasse, String> note;

    // Si un fichier est ouvert
    public boolean file;

    @FXML
    private void initialize() {
        file = false;
        updateBoutons();

        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        url.setCellValueFactory(new PropertyValueFactory<>("url"));
        note.setCellValueFactory(new PropertyValueFactory<>("note"));
    }

    public void openFile() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Ouvrir un fichier");

        // Ouverture sur Documents par défaut
        fc.setInitialDirectory(new File(System.getProperty("user.home"), "Documents"));

        // Uniquement les JSONs (A MODIFIER PLUS TARD)
        FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("JSON (*.json)", "*.json");
        fc.getExtensionFilters().add(ext);

        File fichier = fc.showOpenDialog(openMDP.getScene().getWindow());
        if (fichier != null) {
            file = true;
            updateBoutons();
            
            // Lecture fichier
            ObservableList<MotDePasse> mdps = FichierUtils.getMdpsFromFichier(fichier);
            table.setItems(mdps);
        }
    }

    public void newEntry() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/new_entry.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Nouvelle Entrée");
        stage.setScene(new Scene(root));

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void editEntry() {
        System.out.println("TODO Editer Entree");
    }

    public void deleteEntry() {
        System.out.println("TODO Supprimer Entree");
    }

    private void updateBoutons() {
        newMDP.setDisable(!file);
        editMDP.setDisable(!file);
        deleteMDP.setDisable(!file);
    }
}
