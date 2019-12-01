package entity;

import gameclasses.Level;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Shooter extends Plant implements spawner {
    protected Pea shoot;
    protected final int shoot_time;
    public Shooter(int x_position, int y_position, int health, String image_path, int SUN_COST, int MAX_COOLDOWN,Pea shoot,int shoot_time) {
        super(x_position, y_position, health, image_path, SUN_COST, MAX_COOLDOWN);
        this.shoot = shoot;
        this.shoot_time = shoot_time;
    }

    public Pea getShoot() {
        return shoot;
    }

    public void setShoot(Pea shoot) {
        this.shoot = shoot;
    }

    public int getShoot_time() {
        return shoot_time;
    }

    public void spawn(Level a, Stage stage, AnchorPane anchor) {
        System.out.println("....");
        Pea pea=new Pea(x_position,y_position);
        a.getPeas().add(pea);
        anchor.getChildren().add(pea.getImg());


    }



}
