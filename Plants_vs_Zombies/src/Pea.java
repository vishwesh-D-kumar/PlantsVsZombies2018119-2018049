public class Pea extends Entity
{
    protected int attack;

    public Pea(int x_position, int y_position, String image_path) {
        super(x_position, y_position, 1, 2, image_path);
        this.attack = 1;
    }

    public Pea(int x_position, int y_position, String image_path, int attack)
    {
        super(x_position, y_position, 1, 2, image_path);
        this.attack = attack;
    }
}
