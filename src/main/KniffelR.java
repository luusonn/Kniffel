package main;

public class KniffelR {

    private Dice[] dice;

    public KniffelR(Dice[] dice) {
        this.dice = dice;
    }

    public int calculatePoints() {

        int number1 = dice[0].getValue(dice[0]);

        for (Dice d : dice) {

            int currentNumber = d.getValue(d);

            if (currentNumber != number1) {
                return 0;
            }
        }

        return 50;
    }
}