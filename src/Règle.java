import java.util.ArrayList;

public class Règle {
    
    int id;
    ArrayList<Faits> faits;
    Faits conclusion;
    int count;

    public Règle (int id, ArrayList<Faits> faits, Faits conclusion) {
        this.id = id; 
        this.faits = faits;
        this.conclusion = conclusion;
        this.count = 0;
    }

    /* Méthode pour savoir si la règle est correct ou nom */
    public boolean isTrue (BaseConnue base) {
        /* parcours la liste des faits prédicats de la règle
         * vérifie pour chacun leur présence dans la liste des faits de la base (ArrayList<>.contains(Object o))
         * si tous les faits prédicats sont dans la base : la règlé est vérifiée -> ajout de sa conclusion dans la liste + return true;
         * si un ou plsrs faits prédicats ne sont pas dans la base: la règle n'est pas vérifiée -> return false;
         */
        boolean res = false;
        this.faits.forEach ((f) -> {
            if (base.faits.contains(f) == true) {
                this.count ++;
            }
        });
        
        if (this.count == this.faits.size()) {
            base.faits.add(this.conclusion);
            res = true;
        }

        return res;
    }


    //retourn le modèle d'affichage des règles
    public String toString(){
        String resultat="";
         resultat="R" + this.id + ":\n";
            for (int i=0; i<this.faits.size()-1; ++i) {
              resultat+=faits.get(i).getFait();
              if(faits.size()>1) //s'il y a plusieurs prémice
                resultat+=" Et ";
            }
          resultat+= " Alors "+ this.conclusion;
          return resultat;
    }
  
}
