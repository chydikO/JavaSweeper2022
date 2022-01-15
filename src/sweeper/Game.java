package sweeper;

import java.awt.*;

public class Game {
    private Bomb bomb;
    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(rows, cols));
        bomb = new Bomb(bombs);
    }

    public void start() {
        bomb.start();
    }

    public Box getBox(Coord coord) {
        return bomb.get(coord);
    }
}
