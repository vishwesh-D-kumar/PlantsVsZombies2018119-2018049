package gameclasses;

import entity.Plant;

import java.util.ArrayList;

public class Level1 extends Level {

    public Level1(ArrayList<Plant> plants)
    {
        super(plants,10);
        for(int i = 0;i<10;i++) {
            zombies.add(random_Zombie(1));
        }

    }
}
