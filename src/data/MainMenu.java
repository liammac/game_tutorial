package data;

import UI.*;
import helpers.StateManager;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
/**
 * Created by Liam on 2016-09-11.
 */
public class MainMenu {

    private Texture background;
    private UI menuUI;

    public MainMenu() {
        background = QuickLoad("mainmenu");
        menuUI = new UI();
        menuUI.addButton("Play", "playButton", WIDTH / 2 - 128, (int) (HEIGHT * 0.45f) );
        menuUI.addButton("Editor", "editorButton", WIDTH / 2 - 128, (int) (HEIGHT * 0.55f));
        menuUI.addButton("Quit", "quitButton", WIDTH / 2 - 128, (int) (HEIGHT * 0.65f));
    }

    private void updateButtons() {
        if (Mouse.isButtonDown(0)) {
            if (menuUI.isButtonClicked("Play"))
                StateManager.setState(StateManager.GameState.GAME);
        }
    }

    public void update() {
        DrawQuadTex(background, 0, 0, 2048, 1024);
        menuUI.draw();
        updateButtons();
    }
}
