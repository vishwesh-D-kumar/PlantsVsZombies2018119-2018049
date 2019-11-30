package gameclasses;

import entity.Plant;

import java.util.ArrayList;

public class Level3 extends Level {
    public Level3(ArrayList<Plant> plants) {
        super(plants, 20);
        for(int i =0 ;i<20; i++)
        {
            zombies.add(random_Zombie(2));
        }

    }
}
