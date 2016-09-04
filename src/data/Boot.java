package data;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;

/**
 * Created by Liam on 2016-09-03.
 */
public class Boot {

    public Boot() {

        BeginSession();

        Tile tile = new Tile(0, 0, 64, 64, TileType.Grass);
        Tile tile2 = new Tile(0, 64, 64, 64, TileType.Dirt);

        while(!Display.isCloseRequested()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            tile.Draw();
            tile2.Draw();

            Display.update();
            Display.sync(60);
        }

        Display.destroy();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
