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
    
        //Gui view=new Gui();
        ReadFile readfile=new ReadFile("ressource/faits.txt");
        readfile.lireRegle("ressource/regles.txt");

        //System.out.println(readfile.getBasefaits());
        //System.out.println(readfile.getBaseregle());
        BaseRegle allRegle = new BaseRegle(readfile.getBaseregle());

        Interface view = new Interface(allRegle, readfile.getBasefaits());

    }
}
