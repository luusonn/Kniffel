package main;

public class Fuenfer implements Category {
    private Dicetest[] dice;

    public Fuenfer(Dicetest[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dicetest d: dice) {
            if(d.getvalue() == 5) {
                number++;
            }
        }

        number *= 5;
        return number;
    }
}
