import java.util.ArrayList;
import java.util.List;

/**
 * Classe App
 * 
 * Classe principale où l'application est lancée
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

public class App {
    public static void main(String[] args) throws Exception {
       
        /* --- TOUS LES FAITS --- */
        Fait f1 = new Fait(1, "Est un oiseau");
        Fait f2 = new Fait(2, "Peut voler");
        Fait f3 = new Fait(3, "Est noir et blanc");
        Fait f4 = new Fait(4, "Ne peut pas voler");
        Fait f5 = new Fait(5, "Est un pingouin");
        Fait f6 = new Fait(6, "Est une pie");


        /* --- TOUTES LES REGLES --- */
        Regle r1 = new Regle(1, new ArrayList<Fait>(List.of(f1)), f3);
        Regle r2 = new Regle(2, new ArrayList<Fait>(List.of(f1, f3, f4)), f5);
        Regle r3 = new Regle(3, new ArrayList(List.of(f1, f3, f2)), f6);


        /* --- NOTRE BASE DE FAITS CONNUS --- */
        BaseConnue base = new BaseConnue();
        base.addFait(f1);
        base.addFait(f4);

        /* --- TEST DE L'APPLICATION --- */
        
        /*
         * Comment faire pour tester les différentes règles ? 
         * 
         * Idée 1 (chaînage avant):
         *      Avoir une liste de règle qui est parcourue entièrement à chaque test
         *      Dès la première règle validée dont la conclusion n'est pas dans la base : 
         *          ajout conclusion dans la base
         *          + quitter fonction de parcours de la liste puis la relancer jusqu'à ce qu'on ne puisse plus ajouter de conclusion
         *          = dernière conclusion ajoutée (dernier élément de la liste de faits de la base) == Conclusion finale
         *      Adapter cette méthode pour les différentes manière de faire du chaînage avant (cf feuille Projet)
         * 
         * Idée 2 (chaînage arrière):
         *      Liste de règle à parcourir entièrement
         *      Cette fois, regarder si la conclusion fait partie de la base de donnée --> si oui ajouter les hypothèses dans la base
         *      --> A adapter selon les différentes manière de faire la recherche (cf feuille Projet) 
         */
        
    }
}
