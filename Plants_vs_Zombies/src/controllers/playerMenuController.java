package controllers;

import gameclasses.player;
import helper.sceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class playerMenuController {
    player mainplayer=player.getCurrPlayer();



    public void changeScreen(ActionEvent evt){
        sceneLoader.changeScreen(evt);
    }

    public void resume(ActionEvent evt) throws IOException {
        mainplayer=player.getCurrPlayer();
        if (mainplayer.isInGame()|| true){
            sceneLoader.getNameToPath().put("gameStage","/fxmls/GameStage.fxml");
            String url=sceneLoader.getNameToPath().get("gameStage");
            Parent root = FXMLLoader.load(getClass().getResource(url));
            sceneLoader.getNameToScene().put("gameStage",new Scene(root,678,482));
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
