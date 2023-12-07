import java.awt.*;
import java.awt.event.*;

import java.util.*;
import javax.swing.*;

public class Interface {
    
    private BaseRegle allRegles;
    private BaseConnue baseConnue;
    private ArrayList<Fait> allFaits;

    public Interface (BaseRegle allRegles, ArrayList<Fait> allFaits) {
        this.allRegles = allRegles;
        this.allFaits = allFaits;

        this.baseConnue = new BaseConnue();


        JFrame principale = new JFrame();
        principale.setSize(1600, 800);

        //panelTop = affichage (sur 2 lignes)
        JPanel panelTop = new JPanel(new GridLayout(2, 1));
        //panelMain = affichages des bases (sur 2 colonnes)
        JPanel panelMain = new JPanel (new GridLayout(1, 2));
        
        JList allFaitsList = new JList<>(this.allFaits.toArray());
        JScrollPane scrollPanel = new JScrollPane(allFaitsList);

        JList allReglesList = new JList<>(this.allRegles.getListRegle().toArray());
        JScrollPane scrollPanelRegles = new JScrollPane(allReglesList);

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> baseConnueJList = new JList<>(model);
        JScrollPane scrollPanelbaseConnue = new JScrollPane(baseConnueJList);

        panelMain.add(scrollPanel, BorderLayout.CENTER);
        panelMain.add(scrollPanelRegles, BorderLayout.CENTER);
        panelTop.add(panelMain, BorderLayout.NORTH);
        panelTop.add(scrollPanelbaseConnue, BorderLayout.CENTER);

        //panelBottom = affichage des boutons (sur 3 lignes)
        JPanel panelBottom = new JPanel (new GridLayout(3,1));

        JButton ajout = new JButton("Ajout");
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

        JButton chainageAvantSimpleBtn = new JButton("Chainage Avant Simple");
        chainageAvantSimpleBtn.addActionListener(new ActionListener() {
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

        panelBottom.add(ajout);
        panelBottom.add(chainageAvantSimpleBtn);

        principale.add(panelTop, BorderLayout.NORTH);
        principale.add(panelBottom, BorderLayout.SOUTH);

        


        principale.setVisible(true);
    }

}
