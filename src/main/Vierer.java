package main;

public class Vierer implements Category {
    private Dicetest[] dice;

    public Vierer(Dicetest[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dicetest d: dice) {
            if(d.getvalue() == 4) {
                number++;
            }
        }

        number *= 4;
        return number;
    }
}

