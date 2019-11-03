package entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class  Entity {
    protected int x_position;
    protected int y_position;
    protected int health;
    protected final int MAX_HEALTH;
    protected int speed;
    protected final String image_path;
    protected ImageView img;
    Entity(int x_position,int y_position,int MAX_HEALTH,int speed,String image_path)
    {
        this.x_position = x_position;
        this.y_position = y_position;
        this.health = MAX_HEALTH;
        this.MAX_HEALTH = MAX_HEALTH;
        this.speed = speed;
        this.image_path = image_path;
        this.img=new ImageView(new Image(image_path));
        this.img.setX(x_position);
        this.img.setY(y_position);



    }

    public int getX_position() {
        return x_position;
    }

    public void setX_position(int x_position) {
        this.x_position = x_position;
    }

    public int getY_position() {
        return y_position;
    }

    public void setY_position(int y_position) {
        this.y_position = y_position;
    }

    public int getHealth() {
        return health;
    }

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getImage_path() {
        return image_path;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
        this.x_position=(int)this.img.getX();
        this.y_position=(int)this.img.getY();


    }

    public abstract void updatepos();

}
