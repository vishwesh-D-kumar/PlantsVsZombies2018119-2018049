package entity;

public class Pea extends Entity
{
    protected int attack;

    public Pea(int x_position, int y_position) {
        super(x_position, y_position, 1, 2, "sprites/entity_images/pea.png");
    }

    public Pea(int x_position, int y_position, String image_path, int attack)
    {
        super(x_position, y_position, 1, 2, image_path);
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public void updatepos() {
        x_position += speed;
        img.setX(x_position);
    }
}
