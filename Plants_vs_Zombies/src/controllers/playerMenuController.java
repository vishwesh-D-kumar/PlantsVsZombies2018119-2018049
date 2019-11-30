package controllers;

import gameclasses.player;
import helper.sceneLoader;
import javafx.event.ActionEvent;

public class playerMenuController {
    player mainplayer=player.getCurrPlayer();



    public void changeScreen(ActionEvent evt){
        sceneLoader.changeScreen(evt);
    }

    public void resume(ActionEvent evt) {
        mainplayer=player.getCurrPlayer();
        if (mainplayer.isInGame()){
            sceneLoader.changeScreen("gameStage");

        }
        else{
            sceneLoader.changeScreen("plantSelect");
        }
    }

    public void levelSelect(ActionEvent evt) {
            sceneLoader.changeScreen("levelSelect");


    }
}
