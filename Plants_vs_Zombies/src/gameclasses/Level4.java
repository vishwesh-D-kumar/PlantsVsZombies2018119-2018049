package gameclasses;

import entity.Plant;

import java.util.ArrayList;

public class Level4 extends Level
{

    public Level4(ArrayList<Plant> plants) {
        super(plants, 20);
        for(int i = 0;i<20;i++)
        {
            zombies.add(random_Zombie(3));

        }
        this.setCopy(zombies);
    }
}
