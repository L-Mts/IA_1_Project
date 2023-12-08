import java.awt.*;
import java.awt.event.*;

import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Interface {
    
    private BaseRegle allRegles;
    private BaseConnue baseConnue;
    private ArrayList<Fait> allFaits;

    public Interface (BaseRegle allRegles, ArrayList<Fait> allFaits) {
        
        //initialisation des bases
        this.allRegles = allRegles;
        this.allFaits = allFaits;
        this.baseConnue = new BaseConnue();

        //creation de la JFrame principale
        JFrame principale = new JFrame("Systeme Expert IA 1 - Himidati & Loana");
        principale.setSize(1600, 800);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        Dimension windowSize = principale.getSize();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        principale.setLocation(dx, dy);

        principale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panelBases = affichage (sur 2 lignes des différentes bases (de faits, de règles, de connaissances)
        JPanel panelBases = new JPanel(new GridLayout(2, 1));
        //panelBasesDeDepart = affichages des bases de départ = base de fait & base de regles (sur 2 colonnes)
        JPanel panelBasesDeDepart = new JPanel (new GridLayout(1, 2));
        
        //affichage de la base de faits
        JList allFaitsList = new JList<>(this.allFaits.toArray());
        JScrollPane scrollPanel = new JScrollPane(allFaitsList);
        scrollPanel.setBorder(BorderFactory.createTitledBorder(null, "BASE DE FAITS", 2, 3));

        //affichage de la base de règles
        JPanel panelReglesEtBoutons = new JPanel();
        DefaultListModel<String> modelRegles = new DefaultListModel<>();
        JList allReglesList = new JList<>(modelRegles);
        for (Regle r : allRegles.getListRegle()) {
            modelRegles.addElement(r.toString());
        }
        JScrollPane scrollPanelRegles = new JScrollPane(allReglesList);
        scrollPanelRegles.setBorder(BorderFactory.createTitledBorder(null, "BASE DE REGLES", 2, 3));
        panelReglesEtBoutons.add(scrollPanelRegles, BorderLayout.SOUTH);

        //boutons en rapport avec la base de règles
        JPanel boutonsReglesPanel = new JPanel();
        JButton checkIncompatibilite = new JButton("Vérifier la cohérence");
        checkIncompatibilite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (allRegles.incompatibilite()) {
                    JOptionPane.showMessageDialog(null, "ATTENTION : il y a des incohérences dans votre base de règles");
                } else {
                    JOptionPane.showMessageDialog(null, "Nous n'avons pas détecté d'incohérences dans votre base de règles");
                }
            }
        });
        JButton correctIncompatibilite = new JButton("Corriger les incohérences");
        correctIncompatibilite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                allRegles.correctionIncompatibilite();
                modelRegles.clear();
                for(Regle r : allRegles.getListRegle()) {
                    modelRegles.addElement(r.toString());
                }

            }
        });
        boutonsReglesPanel.add(checkIncompatibilite);
        boutonsReglesPanel.add(correctIncompatibilite);

        panelReglesEtBoutons.add(boutonsReglesPanel, BorderLayout.SOUTH);


        //affichage de la base de connaissances
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> baseConnueJList = new JList<>(model);
        JScrollPane scrollPanelbaseConnue = new JScrollPane(baseConnueJList);
        scrollPanelbaseConnue.setBorder(BorderFactory.createTitledBorder(null, "BASE DE CONNAISSANCES", 2, 3));

        panelBasesDeDepart.add(scrollPanel);
        panelBasesDeDepart.add(panelReglesEtBoutons);
        panelBases.add(panelBasesDeDepart, BorderLayout.NORTH);
        panelBases.add(scrollPanelbaseConnue, BorderLayout.CENTER);

        //panelBottom = affichage des boutons (sur 3 lignes)
        JPanel panelBottom = new JPanel (new GridLayout(3,1));

        JPanel boutonsBasesConnaissances = new JPanel();

        JButton ajout = new JButton("Ajouter à la base de connaissances");
        ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (allFaitsList.getSelectedValue() == null) {
                    System.out.println("nothing there");
                } else {
                    String selected = allFaitsList.getSelectedValue().toString();
                    model.addElement(selected);
                    int pos = allFaitsList.getSelectedIndex();
                    baseConnue.addFait(allFaits.get(pos));
                }
                
            }
        });

        JButton clearBasesConnue = new JButton("Effacer la base de connaissances");
        clearBasesConnue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                model.clear();
                baseConnue.getFaits().clear();
                System.out.println("IN CLEAR BASE CONNUE = " +baseConnue.getFaits());  
            }
        });

        boutonsBasesConnaissances.add(ajout);
        boutonsBasesConnaissances.add(clearBasesConnue);

        panelBottom.add(boutonsBasesConnaissances);

        JButton chainageAvantSimpleBtn = new JButton("Chainage Avant Simple");
        chainageAvantSimpleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ChainageAvant moteur = new ChainageAvant(baseConnue, allRegles);
                moteur.chainageSimple();
                model.clear();
                for (int i=0; i<baseConnue.getFaits().size(); i++) {
                    model.addElement(baseConnue.getFaits().get(i).toString());
                }
            }
        });

        JButton chainageAvtRecentBtn = new JButton("Chainage Avant Faits Récents");
        chainageAvtRecentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ChainageAvant moteur = new ChainageAvant(baseConnue, allRegles);
                moteur.appliqueRegleRecent();
                model.clear();
                for (int i=0; i<baseConnue.getFaits().size(); i++) {
                    model.addElement(baseConnue.getFaits().get(i).toString());
                }
            }
        });

        JButton chainageAvtPlusBtn = new JButton("Chainage Avant Plus de Prémices");
        chainageAvtPlusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ChainageAvant moteur = new ChainageAvant(baseConnue, allRegles);
                moteur.chainagePlusPremicesRecursive();
                model.clear();
                for (int i=0; i<baseConnue.getFaits().size(); i++) {
                    model.addElement(baseConnue.getFaits().get(i).toString());
                }
            }
        });

        JButton chainageArriereSimpleBtn = new JButton("Chainage Arrière Simple");
        chainageArriereSimpleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ChainageArriere moteur = new ChainageArriere(baseConnue, allRegles);
                moteur.chainageSimple();
                model.clear();
                for (int i=0; i<baseConnue.getFaits().size(); i++) {
                    model.addElement(baseConnue.getFaits().get(i).toString());
                }
            }
        });

        JButton chainageArriereRecentBtn = new JButton("Chainage Arrière Plus Récents");
        chainageArriereRecentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ChainageArriere moteur = new ChainageArriere(baseConnue, allRegles);
                moteur.chainageRecentRecursif();
                model.clear();
                for (int i=0; i<baseConnue.getFaits().size(); i++) {
                    model.addElement(baseConnue.getFaits().get(i).toString());
                }
            }
        });

        JButton chainageArrierePlusBtn = new JButton("Chainage Arrière Plus de Prémices");
        chainageArrierePlusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ChainageArriere moteur = new ChainageArriere(baseConnue, allRegles);
                moteur.chainagePlusRecursif();
                model.clear();
                for (int i=0; i<baseConnue.getFaits().size(); i++) {
                    model.addElement(baseConnue.getFaits().get(i).toString());
                }
            }
        });

        JPanel chainageAvantPanel = new JPanel();
        
        chainageAvantPanel.add(chainageAvantSimpleBtn);
        chainageAvantPanel.add(chainageAvtRecentBtn);
        chainageAvantPanel.add(chainageAvtPlusBtn);

        panelBottom.add(chainageAvantPanel);

        JPanel chainageArrierePanel = new JPanel();

        chainageArrierePanel.add(chainageArriereSimpleBtn);
        chainageArrierePanel.add(chainageArriereRecentBtn);
        chainageArrierePanel.add(chainageArrierePlusBtn);

        panelBottom.add(chainageArrierePanel);

        principale.add(panelBases, BorderLayout.CENTER);
        principale.add(panelBottom, BorderLayout.SOUTH);


        principale.setVisible(true);
    }

}
