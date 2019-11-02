
import helper.sceneLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        sceneLoader loader=new sceneLoader();
        Scene welcomeScene=loader.getScene("welcome");
        controllers.initialController.setCurrStage(primaryStage);
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
//        System.out.println(helpers.sceneLoader.getScene("welcome"));
    }
}
