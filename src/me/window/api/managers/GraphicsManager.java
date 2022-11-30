package me.window.api.managers;

import me.window.api.WindowDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;

public final class GraphicsManager {
    private final WindowDisplay      windowDisplay;
    private final GraphicsProperties graphicsProperties;

    private JPanel dynamicCanvas;
    private Canvas staticCanvas;

    private VolatileImage volatileImage;
    private BufferedImage bufferedImage;

    public GraphicsManager(final WindowDisplay windowDisplay) {
        this.windowDisplay      = windowDisplay;
        this.graphicsProperties = new GraphicsProperties(this);
    }

    public void initializeGraphics() {
        this.staticCanvas  = new Canvas();
        this.dynamicCanvas = new JPanel() {
            @Override
            public void paint(final Graphics g) {
                switch (graphicsProperties().getGraphicsRenderType()) {
                    case Volatile:
                        g.drawImage(volatileImage, 0, 0, windowDisplay().displayManager().getActiveFrame().getWidth(), windowDisplay().displayManager().getActiveFrame().getHeight(), null);
                    case Buffered:
                        g.drawImage(bufferedImage, 0, 0, windowDisplay().displayManager().getActiveFrame().getWidth(), windowDisplay().displayManager().getActiveFrame().getHeight(), null);
                    case Direct:
                        windowDisplay().sceneManager().activeScene().render((Graphics2D) g);
                    default:
                        windowDisplay().sceneManager().activeScene().render((Graphics2D) g);
                }
            }
        };
    }

    public Canvas staticCanvas() {
        return this.staticCanvas;
    }

    public JPanel dynamicCanvas() {
        return this.dynamicCanvas;
    }

    public Component getActiveCanvas() {
        switch (windowDisplay().getDisplayType()) {
            case Dynamic:
                return dynamicCanvas();
            case Static:
                return staticCanvas();
            default:
                return null;
        }
    }


    public GraphicsProperties graphicsProperties() {
        return this.graphicsProperties;
    }

    public WindowDisplay windowDisplay() {
        return this.windowDisplay;
    }
}
