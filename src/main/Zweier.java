package main;

public class Zweier implements Category {
    private Dicetest[] dice;

    public Zweier(Dicetest[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dicetest d: dice) {
            if(d.getvalue() == 2) {
                number++;
            }
        }

        number *= 2;
        return number;
    }
}
