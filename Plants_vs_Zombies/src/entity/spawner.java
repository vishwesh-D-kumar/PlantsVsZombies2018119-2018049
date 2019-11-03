package entity;

import gameclasses.Level;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public interface spawner {
    public void spawn(Level level, Stage s, AnchorPane anchor);
}
