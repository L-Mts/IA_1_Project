import java.util.ArrayList;

public class Regle {
    
    public int id;
    private ArrayList<Fait> faits;
    private Fait conclusion;
    private int count;

    public Regle (int id, ArrayList<Fait> faits, Fait conclusion) {
        this.id = id; 
        this.faits = faits;
        this.conclusion = conclusion;
        this.count = 0;
    }

    /**
     * @function isTrue
     * @param BaseConnue base
     * @return boolean (true / false)
     * 
     * Parcours la liste des prédicats de la règle (ArrayList<Faits> faits)
     * Pour chaque: vérifie sa présence dans la liste des faits de la base
     * Si tous les prédicats sont dans la base 
     */
    public boolean isTrue (BaseConnue base) {
        boolean res = false;
        this.faits.forEach ((f) -> {
            if (base.isTrueFait(f) == true) {
                this.count ++;
            }
        });
        
        if (this.count == this.faits.size()) {
            res = true;
        }

        return res;
    }


    //retourn le modèle d'affichage des règles
    public String toString(){
        String resultat="";
         resultat="R" + this.id + ":\tSi\t";
            for (int i=0; i<this.faits.size()-1; ++i) {
              resultat+=faits.get(i).getFait();
              if(faits.size()>1) //s'il y a plusieurs faits
                resultat+=" Et ";
            }
          resultat+= " Alors "+ this.conclusion;
          return resultat;
    }
  
}
