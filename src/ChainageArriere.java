import java.util.ArrayList;

public class ChainageArriere {

    /* Va-t-on utiliser cette classe ?? */
    
    /* Une base de fait + une base de règle + une base connue + les méthodes pour faire le chainage avant */

    BaseConnue baseConnue;
    BaseRegle baseRegle;

    /* --- CONSTRUCTEUR --- */
    public ChainageArriere(BaseConnue base, BaseRegle baseRegles) {
        this.baseConnue = base;
        this. baseRegle = baseRegles;
        
    }


    /**
     * Pour une règle & une base connues (attributs de la classe chainage arriere):
     * Vérifie que la conclusion de la règle fait partie de la base connue
     * Ajoute les faits prédicats de la règle à la base connue
     * Continue jusqu'à ce que plus aucune règle ne soit applicable à la base --> derniers faits ajoutés = faits de bases recherchés
     */
    public void ChainageSimple () {
        int i = 0;
        // tant que l'index est dans la liste de règles
        while (i < this.baseRegle.getListRegle().size()) {
            //si la conclusion est vraie & que les faits ne font pas partie des la base
            if (this.baseRegle.getListRegle().get(i).isConclusionTrue(baseConnue) && this.baseRegle.getListRegle().get(i).isTrue(this.baseConnue) == false) {
                //ajouter les faits à la base
                for (Fait f : this.baseRegle.getListRegle().get(i).getListFaits()) {
                    baseConnue.addFait(f);
                }
                //revenir à la première règle de baseRegle
                i = 0;
            } else {
                //passer à la règle suivante
                i++;
            }
        }
    }

    
}
