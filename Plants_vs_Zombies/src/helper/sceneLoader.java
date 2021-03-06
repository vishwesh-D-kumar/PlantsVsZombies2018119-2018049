package helper;

import entity.Plant;
import gameclasses.Level;
import gameclasses.Level1;
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


    public static Stage getCurrStage() {
        return currStage;
    }

    public static HashMap<String, String> getNameToPath() {
        return nameToPath;
    }

    public static void setNameToPath(HashMap<String, String> nameToPath) {
        sceneLoader.nameToPath = nameToPath;
    }

    public static HashMap<String, Scene> getNameToScene() {
        return nameToScene;
    }

    public static void setNameToScene(HashMap<String, Scene> nameToScene) {
        sceneLoader.nameToScene = nameToScene;
    }

    public sceneLoader () throws IOException {
        nameToPath.put("welcome","/fxmls/sample.fxml");
        nameToPath.put("login","/fxmls/loginscreen.fxml");
        nameToPath.put("help","/fxmls/help.fxml");
        nameToPath.put("register","/fxmls/userRegister.fxml");
        nameToPath.put("playerMenu","/fxmls/playerMenu.fxml");
        nameToPath.put("plantSelect","/fxmls/plantSelect.fxml");
        nameToPath.put("levelSelect","/fxmls/levelSelect.fxml");
        nameToPath.put("shop","/fxmls/shop.fxml");
        nameToPath.put("almanac","/fxmls/Almanac.fxml");
        nameToPath.put("leaderboard","/fxmls/leaderboard.fxml");
        for (String name : nameToPath.keySet()) {
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
            Level level = new Level1(new ArrayList<Plant>());
            controllers.Game_Controller.setLevel(level);
        }
    }
    public static void changeScreen( String name) {
//        System.out.println(((Control) evt.getSource()).getId());
        Scene currScene = helper.sceneLoader.getScene(name);
        currStage.setScene(currScene);
//            currStage.setTitle("login");
        currStage.setTitle(name);
        currStage.show();


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