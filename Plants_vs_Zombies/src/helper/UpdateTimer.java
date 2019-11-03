package helper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class UpdateTimer implements EventHandler<ActionEvent> {

    private int time;
    private TextField timer;

    public UpdateTimer(int time, TextField timer)
    {
        this.time = time;
        this.timer = timer;
    }

    @Override
    public void handle(ActionEvent event) {
        time = time - 1;
        timer.setText(Integer.toString(time));


    }
}
