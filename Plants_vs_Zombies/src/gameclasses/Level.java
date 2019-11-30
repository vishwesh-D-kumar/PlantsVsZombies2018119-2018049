package gameclasses;


import entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Level {
    protected ArrayList<entity.Pea> peas;
    protected ArrayList<entity.Zombie> zombies;
    protected ArrayList<entity.Plant> plants;
    protected HashMap<entity.Plant,String> position;
    protected int num_zombie;
    public Level(ArrayList<Plant> plants,int num_zombie)
    {
        this.plants = plants;
        this.num_zombie = num_zombie;
        zombies = new ArrayList<>();
        peas = new ArrayList<Pea>();
        position = new HashMap<>();

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
    protected Zombie random_Zombie(int value)
    {
        Random rand1 = new Random();
        Random rand2 = new Random();
        int [] y_coordinates = new int[]{147,204,261,319,375,433};
        int zomb = rand1.nextInt(value);
        int coor = rand2.nextInt(6);
        switch (zomb)
        {
            case 0:
                return new normalZombie(600,y_coordinates[coor]);
            case 1:
                return new ConeHeadZombie(600,y_coordinates[coor]);
            case 2:
                return new BucketHeadZombie(600,y_coordinates[coor]);
            case 3:
                return  new GangZombie(600,y_coordinates[coor]);
                default:
                return null;

        }
    }
}
