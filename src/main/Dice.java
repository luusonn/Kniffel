package main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

public class Dice extends JPanel{

	Random r = new Random();
	 private int value = r.nextInt(6) + 1;;
	 private Color dcolor = Color.BLACK;
	 int selected = 0;

	    public Dice() {
	        setPreferredSize(new java.awt.Dimension (100, 100));
	        setBackground(Color.WHITE);
	    }


	    public void setValue(int value) {
	        this.value = value;
	        repaint();
	    }
	    
	    public int getValue(Dice d) {
	    	return d.value;
	    }
	    
	    public void setBorderColor(Color color) {
	    	dcolor = color;
	    	repaint();
	    }
	    
	    //selectable
	    public int getSelect(Dice d) {
	    	return selected;}
	    

	    @Override
	    protected void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	    	
	        Graphics2D g2 = (Graphics2D) g;

	        // dieser Teil des Interfaces wurde mit Ki generiert und dann angepasst
	        g2.setColor(Color.WHITE);
	        g2.fillRoundRect(5, 5, 90, 90, 15, 15);

	        g2.setColor(dcolor);
	        g2.drawRoundRect(5, 5, 90, 90, 15, 15);


	        g2.setColor(dcolor);

	        int dotSize = 15;

	        int left = 25;
	        int center = 50;
	        int right = 75;

	        int top = 25;
	        int middle = 50;
	        int bottom = 75;
	        
	        switch (value) {

            case 1:
                drawDot(g2, center, middle, dotSize);
                break;

            case 2:
                drawDot(g2, left, top, dotSize);
                drawDot(g2, right, bottom, dotSize);
                break;

            case 3:
                drawDot(g2, left, top, dotSize);
                drawDot(g2, center, middle, dotSize);
                drawDot(g2, right, bottom, dotSize);
                break;

            case 4:
                drawDot(g2, left, top, dotSize);
                drawDot(g2, right, top, dotSize);
                drawDot(g2, left, bottom, dotSize);
                drawDot(g2, right, bottom, dotSize);
                break;
                
            case 5:
                drawDot(g2, left, top, dotSize);
                drawDot(g2, right, top, dotSize);
                drawDot(g2, center, middle, dotSize);
                drawDot(g2, left, bottom, dotSize);
                drawDot(g2, right, bottom, dotSize);
                break;

            case 6:
                drawDot(g2, left, top, dotSize);
                drawDot(g2, right, top, dotSize);
                drawDot(g2, left, middle, dotSize);
                drawDot(g2, right, middle, dotSize);
                drawDot(g2, left, bottom, dotSize);
                drawDot(g2, right, bottom, dotSize);
                break;
        }
    }
	    private void drawDot(Graphics2D g2, int x, int y, int size) {

	        g2.fillOval(
	                x - size / 2,
	                y - size / 2,
	                size,
	                size
	        );
	    }
}
