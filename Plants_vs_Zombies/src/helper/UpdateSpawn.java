package helper;

import entity.Plant;
import entity.Shooter;
import entity.Suntype;
import entity.sun;
import gameclasses.Level;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UpdateSpawn {

    private gameclasses.Level a ;
    private Stage stage;
    private AnchorPane anchor;

    
    public UpdateSpawn(Level a, Stage currStage, AnchorPane anchor){
        this.a=a;
        this.stage=currStage;
        this.anchor=anchor;
    }
    public void handle(ActionEvent e){
//        for (Plant p: a.getPlants()
//             ) {
//            try{
//                entity.spawner spawner=(entity.spawner) p;
//                try {
//                    a.getPeas().add(p.spawn(a,s));
//
//                } catch (Exception ex2) {
//                    ex2.printStackTrace();
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//        }
//
        for (Suntype s:a.getSuntypes()){
            s.spawn(a,stage,anchor);
        }
        for (Shooter s:a.getShooters()){
            s.spawn(a,stage,anchor);
        }
    }


}

