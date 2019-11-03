package controllers;

import helper.UpdatePos;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.util.Duration;


public class Game_Controller
{
    private static gameclasses.Level currLevel;
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
        KeyFrame update_frame =  new KeyFrame(Duration.millis((double)1000), new helper.UpdatePos());
        Timeline tl = new Timeline(update_frame);
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();

    }



}
