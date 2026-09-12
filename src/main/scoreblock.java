package main;

public class scoreblock {
    private Rules rules;
    private int[][] scoreboard;
    private int players;

    public scoreblock(int players){
        this.players = players;
        this.scoreboard = new int[13][players];
        this.rules = new Rules();
    }

    public int calculate(Dice[] dice,int player, int category) {
    	if((scoreboard[category][player]!=0)){return 0;}
        if((rules.implentRule(dice,11)==50)&&kniffelcheck(player)==false){return 100;}
        else {return rules.implentRule(dice, category);}
    }
    
    public void write(int points, int player, int category){
        if(points == 100){scoreboard[category][player]=100;}
        else {scoreboard[category][player]=points;}
    }

    public int delete(int player,int category){
        if(scoreboard[category][player]==0){return 0;}//if its 0 no need to rewrite
        else{scoreboard[category][player]=0;return 1;}//maybe exclude 900 too
    }

    public int streichen(int player, int category){
        if(scoreboard[category][player]==0){scoreboard[category][player]=900;return 1;}
        else{return 0;}
    }

    public int read(int player, int category){
    return scoreboard[category][player];
    }

    public int playercount(){return this.players;}

    private boolean kniffelcheck(int player){
 
            if((scoreboard[11][player]!=0)&&(scoreboard[11][player]!=900)){return false;}//900 because it does not apply unless val!=900
            else{return true;}
    }
}
