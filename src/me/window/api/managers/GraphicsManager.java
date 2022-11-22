package me.window.api.managers;

import me.window.api.WindowDisplay;

public final class GraphicsManager {
    private final WindowDisplay      windowDisplay;
    private final GraphicsProperties graphicsProperties;

    public GraphicsManager(final WindowDisplay windowDisplay) {
        this.windowDisplay      = windowDisplay;
        this.graphicsProperties = new GraphicsProperties(this);
    }


    public GraphicsProperties graphicsProperties() {
        return this.graphicsProperties;
    }

    public WindowDisplay windowDisplay() {
        return this.windowDisplay;
    }
}
