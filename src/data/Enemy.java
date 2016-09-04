package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;

/**
 * Created by Liam on 2016-09-03.
 */
public class Enemy {
    private int width, height, health;
    private float speed, x, y;
    private Tile startTile;
    Texture texture;

    public Enemy(Texture texture, Tile startTile, int width, int height, float speed) {
        this.texture = texture;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void Draw() {
        DrawQuadTex(texture, x, y, width, height);
    }
}
