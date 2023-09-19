public abstract class Personnel {

    // --- Attributs --- //

    public String nom;
    public int heures_hebdomadaires;
    public int heures_planifiees;

    // --- Constructeur --- //

    public Personnel(String nom, int heures_hebdomadaires) {
        this.nom = nom;
        this.heures_hebdomadaires = heures_hebdomadaires;
        this.heures_planifiees = 0;
    }

}