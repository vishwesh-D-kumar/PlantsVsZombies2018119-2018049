package controllers;

import gameclasses.player;
import helper.login;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class loginController {
    @FXML public Button login;
    @FXML public TextField userName;
    @FXML public TextField password;

    @FXML public TextField error;
    private helper.login logger;




    public void login(ActionEvent evt){
        if (logger==null){
            try {
                logger= helper.login.deserialize();
            } catch (Exception e) {
                logger=new login();
            }
        }
        try{
        player player=logger.getPlayer(userName.getText(),password.getText());}

        catch (Exception e) {
            error.setText("ERROR!!! " + e.getMessage());
        }
    }
}
