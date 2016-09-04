package data;

import static helpers.Artist.*;

/**
 * Created by Liam on 2016-09-03.
 */
public class TileGrid {

    public Tile[][] map;

    public TileGrid() {
        map = new Tile[20][15];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
            }
        }
    }

    public TileGrid(int[][] newMap) {
        map = new Tile[20][15];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++) {
                if (newMap[j][i] == 0)
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
                else
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Dirt);
            }
        }
    }

    public void Draw() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j].Draw();
            }
        }
    }
}
