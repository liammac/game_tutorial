package data;

/**
 * Created by Liam on 2016-09-05.
 */
public class Checkpoint {

    private Tile tile;
    private int xDirection, yDirection;

    public Checkpoint(Tile tile, int xDirection, int yDirection) {
        this.tile = tile;
        this.yDirection = yDirection;
        this.xDirection = xDirection;

    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }
}
