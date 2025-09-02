package fr.haronman.sentinel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class MotDePasse {

    private String titre;
    private String login;
    private String mdp;
    private String url;
    private String note;
    
}
