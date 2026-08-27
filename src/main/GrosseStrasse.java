package main;

public class GrosseStrasse {
	
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
			
			if (longestSequence > sequence) {
				longestSequence = sequence;
			}
		}
		
		if (longestSequence >= 4) {
			return 30;
		}
		return 0;
	}
	
}
