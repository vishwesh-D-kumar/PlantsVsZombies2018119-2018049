package helper;

import entity.Pea;
import gameclasses.Level;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class UpdatePos implements EventHandler<ActionEvent> {
    private gameclasses.Level a =new gameclasses.Level();
    @Override
    public void handle(ActionEvent event)
    {
        for(Pea pea:a.getPeas())
            pea.updatepos();

    }


}
