import gameclasses.Level;
import gameclasses.player;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    private player play;
    private ArrayList<Level> levels;

    Game(player play)
    {
        this.play = play;

    }

}
