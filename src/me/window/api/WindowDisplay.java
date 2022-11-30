package me.window.api;

import me.window.api.exceptions.InitializedException;
import me.window.api.managers.*;
import me.window.api.types.WindowDisplayType;

public abstract class WindowDisplay {

    private final WindowDisplayType windowDisplayType;
    private final GraphicsManager   graphicsManager;
    private final DisplayManager    displayManager;
    private final SceneManager      sceneManager;
    private final EventManager      eventManager;
    private final UpdateEngine      updateEngine;
    private       boolean           initialized;
    private       boolean           shouldTerminate;

    public WindowDisplay(final WindowDisplayType windowDisplayType) {
        this.windowDisplayType = windowDisplayType;
        this.displayManager    = new DisplayManager(this);
        this.graphicsManager   = new GraphicsManager(this);
        this.sceneManager      = new SceneManager(this);
        this.eventManager      = new EventManager(this);
        this.updateEngine      = new UpdateEngine(this);
        try {
            setup();
        } catch (InitializedException exception) {
            exception.printStackTrace();
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
        eventManager().initializeEvents();
        graphicsManager().initializeGraphics();
        displayManager().setupFrame();
        sceneManager().loadScenes();
        updateEngine().initializeEngine();
        initialized     = true;
        shouldTerminate = false;
    }

    public final void show() throws InitializedException {
        if (initialized) displayManager().show();
        else throw new InitializedException("Cannot show WindowDisplay, WindowDisplay is not initialized");
    }

    public final void hide() throws InitializedException {
        if (initialized) displayManager().hide();
        else throw new InitializedException("Cannot hide WindowDisplay, WindowDisplay is not initialized");
    }

    public final void dispose() throws InitializedException {
        if (initialized) displayManager().dispose();
        else throw new InitializedException("Cannot dispose WindowDisplay, WindowDisplay is not initialized");
    }

    public void shutdown() {
        try {
            hide();
            dispose();
            //TODO: SHUTDOWN REPAINTER AND UPDATOR.
            shouldTerminate = true;
        } catch (InitializedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean shouldRepaint() {
        return initialized() && !shouldTerminate;
    }

    public void repaint() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

    public final EventManager eventManager() {
        return this.eventManager;
    }

    public final UpdateEngine updateEngine() {
        return this.updateEngine;
    }
}
