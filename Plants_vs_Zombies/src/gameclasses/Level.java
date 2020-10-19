package gameclasses;


import entity.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// importing required utils
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Level {
    protected ArrayList<entity.Pea> peas;
    private ArrayList<Zombie> copy;
    protected ArrayList<entity.Zombie> zombies;
    protected ArrayList<entity.Plant> plants;
    protected HashMap<entity.Plant, ImageView> position;
    protected HashMap<ImageView,Plant> remover;
    protected int num_zombie;
    protected Stage s;
    protected AnchorPane a;
    protected GridPane g;
    private int turns=0;



    public GridPane getG() {
        return g;
    }

    public void setG(GridPane g) {
        this.g = g;
    }



    public HashMap<ImageView, Plant> getRemover() {
        return remover;
    }

    public void setRemover(HashMap<ImageView, Plant> remover) {
        this.remover = remover;
    }

    public int getNum_zombie() {
        return num_zombie;
    }

    public void setNum_zombie(int num_zombie) {
        this.num_zombie = num_zombie;
    }

    public Stage getS() {
        return s;
    }

    public void setS(Stage s) {
        this.s = s;
    }

    public AnchorPane getA() {
        return a;
    }

    public void setA(AnchorPane a) {
        this.a = a;
    }

    public void setSuntypes(ArrayList<Suntype> suntypes) {
        this.suntypes = suntypes;
    }

    public void setShooters(ArrayList<Shooter> shooters) {
        this.shooters = shooters;
    }

    public void setSuns(ArrayList<sun> suns) {
        this.suns = suns;
    }

    public ArrayList<Zombie> getCopy() {
        return copy;
    }

    public void setCopy(ArrayList<Zombie> copy) {
        this.copy = new ArrayList<Zombie>(copy);
    }

    public HashMap<Plant, ImageView> getPosition() {
        return position;
    }

    public void setPosition(HashMap<Plant, ImageView> position) {
        this.position = position;
    }

    public Level(ArrayList<Plant> plants, int num_zombie)
    {
        this.plants = plants;
        this.num_zombie = num_zombie;
        zombies = new ArrayList<>();
        peas = new ArrayList<Pea>();
        position = new HashMap<>();
        remover = new HashMap<>();

    }

///asdsadasasdsada

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
    public void update()
    {   turns++;

        for(Zombie z: zombies)
        {
            z.setAttacking(false);
        }
//        System.out.println(plants);
        ArrayList<Plant> remove = new ArrayList<>();
        for(Plant i: plants)
        {
            if(i.getHealth() <= 0)
            {
                remove.add(i);
            }
            else {
                if (turns > 20) {
                    turns=0;
                    System.out.println("here");
                    for (Plant plantedPlant : plants
                    ) {
                        if (plantedPlant.getClass() == new Peashooter(1, 0).getClass()) {
                            ((Shooter) plantedPlant).spawn(this, this.s, a);
                        }
                        if (plantedPlant.getClass() == new Snowpeashooter(1, 0).getClass()) {
                            ((Shooter) plantedPlant).spawn(this, this.s, a);
                        }

                    }
//                    for(Class c :i.getClass().getInterfaces())
//                    {      System.out.println("here");
//                        System.out.println(c.getName()+"asdasdsads");
//
//                        if(c.getName().equals("spawner"))
//                        {
//
//                            spawner s = (spawner)i;
//                            s.spawn(this, this.s,a);
//                        }
//                    }
                }
            }
        }
        for(Plant p : remove)
        {
            ImageView v =  position.get(p);
            v.setImage(null);
            plants.remove(p);
        }
        ArrayList<Pea> removepea = new ArrayList<>();
        ArrayList<Zombie> removeZombie = new ArrayList<>();

        for(Pea i :peas)
        {
            for(Zombie j :zombies)
            {
                if((i.getX_position()==j.getX_position()))
                {
                    System.out.println("pea position   "+i.getX_position()+" "+i.getY_position() );
                    System.out.println("zombie position"+j.getX_position()+" "+j.getY_position());
                    j.setHealth(j.getHealth()-i.getAttack());
                    if(j.getHealth()<=0)
                    {
                        removeZombie.add(j);
                    }
                    removepea.add(i);


                }
            }
        }
        for(Pea i: peas)
        {
            i.updatepos();
        }

        for (Pea i : removepea)
        {
            i.getImg().setImage(null);
            peas.remove(i);
        }
        for(Zombie t: removeZombie)
        {
            t.getImg().setImage(null);
            zombies.remove(t);
        }
        remove = new ArrayList<>();
        removeZombie = new ArrayList<>();
        for(Plant i: plants)
        {
            for (Zombie j: zombies)
            {
                if((i.getX_position()==j.getX_position()))
                {
                    if(i.getClass().getName().equals("potatomine"))
                    {
                        j.getImg().setImage(null);
                        removeZombie.add(j);
                        remove.add(i);
                    }
                    else
                    {
                        j.setAttacking(true);
                        i.setHealth(i.getHealth()-j.getAttack());
                        if(i.getHealth()<=0)
                        {
                            remove.add(i);
                        }
                    }
                }
            }
        }
        for(Plant i : remove)
        {
            ImageView v = position.get(i);
            v.setImage(null);
            plants.remove(i);
        }
        for(Zombie z: removeZombie)
        {
            z.getImg().setImage(null);
            zombies.remove(z);
        }
        for(Zombie z: zombies)
        {
            if(!z.isAttacking())
            {
                if(copy.indexOf(z)==-1)
                {z.updatepos();}

            }
        }


    }
}
