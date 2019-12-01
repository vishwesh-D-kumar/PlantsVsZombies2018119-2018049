package entity;

public abstract class Zombie extends Entity
{
    protected boolean isAttacking;
    protected int attack;
    public Zombie(int x_position, int y_position, int health,int speed,String image_path,int attack)
    {
        super(x_position, y_position, health,speed,image_path);
        isAttacking = false;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    @Override
    public void updatepos() {
        x_position+=speed;
        img.setX(x_position);
    }
}
