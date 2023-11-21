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
     * @function Constructeur BaseConnue
     * Création d'une base avec une liste vide
     */
    public BaseConnue () {
        this.faits = new ArrayList<Fait>();
    }


    /**
     * @function addFait: ajout d'un fait à la base de fait
     * @param f : le fait à ajouter
     * @return : vrai si réussite, faux sinon
     */
    public boolean addFait (Fait f) {
        return this.faits.add(f);
    }

    public boolean removeFait (Fait f) {
        return (this.faits.remove(f));
    }

    
    /**
     * @function isTrueFait
     * @param f : un fait
     * @return : vrai si le fait est présent dans la base de faits, faux si le fait n'est pas présent dans la base de faits
     */
    public boolean isTrueFait (Fait f) {
        return this.faits.contains(f);
    }

    /**
     * @function isEmpty
     * @return : vrai si la liste des faits de la base connue est vide, faux sinon
     */
    public boolean isEmpty ()  {
        return (this.faits.isEmpty());
    }

    public ArrayList<Fait> getFaits (){
        return this.faits;
    }



}