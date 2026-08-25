public class Sechser {
    private Dicetest[] dice;

    public Sechser(Dicetest[] dice) {
        this.dice = dice;
    }

    public int calculatePoints() {

            int number = 0;// amount of times the number appears

            for (Dicetest d: dice) {
                if(d.getvalue() == 6) {
                    number++;
                }
            }

        number *= 6;
        return number;
    }
    }


