package gameclasses;

import entity.Pea;
import entity.Plant;
import entity.Zombie;
import entity.sun;

import java.util.ArrayList;

public class Level {
    private ArrayList<entity.Pea> peas=new ArrayList<>();
    private ArrayList<entity.Zombie> zombies=new ArrayList<>();
    private ArrayList<entity.Plant> plants = new ArrayList<>();

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
