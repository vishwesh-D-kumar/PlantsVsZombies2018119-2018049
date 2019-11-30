package helper;

import entity.Plant;
import gameclasses.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class sceneLoader{
    private static Stage currStage;


    private static HashMap<String,String> nameToPath=new HashMap<>();
    private static HashMap<String, Scene> nameToScene=new HashMap<>();


    public sceneLoader () throws IOException {
        nameToPath.put("welcome","/fxmls/sample.fxml");
        nameToPath.put("login","/fxmls/loginscreen.fxml");
        nameToPath.put("game","/fxmls/GameStage.fxml");
        nameToPath.put("help","/fxmls/help.fxml");
        nameToPath.put("register","/fxmls/userRegister.fxml");
        for (String name :
                nameToPath.keySet()) {
            System.out.println(name);
            getNewScene(name);

        }

    }
    public static void setCurrStage(Stage currStage) {
        sceneLoader.currStage = currStage;


    }
    public static void changeScreen(ActionEvent evt) {
        System.out.println(((Control) evt.getSource()).getId());
        Scene currScene = helper.sceneLoader.getScene(((Control) evt.getSource()).getId());
        currStage.setScene(currScene);
//            currStage.setTitle("login");
        currStage.setTitle(((Control) evt.getSource()).getId());
        currStage.show();

        if (((Control) evt.getSource()).getId().equals("login")) {
            Level level = new Level(1,new ArrayList<Plant>());
            controllers.Game_Controller.setLevel(level);
        }
    }
    public static Scene getScene(String name){
        return nameToScene.get(name);

    }

    public Scene getNewScene(String name) throws IOException {
        String url=nameToPath.get(name);
        Parent root = FXMLLoader.load(getClass().getResource(url));
        if (name.equals("game")){
            nameToScene.put(name,new Scene(root,678,482));

        }
        else {
            nameToScene.put(name, new Scene(root, 596, 340));
        }
        return nameToScene.get(name);
    }
}