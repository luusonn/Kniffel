package main;

import java.util.Random;

public class dice {

	public dice() {
		private int surfaces;
		private Rondom random;
		
		
		public Dice(int surfaces) {
			this(6);
		}
		
		public int throw() {
			
			return random.nextInt(surfaces) +1;
		}
	}

}
