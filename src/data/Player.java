package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;

import static helpers.Artist.*;

/**
 * Created by Liam on 2016-09-05.
 */
public class Player {

    private TileGrid grid;
    private TileType[] types;
    private int index;
    private WaveManager waveManager;
    private ArrayList<TowerCannon> towerList;
    private boolean leftMouseButtonDown;


    public Player(TileGrid grid, WaveManager waveManager) {
        this.grid = grid;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        this.index = 0;
        this.waveManager = waveManager;
        this.towerList = new ArrayList<TowerCannon>();
        this.leftMouseButtonDown = false;

    }

    public void setTile() {
        grid.setTile((int) Math.floor(Mouse.getX() / 64), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64), types[index] );
    }

    public void update() {
        for (TowerCannon t: towerList)
            t.update();

        //Handle Mouse Input
        if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
            towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(Mouse.getX() / 64, (HEIGHT - Mouse.getY() - 1) / 64), 10, waveManager.getCurrentWave().getEnemyList()));
            //setTile();

        }

        leftMouseButtonDown =  Mouse.isButtonDown(0);
        //Handle Keyboard Input
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                moveIndex();
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()) {

            }
        }
    }

    private void moveIndex() {
        index++;
        if (index > types.length - 1) {
            index = 0;
        }
    }
}
