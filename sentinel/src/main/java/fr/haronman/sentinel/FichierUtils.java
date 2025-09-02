package fr.haronman.sentinel;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.haronman.sentinel.model.MotDePasse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FichierUtils {

    public static ObservableList<MotDePasse> getMdpsFromFichier(File fichier) throws IOException {
        ArrayList<MotDePasse> mdps = new ArrayList<MotDePasse>();

        // Récupération en texte du contenu du fichier puis conversion en liste
        String content = Files.readString(fichier.toPath(), StandardCharsets.UTF_8);
        JSONArray json = new JSONArray(content);
        
        // Ajout des elements dans la liste
        if (json.length() > 0) {
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                mdps.add(
                    new MotDePasse(
                        item.getString("titre"),
                        item.getString("login"),
                        item.getString("mdp"),
                        item.getString("url"),
                        item.getString("note")
                    )
                );
                System.out.println(item);
            }
        }

        return FXCollections.observableArrayList(mdps);
    }
    
}
