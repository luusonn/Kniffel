package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectNumber extends JFrame {

    private int number;

    public SelectNumber() {

        setTitle("Select Number");

        setSize(400,400);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        add(panel);
       
        
        JLabel text = new JLabel("Enter a number from 1 and 5!");
        

        JTextField textField = new JTextField(5);

        panel.add(textField);

        JButton saveNumber = new JButton("LET'S GOO!!");
        
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
  

        panel.add(text);

        panel.add(Box.createRigidArea(new Dimension(0, 40)));

        panel.add(textField);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

       panel.add(saveNumber);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

  
        
        add(panel);
        
        setVisible(true);


        saveNumber.addActionListener(e -> {

            String input = textField.getText();

            try {

                number = Integer.parseInt(input);

                if(number < 1 || number > 5) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Enter a number between 1 and 5!"
                    );

                    return;
                }

                new Game(number);

                dispose();

            } catch(NumberFormatException error) {JOptionPane.showMessageDialog(this,"No letters!");
            }
        });
    }
}