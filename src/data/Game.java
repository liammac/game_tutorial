package data;

import static helpers.Artist.QuickLoad;

/**
 * Created by Liam on 2016-09-10.
 */
public class Game {

    private TileGrid grid;
    private Player player;
    private WaveManager waveManager;

    //Temp Variables
    TowerCannon tower;

    public Game(int[][] map) {
        grid = new TileGrid(map);
        player = new Player(grid);
        waveManager = new WaveManager(new Enemy(QuickLoad("enemy1"), grid.GetTile(14,8), grid, 64, 64, 40),
                4, 5);
        tower = new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(14, 7), 10);
    }

    public void update(){
        grid.Draw();
        waveManager.update();
        player.Update();

        tower.update();

    }
}
