/**
 * Classe ChainageAvant
 * 
 * Moteur d'inférence en chainage avant
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */


import java.util.ArrayList;

public class ChainageAvant {

    BaseConnue baseConnue;
    BaseRegle baseRegle;

    /**
     * <h4> Constructeur </h4>
     * @param base : une base de connaissances
     * @param baseRegles : une base de règles
     */
    public ChainageAvant(BaseConnue base, BaseRegle baseRegles) {
       this.baseConnue=base;
       this.baseRegle=baseRegles;
    }

    /**
     * Choisit la première règle applicable et ajoute sa conclusion à la base de connaissances
     */
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

    /**
     * <p> Choix de la règle comportant comme prémisses les faits déduits les plus récents  </p>
     * Pour chaque règle compare les indices des faits, celle dont la somme des indices est la plus grande correspond à celle ayant les faits les plus récents
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


    /**
     * <p> Choisit la règle ayant le plus de prémisses à satisfaire </p>
     * <p> Ajoute sa conclusion à la base connue </p>
     * @return vrai si trouve une règle à appliquer, faux sinon
     */
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

    /**
     * <p> Appel de chainagePlusPremices jusqu'à ce qu'il n'y ait plus aucune règle à appliquer </p>
     */
    public void chainagePlusPremicesRecursive(){
        boolean res = chainagePlusPremices();
        
        while(res!=false){
            res = chainagePlusPremices();
        }
        
    }
    
}
