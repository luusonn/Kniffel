package main;

public class Zweier implements Category {
    private Dice[] dice;

    public Zweier(Dice[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dice d: dice) {
            if(d.getValue(d) == 2) {
                number++;
            }
        }

        number *= 2;
        return number;
    }
}
