/**
 * Classe ChainageArriere
 * 
 * Moteur d'inférence en chainage arrière
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

public class ChainageArriere {

    BaseConnue baseConnue;
    BaseRegle baseRegle;

    /**
     * <h4> Constructeur </h4>
     * @param base : une base de connaissances
     * @param baseRegles : une base de règles
     */
    public ChainageArriere(BaseConnue base, BaseRegle baseRegles) {
        this.baseConnue = base;
        this. baseRegle = baseRegles; 
    }


    /**
     * <p> Pour une règle & une base connues (attributs de la classe chainage arriere): </p>
     * <p> Vérifie que la conclusion de la règle fait partie de la base connue </p>
     * <p> Ajoute les faits prédicats de la règle à la base connue </p>
     * Continue jusqu'à ce que plus aucune règle ne soit applicable à la base --> derniers faits ajoutés = faits de bases recherchés
     */
    public void chainageSimple () {
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

    /**
     * <p> Pour une règle et une base connues (attributs de la classe ChainageArriere) : </p>
     * <p> Vérifie quelle conclusion de la base connue a le + de prémisses </p>
     * <p> Ajoute ces prémisses à la base connue </p>
     */
    public boolean chainagePlus () {
        int max = 0;
        Regle regle = null;
        for (Regle r : this.baseRegle.getListRegle()) {
            for (Fait f: this.baseConnue.getFaits()) {
                // si le fait est égal à la conclusion & que les prémisses ne sont pas dans la base connue & qu'il y a plus de prémisses que le max déjà trouvé
                if (r.getConclusion().equals(f) && r.isConclusionTrue(baseConnue) && !r.isTrue(baseConnue) && r.getListFaits().size() > max) {
                    max = r.getListFaits().size();
                    regle = r;
                }
            }
        }
        //si on a trouvé une règle & ses prémisses à mettre dans la base sont plus que le max initialisé
        if (regle != null && max > 0) {
            for (Fait f : regle.getListFaits()) {
                this.baseConnue.addFait(f);
            }
            return true;
        }

        return false;
    }

    /**
     * Appel récursif de la fonction ChainagePlus jusqu'à ce qu'on ne trouve plus aucune prémisses à ajouter dans la base connue
     */
    public void chainagePlusRecursif () {
        boolean continuer = this.chainagePlus();
        while (continuer != false) {
            continuer = this.chainagePlus();
        }
    }

    /**
     * <p> Pour une règle et une base connues (attributs de la classe ChainageArriere) : </p>
     * <p> Vérifie quelle conclusion de la base de règle a été le plus récement incluse dans la base connue </p>
     * Ajoute ses prémisses à la base connue
     * @return vrai si il y a une règle à appliquer, faux sinon
     */
    public boolean chainageRecent () {
        int recent = -1;
        Regle regle = null;
        for (Regle r : this.baseRegle.getListRegle()) {
            for (Fait f: this.baseConnue.getFaits()) {
                // SI : le fait est égal à la conclusion && la conclusion fait partie de la base de connaissance && les prémisses ne sont pas dans la base connue && la position du fait est plus grande
                if (r.getConclusion().equals(f) && r.isConclusionTrue(baseConnue) && !r.isTrue(baseConnue) && this.baseConnue.getFaits().indexOf(f) > recent) {
                    recent = this.baseConnue.getFaits().indexOf(f);
                    regle = r;
                }
            }
        }

        //si on a trouvé une règle && sa conclusion est la plus récente
        if (regle != null && recent > -1) {
            for (Fait f : regle.getListFaits()) {
                this.baseConnue.addFait(f);
            }
            return true;
        }
        
        return false;
    }

    /**
     * Appel de chainageRecent jusqu'à ce qu'il n'y ait plus aucune règle applicable
     */
    public void chainageRecentRecursif () {
        boolean continuer = this.chainageRecent();
        while (continuer != false) {
            continuer = this.chainageRecent();
        }
    }

    
}
