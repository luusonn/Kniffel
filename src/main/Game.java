package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Game extends JFrame {

    private String[] categoryNames = {
            "Einser",
            "Zweier",
            "Dreier",
            "Vierer",
            "Fuenfer",
            "Sechser",
            "Dreierpasch",
            "Viererpasch",
            "Full House",
            "Kleine Strasse",
            "Grosse Strasse",
            "Kniffel",
            "Chance"
    };

    private int currentPlayer = 0;
    private Dicecup dicecup;
    private JLabel playerLabel;
    private JLabel totalLabel;
    private scoreblock scoreboard;
    private JSplitPane splitPane;
    private JTable table;
    private DefaultTableModel tableModel;


    public Game() {

        this(1);
    }


    public Game(int players) {

        scoreboard = new scoreblock(players);

        setTitle("KNIFFEL Game");
        setSize(1100, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JPanel scorePanel = createScorePanel(players);

        dicecup = new Dicecup();

        splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                scorePanel,
                dicecup
        );

        splitPane.setDividerLocation(350);
        splitPane.setResizeWeight(0.3);

        add(splitPane, BorderLayout.CENTER);

        setVisible(true);
    }


    private void categoryClicked(int category) {

        if (!dicecup.isConfirmed()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Press CONFIRM"
            );

            return;
        }


        if (scoreboard.read(currentPlayer, category) != 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Field is already used!"
            );

            return;
        }


        Dice[] dice = createDiceFromDicecup();

        Category[] categories = createCategories(dice);

        int points =
                categories[category].calculatePoints();

        showChoice(category, points);
    }


    private Category[] createCategories(Dice[] dice) {

        Category[] categories = {

                new Einser(dice),
                new Zweier(dice),
                new Dreier(dice),
                new Vierer(dice),
                new Fuenfer(dice),
                new Sechser(dice),
                new Dreierpasch(dice),
                new Viererpasch(dice),
                new Fullhouse(dice),
                new KleineStrasse(dice),
                new GrosseStrasse(dice),
                new KniffelR(dice),
                new Chance(dice)
        };

        return categories;
    }


    private Dice[] createDiceFromDicecup() {

        int[] values =dicecup.getDices();

        Dice[] dice =new Dice[5];


        for (int i = 0; i < 5; i++) {

            dice[i] = new Dice();

            dice[i].setValue(values[i]);
        }

       return dice;
    }


    private JPanel createScorePanel(int players) {

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        panel.setPreferredSize(
                new Dimension(350, 500)
        );


        playerLabel =new JLabel("Current Player: Player 1");

        panel.add(playerLabel,BorderLayout.NORTH);


        String[] spalten =new String[players + 1];

        spalten[0] = "Category";


        for (int i = 0; i < players; i++) {

            spalten[i + 1] =
                    "Player " + (i + 1);
        }


        Object[][] zeilen =new Object[13][players + 1];


        for (int category = 0;category < 13;category++) {

            zeilen[category][0] =categoryNames[category];
            
            for (int player = 0; player < players; player++) {

                zeilen[category][player + 1] = "";
            }
        }


        tableModel = new DefaultTableModel(zeilen,spalten) {

                    @Override
                    public boolean isCellEditable( int row, int column) {
                    	return false;
                    }
                };


        table = new JTable(tableModel);

        table.setRowHeight(28);


        table.getSelectionModel().addListSelectionListener(e -> {

                    if (e.getValueIsAdjusting()) {
                        return;
                    }

                    int row =table.getSelectedRow();

                    if (row != -1) {

                        categoryClicked(row);

                        table.clearSelection();
                    }
                });


        JScrollPane scrollPane =new JScrollPane(table);

        panel.add(scrollPane,BorderLayout.CENTER);


        totalLabel = new JLabel("Gesamt: 0");

        panel.add(totalLabel,BorderLayout.SOUTH
        );
        return panel;
    }


    private void finishTurn() {

        updateScoreTable();

        currentPlayer++;


        if (currentPlayer >= scoreboard.playercount()) {

            currentPlayer = 0;
        }


        playerLabel.setText("CurrentPlayer: Player:  "+ (currentPlayer + 1));
        
        createNewDicecup();
    }


    private void createNewDicecup() {

        dicecup = new Dicecup();

        splitPane.setRightComponent(dicecup);

        splitPane.setDividerLocation(350);

        revalidate();
        repaint();
    }


    private void showChoice(int category,int points) {

        Object[] options = {"Put in: " + points,"Cross out","Cancel"};

        int result = JOptionPane.showOptionDialog(this,categoryNames[category] + "\nPunkte: " + points,

                        "Choose Category",

                        JOptionPane.YES_NO_CANCEL_OPTION,

                        JOptionPane.QUESTION_MESSAGE,

                        null,

                        options,

                        options[0]
                );


        if (result == 0) {
        	
        	writePoints(category,points);

        }


        if (result == 1) {

            crossCategory(category);
        }
    }


    private void writePoints(int category,int points) {
    	
        if (points == 0) {

            scoreboard.streichen(currentPlayer,category);

        } 
        else {

            scoreboard.write(points,currentPlayer,category);
        }


        finishTurn();
    }


    private void crossCategory(int category) {

        scoreboard.streichen(currentPlayer,category);

        finishTurn();
    }


    private void updateScoreTable() {

        for (int category = 0;category < 13;category++) {


            for (int player = 0;player < scoreboard.playercount(); player++) {


                int value =scoreboard.read(player,category);


                if (value == 0) {

                    tableModel.setValueAt("",category,player + 1);

                } 
                else if (value == 900) {

                    tableModel.setValueAt(0,category,player + 1);

                } 
                else {tableModel.setValueAt(value,category,player + 1);
                }
            }
        }


        updateTotal();
    }


    private void updateTotal() {

        String text = "Total Points: ";


        for (int player = 0;player < scoreboard.playercount();player++) {

            int total = 0;

            for (int category = 0;category < 13;category++) {

                int value =scoreboard.read(player,category);


                if (value != 900) {total += value;
                }
            }


            text += "Spieler " + (player + 1) + ": " + total + "   ";
        }
        totalLabel.setText(text);
    }
}