package data;

import java.util.ArrayList;
import static helpers.Clock.*;

/**
 * Created by Liam on 2016-09-05.
 */
public class Wave {
    private float timeSinceLastSpawn, spawnTime;
    private Enemy enemyType;
    private ArrayList<Enemy> enemyList;

    public  Wave(float spawnTime, Enemy enemyType) {
        this.enemyType = enemyType;
        this.spawnTime = spawnTime;
        timeSinceLastSpawn = 0;
        enemyList = new ArrayList<Enemy>();
    }

    public void Update() {
        timeSinceLastSpawn += Delta();
        if (timeSinceLastSpawn > spawnTime) {
            Spawn();
            timeSinceLastSpawn = 0;
        }

        for (Enemy e: enemyList) {
            e.Update();
            e.Draw();
        }
    }

    private void Spawn() {
        enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), 64, 64, enemyType.getSpeed()));
    }

}
