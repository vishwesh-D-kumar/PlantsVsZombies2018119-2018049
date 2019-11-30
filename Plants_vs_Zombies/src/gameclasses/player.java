package gameclasses;

import java.io.Serializable;
import java.util.ArrayList;

public class player implements Serializable {
    private int coins;
    private ArrayList<entity.Plant> unlockedPlants;
    private int levelUnlocked;
    private boolean inGame;
    //Fixme
    private static player currPlayer;
    public player(){
        unlockedPlants=new ArrayList<>();
        inGame=false;
        levelUnlocked=0;

    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public static void setCurrPlayer(player currPlayer) {
        player.currPlayer = currPlayer;
    }

    public static player getCurrPlayer() {
        return currPlayer;

    }
}

