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

    public int write(Dice[] dice,int player,int category){
        
        if((scoreboard[category][player]!=0)){return 0;}
        if((category==13)&&kniffelcheck()==false){scoreboard[category][player]=100;return 2;}

        else {scoreboard[category][player]=rules.implentRule(dice,category);
        return 3;
        }
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

    private boolean kniffelcheck(){
        for(int x=0;x>players;x++){
            if((scoreboard[11][x]!=0)&&(scoreboard[13][x]!=900)){return false;}//900 because it does not apply unless val!=900
        }
        return true;
    }
}
