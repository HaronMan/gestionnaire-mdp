package fr.haronman.sentinel.controller;

import java.io.File;

import fr.haronman.sentinel.FichierUtils;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class MainController {
    
    public Button openMDP;
    public Button newMDP;
    public Button editMDP;
    public Button deleteMDP;

    public void openFile() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Ouvrir un fichier");

        // Ouverture sur Documents par défaut
        fc.setInitialDirectory(new File(System.getProperty("user.home"), "Documents"));

        FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("JSON (*.json)", "*.json");
        fc.getExtensionFilters().add(ext);

        File fichier = fc.showOpenDialog(openMDP.getScene().getWindow());
        if (fichier != null) {
            FichierUtils.getMdpsFromFichier(fichier);
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
}
