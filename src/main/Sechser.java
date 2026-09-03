package main;

public class Sechser implements Category {
    private Dice[] dice;

    public Sechser(Dice[] dice) {
        this.dice = dice;
    }

    public int calculatePoints() {

            int number = 0;// amount of times the number appears

            for (Dice d: dice) {
                if(d.getValue(d) == 6) {
                    number++;
                }
            }

        number *= 6;
        return number;
    }
    }


