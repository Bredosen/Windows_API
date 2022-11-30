package me.window.api.managers;

import me.window.api.WindowDisplay;
import me.window.api.types.GraphicsRenderType;

public final class GraphicsProperties {
    private final GraphicsManager graphicsManager;

    private double             renderRatio;
    private GraphicsRenderType graphicsRenderType;


    public GraphicsProperties(final GraphicsManager graphicsManager) {
        this.graphicsManager    = graphicsManager;
        this.renderRatio        = 1.0D;
        this.graphicsRenderType = GraphicsRenderType.Volatile;
    }


    public GraphicsManager graphicsManager() {
        return this.graphicsManager;
    }

    public WindowDisplay windowDisplay() {
        return graphicsManager().windowDisplay();
    }


    public double getRenderRatio() {
        return this.renderRatio;
    }

    public void setRenderRatio(final double renderRatio) {
        this.renderRatio = renderRatio;
    }

    public GraphicsRenderType getGraphicsRenderType() {
        return this.graphicsRenderType;
    }

    public void setGraphicsRenderType(final GraphicsRenderType graphicsRenderType) {
        this.graphicsRenderType = graphicsRenderType;
    }
}
