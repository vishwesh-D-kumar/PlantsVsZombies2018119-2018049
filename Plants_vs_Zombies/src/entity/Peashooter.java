package entity;

public final class Peashooter extends Shooter
{
    public Peashooter(int x_position, int y_position) {
        super(x_position, y_position, 10000,"/sprites/entity_images/PeaShooter.gif",100,5,new Pea(x_position,y_position),5 );
    }
}
