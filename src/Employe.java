public class Employe{
    
    // --- Attributs --- //
    private String nom;
    private String prenom;
    public static int _compteur=0;
    private int id;
    private int heures_hebdomadaires;

    // --- Constructeur --- //

    public Employe(String nom,String prenom, int heures_hebdomadaires) {
        this.nom=nom;
        this.prenom=prenom; 
        this.id=++_compteur;
        this.heures_hebdomadaires=heures_hebdomadaires;
    }
}
