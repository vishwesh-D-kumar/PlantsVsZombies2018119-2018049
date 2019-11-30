package gameclasses;

import entity.Plant;
import errors.notEnoughCoins;

import java.io.Serializable;
import java.util.ArrayList;

public class player implements Serializable {
    private int coins;
    private int numSlots;

//    private ArrayList<entity.Plant> unlockedPlants;
    private int levelUnlocked;
    private boolean inGame;
    private boolean [] unlockedPlants;

    //Fixme
    private static player currPlayer;
    public player(){
        unlockedPlants=new boolean[10]; //Order of use :pea shooter,snowpeashooter,wallnut,torchwood,firepeashooter,potatomine,
        for (int i = 0; i <10; i++) {
            unlockedPlants[i]=false;
        }
        unlockedPlants[0]=true;

        inGame=false;
        levelUnlocked=0;


    }

    public boolean[] getUnlockedPlants() {
        return unlockedPlants;
    }

    public void setUnlockedPlants(boolean[] unlockedPlants) {
        this.unlockedPlants = unlockedPlants;
    }

    public int getNumSlots() {
        return numSlots;
    }

    public void setNumSlots(int numSlots) {
        this.numSlots = numSlots;
    }

    public int getCoins() {
        return coins;
    }
    public void addSlot(){
        this.numSlots+=1;

    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    public void addCoins(int x){
        this.coins+=x;
    }
    public void reduceCoins(int x) throws notEnoughCoins {
        if(this.coins-x<0){
            throw new errors.notEnoughCoins();

        }
        this.coins-=x;


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

