package gameclasses;

import entity.Plant;

import java.util.ArrayList;

public class Level2 extends Level
{

    public Level2(ArrayList<Plant> plants) {
        super(plants, 20);
        for(int i =0;i<10;i++)
        {
            zombies.add(random_Zombie(1));
        }
        this.setCopy(zombies);
    }
}
