public class Faits {

    private int id;
    private String fait;

    /* Il vaudrait mieux ne pas passer l'id en paramètre mais faire un id auto-incrémenté si on a bcp de fiats */
    public Faits (int id, String fait) {
        this.id = id;
        this.fait = fait;
    }

    public int getId(){
        return this.id;
    }

    public String getFait(){
        return this.fait;
    }

}