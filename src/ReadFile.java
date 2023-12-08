import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    ArrayList<Fait> baseFaits=new ArrayList<Fait>();
    ArrayList<Regle> baseRegles= new ArrayList<Regle>();

    /*
     *lit un fichier de fait
     */
    public ReadFile(String nomfichier) throws Exception {
        try {
            // Le fichier d'entrée
            File file = new File(nomfichier);
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i=0;
            while ((line = br.readLine()) != null) {
                // ajoute la ligne au buffer
                Fait fait=new Fait(i++, line);
                baseFaits.add(fait);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Fait> getBasefaits(){
        return this.baseFaits;
    }

    /*
     * méthode qui lit un fichier txt de Règle 
     */
    public void lireRegle(String nomfichier) throws Exception{
        try {
            File file = new File(nomfichier);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i=0;
            while ((line = br.readLine()) != null) { //sous forme c1;f1,f2
                String[] regle=line.split(";");
                String conclu=regle[0];
                int k=0;
                int idConclu=-1;
                //si la conclusion existe dans ma base de fait
                while(k<baseFaits.size() && idConclu==-1){
                        if(baseFaits.get(k).getFait().equals(conclu)) {
                            idConclu = k;
                        }
                        k++;
                }
                String listPremices=regle[1];
                String[] unePremice=listPremices.split(",");
                ArrayList<Fait> premices=new ArrayList<Fait>();
                //ajout tous les premices de la règle
                for(String f: unePremice){
                    int j=0;
                    int pos = -1;
                    while(j<baseFaits.size() && pos==-1){
                        if(baseFaits.get(j).getFait().equals(f)) {
                            pos = j;
                        }
                        j++;
                    }
                    if(pos != -1) {
                        premices.add(baseFaits.get(pos)); 

                    }
                    else throw new Exception("Veuillez vérifier que les prémices des règles existent dans le fichier des faits");
                }
                if(idConclu!=-1){
                    Regle rule=new Regle(i++, premices, baseFaits.get(idConclu));
                    this.baseRegles.add(rule);
                }else throw new Exception("Veuillez vérifier que la conclusion existe dans le fichier des faits");
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBaseFaits(ArrayList<Fait> faits){
        this.baseFaits=faits;
    }

    public ArrayList<Regle> getBaseregle(){
        return this.baseRegles;
    }

}
