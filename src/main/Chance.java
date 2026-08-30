package main;

public class Chance {

    private Dice[] dice;

    public Chance(Dice[] dice) {
        this.dice = dice;
    }

    public int calculatePoints() {

        int points = 0;

        for (Dice d : dice) {
            points += d.getValue(d);
        }

        return points;
    }
}