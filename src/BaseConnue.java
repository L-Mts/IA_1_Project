/**
 * Classe BaseConnue
 * 
 * Base de faits connus et vérifiés
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

import java.util.ArrayList;

public class BaseConnue {
    

    private ArrayList<Faits> faits;

    /**
     * @function Constructeur BaseConnue
     * Création d'une base avec une liste vide
     */
    public BaseConnue () {
        this.faits = new ArrayList<Faits>();
    }

    
    /**
     * @function addFait: ajout d'un fait à la base de fait
     * @param f : le fait à ajouter
     * @return : vrai si réussite, faux sinon
     */
    public boolean addFait (Faits f) {
        boolean res = false;
        if (this.faits.add(f)) res = true;
        return res;
    }

    
    /**
     * @function isTrueFait
     * @param f : un fait
     * @return : vrai si le fait est présent dans la base de faits
     *           faux si le fait n'est pas présent dans la base de faits
     */
    public boolean isTrueFait (Faits f) {
        boolean res = false;
        if (this.faits.contains(f)) res = true;
        return res;
    }




    /* Méthodes nécessaires:
     * méthode pour vérifier chaque règle
     * méthode pour ajouter un fait dans la base de fait (déjà prévue dans ArrayList)
     * 
     * Si interface graphique avec la liste des faits et la possibilité d'en ajouter dans la base connue avant de lancer l'appli:
     * méthode pour supprimer un fait de la base de fait en cas d'erreur (déjà prévue dans ArrayList)
     * 
     * 
     * Je pense que les différentes manière de parcourir la base de règle (chaînage avant, chaînage arrière, etc)
     * devraient être implémentées dans App directement (ce ne sont pour moi pas des classes, ni des méthodes particulières
     * de BaseConnue, mais leur imlémentation devra appeler des méthodes de BaseConnue)
     */
}
