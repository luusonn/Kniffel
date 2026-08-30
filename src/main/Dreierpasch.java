package main;

public class Dreierpasch implements Category {
	
	private Dice[] dice;
	
	public Dreierpasch(Dice[] dice) {
		this.dice = dice;
	}
	
	public int calculatePoints() {
		
		for(int i=1;i<=6;i++) {
			int number =0;
			
			for(Dice d: dice) {
				if(d.getValue(d) ==i){
					number++;
				}
			}
			if ( number >= 3) {
				int points =0;
				
				for(Dice d : dice) {
					points += d.getValue(d);
				}
				return points;
			}
		}
		return 0;
	}

}
