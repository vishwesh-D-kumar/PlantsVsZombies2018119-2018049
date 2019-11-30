package gameclasses;


import entity.*;

import java.util.ArrayList;
import java.util.Random;

public class Level {
    private ArrayList<entity.Pea> peas;
    private ArrayList<entity.Zombie> zombies;
    private ArrayList<entity.Plant> plants;
    public Level(int LEVEL, ArrayList<Plant> plants)
    {
        this.plants = plants;
        peas = new ArrayList<Pea>();

        if(LEVEL == 1)
        {
            for(int i = 0;i<20;i++)
            {
                zombies.add(new normalZombie(600,2));
            }
        }
    }


    public ArrayList<Suntype> getSuntypes() {
        return suntypes;
    }

    private ArrayList<entity.Suntype> suntypes=new ArrayList<>();

    public ArrayList<Shooter> getShooters() {
        return shooters;
    }

    private ArrayList<entity.Shooter> shooters=new ArrayList<>();
    public ArrayList<sun> getSuns() {
        return suns;
    }

    private ArrayList<entity.sun> suns=new ArrayList<>();

    public ArrayList<Pea> getPeas() {
        return peas;
    }

    public void setPeas(ArrayList<Pea> peas) {
        this.peas = peas;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }
}
