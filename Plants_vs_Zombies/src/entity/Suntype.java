package entity;

import gameclasses.Level;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Suntype extends Plant implements spawner {
    public Suntype(int x_position, int y_position, int health,String image_path, int SUN_COST, int MAX_COOLDOWN)
    {
        super(x_position, y_position, health, image_path, SUN_COST, MAX_COOLDOWN);
    }

    @Override
    public void spawn(Level level, Stage s, AnchorPane anchor) {
        sun sun=new sun(x_position,y_position);
        level.getSuns().add(sun);
        anchor.getChildren().add(sun.getImg());





    }

}
