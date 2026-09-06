package main;


public class Rules {

    public Rules(){}


public int implentRule(Dice[] dice,int rulenumber){
    if(rulenumber==1){return einser(dice);}
    if(rulenumber==2){return zweier(dice);}
    if(rulenumber==3){return dreier(dice);}
    if(rulenumber==4){return vierer(dice);}
    if(rulenumber==5){return fuenfer(dice);}
    if(rulenumber==6){return sechser(dice);}
    if(rulenumber==7){return dreierpasch(dice);}
    if(rulenumber==8){return viererpasch(dice);}
    if(rulenumber==9){return fullhouse(dice);}
    if(rulenumber==10){return kleinestrasse(dice);}
    if(rulenumber==11){return grossestrasse(dice);}
    if(rulenumber==12){return kniffel(dice);}
    if(rulenumber==13){return chance(dice);}

    else{return 1000;}//error happened

}










private int einser(Dice[] dice){
    int number = 0;// amount of times the number appears(same for following classes)

    for (Dice d: dice) {
        if(d.getValue(d) == 1) {
            number++;
        }
    }
    return number;
}

private int zweier(Dice[] dice){
    int number = 0;

    for (Dice d: dice) {
        if(d.getValue(d) == 2) {
            number++;
        }
    }
    number =number*2;
    return number;
}

private int dreier(Dice[] dice){
    int number = 0;

    for (Dice d: dice) {
        if(d.getValue(d) == 3) {
            number++;
        }
    }
    number =number*3;
    return number;
}

private int vierer(Dice[] dice){
    int number = 0;

    for (Dice d: dice) {
        if(d.getValue(d) == 4) {
            number++;
        }
    }
    number =number*4;
    return number;
}

private int fuenfer(Dice[] dice){
    int number = 0;

    for (Dice d: dice) {
        if(d.getValue(d) == 5) {
            number++;
        }
    }
    number =number*5;
    return number;
}

private int sechser(Dice[] dice){
    int number = 0;// amount of times the number appears

    for (Dice d: dice) {
        if(d.getValue(d) == 6) {
            number++;
        }
    }
    number =number*6;
    return number;
}

private int dreierpasch(Dice[] dice){

    for(int i=1;i<=6;i++) {
        int number =0;

        for(Dice d: dice) {
            if(d.getValue(d) ==i){
                number++;
            }
        }
        if ( number >= 3) {
            int points =0;

            for(Dice d : dice) {
                points += d.getValue(d);
            }
            return points;
        }
    }
    return 0;}

private int viererpasch(Dice[] dice){for(int i=1;i<=6;i++) {
    int number =0;
    for(Dice d: dice) {
        if(d.getValue(d) ==i){
            number++;
        }
    }
    if ( number >= 4) {
        int points =0;

        for(Dice d : dice) {
            points += d.getValue(d);
        }
        return points;
    }
}
    return 0;}

private int fullhouse(Dice[] dice){
    boolean pair = false;
    boolean triple = false;
    for (int i = 1; i <= 6; i++) {
        int number = 0;

        for (Dice d : dice) {
            if (d.getValue(d) == i) {
                number++;
            }
        }

        if (number == 2) {
            pair = true;
        }

        if (number == 3) {
            triple = true;
        }
    }

    if (pair && triple) {
        return 25;
    }

    return 0;
}

private int kleinestrasse(Dice[] dice) {
    boolean[] numbers = new boolean[7];

    for (Dice d : dice) {
        numbers[d.getValue(d)] = true;
    }
    int previous = 0;
    int sequence = 0;
    int longestSequence = 0;

    for (int i = 1; i <= 6; i++) {
        if (!numbers[i]) {
            continue;
        }

        if (i == previous + 1) {
            sequence++;
        } else {
            sequence = 1;
        }

        previous = i;

        if (longestSequence > sequence) {
            longestSequence = sequence;
        }
    }

    if (longestSequence >= 4) {
        return 30;
    }
    return 0;
}
private int grossestrasse(Dice[] dice){
    boolean[] numbers = new boolean[7];

    for (Dice d: dice) {
        numbers[d.getValue(d)] = true;
    }

    int previous = 0;
    int sequence = 0;
    int longestSequence = 0;

    for(int i =1; i <=6;i++) {
        if(!numbers[i]) {
            continue;
        }

        if (i == previous +1) {
            sequence++;
        }
        else {
            sequence = 1;
        }

        previous = i;

        if (longestSequence > sequence) {
            longestSequence = sequence;
        }
    }

    if (longestSequence >= 4) {
        return 30;
    }
    return 0;
}

private int kniffel(Dice[] dice){
    int number1 = dice[0].getValue(dice[0]);
    for (Dice d : dice) {
        int currentNumber = d.getValue(d);
        if (currentNumber != number1) {
            return 0;
        }
    }
    return 50;
}

private int chance(Dice[] dice){
    int points = 0;
    for (Dice d : dice) {
        points += d.getValue(d);
    }
    return points;
}

void main() {
}
}