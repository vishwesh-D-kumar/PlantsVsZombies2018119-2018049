package entity;

public class sun extends Entity {
    sun(int x_position, int y_position, int MAX_HEALTH, int speed, String image_path) {
        super(x_position, y_position, MAX_HEALTH, speed, "/sprites/entity_images/Sun.png");

    }

    @Override
    public void updatepos() {

    }
}
