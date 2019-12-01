package gameclasses;

import entity.Plant;

import java.util.ArrayList;

public class Level1 extends Level {

    public Level1(ArrayList<Plant> plants)
    {
        super(plants,1);
        for(int i = 0;i<1;i++) {
            zombies.add(random_Zombie(1));
        }
        this.setCopy(zombies);

    }
}
