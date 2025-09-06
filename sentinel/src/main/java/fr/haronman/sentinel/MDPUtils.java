package fr.haronman.sentinel;

import java.util.Random;

public class MDPUtils {

    public static final String CARACTERES_MDP = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:'\\\",.<>?/`~" ;

    /**
     * Permet, a partir d'une longueur donné, de générer un mot de passe
     * @param longueur
     * @return Mot de passe généré
     */
    public static String generateMDP(int longueur) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < longueur; i++) {
            sb.append(
                CARACTERES_MDP.charAt(
                    r.nextInt(CARACTERES_MDP.length())
                )  
            );
        }

        return sb.toString();
    }

    /**
     * /**
     * Récupère un mot de passe et renvoie la mesure de son incertitude
     * @param mdp Mot de passe
     * @return Entropie du mot de passe
     */
    private int entropie(String mdp) {
        // TODO Entropie : log2(R**l)
        return 0;
    }
    
}
