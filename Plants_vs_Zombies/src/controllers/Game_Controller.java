package controllers;

import entity.*;
import gameclasses.Level;
import gameclasses.player;
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
import sun.security.provider.Sun;

import java.util.Timer;
import java.util.TimerTask;


public class Game_Controller
{

    private static Stage currStage;
    private int plant_choice=-1;
    private static int count=0;
    private static gameclasses.Level currLevel;
    @FXML
    TextField progress;

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
        boolean[] p=player.getCurrPlayer().getUnlockedPlants();
        int t=0;
        for(t=0;t<10;t++)
        {
            if(!p[t])
            {
                break;
            }
        }
        if(t==1)
        {
            p1.setImage(new Peashooter(1,3).getImg().getImage());
        }
        if(t==2)
        {
            p1.setImage(new Peashooter(1,3).getImg().getImage());
            p2.setImage(new SunFlower(1,3).getImg().getImage());
        }
        if(t==3)
        {

            p1.setImage(new Peashooter(1,3).getImg().getImage());
            p2.setImage(new SunFlower(1,3).getImg().getImage());
            p3.setImage(new potatomine(1,3).getImg().getImage());
        }
        if(t==4)
        {
            p1.setImage(new Peashooter(1,3).getImg().getImage());
            p2.setImage(new SunFlower(1,3).getImg().getImage());
            p3.setImage(new potatomine(1,3).getImg().getImage());
            p4.setImage(new Walnut(1,4).getImg().getImage());

        }
        if(t==5)
        {
            p1.setImage(new Peashooter(1,3).getImg().getImage());
            p2.setImage(new SunFlower(1,3).getImg().getImage());
            p3.setImage(new potatomine(1,3).getImg().getImage());
            p4.setImage(new Walnut(1,4).getImg().getImage());
            p5.setImage(new Firewood(1,5).getImg().getImage());
        }
        if(t==6)
        {
            p1.setImage(new Peashooter(1,3).getImg().getImage());
            p2.setImage(new SunFlower(1,3).getImg().getImage());
            p3.setImage(new potatomine(1,3).getImg().getImage());
            p4.setImage(new Walnut(1,4).getImg().getImage());
            p5.setImage(new Firewood(1,5).getImg().getImage());
            p6.setImage(new Snowpeashooter(1,6).getImg().getImage());

        }


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
                                    progress.setText("");
                                    progress.setText(currLevel.getCopy().size()+"/"+currLevel.getNum_zombie());
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
    public void setupTimeline()
    {

    }
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
///asdsadas
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
        Plant p;
        switch (plant_choice) {
            case 0:
                p = new Peashooter(x_position, y_position);
                break;
            case 1:
                p = new SunFlower(x_position,y_position);
                break;
            case 2:
                p = new potatomine(x_position,y_position);
                break;
            case 3:
                p= new Walnut(x_position,y_position);
                break;
            case 4:
                p = new Firewood(x_position,y_position);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + plant_choice);
        }
        v.setImage(p.getImg().getImage());
        currLevel.getPlants().add(p);


    }



}
