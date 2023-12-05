import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame{

    private String strategieChoisie;
    private BaseRegle mesRegles;
    private BaseConnue baseConnue=new BaseConnue();
    private ArrayList<Fait> maBaseConnaissance;

    public Gui(){
        super("Système Expert");
        setSize(1600,800);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );

        JPanel panelPrincipale=new JPanel();
        JPanel panelBas=new JPanel();

        this.add(panelPrincipale,BorderLayout.CENTER);
        this.add(panelBas, BorderLayout.SOUTH);

        panelPrincipale.setLayout(new GridLayout(2,3));

        JTextArea factsTextArea=new JTextArea();
        JTextArea ruleTextArea= new JTextArea();
        JTextArea baseConnaissanceTextArea= new JTextArea();
        JPanel panelResultat=new JPanel();
        JLabel resultatChainage=new JLabel();

        panelResultat.add(resultatChainage);

        factsTextArea.setLineWrap(true);
        ruleTextArea.setLineWrap(true);
        baseConnaissanceTextArea.setLineWrap(true);

        Border cadre = BorderFactory.createRaisedBevelBorder();
        Border  borderFaits=  BorderFactory.createTitledBorder(cadre, "FAITS", TitledBorder.LEFT, TitledBorder.TOP, 
        new Font("Arial", Font.PLAIN, 20));
        factsTextArea.setBorder(borderFaits);

        Border  borderBaseConnaissance=  BorderFactory.createTitledBorder(cadre, "BASE DE CONNAISSANCE", TitledBorder.LEFT, TitledBorder.TOP, 
        new Font("Arial", Font.PLAIN, 20));
        baseConnaissanceTextArea.setBorder(borderBaseConnaissance);

        Border borderRegle= BorderFactory.createTitledBorder(cadre, "REGLES", TitledBorder.LEFT, TitledBorder.TOP, 
        new Font("Arial", Font.PLAIN, 20));
        ruleTextArea.setBorder(borderRegle);

        Border borderResultat=BorderFactory.createTitledBorder(cadre, "RESULTATS",  TitledBorder.LEFT,TitledBorder.TOP, 
        new Font("Arial", Font.PLAIN , 20));
        panelResultat.setBorder(borderResultat);

        JScrollPane scrollFait= new JScrollPane(factsTextArea);
        JScrollPane scrollRegle= new JScrollPane(ruleTextArea);
        JScrollPane scrollBaseFait=new JScrollPane(baseConnaissanceTextArea);

        scrollFait.getVerticalScrollBar();
        scrollRegle.getVerticalScrollBar();

		scrollFait.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollRegle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollBaseFait.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JLabel choisirStratLabel=new JLabel("Choisir une stratégie :");
        String strategie [] = {"---","Chainage avant Simple","chainage avant Règle avec le plus de prémices", "chainage avant prémices récemment déduit","Chainage arrière Simple","Chainage arrière Plus prémices"};
        JButton rechercher= new JButton("RECHERCER");
        JComboBox<String> typeChainage=new JComboBox<>(strategie); 

        typeChainage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                strategieChoisie=(String) typeChainage.getSelectedItem();
            }
        });

        rechercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                switch (strategieChoisie) {
                    case "Chainage avant Simple":
                        /*String tousLesFaits=factsTextArea.getText();
                        String tousLesregles=ruleTextArea.getText();
                        String faitsconnue=baseConnaissanceTextArea.getText();

                        String[] lignes = faitsconnue.split("\\n");
                        int i=0;
                        for(String ligne : lignes){
                            Fait fait=new Fait(i++, ligne);
                            maBaseConnaissance.add(fait);
                        }*/
                        //resultatChainage.setText("cliqué"); //pour afficher le résultat dans le panel
                        
                        System.out.println("s1");
                        break;
                    case "chainage avant Règle avec le plus de prémices":
                        System.out.println("s2");
                        break;
                    case "chainage avant prémices récemment déduit":
                        System.out.println("s3");
                        break;
                    case "Chainage arrière Simple":
                        System.out.println("s4");
                        break;
                    case "Chainage arrière Plus prémices":
                        System.out.println("s5");
                        break;
                    default: //chainage avant simple par défaut
                        break;
                }
            }
        });

        panelBas.add(choisirStratLabel);
        panelBas.add(typeChainage);
        panelBas.add(rechercher);

        panelPrincipale.add(scrollFait);
        panelPrincipale.add(scrollRegle);
        panelPrincipale.add(scrollBaseFait);
        panelPrincipale.add(panelResultat);

        getContentPane().add(panelPrincipale);

        setVisible(true);

    }
    /*
     * écire une méthode qui récupère le contenu de chaque textArea
     * chaque ligne représente une règle/Fait
     * Pour chaque fait, on l'ajoute dans la liste de fait
     */

     /*
      * Etape 1 : récupérer tous les faits, règles, et base de connaissance
       Etape 2 : ajouter dans les liste
       Etape 3 : faire appel aux stratégies correspondants.
      */

     /* 
      * une méthode  qui permet d'afficher les résultat sur le panel correspondant
      */


}
