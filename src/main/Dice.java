package main;

import java.util.Random;
//nicht unser Main Dice-Klasse (weil Oz das macht)
public class Dice {
	
	private int value;
	private Random random; 

	public Dice() {
		this.value = 1;
		this.random = new Random();
	}
	
	public int getvalue() {
		return value;
	}
	
	public void setvalue(int value) {
		this.value = value;
	}
	
	public void rolled( ) {
		value = random.nextInt(6) +1;
	}
	
}
