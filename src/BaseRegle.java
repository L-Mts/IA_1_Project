import java.util.ArrayList;

public class BaseRegle {
    
    private ArrayList<Regle> listRegles;


    public BaseRegle(ArrayList<Regle> list){
        this.listRegles=list;
    }

    public ArrayList<Regle> getListRegle(){
        return this.listRegles;
    }

    public void afficher(){
        for(Regle regle: listRegles){
            System.out.println(regle.toString());
        }
    }

    public void addRegle(Regle r){
        this.listRegles.add(r);
    }

    public ArrayList<Regle> getListRegles(){
        return this.listRegles;
    }

    public Regle getRegleByID (int id) {
        for (int i=0; i<this.listRegles.size(); i++) {
            if (this.listRegles.get(i).id == id)
                return this.listRegles.get(i);
        }
        return null;
    }

    /*
     * retourne vraie si la liste des règles présente au moins une incohérence
     * cad s'il des règles avec les mêmes prémices mais pas la même conclusion
    */
    public boolean incompatibilite() {
        for (Regle r1 : this.listRegles) {
            for (Regle r2 : this.listRegles) {
                if (!r1.equals(r2) && (r1.getListFaits().equals(r2.getListFaits()) || r1.getConclusion().equals(r2.getConclusion()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bouclageRegle(){
        for (Regle r1 : this.listRegles) {
            for (Regle r2 : this.listRegles) {
                for(Regle r3: this.listRegles){
                    return true;
                }
            
            }
        }
        return false;

    }

    public void correctionIncompatibilite() {
        boolean isIncompatible = this.incompatibilite();
        
        while (isIncompatible == true) {
            Regle toDelete;
            Regle r1;
            toDelete = null;
            int i = 0;
            while (toDelete == null && i < this.listRegles.size()) {
                r1 = this.listRegles.get(i);
                for (Regle r2 : this.listRegles) {
                        //on vérifie si l'une des 2 incompatibilités existe
                        if ((r1.getConclusion().equals(r2.getConclusion()) ||r1.getListFaits().equals(r2.getListFaits())) && r1.id!=r2.id) {
                            //on supprime la dernière règle ajoutée qui pose problème, c'est à dire la règle ayant l'ID le plus grand
                            if (toDelete == null) {
                                if (r1.id < r2.id) toDelete = r2;
                                else toDelete = r1;
                            } else {
                                int id = Math.max(r1.id, Math.max(toDelete.id, r2.id));
                                toDelete = this.getRegleByID(id);
                            }
                        }
                }
                i++;
            }
            if (toDelete != null) {
                this.listRegles.remove(toDelete);
            }

            isIncompatible = this.incompatibilite();
        }
    }
    

}
