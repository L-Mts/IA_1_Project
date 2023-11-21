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

}
