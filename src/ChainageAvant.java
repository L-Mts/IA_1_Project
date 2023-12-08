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
        while (i < this.baseRegle.getListRegle().size()) {
            if(!this.baseRegle.getListRegle().get(i).estApplicable(this.baseConnue))
                i++;
            else{
                baseConnue.addFait(this.baseRegle.getListRegle().get(i).getConclusion());    
                i=0;
            }
        }
        

    }

    /* choix de la règle comportant comme prémices les faits déduits les plus récents  
     * toutes les prémices de la règle doivent être récemment déduis
     * Pour chaque règle je compare les indices du fait, celle dont la somme des indices est la plus grande, 
     * correspond à celle ayant les faits les plus récents
    */
    public void appliqueRegleRecent() {
        boolean regleAppliquee = true; //pour être sûr que la boucle est exécuté au moins une fois même si aucune règle n'est applicable ou que la base de fait est nulle
    
        while (regleAppliquee) {

            ArrayList<Regle> mesResglesApplicables = new ArrayList<>();
    
            for (Regle r : this.baseRegle.getListRegle()) {
                if (r.estApplicable(baseConnue)) {
                    mesResglesApplicables.add(r);
                }
            }
            regleAppliquee = false; // Réinitialisé à false avant chaque itération si jamais il n'existe pas de règle applicable

            if (mesResglesApplicables.size() > 0) {
                Regle regleLaPlusRecente = mesResglesApplicables.get(0);
                int somme = regleLaPlusRecente.sommeIndices(baseConnue);
    
                // Parmi mes règles applicables, choisir celle dont les faits sont les plus récents
                for (Regle r : mesResglesApplicables) {
                    if (r.sommeIndices(baseConnue) > somme) {
                        regleLaPlusRecente = r;
                        somme = r.sommeIndices(baseConnue);
                    }
                }
    
                baseConnue.addFait(regleLaPlusRecente.getConclusion());
                regleAppliquee = true; // Indiquer qu'une règle a été appliquée
            }
        }
    }


    /* choix de la règle avec le plus de prémices */
    public boolean chainagePlusPremices(){
        int nbFait=0;
        Regle rule=null;
        for(Regle r: this.baseRegle.getListRegle()){
            if(r.estApplicable(baseConnue) && nbFait<r.getListFaits().size()){
                nbFait=r.getListFaits().size();
                rule=r;
            }
        }

        if(rule!=null){
            this.baseConnue.addFait(rule.getConclusion());
            return true;
        }
        return false;
    }

    public void chainagePlusPremicesRecursive(){
        boolean res = chainagePlusPremices();
        
        while(res!=false){
            res = chainagePlusPremices();
        }
        
    }
    
}
