/**
 * Classe BaseConnue
 * 
 * Base de faits connus et vérifiés
 * 
 * @author: Loana MOTTAIS, Himidati BOINAIDI
 */

import java.util.ArrayList;

public class BaseConnue {
    

    private ArrayList<Fait> faits;

    /**
     * <h4> Constructeur </h4>
     * Création d'une base avec une liste vide
     */
    public BaseConnue () {
        this.faits = new ArrayList<Fait>();
    }


    /**
     * @param f : le fait à ajouter
     * @return : vrai si réussite, faux sinon
     */
    public boolean addFait (Fait f) {
        if (this.faits.contains(f)) return false;
        return this.faits.add(f);
    }

    /**
     * @param f : le fait à supprimer
     * @return : vrai si réussite, faux sinon
     */
    public boolean removeFait (Fait f) {
        return (this.faits.remove(f));
    }

    /**
     * Supprime tous les faits de la base connue
     */
    public void removeAllFaits () {
        this.faits.clear();
    }

    
    /**
     * @param f : un fait à vérifier
     * @return : vrai si le fait est présent dans la base connue, faux si le fait n'est pas présent dans la base connue
     */
    public boolean isTrueFait (Fait f) {
        return this.faits.contains(f);
    }

    /**
     * @return : vrai si la liste des faits de la base connue est vide, faux sinon
     */
    public boolean isEmpty ()  {
        return (this.faits.isEmpty());
    }

    /**
     * @return la liste des faits de la base connue
     */
    public ArrayList<Fait> getFaits (){
        return this.faits;
    }

    /**
     * @return le nombre de faits dans la base connue
     */
    public int nbrFaits(){
        return this.faits.size();
    }


}