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

        int[][] map = {
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0},
                {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0},
                {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        };

        TileGrid grid = new TileGrid(map);

        while(!Display.isCloseRequested()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            grid.Draw();

            Display.update();
            Display.sync(60);
        }

        Display.destroy();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
