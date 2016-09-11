package data;

import org.newdawn.slick.opengl.Texture;

import java.util.ArrayList;

import static helpers.Artist.*;
import static helpers.Clock.*;

/**
 * Created by Liam on 2016-09-10.
 */
public class TowerCannon {

    private float x, y, timeSinceLastShot, firingSpeed;
    private int width,height,damage;
    private Texture baseTexture, cannonTexture;
    private Tile startTile;
    private ArrayList<Projectile> projectiles;


    public TowerCannon(Texture baseTexture, Tile startTile, int damage) {
        this.baseTexture = baseTexture;
        this.cannonTexture = QuickLoad("cannonGun");
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = (int) startTile.getWidth();
        this.height = (int) startTile.getHeight();
        this.damage = damage;
        this.firingSpeed = 2;
        this.timeSinceLastShot = 0;
        this.projectiles = new ArrayList<Projectile>();

    }

    private void shoot() {
        timeSinceLastShot = 0;
        projectiles.add(new Projectile(QuickLoad("projectile"), x + 32, y + 32, 80, 10));

    }

    public void update() {
        timeSinceLastShot += Delta();
        if (timeSinceLastShot > firingSpeed)
            shoot();
        for (Projectile p: projectiles)
            p.update();

        Draw();
    }

    public void Draw() {
        DrawQuadTex(baseTexture, x, y, width, height);
        DrawQuadTexRot(cannonTexture, x, y, width, height, 45);
    }

}
