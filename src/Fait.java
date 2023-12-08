/**
 * Classe Faits
 * 
 * <p> Un fait </p>
 * <p> Ni vrai ni faux </p>
 * <p> Peut servir de prédicat d'une règle, peut faire partie de la base de connaissances </p>
 * <p> Peut servir de conclusion d'une règle </p>
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */


public class Fait {

    private int id;
    private String fait;

    /**
     * <h4> Constructeur </h4>
     * @param id : l'id du fait
     * @param fait : phrase explicative du fait
     */
    public Fait (int id, String fait) {
        this.id = id;
        this.fait = fait;
    }

    /**
     * @return l'id du fait
     */
    public int getId(){
        return this.id;
    }

    /**
     * @return la phrase explicative du fait
     */
    public String getFait(){
        return this.fait;
    }

    /**
     * Fonction pour écrire un fait
     */
    public String toString() {
        String str  = new String(); 
        str = "f" + this.id + " : " + this.fait;
        return str;
    }

    /**
     * @param allRegles : une base de règles
     * @return vrai si le fait (this) est conclusion d'une des règles de la base, faux sinon
     */
    public boolean isAConclusion (BaseRegle allRegles) {
        for (Regle r : allRegles.getListRegle()) {
            if (r.getConclusion().equals(this)) return true;
        }
        return false;
    }

    /**
     * @param allRegles : une base de règles
     * @return id de la règle dont le fait est la conclusion ou -1 si le fait n'est conclusion d'aucune règle
     */
    public int isConclusionOf (BaseRegle allRegles) {
        for (Regle r : allRegles.getListRegle()) {
            if (r.getConclusion().equals(this)) return r.id;
        }
        return -1;
    }

}