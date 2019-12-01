
import helper.sceneLoader;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        playMusic();
        sceneLoader loader=new sceneLoader();
        Scene welcomeScene=loader.getScene("welcome");
        controllers.initialController.setCurrStage(primaryStage);
        controllers.Game_Controller.setCurrStage(primaryStage);
        helper.sceneLoader.setCurrStage(primaryStage);
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
//        System.out.println(helpers.sceneLoader.getScene("welcome"));
    }
    public void playMusic() {
        try {
            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(new File("Plants_vs_Zombies/src/pvz.wav").getAbsoluteFile());


            Clip go = AudioSystem.getClip();


            go.open(audio);

            go.loop(Clip.LOOP_CONTINUOUSLY);
            go.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
