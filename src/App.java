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


        ArrayList<Fait> baseFaitsComplete = new ArrayList<Fait>(
            List.of(f1, f2, f3, f4, f5, f6)
        );


        /* --- TOUTES LES REGLES --- */
        Regle r1 = new Regle(1, new ArrayList<Fait>(List.of(f1)), f3);
        Regle r2 = new Regle(2, new ArrayList<Fait>(List.of(f1, f3, f4)), f5);
        Regle r3 = new Regle(3, new ArrayList<Fait>(List.of(f1, f3, f2)), f6);

        BaseRegle baseRegle = new BaseRegle(new ArrayList<Regle>(List.of(r1, r2, r3)));


        /* --- TEST DE L'APPLICATION --- */

        /* chainage avant */

        BaseConnue base = new BaseConnue();
        base.addFait(f1);
        base.addFait(f4);

        /* chainage arriere */

        BaseConnue baseArriere = new BaseConnue();
        baseArriere.addFait(f6);

        ChainageArriere moteur = new ChainageArriere(baseArriere, baseRegle);

        System.out.println("Avant chainage arrière, base : " + baseArriere.getFaits());

        moteur.ChainageSimple();

        System.out.println("Après chainage arrière, base : " + baseArriere.getFaits());
        
        
        


         
        
    }
}
