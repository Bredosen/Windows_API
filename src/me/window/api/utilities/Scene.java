package me.window.api.utilities;

import me.window.api.WindowDisplay;

import java.awt.*;

public abstract class Scene {
    private final String        sceneName;
    private       WindowDisplay windowDisplay;

    public Scene(final String sceneName) {
        this.sceneName = sceneName;
    }

    public void inject(final WindowDisplay windowDisplay) {
        this.windowDisplay = windowDisplay;
    }

    public abstract void load();

    public abstract void render(final Graphics2D g);

    public abstract void update();

    public abstract void reset();


    /**
     * Returns the scene name.
     *
     * @return sceneName
     */
    public final String getSceneName() {
        return this.sceneName;
    }

    //TODO:  LOAD SCENE!

    public void loadScene() {
    }

    public double deltaTime() {
        return windowDisplay.updateEngine().deltaTime();
    }
}
