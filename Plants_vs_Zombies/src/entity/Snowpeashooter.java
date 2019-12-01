package entity;

public class Snowpeashooter extends Shooter {
    public Snowpeashooter(int x_position, int y_position) {
        super(x_position, y_position, 100, "sprites/entity_images/SnowPeashooter.png", 125, 10, new SnowPea(0,0), 10);
    }
}
