package me.window.api.managers;

import me.window.api.WindowDisplay;

public final class GraphicsProperties {
    private final GraphicsManager graphicsManager;

    private double renderRatio;


    public GraphicsProperties(final GraphicsManager graphicsManager) {
        this.graphicsManager = graphicsManager;
    }


    public GraphicsManager graphicsManager() {
        return this.graphicsManager;
    }

    public WindowDisplay windowDisplay() {
        return graphicsManager().windowDisplay();
    }
}
