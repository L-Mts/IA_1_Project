import java.util.ArrayList;

public class ChainageAvant {

    /* Va-t-on utiliser cette classe ?? */
    
    /* Une base de fait + une base de règle + une base connue + les méthodes pour faire le chainage avant */

    BaseConnue baseConnue;
    BaseRegle baseRegle;

    /* --- CONSTRUCTEUR --- */
    public ChainageAvant(BaseConnue base, BaseRegle baseRegles) {
       this.baseConnue=base;
       this.baseRegle=baseRegles;
    }
    /*choix de la première règle applicable */
    public void chainageSimple () {
        int i=0;
        while (!this.baseRegle.getListRegle().get(i).estApplicable(this.baseConnue) && i < this.baseRegle.getListRegle().size()) {
            i++;
        }
        baseConnue.addFait(this.baseRegle.getListRegle().get(i).getConclusion());
    }

    /* choix de la règle comportant comme prémices les faits déduits les plus récents  
     * toutes les prémices de la règle doivent être récemment déduis
     * Je récupère toutes les règles applicables 
     * Pour chaque règle je compare les indices du fait, celle dont la somme des indices est le plus correspond au fait le plus récent
    */
    public void chainageDeux(){
        ArrayList<Regle> mesResglesApplicables=new ArrayList<Regle>();
        for(Regle r: this.baseRegle.getListRegle()){
            if(r.estApplicable(baseConnue)){
                mesResglesApplicables.add(r);
            }
        }
        Regle regleLaPlusRecente= mesResglesApplicables.get(0);
        int somme=regleLaPlusRecente.sommeIndices(baseConnue);
        for(Regle r: mesResglesApplicables){
            if(r.sommeIndices(baseConnue)>somme){
                regleLaPlusRecente=r;
                somme=r.sommeIndices(baseConnue);
            }
        }
        baseConnue.addFait(regleLaPlusRecente.getConclusion());
    }
    
}
