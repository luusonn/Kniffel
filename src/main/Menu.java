package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame {

    public Menu() {

        setTitle("KNIFFEl Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menuPanel = new JPanel();

        menuPanel.setLayout(
                new BoxLayout(menuPanel, BoxLayout.Y_AXIS)
        );


        JLabel title = new JLabel("KNIFFEL-GAME");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton startButton = new JButton("START");
        JButton rulesButton = new JButton("RULES");
        JButton quitButton = new JButton("QUIT");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rulesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        menuPanel.add(Box.createRigidArea(new Dimension(0, 60)));

        menuPanel.add(title);

        menuPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        menuPanel.add(startButton);

        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        menuPanel.add(rulesButton);

        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        menuPanel.add(quitButton);

        
        add(menuPanel);

        
        // start button
        startButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new Dicecup();

                dispose();
            }
        });


        //rules button

        rulesButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                showRules();
            }
        });


        //quit button
  

        quitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });


        setVisible(true);
    }


    private void showRules() {

        JFrame rulesFrame = new JFrame();

        rulesFrame.setTitle("Rules");
        rulesFrame.setSize(800, 700);

        rulesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel rulesPanel = new JPanel();

        rulesPanel.setLayout(
                new BoxLayout(rulesPanel, BoxLayout.Y_AXIS)
        );


        JLabel title = new JLabel("RULES");
        JLabel rule1 = new JLabel("Feld1:(Einser) Punkte: Summe aller Einsen");
        JLabel rule2 = new JLabel("Feld2:(Zweier) Punkte: Summe aller Zweien");
        JLabel rule3 = new JLabel("Feld3:(Dreier) Punkte: Summe aller Dreien");
        JLabel rule4 = new JLabel("Feld4:(Vierer) Punkte: Summe aller Vieren");
        JLabel rule5 = new JLabel("Feld5:(Fuenfer) Punkte: Summe aller Fuenfen");
        JLabel rule6 = new JLabel("Feld6:(Sechser) Punkte: Summe aller Sechsen");
        JLabel rule7 = new JLabel("Feld7:(Dreierpasch) dreimal diesselbe Zahl->z.B 1+1+1+2+4=9 (Punkte: Augen aller Wuerfeln)");
        JLabel rule8 = new JLabel("Feld8:(Viererpasch) viermal diesselbe Zahl->z.B 1+1+1+1+6=10 (Punkte: Augen aller Wuerfeln)");
        JLabel rule9 = new JLabel("Feld9:(FullHouse) einmal zwei und einmal drei gleiche Zahlen");
        JLabel rule10 = new JLabel("z.B 1+1+1+2+2=9 (Punkte:25 unabhaengig von der Augenzahl)");
        JLabel rule11 = new JLabel("Feld10:(Kleine Strasse) Wuerfelkombination von 4 aufeinanderfolgenden Zahlen von 1-4 oder 2-5 oder 3-6");
        JLabel rule12 = new JLabel("z.B 2+3+4+5 (Punkte: 40)");
        JLabel rule13= new JLabel("Feld11:(Grosse Strasse) Wuerfelkombination von 4 aufeinanderfolgenden Zahlen von 1-5 oder 2-6");
        JLabel rule14 = new JLabel("z.B 1+2+3+4+5 (Punkte=40");
        JLabel rule15 = new JLabel("Feld12:(Kniffel) fuenfmal die selbe Zahl ->z.B 3+3+3+3+3");
        JLabel rule16 = new JLabel("Punkte: 50 für den ersten Kniffel, 100 für jeden weioteren Kniffel (kann in beliebiges Feld eintragen werden)");
        JLabel rule17 = new JLabel("Feld13:(Chance) keine besodnere Kombination (Punkte: Augen aller Wuerfel)");



        rulesPanel.add(title);
        rulesPanel.add(Box.createRigidArea(new Dimension(20, 20)));

        rulesPanel.add(rule1);
        rulesPanel.add(rule2);
        rulesPanel.add(rule3);
        rulesPanel.add(rule4);
        rulesPanel.add(rule5);
        rulesPanel.add(rule6);
        rulesPanel.add(rule7);
        rulesPanel.add(rule8);
        rulesPanel.add(rule9);
        rulesPanel.add(rule10);
        rulesPanel.add(rule11);
        rulesPanel.add(rule12);
        rulesPanel.add(rule13);
        rulesPanel.add(rule14);
        rulesPanel.add(rule15);
        rulesPanel.add(rule16);
        rulesPanel.add(rule17);



        rulesFrame.add(rulesPanel);

        rulesFrame.setVisible(true);
    }
}
