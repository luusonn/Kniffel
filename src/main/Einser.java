package main;

public class Einser implements Category {
    private Dice[] dice;

    public Einser(Dice[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dice d: dice) {
            if(d.getValue(d) == 1) {
                number++;
            }
        }


        return number;
    }
}
