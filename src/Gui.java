import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class Gui extends JFrame{
    
    public Gui(){
        super("Système Expert");
        setSize(1600,800);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );

        JPanel panelPrincipale=new JPanel();
        JPanel panelBas=new JPanel();

        this.add(panelPrincipale,BorderLayout.CENTER);
        this.add(panelBas, BorderLayout.SOUTH);

        panelPrincipale.setLayout(new GridLayout(1,3));

        JTextArea factsTextArea=new JTextArea();
        JTextArea ruleTextArea= new JTextArea();
        JPanel panelResultat=new JPanel();

        Border cadre = BorderFactory.createRaisedBevelBorder();
        Border  borderFaits=  BorderFactory.createTitledBorder(cadre, "FAITS", TitledBorder.LEFT, TitledBorder.TOP, 
        new Font("Arial", Font.PLAIN, 20));
        factsTextArea.setBorder(borderFaits);

        Border borderRegle= BorderFactory.createTitledBorder(cadre, "REGLES", TitledBorder.LEFT, TitledBorder.TOP, 
        new Font("Arial", Font.PLAIN, 20));
        ruleTextArea.setBorder(borderRegle);

        Border borderResultat=BorderFactory.createTitledBorder(cadre, "RESULTATS",  TitledBorder.LEFT,TitledBorder.TOP, 
        new Font("Arial", Font.PLAIN , 20));
        panelResultat.setBorder(borderResultat);

        JScrollPane scrollFait= new JScrollPane(factsTextArea);
        JScrollPane scrollRegle= new JScrollPane(ruleTextArea);
        scrollFait.getVerticalScrollBar();
        scrollRegle.getVerticalScrollBar();

		//scrollFait.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollRegle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        String strategie [] = {"Chainage avant Simple","Règle avec le plus de prémices", "prémices récemment déduit","Chainage arrière Simple","Chainage arrière Plus prémices"};
        JButton rechercher= new JButton("RECHERCER");
        JComboBox<String> typeChainage=new JComboBox<>(strategie); 

        panelBas.add(typeChainage);
        panelBas.add(rechercher);

        panelPrincipale.add(factsTextArea);
        panelPrincipale.add(ruleTextArea);
        panelPrincipale.add(panelResultat);

        add(panelPrincipale);

        setVisible(true);

    }
    /*
     * concernant le choix de la stratégie on écoute le choix de l'utilisateur
     */


    /*
     * écire une méthode qui récupère le contenu de chaque textArea
     * chaque ligne représente une règle/Fait
     */

     /*méthode qui permet de lire chaque ligne */

     /* 
      * une méthode  qui permet d'afficher les résultat sur le panel correspondant
      */


}
