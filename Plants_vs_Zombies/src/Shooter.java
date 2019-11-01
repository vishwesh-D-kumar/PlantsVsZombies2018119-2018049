public class Shooter extends Plant {
    protected Pea shoot;
    protected final int shoot_time;
    public Shooter(int x_position, int y_position, int health, String image_path, int SUN_COST, int MAX_COOLDOWN,Pea shoot,int shoot_time) {
        super(x_position, y_position, health, image_path, SUN_COST, MAX_COOLDOWN);
        this.shoot = shoot;
        this.shoot_time = shoot_time;
    }
}
