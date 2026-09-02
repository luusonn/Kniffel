public class Einser {
    private Dice[] dice;

    public Einser(Dice[] dice) {
        this.dice = dice;

    }
    public int calculatePoints() {

        int number = 0;// amount of times the number appears

        for (Dice d: dice) {
            if(d.getvalue() == 1) {
                number++;
            }
        }


        return number;
    }
}
