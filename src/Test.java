/**
 * Classe Test
 * 
 * <p> Classe Main dans laquelle l'application est lancée </p>
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Classe App
 * 
 * Classe principale où l'application est lancée
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

public class Test {
    public static void main(String[] args) throws Exception {
    
        /**
         * Lecture des fichiers et création des bases
         */
        ReadFile readfile=new ReadFile("ressource/faits.txt");
        readfile.lireRegle("ressource/regles.txt");

        BaseRegle allRegle = new BaseRegle(readfile.getBaseregle());

        Interface view = new Interface(allRegle, readfile.getBasefaits());

    }
}
