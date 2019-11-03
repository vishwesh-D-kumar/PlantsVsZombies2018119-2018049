package controllers;

import entity.Pea;
import entity.Zombie;
import entity.normalZombie;
import gameclasses.Level;
import helper.UpdatePos;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game_Controller
{
    private static Stage currStage;
    private static gameclasses.Level currLevel;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView peamove;
    @FXML
    private ImageView peashooter;
    @FXML
    private ImageView sunflower;
    @FXML
    private ImageView torchwood;
    @FXML
    private ImageView snowpea;
    @FXML
    private ImageView walnut;
    @FXML
    private ImageView shovel;
    @FXML
    private GridPane lawn;

    private Image image;
    private boolean plant_selected = false;
    @FXML
    public static void setLevel(gameclasses.Level level){
        currLevel=level;
    }

    public static void setCurrStage(Stage primaryStage) {
        currStage=primaryStage;
    }

    public void selectPlant(ActionEvent Click)
    {
        String id = ((Control)Click.getSource()).getId();
        System.out.println(id);
        if(id.equals("peashooter"))
        {
            image = peashooter.getImage();
            plant_selected = true;
        }
        if(id.equals("sunflower"))
        {
            image = sunflower.getImage();
            plant_selected = true;
        }
        if(id.equals("walnut"))
        {
            image = walnut.getImage();
            plant_selected = true;
        }
        if(id.equals("torchwood"))
        {
            image = torchwood.getImage();
            plant_selected = true;
        }
        if(id.equals("snowpea"))
        {
            image = snowpea.getImage();
            plant_selected = true;
        }
    }
    @FXML
    public void setPlant(MouseEvent event)
    {
        if(plant_selected)
        {
            ImageView imageView = new ImageView(image);

        }
    }


    @FXML
    public void selectShovel(MouseEvent mouseEvent) {

    }
    @FXML
    public void plantSelected(MouseEvent mouseEvent) {
        if(plant_selected)
        {
            System.out.println("yes");
        }
    }
    @FXML
    public void setupTimeline(ActionEvent event)
    {
        Pea pea=new Pea(260,260);
        Zombie zombie=new normalZombie(360,250);

        anchor.getChildren().add(pea.getImg());
        anchor.getChildren().add(zombie.getImg());

//        pea.setImg(peamove);
//        currStage.getScene().getRoot();
        currLevel.getPeas().add(pea);
        currLevel.getZombies().add(zombie);

//        currStage.getScene().getRoot().getC
        KeyFrame update_frame =  new KeyFrame(Duration.millis((double)10), new helper.UpdatePos(currLevel,currStage));
//        KeyFrame update_spawn = new KeyFrame(Duration.millis((double)1),new hel)
        Timeline tl = new Timeline(update_frame);
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();



    }



}
