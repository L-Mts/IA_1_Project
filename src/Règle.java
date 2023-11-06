import java.util.ArrayList;

public class Règle {
    
    int id;
    ArrayList<Faits> faits;
    Faits conclusion;

    public Règle (int id, ArrayList<Faits> faits, Faits conclusion) {
        this.id = id; 
        this.faits = faits;
        this.conclusion = conclusion;
    }

    /* Méthode pour savoir si la règle est correct ou nom */
    public boolean isTrue (BaseConnue base) {
        /* parcours la liste des faits prédicats de la règle
         * vérifie pour chacun leur présence dans la liste des faits de la base (ArrayList<>.contains(Object o))
         * si tous les faits prédicats sont dans la base : la règlé est vérifiée -> ajout de sa conclusion dans la liste + return true;
         * si un ou plsrs faits prédicats ne sont pas dans la base: la règle n'est pas vérifiée -> return false;
         */
        return false;
    }
    
}
