import me.window.api.utilities.Scene;

import java.awt.*;

public class TestScene extends Scene {
    public TestScene(String sceneName) {
        super(sceneName);
    }

    @Override
    public void load() {

    }

    @Override
    public void render(final Graphics2D g) {
        g.setColor(Color.red);
        for (int index = 0; index < 100; index++) {
            g.fillRect(0, 0, 200, 200);
        }

    }

    @Override
    public void update() {

    }

    @Override
    public void reset() {

    }
}
