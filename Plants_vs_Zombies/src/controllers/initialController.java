package controllers;

import gameclasses.Level;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.util.ArrayList;

public class initialController {
    private static Stage currStage;
    @FXML public Button login;
    public static void setCurrStage(Stage currStage) {
        initialController.currStage = currStage;


    }
    @FXML
    public  void changeScreen(ActionEvent evt){
        System.out.println(((Control)evt.getSource()).getId());
        Scene currScene=helper.sceneLoader.getScene(((Control)evt.getSource()).getId());
            currStage.setScene(currScene);
//            currStage.setTitle("login");
        currStage.setTitle(((Control)evt.getSource()).getId());
            currStage.show();
            if (((Control)evt.getSource()).getId().equals("game")){
                Level level=new Level(1,new ArrayList<entity.Plant>());
                Game_Controller.setLevel(level);
            }


    }
    public void closeGame(ActionEvent e){
        System.exit(0);
    }

}
