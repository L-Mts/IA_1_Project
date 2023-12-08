/**
 * Classe Faits
 * 
 * Un fait
 * Ni vrai ni faux, peut servir de prédicat d'une règle, peut faire partie de la base de faits
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */


public class Fait {

    private int id;
    private String fait;

    /**
     * @function Constructeur Faits
     * @param id : l'id du fait
     * @param fait : phrase explicative
     * 
     * Un fait ne pouvant jamais être créé en dehors du code, il n'est pas nécessaire de faire un id auto-incrémenté
     */
    public Fait (int id, String fait) {
        this.id = id;
        this.fait = fait;
    }

    public int getId(){
        return this.id;
    }

    public String getFait(){
        return this.fait;
    }

    public String toString() {
        String str  = new String(); 
        str = "f" + this.id + " : " + this.fait;
        return str;
    }

    public boolean isAConclusion (BaseRegle allRegles) {
        for (Regle r : allRegles.getListRegle()) {
            if (r.getConclusion().equals(this)) return true;
        }
        return false;
    }

    /**
     * @param allRegles : une base de Regle
     * @return id de la règle dont le fait est la conclusion ou -1 si le fait n'est conclusion d'aucune règle
     */
    public int isConclusionOf (BaseRegle allRegles) {
        for (Regle r : allRegles.getListRegle()) {
            if (r.getConclusion().equals(this)) return r.id;
        }
        return -1;
    }

}