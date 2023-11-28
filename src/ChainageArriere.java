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
     * @function ChainagePlus()
     * Pour une règle et une base connues (attributs de la classe ChainageArriere) : <br/>
     * Vérifie quelle conclusion de la base connue a le + de prémisses
     * Ajoute ces prémisses à la base connue
     * Continue jusqu'à ce que plus aucune règle de la base de règle ne soit applicable
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
            System.out.println("Regle n°" + regle.id);
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
        boolean cont = this.chainagePlus();
        while (cont != false) {
            cont = this.chainagePlus();
        }
    }

    
}
