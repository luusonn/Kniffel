package main;

public class Fuenfer implements Category {
    private Dice[] dice;

    public Fuenfer(Dice[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dice d: dice) {
            if(d.getValue(d) == 5) {
                number++;
            }
        }

        number *= 5;
        return number;
    }
}
