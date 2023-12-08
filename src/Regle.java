/**
 * Classe Regle
 * 
 * <p> Une règle (avec prémisses & conclusion) </p>
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

import java.util.ArrayList;

public class Regle {
    
    public int id;
    private ArrayList<Fait> faits;
    private Fait conclusion;


    /**
     * <h4> Constructeur </h4>
     * @param id : l'id de la règle
     * @param faits : la liste des faits à mettre en prémisse
     * @param conclusion : la conclusion de la règle
     */
    public Regle (int id, ArrayList<Fait> faits, Fait conclusion) {
        this.id = id; 
        this.faits = faits;
        this.conclusion = conclusion;
    }

    /**
     * @param BaseConnue base
     * @return vrai si tous les prédicats font partie de la base de faits, faux sinon
     * 
     * <p> Parcours la liste des prédicats, vérifie leur présence dans la base de faits </p>
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
     * @param base : classe BaseConnue, une base de faits
     * @return vrai si la conclusion fait partie de la base de fait, faux sinon
     * 
     * <p> Vérifie la présence de la conclusion dans la base de faits </p>
     */
    public boolean isConclusionTrue (BaseConnue base) {
        return (base.isTrueFait(this.conclusion));
    }


    /**
     * Modèle d'écriture d'une règle
     */
    public String toString(){
        String resultat="";
         resultat="R" + this.id + " - ";
         for (int i=0; i<this.faits.size(); ++i) {
              resultat+= "f"+faits.get(i).getId();
              if(i<faits.size()-1) //s'il y a plusieurs prémice
                resultat+=" + ";
            }
          resultat+= " = f"+ this.conclusion.getId()+" ---> SI ";
            for (int i=0; i<this.faits.size(); ++i) {
              resultat+=faits.get(i).getFait();
              if(i<faits.size()-1) //s'il y a plusieurs prémice
                resultat+=" ET ";
            }
          resultat+= " ALORS "+ this.conclusion.getFait()+"\n";
          return resultat;
    }

    /**
     * @return la liste des faits prédicats de la règle
     */
    ArrayList<Fait> getListFaits () {
        return this.faits;
    }

    /**
     * @param baseConnue
     * @return true : si la règle est applicable = si tous ses faits prédicats sont dans la base connue ET que sa conclusion n'est pas encore dans la base connue
     */
    public boolean estApplicable (BaseConnue baseConnue) {
        if (this.isTrue(baseConnue) && this.isConclusionTrue(baseConnue) == false) {
            return true;
        }
        return false;
    }

    /**
     * @return la conclusion de la règle
     */
    public Fait getConclusion(){
        return this.conclusion;
    }

    /**
     * @param baseConnue : une base de connaissances
     * @return la somme des indices des prémisses de la règle au sein de la base de connaissance
     */
    public int sommeIndices(BaseConnue baseConnue){
        int som=0;
        for(Fait f: this.faits){
            som+=baseConnue.getFaits().indexOf(f);
        }
        return som;
    }
}
