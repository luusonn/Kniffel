public class Vierer {
    private Dice[] dice;

    public Vierer(Dice[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dice d: dice) {
            if(d.getvalue() == 4) {
                number++;
            }
        }

        number *= 4;
        return number;
    }
}

