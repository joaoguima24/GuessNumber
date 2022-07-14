package academy.mindswap;

import static academy.mindswap.Game.*;

public class Main {
    public static void main(String[] args) {
        Game.setMaxRange(10);
        Game.setMinRange(1);
        Game.betterOf(10);
        Game.playButton();
    }
}
