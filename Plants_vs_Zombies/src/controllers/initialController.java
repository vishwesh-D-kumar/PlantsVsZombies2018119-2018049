package controllers;

import entity.Plant;
import gameclasses.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import helper.sceneLoader;
import javafx.event.ActionEvent;

import java.io.IOException;
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
        Level level=new Level1(new ArrayList<entity.Plant>());
        Game_Controller.setLevel(level);


    }
    @FXML
    public void goToLevel(ActionEvent evt) throws IOException {
        System.out.println(((Control)evt.getSource()).getId());
        String l=((Control)evt.getSource()).getId();
        Level level=new Level1(new ArrayList<Plant>());

        switch(l.charAt(1)){

            case '1':
                level=new Level1(new ArrayList<Plant>());
                break;
            case '2':
                level=new Level2(new ArrayList<Plant>());
                break;
            case '3':
                level=new Level3(new ArrayList<Plant>());
                break;
            case '4':
                level=new Level4(new ArrayList<Plant>());
                break;
            case '5':
                level=new Level5(new ArrayList<Plant>());
                break;
        }
        Game_Controller.setLevel(level);

        sceneLoader.getNameToPath().put("gameStage","/fxmls/GameStage.fxml");
//        String l=((Control)evt.getSource()).getId();
        String url=sceneLoader.getNameToPath().get("gameStage");
        Parent root = FXMLLoader.load(getClass().getResource(url));
        sceneLoader.getNameToScene().put("gameStage",new Scene(root,678,482));
        sceneLoader.changeScreen("gameStage");



    }
    @FXML
    public void closeGame(ActionEvent e){
        System.exit(0);
    }

}
