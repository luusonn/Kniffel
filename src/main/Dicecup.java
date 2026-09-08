package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dicecup extends JPanel{

	private Dice[] dice;
	private JButton[] diceButtons;
	private JButton[] rigg = new JButton[5];
	int[] xPositions = {30,160,290,420,550};
	
	private boolean confirm = false;
    private Random random = new Random();
	private int counterroll = 1;
	private JLabel fertig= new JLabel("ZUG BEENDET!");
     
	public Dicecup() {
		
			setLayout(new BorderLayout());

	        JPanel dicePanel = new JPanel(); 
	        dicePanel.setLayout(null); //so i can manually position dice
	        
	        dice = new Dice[5];
	        diceButtons = new JButton[5];
	        
	        for (int i = 0; i < 5; i++) {
	        	
	            dice[i] = new Dice();
	            dice[i].setBounds(xPositions[i], 20, 100, 100);
	            dicePanel.add(dice[i]);
	            
	            int k = i;
	            diceButtons[i] = new JButton("select");
	            diceButtons[i].setFont(new Font("Arial", Font.BOLD, 14));
	            diceButtons[i].setBounds(xPositions[i], 135, 100, 40);
	            diceButtons[i].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
	            	select(dice[k], diceButtons[k]);
	            	}                                                                   });
	           dicePanel.add(diceButtons[i]);
	           
	            }
	        // die beiden zeilen fügen Knöpfe zum manuellen Verändern der Würfel ein ( for rigging)
	       // riggbuttons();
	       // for(int f = 0; f < 5; f++) {dicePanel.add(rigg[f]);}

	        add(dicePanel, BorderLayout.CENTER);
	        
	        //Button to roll the dice and wnforce to only roll 3 times
	        JButton rollButton = new JButton("ROLL DICE");

	        rollButton.setFont(new Font("Arial", Font.BOLD, 20));
	        rollButton.setBounds(275, 210, 150, 50);
	        rollButton.addActionListener(new ActionListener() {
	           // @Override
	            public void actionPerformed(ActionEvent e) {
	            	counterroll++;
	            	if (counterroll < 4) {
	                rollDice();}
	            	else { if(fertig == null) {fertig = new JLabel("ZUG BEENDET");}
	            	fertig.setFont(new Font("Arial", Font.BOLD, 20));
						fertig.setBounds(100, 200, 200,50);
						dicePanel.add(fertig);
						dicePanel.repaint();}
	            }
	        });
	        
	        dicePanel.add(rollButton);
	        
	        //confirm button locks in current dice
	        JButton confirmButton = new JButton("CONFIRM");

	        confirmButton.setFont(new Font("Arial", Font.BOLD, 20));
	        confirmButton.setBounds(275, 300, 150, 50);
	        confirmButton.addActionListener(new ActionListener() {
	           // @Override
	            public void actionPerformed(ActionEvent e) {
	            		counterroll = 4;
	            		confirm = true;

	            		dicePanel.repaint();
	            }
	        });
	        
	        dicePanel.add(confirmButton);
	    }

	
	
private void rollDice() {
	for (Dice die : dice) {
		if (die.getSelect(die) == 1) {continue;}
        int value = random.nextInt(6) + 1;
        die.setValue(value);
        }
}


private void select(Dice d, JButton diceB) {
	if(d.selected == 0) {d.selected = 1;
		diceB.setText("selected");
		d.setBorderColor(Color.RED);}
	else {d.selected = 0;
		diceB.setText("select");
		d.setBorderColor(Color.BLACK);
		}
}

public Dice[] getDice() {
	return dice;
}

public boolean isConfirmed() {
	return confirm;
}

private void riggbuttons() {	
	for(int i = 0; i < 5; i++) {
		int k = i;
		rigg[k] = new JButton("+1");
        rigg[k].setBounds(xPositions[k], 180, 100, 20);
        rigg[k].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
        	int v = dice[k].getValue(dice[k]) + 1;
        	if (v > 6) {v = 1;};
        	dice[k].setValue(v);}});
		}
}
}

