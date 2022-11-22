package me.window.api.managers;

import me.window.api.WindowDisplay;

import javax.swing.*;
import java.awt.*;

public final class DisplayManager {

    private final WindowDisplay     windowDisplay;
    private final DisplayProperties displayProperties;

    private final Frame  staticFrame;
    private final JFrame dynamicFrame;

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

    public WindowDisplay windowDisplay() {
        return this.windowDisplay;
    }


    public DisplayProperties displayProperties() {
        return this.displayProperties;
    }
}
