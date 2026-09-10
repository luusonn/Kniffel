package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;

public class EndScreen extends JFrame {

	public EndScreen(scoreblock scoreboard) {
		
			boolean[] bonus = new boolean[scoreboard.playercount()];
			int[] totals = new int[scoreboard.playercount()];
		  	setTitle("Game Over");
	        setSize(450, 700);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);

	        JPanel panel = new JPanel();

	        for (int player = 0; player < scoreboard.playercount(); player++) {

	            int total = 0;
	            int b = 0;

	            for (int category = 0; category < 13; category++) {

	                int value = scoreboard.read(player, category);

	                if (category == 6 && total >= 63) {
	                    total += 35;
	                }

	                if (value != 900) {
	                	bonus[player] = false;
	                    total += value;
	                }
	            }

	            totals[player] = total;
	            if (bonus[player] = false) { b = 35;}
	            
	            JTextArea credits = new JTextArea("Player" + (player +1 ) + ": " + total + " points"
	            									+ "\nBonus: " + b);
	            
	            credits.setFont(new Font("Arial", Font.PLAIN, 40));
	            credits.setEditable(false);
	            panel.add(credits);
	        }
	        
	        int winner = 0;
	        for(int t = 1; t < totals.length; t++) { if(totals[t] > totals[t-1]) {winner = t;}}
	        JTextArea winning = new JTextArea("Winner: " + "Player " + (winner+1) + "!!!");
	        winning.setFont(new Font("Arial", Font.PLAIN, 45));
	        winning.setEditable(false);
	        
	        panel.add(winning);

	        add(panel);
	        setVisible(true);
	    }
	}
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       