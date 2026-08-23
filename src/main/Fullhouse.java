package main;

public class Fullhouse {
	
	private Dice[] dice;
	
	public Fullhouse(Dice[] dice) {
		this.dice = dice;
	}
	
	public int calculatePoints() {
		boolean pair = false;
		boolean triple = false;
		
		for (int i = 1; i <= 6; i++) {
			int number = 0;
			
			for (Dice d: dice) {
				if(d.getvalue() == i) {
					number++;
				}
			}
			if (number == 2) {
				pair = true;
				
			if (number == 3) {
				triple =true;
			}
		}
			if (pair && triple) {
				return 25;
			}
		
		}
		return 0;
	}

}
