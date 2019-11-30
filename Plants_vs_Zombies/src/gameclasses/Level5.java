package gameclasses;

import entity.Plant;

import java.util.ArrayList;

public class Level5 extends Level
{

    public Level5(ArrayList<Plant> plants) {
        super(plants, 50);
        zombies.add(random_Zombie(4));
    }
}
