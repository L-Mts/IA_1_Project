import java.util.ArrayList;

public class BaseConnue {

    ArrayList<Faits> faits;

    public BaseConnue (ArrayList<Faits> faits) {
        this.faits = faits;
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
