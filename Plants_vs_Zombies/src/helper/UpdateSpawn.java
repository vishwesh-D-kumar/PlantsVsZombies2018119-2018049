package helper;

import entity.Plant;
import entity.Suntype;
import gameclasses.Level;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class UpdateSpawn {

    private gameclasses.Level a ;
    private Stage s;
    
    public UpdateSpawn(Level a, Stage currStage){
        this.a=a;
        this.s=currStage;
    }
    public void handle(ActionEvent e){
        for (Plant p: a.getPlants()
             ) {
            try{
                entity.spawner spawner=(entity.spawner) p;
                spawner.spawn(a,s);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}

