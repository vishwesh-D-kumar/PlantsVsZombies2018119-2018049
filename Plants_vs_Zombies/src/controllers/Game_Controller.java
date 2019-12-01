package controllers;

import entity.*;
import gameclasses.Level;
import helper.UpdatePos;
import helper.UpdateTimer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


public class Game_Controller
{

    private static Stage currStage;
    private int plant_choice=-1;
    private static int count=0;
    private static gameclasses.Level currLevel;
    @FXML
    TextField timer;

    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView p1;
    @FXML
    private ImageView p2;
    @FXML
    private ImageView p3;
    @FXML
    private ImageView p4;
    @FXML
    private ImageView p5;
    @FXML
    private ImageView p6;
    @FXML
    private ImageView p7;
    @FXML
    private ImageView shovel;
    @FXML
    private GridPane lawn;
    @FXML
    public void initialize()
    {
        Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                if(!(currLevel.getCopy().isEmpty())&&(count==100))
                                {
                                    Zombie z = currLevel.getCopy().remove(0);
                                    anchor.getChildren().add(z.getImg());
                                    count = 0;
                                }

                                currLevel.setA(anchor);
                                currLevel.setS(currStage);
                                currLevel.setG(lawn);
                                currLevel.update();
                            }
                        });
                    }
                }, 300, 100);
    }

    private Image image;
    private boolean plant_selected = false;
    private boolean shovel_Selected = false;
    @FXML
    public static void setLevel(gameclasses.Level level){
        currLevel=level;
    }

    public static void setCurrStage(Stage primaryStage) {
        currStage=primaryStage;
    }

    public void setUpgame()
    {

    }
    public void selectPlant(MouseEvent Click)
    {
        ImageView v = (ImageView) Click.getSource();
        String id = v.getId();
        System.out.println(id);
        if(id.equals("p1"))
        {

            plant_selected = true;
            plant_choice =0;
        }
        if(id.equals("p2"))
        {
            plant_selected = true;
            plant_choice =1;
        }
        if(id.equals("p3"))
        {
            plant_selected = true;
            plant_choice =2;
        }
        if(id.equals("p4"))
        {
            plant_selected = true;
            plant_choice =3;
        }
        if(id.equals("p5"))
        {
            plant_selected = true;
            plant_choice =4;
        }
        if(id.equals("p6"))
        {
            plant_selected = true;
            plant_choice =5;

        }
        if(id.equals("p7"))
        {
            plant_selected = true;
            plant_choice =6;
        }
        shovel_Selected = false;
    }





    @FXML
    public void selectShovel(MouseEvent mouseEvent) {
        plant_choice = -1;
        plant_selected = false;
        shovel_Selected = true;

    }

    @FXML
    public void setupTimeline(ActionEvent event)
    {


    }
    @FXML
    public void plant(MouseEvent mouseEvent)

    {
        if(!plant_selected)
        {
            if(shovel_Selected)
            {
                ImageView t = (ImageView) mouseEvent.getSource();

                t.setImage(null);
            }
            shovel_Selected = false;
            return;
        }
        plant_selected = false;

        ImageView v = (ImageView) mouseEvent.getSource();
        Bounds b = v.localToScene(v.getBoundsInLocal());
        int x_position = (int)(b.getMaxX()+b.getMinX())/2;
        int y_position = (int)(b.getMinY()+b.getMaxY())/2;
        System.out.println(y_position);
        Plant p = new Peashooter(x_position,y_position);
        v.setImage(p.getImg().getImage());


    }



}
