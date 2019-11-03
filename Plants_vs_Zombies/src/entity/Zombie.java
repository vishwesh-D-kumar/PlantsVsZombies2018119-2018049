package entity;

public abstract class Zombie extends Entity
{
    public Zombie(int x_position, int y_position, int health,int speed,String image_path)
    {
        super(x_position, y_position, health,speed,image_path);
    }

    @Override
    public void updatepos() {
        x_position+=speed;
        img.setX(x_position);
    }
}
