package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dicecup extends JPanel{

	private Dice[] dice;
	private int dices[] = new int[5];
	private JButton[] diceButtons;
	
	private boolean confirm = false;
    private Random random = new Random();
	private int counterroll = 1;
	private JLabel fertig= new JLabel("ZUG BEENDET!");
     
	public Dicecup() {
		
	        setSize(700, 500);
	        setLayout(new BorderLayout());

	        JPanel dicePanel = new JPanel(); 
	        dicePanel.setLayout(null); //so i can manually position dice
	        
	        dice = new Dice[5];
	        diceButtons = new JButton[5];
	        
	        int[] xPositions = {30,160,290,420,550};
	        
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
	            	}});
	           dicePanel.add(diceButtons[i]);
	           
	            }

	        add(dicePanel, BorderLayout.CENTER);
	        
	        JButton rollButton = new JButton("ROLL DICE");

	        rollButton.setFont(new Font("Arial", Font.BOLD, 20));
	        rollButton.setBounds(275, 200, 150, 50);
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
	        
	        JButton confirmButton = new JButton("CONFIRM");

	        confirmButton.setFont(new Font("Arial", Font.BOLD, 20));
	        confirmButton.setBounds(275, 300, 150, 50);
	        confirmButton.addActionListener(new ActionListener() {
	           // @Override
	            public void actionPerformed(ActionEvent e) {
	            	if (confirm == false) {
	            		counterroll = 4;
	            		
	            		for (int i = 0; i < 5; i++) {
	            		    dices[i] = dice[i].getValue(dice[i]);}
	            		
	            		confirm = true;
	            	}
	            	else {
	            		for(int i = 0; i < 5; i ++) {
	            			dices[i] = 0;
	            		}
	            		confirm = false;
	            		if (fertig != null) {dicePanel.remove(fertig);
	            							fertig = null;}
	            		counterroll = 0;
	            		for (int i = 0; i< 5; i++) { if(dice[i].selected == 1) {select(dice[i], diceButtons[i]);};}
	            	}
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
}}

public int[] getDices() {
	return dices;
}

public boolean isConfirmed() {
	return confirm;
}
}

