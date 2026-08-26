package main;

public class Dreier {
    private Dicetest[] dice;

    public Dreier(Dicetest[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dicetest d: dice) {
            if(d.getvalue() == 3) {
                number++;
            }
        }

        number *= 3;
        return number;
    }
}
