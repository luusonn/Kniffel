public class scoreblock {
    private int[][] scoreboard;
    private int players;

    public scoreblock(int players){
        this.players = players;
        scoreboard = new int[13][players];
    }

    public int write(int points,int player,int category){
        boolean b = scoreboard[category][player] == 900;
        if((scoreboard[category][player]!=0)|| b){return 0;}//if the int is not 0 theres alr points written there so we shouldnt override them 900 is used to cancel any interaction
        else{scoreboard[category][player]=points;return 1;}
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
}
