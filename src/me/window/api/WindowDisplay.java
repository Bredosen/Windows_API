package me.window.api;

import me.window.api.exceptions.InitializedException;
import me.window.api.managers.*;
import me.window.api.types.WindowDisplayType;

public abstract class WindowDisplay {

    private final WindowDisplayType windowDisplayType;
    private final GraphicsManager   graphicsManager;
    private final DisplayManager    displayManager;
    private final SceneManager      sceneManager;
    private       boolean           initialized;

    public WindowDisplay(final WindowDisplayType windowDisplayType) {
        this.windowDisplayType = windowDisplayType;
        this.displayManager    = new DisplayManager(this);
        this.graphicsManager   = new GraphicsManager(this);
        this.sceneManager      = new SceneManager(this);
        try {
            setup();
        } catch (InitializedException e) {
            e.printStackTrace();
        }
    }

    /*
    display settings
    graphics settings
    Scenes
    Initialize
    Show
    Repaint
     */
    public abstract void setup() throws InitializedException;

    public final void initialize() {
        sceneManager().loadScenes();
        initialized = true;
    }

    public final boolean initialized() {
        return this.initialized;
    }


    public final WindowDisplayType getDisplayType() {
        return this.windowDisplayType;
    }

    public final DisplayManager displayManager() {
        return this.displayManager;
    }

    public final DisplayProperties displayProperties() {
        return displayManager().displayProperties();
    }

    public final SceneManager sceneManager() {
        return this.sceneManager;
    }

    public final GraphicsManager graphicsManager() {
        return this.graphicsManager;
    }

    public final GraphicsProperties graphicsProperties() {
        return graphicsManager().graphicsProperties();
    }
}
