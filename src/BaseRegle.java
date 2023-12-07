import java.util.ArrayList;

public class BaseRegle {
    
    private ArrayList<Regle> listRegles;


    public BaseRegle(ArrayList<Regle> list){
        this.listRegles=list;
    }

    public ArrayList<Regle> getListRegle(){
        return this.listRegles;
    }

    public void afficher(){
        for(Regle regle: listRegles){
            System.out.println(regle.toString());
        }
    }

    public void addRegle(Regle r){
        this.listRegles.add(r);
    }

    public ArrayList<Regle> getListRegles(){
        return this.listRegles;
    }

    /*
     * retourne vraie si la liste des règles présente au moins une incohérence
     * cad s'il des règles avec les mêmes prémices mais pas la même conclusion
    */
    public boolean incompatibilite(){
        for(int i=0; i<this.listRegles.size(); i++)
            for(int j=0; j<this.listRegles.size(); j++)
                if(this.listRegles.get(i).getListFaits()==this.listRegles.get(j).getListFaits() && this.listRegles.get(i).getConclusion()!=this.getListRegle().get(j).getConclusion())
                    return true;
            
        
        return false;
    }
    

}
