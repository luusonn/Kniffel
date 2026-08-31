package main;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class ScoreblockGUI extends JFrame{

	    private JTable table;

	    public ScoreblockGUI() {

	        setTitle("Schreibblock");
	        setSize(400, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        String[] columns = {
	            "Kategorie",
	            "Spieler X"
	        };
	        
	        Object[][] rows = {
	        	    {"Einser", ""},
	        	    {"Zweier", ""},
	        	    {"Dreier", ""},
	        	    {"Vierer", ""},
	        	    {"Fünfer", ""},
	        	    {"Sechser", ""},
	        	    {"Dreierpasch", ""},
	        	    {"Viererpasch", ""},
	        	    {"Full House", ""},
	        	    {"Kleine Straße", ""},
	        	    {"Große Straße", ""},
	        	    {"Kniffel", ""},
	        	    {"Chance", ""}
	        	
	        		
	        };

	        table = new JTable(rows, columns) {

	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	        
	        table.addMouseListener(new MouseAdapter() {

	            @Override
	            public void mouseClicked(MouseEvent e) {

	                int row = table.getSelectedRow();

	                System.out.println("Clicked: " + row);
	            }
	        });

	        JScrollPane scrollPane = new JScrollPane(table);

	        add(scrollPane, BorderLayout.CENTER);

	        setVisible(true);
	    }
	}

