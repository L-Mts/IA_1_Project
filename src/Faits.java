public class Faits {

    int id;
    String fait;

    /* Il vaudrait mieux ne pas passer l'id en paramètre mais faire un id auto-incrémenté si on a bcp de fiats */
    public Faits (int id, String fait) {
        this.id = id;
        this.fait = fait;
    }

}