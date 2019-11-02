package entity;

public class Pea extends Entity
{
    protected int attack;

    public Pea(int x_position, int y_position) {
        super(x_position, y_position, 1, 2, "");
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
}
