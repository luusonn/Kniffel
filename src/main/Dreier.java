public class Dreier {
    private Dice[] dice;

    public Dreier(Dice[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dice d: dice) {
            if(d.getvalue() == 3) {
                number++;
            }
        }

        number *= 3;
        return number;
    }
}
