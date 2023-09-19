public class Employe extends Personnel {
    
    // --- Attributs --- //

    Boolean[] conges;
    Boolean[] teletravail;


    // --- Constructeur --- //

    public Employe(String nom, int heures_hebdomadaires, Boolean[] conges, Boolean[] teletravail) {
        super(nom, heures_hebdomadaires);
        this.conges = conges;
        this.teletravail = teletravail;
        
    }


}
