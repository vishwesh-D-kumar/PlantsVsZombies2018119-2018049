package controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;



public class Game_Controller
{
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
    public void setPlant(ActionEvent event)
    {
        if(plant_selected)
        {
            ImageView imageView = new ImageView(image);

        }
    }


    public void selectShovel(MouseEvent mouseEvent) {
    }

    public void plantSelected(MouseEvent mouseEvent) {
    }
}
