package data;

import helpers.Clock;
import helpers.StateManager;
import org.lwjgl.opengl.Display;
import static helpers.Artist.*;
/**
 * Created by Liam on 2016-09-03.
 */
public class Boot {

    public Boot() {
        BeginSession();
        while(!Display.isCloseRequested()) {
            Clock.update();
            StateManager.update();
            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }
    public static void main(String[] args) {
        new Boot();
    }
}
