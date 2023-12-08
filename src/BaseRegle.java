/**
 * Classe BaseRegle
 * 
 * Base de toutes les règles du domaine
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

import java.util.ArrayList;

public class BaseRegle {
    
    private ArrayList<Regle> listRegles;


    /**
     * <h4> Constructeur </h4>
     * @param list : liste des règles
     */
    public BaseRegle(ArrayList<Regle> list){
        this.listRegles=list;
    }

    /**
     * @return la liste de toutes les règles
     */
    public ArrayList<Regle> getListRegle(){
        return this.listRegles;
    }

    /**
     * Affiche la liste des règles dans le terminal
     */
    public void afficher(){
        for(Regle regle: listRegles){
            System.out.println(regle.toString());
        }
    }

    /**
     * @param r : la règle à ajouter à la base de règles
     */
    public void addRegle(Regle r){
        this.listRegles.add(r);
    }

    /**
     * @param id : l'id de la règle à trouver
     * @return la règle souhaitée
     */
    public Regle getRegleByID (int id) {
        for (int i=0; i<this.listRegles.size(); i++) {
            if (this.listRegles.get(i).id == id)
                return this.listRegles.get(i);
        }
        return null;
    }

    /**
     * @return vrai si la liste des règles présente au moins une incohérence
     * </br>
     * <p> Incohérence = redondance de règle ou incompatibilité des règles </p>
     * <p> Respectivement: on la même conclusion, et on les mêmes prémisses mais des conclusions différentes </p>
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

    /**
     * Supprime les règles (en partant de la dernière ajoutée) à la base qui causent une incohérence
     */
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
