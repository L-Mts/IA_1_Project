/**
 * Classe Règle
 * 
 * Règle avec ses prédicats
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */


import java.util.ArrayList;

public class Regle {
    
    public int id;
    private ArrayList<Fait> faits;
    private Fait conclusion;

    public Regle (int id, ArrayList<Fait> faits, Fait conclusion) {
        this.id = id; 
        this.faits = faits;
        this.conclusion = conclusion;
    }

    /**
     * @function isTrue
     * @param base : classe BaseConnue, une base de faits
     * @return vrai si tous les prédicats font partie de la base de faits, faux sinon
     * 
     * Parcours la liste des prédicats, vérifie leur présence dans la base de faits
     * Chaînage Avant
     */
    public boolean isTrue (BaseConnue base) {
        boolean res = false;
        int count = 0;
        for (Fait f : this.faits) {
            if (base.isTrueFait(f)) {
                count ++;
            }
        }
        
        if (count == this.faits.size()) {
            res = true;
        }

        return res;
    }

    /**
     * @function isConclusionTrue
     * @param base : classe BaseConnue, une base de faits
     * @return vrai si la conclusion fait partie de la base de fait, faux sinon
     * 
     * Vérifie la présence de la conclusion dans la base de faits
     */
    public boolean isConclusionTrue (BaseConnue base) {
        return (base.isTrueFait(this.conclusion));
    }


    //retourne le modèle d'affichage des règles
    public String toString(){
        String resultat="";
         resultat="R" + this.id + ":\tSi\t";
            for (int i=0; i<this.faits.size()-1; ++i) {
              resultat+=faits.get(i).getFait();
              if(faits.size()>1) //s'il y a plusieurs prémices
                resultat+=" Et ";
            }
          resultat+= " Alors "+ this.conclusion;
          return resultat;
    }
  
}
