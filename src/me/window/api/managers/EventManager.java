package me.window.api.managers;

import me.window.api.WindowDisplay;
import me.window.api.events.DisplayStateEvent;

public final class EventManager {

    private final WindowDisplay     windowDisplay;
    private       DisplayStateEvent displayStateEvent;

    public EventManager(final WindowDisplay windowDisplay) {
        this.windowDisplay = windowDisplay;
    }

    public void initializeEvents() {
        this.displayStateEvent = new DisplayStateEvent(this);
    }

    public DisplayStateEvent displayStateEvent() {
        return this.displayStateEvent;
    }


    public WindowDisplay windowDisplay() {
        return this.windowDisplay;
    }
}
