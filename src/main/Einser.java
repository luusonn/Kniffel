package main;

public class Einser implements Category {
    private Dicetest[] dice;

    public Einser(Dicetest[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dicetest d: dice) {
            if(d.getvalue() == 1) {
                number++;
            }
        }


        return number;
    }
}
