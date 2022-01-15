package sweeper;

public class Bomb {
    private Matrix bombMap;
    private int totalBomb;

    public Bomb(int totalBomb) {
        this.totalBomb = totalBomb;
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBomb; i++) {
            placeBomb();
        }
    }

    private void placeBomb() {
        Coord coord = Ranges.getRandomCoord();
        bombMap.set(new Coord(coord.x,coord.y), Box.BOMB);
        incNumbersAroundBomb(coord);
    }

    private void incNumbersAroundBomb(Coord coord) {
        for (Coord around: Ranges.getCoordsAround(coord)) {
            if (Box.BOMB != bombMap.get(around)) {
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
            }
        }
    }

}
