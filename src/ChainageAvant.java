import java.util.ArrayList;

public class ChainageAvant {

    /* Va-t-on utiliser cette classe ?? */
    
    /* Une base de fait + une base de règle + une base connue + les méthodes pour faire le chainage avant */

    BaseConnue baseConnue;
    BaseRegle baseRegle;

    /* --- CONSTRUCTEUR --- */
    public ChainageAvant(BaseConnue base, BaseRegle baseRegles) {
        // TODO Ecrire le constructeur
        
    }


    public void ChainageSimple () {
        int i=0;
        while (this.baseRegle.getListRegle().get(i).estApplicable(this.baseConnue) == false && i < this.baseRegle.getListRegle().size()) {
            i++;
        }
        baseConnue.addFait(this.baseRegle.getListRegle().get(i).getConclusion());
    }

    
}
