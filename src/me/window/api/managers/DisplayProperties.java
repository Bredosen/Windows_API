package me.window.api.managers;

import me.window.api.WindowDisplay;
import me.window.api.exceptions.InitializedException;

import java.awt.*;

public class DisplayProperties {
    private final DisplayManager displayManager; // Display Manger instance.

    private String  title; // Display title.
    private double  displayWidth; // Display screen width.
    private double  displayHeight; // Display screen height.
    private double  displayX; // Display screen x.
    private double  displayY; // Display screen y.
    private boolean centerDisplay; // Center display screen.
    private boolean border; // Display border.
    private Image   iconImage; // Display icon image.
    private boolean fullscreen; // Display fullscreen mode.
    private Cursor  cursor; // Display cursor.
    private boolean resizeable; // Display resizeable mode.
    private boolean focusable; // Display focusable mode.

    /**
     * Setting up DisplayProperties, with default values for the variables.
     *
     * @param windowDisplay
     */
    public DisplayProperties(final DisplayManager displayManager) {
        this.displayManager = displayManager;
        this.title          = "WindowDisplay API";
        this.displayWidth   = 1200.0D;
        this.displayHeight  = 800.0D;
        this.displayX       = 0.0D;
        this.displayY       = 0.0D;
        this.centerDisplay  = true;
        this.border         = true;
        this.iconImage      = null;
        this.fullscreen     = false;
        this.cursor         = Cursor.getDefaultCursor();
        this.resizeable     = false;
        this.focusable      = true;
    }

    /**
     * Returns the DisplayManger.
     *
     * @return displayManager
     */
    public final DisplayManager displayManager() {
        return this.displayManager;
    }

    /**
     * Returns the WindowDisplay.
     *
     * @return WindowDisplay.
     */
    public final WindowDisplay windowDisplay() {
        return displayManager().windowDisplay();
    }

    /**
     * Returns the title of the windowDisplay.
     *
     * @return Title.
     */
    public final String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the windowDisplay.
     *
     * @param title
     */
    public final void setTitle(final String title) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.title = title;
    }

    /**
     * Returns the display width of the windowDisplay.
     *
     * @return displayWidth
     */
    public final double getDisplayWidth() {
        return this.displayWidth;
    }

    /**
     * Sets the display width of the windowDisplay.
     *
     * @param displayWidth
     */
    public final void setDisplayWidth(final double displayWidth) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.displayWidth = displayWidth;
    }

    /**
     * Returns the display height of the windowDisplay.
     *
     * @return displayHeight
     */
    public final double getDisplayHeight() {
        return this.displayHeight;
    }

    /**
     * Sets the display height of the windowDisplay.
     *
     * @param displayHeight
     */
    public final void setDisplayHeight(final double displayHeight) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.displayHeight = displayHeight;
    }

    /**
     * Returns the display x location of the windowDisplay.
     *
     * @return displayX
     */
    public final double getDisplayX() {
        return this.displayX;
    }

    /**
     * Sets the display x location of the windowDisplay.
     *
     * @param displayX
     */
    public final void setDisplayX(final double displayX) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.displayX = displayX;
    }

    /**
     * Returns the display y location of the windowDisplay.
     *
     * @return displayY
     */
    public final double getDisplayY() {
        return this.displayY;
    }

    /**
     * Sets the display y location of the windowDisplay.
     *
     * @param displayY
     */
    public final void setDisplayY(final double displayY) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.displayY = displayY;
    }

    /**
     * Returns if the display is centered in the screen.
     *
     * @return centerDisplay
     */
    public final boolean isCenterDisplay() {
        return this.centerDisplay;
    }

    /**
     * Sets display centered in the screen.
     *
     * @param centerDisplay
     */
    public final void setCenterDisplay(final boolean centerDisplay) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.centerDisplay = centerDisplay;
    }

    /**
     * Returns display has border.
     *
     * @return border
     */
    public final boolean hasBorder() {
        return this.border;
    }

    /**
     * Sets display has border.
     *
     * @param border
     */
    public final void setBorder(final boolean border) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.border = border;
    }

    /**
     * Returns Icon image of the display.
     *
     * @return iconImage
     */
    public final Image getIconImage() {
        return this.iconImage;
    }

    /**
     * Sets the icon image of the display.
     *
     * @param iconImage
     */
    public final void setIconImage(final Image iconImage) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.iconImage = iconImage;
    }

    /**
     * Returns if the display is fullscreen.
     *
     * @return fullscreen
     */
    public final boolean isFullscreen() {
        return this.fullscreen;
    }

    /**
     * Sets the display fullscreen mode.
     *
     * @param fullscreen
     */
    public final void setFullscreen(final boolean fullscreen) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.fullscreen = fullscreen;
    }

    /**
     * Returns the cursor of the display.
     *
     * @return cursor
     */
    public final Cursor getCursor() {
        return this.cursor;
    }

    /**
     * Sets the cursor of the display.
     *
     * @param cursor
     */
    public final void setCursor(final Cursor cursor) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.cursor = cursor;
    }

    /**
     * Returns the display resizeable mode.
     *
     * @return resizeable
     */
    public final boolean isResizeable() {
        return this.resizeable;
    }

    /**
     * Sets the display resizeable mode.
     *
     * @param resizeable
     */
    public final void setResizeable(final boolean resizeable) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.resizeable = resizeable;
    }

    /**
     * Returns the display focusable mode.
     *
     * @return focusable
     */
    public final boolean isFocusable() {
        return this.focusable;
    }

    /**
     * Sets the display focusable mode.
     *
     * @param focusable
     */
    public final void setFocusable(final boolean focusable) throws InitializedException {
        if (windowDisplay().initialized()) throw new InitializedException("Cannot modify the display properties, WindowDisplay is already initialized.");
        this.focusable = focusable;
    }

    /**
     * Sets the display width and display height of the screen.
     *
     * @param displayWidth
     * @param displayHeight
     */
    public final void setDisplaySize(final double displayWidth, final double displayHeight) throws InitializedException {
        setDisplayWidth(displayWidth);
        setDisplayHeight(displayHeight);
    }

    /**
     * Sets the display x location and display y location of the screen.
     *
     * @param displayX
     * @param displayY
     */
    public final void setDisplayLocation(final double displayX, final double displayY) throws InitializedException {
        setDisplayX(displayX);
        setDisplayY(displayY);
    }
}
