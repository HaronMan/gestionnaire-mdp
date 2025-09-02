package fr.haronman.sentinel.controller;

import java.io.File;
import java.io.IOException;

import fr.haronman.sentinel.FichierUtils;
import fr.haronman.sentinel.model.MotDePasse;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

public class MainController {
    
    public Button openMDP;
    public Button newMDP;
    public Button editMDP;
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

            // Lecture fichier
            ObservableList<MotDePasse> mdps = FichierUtils.getMdpsFromFichier(fichier);
            table.setItems(mdps);
        }
    }

    public void newEntry() {
        System.out.println("TODO Nouvelle Entree");
    }

    public void editEntry() {
        System.out.println("TODO Editer Entree");
    }

    public void deleteEntry() {
        System.out.println("TODO Supprimer Entree");
    }

    @FXML
    private void initialize() {
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        url.setCellValueFactory(new PropertyValueFactory<>("url"));
        note.setCellValueFactory(new PropertyValueFactory<>("note"));
    }
}
