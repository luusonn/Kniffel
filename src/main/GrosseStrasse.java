package main;

public class GrosseStrasse implements Category {
	
	private Dice[] dice;
	
	public GrosseStrasse(Dice[] dice) {
		this.dice = dice;
	}

	public int calculatePoints() {
		
		boolean[] numbers = new boolean[7];
		
		for (Dice d: dice) {
			numbers[d.getValue(d)] = true;
		}
		
		int previous = 0;
		int sequence = 0;
		int longestSequence = 0;
		
		for(int i =1; i <=6;i++) {
			if(!numbers[i]) {
				continue;
			}
			
			if (i == previous +1) {
				sequence++;
			}
			else {
				sequence = 1;
			}
			
			previous = i;
			
			if (sequence > longestSequence) {
				longestSequence = sequence;
			}
		}
		
		if (longestSequence >= 4) {
			return 50;
		}
		return 0;
	}
	
}
