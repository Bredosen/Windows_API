package me.window.api.managers;

import me.window.api.WindowDisplay;

import javax.swing.*;
import java.awt.*;

public final class DisplayManager {

    private final WindowDisplay     windowDisplay;
    private final DisplayProperties displayProperties;

    private final Frame  staticFrame;
    private final JFrame dynamicFrame;

    private boolean visible;

    public DisplayManager(final WindowDisplay windowDisplay) {
        this.windowDisplay     = windowDisplay;
        this.displayProperties = new DisplayProperties(this);
        this.staticFrame       = new Frame();
        this.dynamicFrame      = new JFrame();
    }

    public Frame staticFrame() {
        return this.staticFrame;
    }

    public JFrame dynamicFrame() {
        return this.dynamicFrame;
    }

    public void setupFrame() {
        final Frame frame = getActiveFrame();

        frame.setTitle(displayProperties().getTitle());
        frame.setUndecorated(!displayProperties().hasBorder());
        frame.setSize((int) displayProperties().getDisplayWidth(), (int) displayProperties().getDisplayHeight());
        frame.setLocation((int) displayProperties().getDisplayX(), (int) displayProperties().getDisplayY());
        if (displayProperties().isCenterDisplay()) frame.setLocationRelativeTo(null);
        if (displayProperties().isFullscreen()) frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        if (frame instanceof JFrame dynamicFrame) dynamicFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        if (frame instanceof JFrame dynamicFrame) dynamicFrame.setContentPane(windowDisplay().graphicsManager().dynamicCanvas());
        else frame.add(windowDisplay().graphicsManager().staticCanvas());
        frame.setCursor(displayProperties().getCursor());
        frame.addWindowListener(windowDisplay().eventManager().displayStateEvent());
        frame.setIconImage(displayProperties().getIconImage());
        frame.setFocusable(displayProperties().isFocusable());
        frame.setResizable(displayProperties().isResizeable());
        frame.setOpacity(displayProperties().getOpacity());
    }


    public void show() {
        final Frame frame = getActiveFrame();
        this.visible = true;
        frame.setVisible(true);
    }

    public void hide() {
        final Frame frame = getActiveFrame();
        this.visible = false;
        frame.setVisible(false);
    }

    public void dispose() {
        final Frame frame = getActiveFrame();
        frame.dispose();
    }

    public boolean isVisible() {
        return this.visible;
    }

    public Frame getActiveFrame() {
        switch (windowDisplay().getDisplayType()) {
            case Dynamic:
                return dynamicFrame();
            case Static:
                return staticFrame();
            default:
                return null;
        }
    }


    public WindowDisplay windowDisplay() {
        return this.windowDisplay;
    }


    public DisplayProperties displayProperties() {
        return this.displayProperties;
    }


}
