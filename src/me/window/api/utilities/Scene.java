package me.window.api.utilities;

public abstract class Scene {
    private final String sceneName;

    public Scene(final String sceneName) {
        this.sceneName = sceneName;
    }

    public abstract void load();

    public abstract void render();

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
}
