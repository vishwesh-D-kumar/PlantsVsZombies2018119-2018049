package controllers;

import gameclasses.player;
import helper.login;
import helper.sceneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class loginController {
    @FXML public Button login;
    @FXML public TextField userName;
    @FXML public TextField password;

    @FXML public TextField error;
    private helper.login logger;



    private void initialize(){
        if (logger==null){
            try {
                logger= helper.login.deserialize();
            } catch (Exception e) {
                logger=new login();
            }
        }
    }
    public void login(ActionEvent evt){
        initialize();
        player mainplayer=new player();
        boolean authenticated=false;
        while(!authenticated) {
            try {
                mainplayer= logger.getPlayer(userName.getText(), password.getText());
                System.out.println(mainplayer);
                authenticated=true;
            } catch (Exception e) {
                error.setText("ERROR!!! " + e.getMessage());
                return;
            }
        }
        gameclasses.player.setCurrPlayer(mainplayer);
        sceneLoader.changeScreen("playerMenu");
    }
    public void changeScreen(ActionEvent evt){
            sceneLoader.changeScreen(evt);
    }
    public void registerUser(ActionEvent evt){
        initialize();
        try{
            logger.addUser(userName.getText(),password.getText(),new player());}
        catch (Exception e) {
            error.setText("ERROR!!! " + e.getMessage());
        }

    }


}
