package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
public class loginController {
    @FXML public Button login;
    @FXML public TextField userName;
    @FXML public TextField password;

    @FXML public TextField error;




    public void login(ActionEvent evt){
        try{
        helper.login.getPlayer(userName.getText(),password.getText());}
        catch (Exception e){
            error.setText("ERROR!!! "+e.getMessage());
        }


    }
}
