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
import javax.swing.JTextArea;

public class Menu extends JFrame {

    public Menu() {

        setTitle("KNIFFEL Game");
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


        // START BUTTON
        startButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                new Game(2);

                dispose();
            }
        });


        // RULES BUTTON
        rulesButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                showRules();
            }
        });


        // QUIT BUTTON
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
        JTextArea rule1 = new JTextArea(" Ziel: die meisten Punkte bekommen durch geschicktes Würfeln bestimmter Kombinationen"
        		+ "\n Jeder Spieler würfelt bis zu 3 mal wobei er eine beiebige Anzahl an Würfeln beiseite legen kann um folgende Kategorien zu füllen:"
        		+ "\n\n Feld1: (Einser) Punkte: Summe aller Einsen"
        		+ "\n Feld2: (Zweier) Punkte: Summe aller Zweien"
        		+ "\n Feld3: (Dreier) Punkte: Summe aller Dreien"
        		+ "\n Feld4: (Vierer) Punkte: Summe aller Vieren"
        		+ "\n Feld5: (Fuenfer) Punkte: Summe aller Fuenfen"
        		+ "\n Feld6: (Sechser) Punkte: Summe aller Sechsen"
        		+ "\n Feld7: (Dreierpasch) dreimal diesselbe Zahl->z.B 1+1+1+2+4=9 (Punkte: Augen aller Wuerfeln)"
        		+ "\n Feld8:(Viererpasch) viermal diesselbe Zahl->z.B 1+1+1+1+6=10 (Punkte: Augen aller Wuerfeln)"
        		+ "\n Feld9: (FullHouse) einmal zwei und einmal drei gleiche Zahlen z.B 1+1+1+2+2=9 (Punkte:25 unabhaengig von der Augenzahl)"
        		+ "\n Feld10: (Kleine Strasse) Wuerfelkombination von 4 aufeinanderfolgenden Zahlen von 1-4 oder 2-5 oder 3-6 z.B 2+3+4+5 (Punkte: 40)\""
        		+ "\n Feld11: (Grosse Strasse) Wuerfelkombination von 4 aufeinanderfolgenden Zahlen von 1-5 oder 2-6 z.B 1+2+3+4+5 (Punkte=40"
        		+ "\n Feld12: (Kniffel) fuenfmal die selbe Zahl ->z.B 3+3+3+3+3 \n               Punkte: 50 für den ersten Kniffel, 100 für jeden weiteren Kniffel (kann in beliebiges Feld eintragen werden)"
        		+ "\n Feld13: (Chance) keine besondere Kombination (Punkte: Augen aller Wuerfel)"); 
        
        JTextArea rule2 = new JTextArea(" nüzliche Anmerkungen zum Programm: \n"
        		+ "\n Nach Beginn des Kniffelspiels und auswählen der Spieleranzahl seht ihr das Spiel vor euch."
        		+ "\n\n In der linken oberen Ecke steht der momentane Spieler. Links unten der momentane Punktestand."
        		+ "\n\n Das System würfelt einmal AUTOMATISCH. Die vorgegebenen Würfel könnt ihr also als ersten der 3 Würfe pro Runde sehen."
        		+ "\n Unter jedem Würfel ist ein Knopf 'select', ausgewählte Würfel werden rot und werden beim nächsten würfeln NICHT mitgewürfelt."
        		+ "\n Wenn das gewünschte Ergebnis für eine der Kategorien erreicht ist oder 3 mal gewürfelt wurde, drückt auf den 'confirm'-Button."
        		+ "\n\n Jetzt könnt ihr eure Punkte in die Tabelle eintragen lassen."
        		+ "\n Dazu einfach auf die Spalte drücken und dann mit dem 'Put in: ...' Knopf bestätigen."
        		+ "\n Dein Zug ist damit beendet. Jetzt wird automatisch für den nächsten Spieler gewürfelt."
        		+ "\n\n Wenn du keine Punkte für eine Kategorie erreicht hast kannst du diese auch streichen lassen. "
        		+ "\n Daraufhin wird in diese Katrgorie eine Null geschrieben und sie wird nicht bewertet.");

        rule1.setEditable(false);
        rule2.setEditable(false);

        rulesPanel.add(title);

        rulesPanel.add(
                Box.createRigidArea(
                        new Dimension(20, 20)
                )
        );


        rulesPanel.add(rule1);
        rulesPanel.add(rule2);


        rulesFrame.add(rulesPanel);

        rulesFrame.setVisible(true);
    }
}