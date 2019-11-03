package helper;

import entity.Pea;
import entity.Zombie;
import gameclasses.Level;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class UpdatePos implements EventHandler<ActionEvent> {
     private gameclasses.Level a ;
     private  Stage s;
     public UpdatePos(Level a, Stage currStage){
         this.a=a;
         this.s=currStage;
     }
    @Override
    public void handle(ActionEvent event)
    {
        for(Pea pea:a.getPeas()){
            pea.updatepos();
            System.out.println(pea.getX_position());
            System.out.println(pea.getY_position());
        }
        for (Zombie zombie:a.getZombies()
             ) {
            zombie.updatepos();
            
        }
        s.show();
    }


}
