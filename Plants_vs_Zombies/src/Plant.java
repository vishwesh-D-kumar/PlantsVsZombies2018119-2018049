public abstract class Plant extends Entity
{
    protected final int SUN_COST;
    protected int cooldown;
    protected final int MAX_COOLDOWN;

    public Plant(int x_position, int y_position, int health, String image_path, int SUN_COST, int MAX_COOLDOWN) {
        super(x_position, y_position, health, 0, image_path);
        this.SUN_COST = SUN_COST;
        this.MAX_COOLDOWN = MAX_COOLDOWN;
        this.cooldown = MAX_COOLDOWN;
    }

    public int getSUN_COST() {
        return SUN_COST;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getMAX_COOLDOWN() {
        return MAX_COOLDOWN;
    }
}
