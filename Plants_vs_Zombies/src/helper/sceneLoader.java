package helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

public class sceneLoader{
    private static HashMap<String,String> nameToPath=new HashMap<>();
    private static HashMap<String, Scene> nameToScene=new HashMap<>();


    public sceneLoader () throws IOException {
        nameToPath.put("welcome","/fxmls/sample.fxml");
        nameToPath.put("login","/fxmls/loginscreen.fxml");
        nameToPath.put("game","/fxmls/GameStage.fxml");
        for (String name :
                nameToPath.keySet()) {
            System.out.println(name);
            getNewScene(name);

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