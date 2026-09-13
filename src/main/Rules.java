package main;


public class Rules {

    public Rules(){}


public int implentRule(DiceGUI[] dice,int rulenumber){
    switch(rulenumber){
        case 0: return einser(dice);
        case 1: return zweier(dice);
        case 2: return dreier(dice);
        case 3: return vierer(dice);
        case 4: return fuenfer(dice);
        case 5: return sechser(dice);
        case 6: return dreierpasch(dice);
        case 7: return viererpasch(dice);
        case 8: return fullhouse(dice);
        case 9: return kleinestrasse(dice);
        case 10: return grossestrasse(dice);
        case 11: return kniffel(dice);
        case 12: return chance(dice);

        default:return 1000;}//error happened

}

private int einser(DiceGUI[] dice){
    int number = 0;// amount of times the number appears(same for following classes)

    for (DiceGUI d: dice) {
        if(d.getValue() == 1) {
            number++;
        }
    }
    return number;
}

private int zweier(DiceGUI[] dice){
    int number = 0;

    for (DiceGUI d: dice) {
        if(d.getValue() == 2) {
            number++;
        }
    }
    number =number*2;
    return number;
}

private int dreier(DiceGUI[] dice){
    int number = 0;

    for (DiceGUI d: dice) {
        if(d.getValue() == 3) {
            number++;
        }
    }
    number =number*3;
    return number;
}

private int vierer(DiceGUI[] dice){
    int number = 0;

    for (DiceGUI d: dice) {
        if(d.getValue() == 4) {
            number++;
        }
    }
    number =number*4;
    return number;
}

private int fuenfer(DiceGUI[] dice){
    int number = 0;

    for (DiceGUI d: dice) {
        if(d.getValue() == 5) {
            number++;
        }
    }
    number =number*5;
    return number;
}

private int sechser(DiceGUI[] dice){
    int number = 0;// amount of times the number appears

    for (DiceGUI d: dice) {
        if(d.getValue() == 6) {
            number++;
        }
    }
    number =number*6;
    return number;
}

private int dreierpasch(DiceGUI[] dice){

    for(int i=1;i<=6;i++) {
        int number =0;

        for(DiceGUI d: dice) {
            if(d.getValue() ==i){
                number++;
            }
        }
        if ( number >= 3) {
            int points =0;

            for(DiceGUI d : dice) {
                points += d.getValue();
            }
            return points;
        }
    }
    return 0;}

private int viererpasch(DiceGUI[] dice){for(int i=1;i<=6;i++) {
    int number =0;
    for(DiceGUI d: dice) {
        if(d.getValue() ==i){
            number++;
        }
    }
    if ( number >= 4) {
        int points =0;

        for(DiceGUI d : dice) {
            points += d.getValue();
        }
        return points;
    }
}
    return 0;}

private int fullhouse(DiceGUI[] dice){
    boolean pair = false;
    boolean triple = false;
    for (int i = 1; i <= 6; i++) {
        int number = 0;

        for (DiceGUI d : dice) {
            if (d.getValue() == i) {
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

private int kleinestrasse(DiceGUI[] dice) {
    boolean[] numbers = new boolean[7];

    for (DiceGUI d : dice) {
        numbers[d.getValue()] = true;
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

        if (sequence > longestSequence) {
            longestSequence = sequence;
        }
    }

    if (longestSequence >= 4) {
        return 30;
    }
    return 0;
}
private int grossestrasse(DiceGUI[] dice){
    boolean[] numbers = new boolean[7];

    for (DiceGUI d: dice) {
        numbers[d.getValue()] = true;
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

        if (sequence > longestSequence) {
            longestSequence = sequence;
        }
    }

    if (longestSequence >= 4) {
        return 40;
    }
    return 0;
}

private int kniffel(DiceGUI[] dice){
    int number1 = dice[0].getValue();
    for (DiceGUI d : dice) {
        int currentNumber = d.getValue();
        if (currentNumber != number1) {
            return 0;
        }
    }
    return 50;
}

private int chance(DiceGUI[] dice){
    int points = 0;
    for (DiceGUI d : dice) {
        points += d.getValue();
    }
    return points;
}

void main() {
}
}
