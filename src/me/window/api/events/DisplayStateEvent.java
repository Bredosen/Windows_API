package me.window.api.events;

import me.window.api.events.methods.windowState.*;
import me.window.api.managers.DisplayManager;
import me.window.api.managers.EventManager;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public final class DisplayStateEvent implements WindowListener {

    private final EventManager   eventManager;
    private final DisplayManager displayManager;

    private final List<DisplayOpenedEvent>      displayOpenedEvents;
    private final List<DisplayClosingEvent>     displayClosingEvents;
    private final List<DisplayClosedEvent>      displayClosedEvents;
    private final List<DisplayIconifiedEvent>   displayIconifiedEvents;
    private final List<DisplayDeiconifiedEvent> displayDeiconifiedEvents;
    private final List<DisplayActivatedEvent>   displayActivatedEvents;
    private final List<DisplayDeactivatedEvent> displayDeactivatedEvents;


    public DisplayStateEvent(final EventManager eventManager) {
        this.eventManager             = eventManager;
        this.displayManager           = eventManager().windowDisplay().displayManager();
        this.displayOpenedEvents      = new ArrayList<>();
        this.displayClosingEvents     = new ArrayList<>();
        this.displayClosedEvents      = new ArrayList<>();
        this.displayIconifiedEvents   = new ArrayList<>();
        this.displayDeiconifiedEvents = new ArrayList<>();
        this.displayActivatedEvents   = new ArrayList<>();
        this.displayDeactivatedEvents = new ArrayList<>();
    }

    @Override
    public void windowOpened(final WindowEvent windowEvent) {
        getDisplayOpenedEvents().forEach(displayOpenedEvent -> displayOpenedEvent.windowOpened(windowEvent));
    }

    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        if (!displayManager().displayProperties().isManageShutdownManuel()) displayManager().windowDisplay().shutdown();
        getDisplayClosingEvents().forEach(displayClosingEvent -> displayClosingEvent.windowClosing(windowEvent));
    }

    @Override
    public void windowClosed(final WindowEvent windowEvent) {
        getDisplayClosedEvents().forEach(displayClosedEvent -> displayClosedEvent.windowClosed(windowEvent));
    }

    @Override
    public void windowIconified(final WindowEvent windowEvent) {
        getDisplayIconifiedEvents().forEach(displayIconifiedEvent -> displayIconifiedEvent.windowIconified(windowEvent));
    }

    @Override
    public void windowDeiconified(final WindowEvent windowEvent) {
        getDisplayDeiconifiedEvents().forEach(displayDeiconifiedEvent -> displayDeiconifiedEvent.windowDeiconified(windowEvent));
    }

    @Override
    public void windowActivated(final WindowEvent windowEvent) {
        getDisplayActivatedEvents().forEach(displayActivatedEvent -> displayActivatedEvent.windowActivated(windowEvent));
    }

    @Override
    public void windowDeactivated(final WindowEvent windowEvent) {
        getDisplayDeactivatedEvents().forEach(displayDeactivatedEvent -> displayDeactivatedEvent.windowDeactivated(windowEvent));
    }


    //<editor-fold desc="Display Opened Events">
    public void addDisplayOpenedEvent(final DisplayOpenedEvent displayOpenedEvent) {
        this.displayOpenedEvents.add(displayOpenedEvent);
    }

    public boolean removeDisplayOpenedEvent(final DisplayOpenedEvent displayOpenedEvent) {
        return this.displayOpenedEvents.remove(displayOpenedEvent);
    }

    public List<DisplayOpenedEvent> getDisplayOpenedEvents() {
        return this.displayOpenedEvents;
    }
    //</editor-fold>

    //<editor-fold desc="Display Closing Events">
    public void addDisplayClosingEvent(final DisplayClosingEvent displayClosingEvent) {
        this.displayClosingEvents.add(displayClosingEvent);
    }

    public boolean removeDisplayClosingEvent(final DisplayClosingEvent displayClosingEvent) {
        return this.displayClosingEvents.remove(displayClosingEvent);
    }

    public List<DisplayClosingEvent> getDisplayClosingEvents() {
        return this.displayClosingEvents;
    }
    //</editor-fold>

    //<editor-fold desc="Display Closed Events">
    public void addDisplayClosedEvent(final DisplayClosedEvent displayClosedEvent) {
        this.displayClosedEvents.add(displayClosedEvent);
    }

    public boolean removeDisplayClosedEvent(final DisplayClosedEvent displayClosedEvent) {
        return this.displayClosedEvents.remove(displayClosedEvent);
    }

    public List<DisplayClosedEvent> getDisplayClosedEvents() {
        return this.displayClosedEvents;
    }
    //</editor-fold>

    //<editor-fold desc="Display Iconified Events">
    public void addDisplayIconifiedEvent(final DisplayIconifiedEvent displayIconifiedEvent) {
        this.displayIconifiedEvents.add(displayIconifiedEvent);
    }

    public boolean removeDisplayIconifiedEvent(final DisplayIconifiedEvent displayIconifiedEvent) {
        return this.displayIconifiedEvents.remove(displayIconifiedEvent);
    }

    public List<DisplayIconifiedEvent> getDisplayIconifiedEvents() {
        return this.displayIconifiedEvents;
    }
    //</editor-fold>

    //<editor-fold desc="Display Deiconified Events">
    public void addDisplayDeiconifiedEvent(final DisplayDeiconifiedEvent displayDeiconifiedEvent) {
        this.displayDeiconifiedEvents.add(displayDeiconifiedEvent);
    }

    public boolean removeDisplayDeiconifiedEvent(final DisplayDeiconifiedEvent displayDeiconifiedEvent) {
        return this.displayDeiconifiedEvents.remove(displayDeiconifiedEvent);
    }

    public List<DisplayDeiconifiedEvent> getDisplayDeiconifiedEvents() {
        return this.displayDeiconifiedEvents;
    }
    //</editor-fold>

    //<editor-fold desc="Display Activated Events">
    public void addDisplayActivatedEvent(final DisplayActivatedEvent displayActivatedEvent) {
        this.displayActivatedEvents.add(displayActivatedEvent);
    }

    public boolean removeDisplayActivatedEvent(final DisplayActivatedEvent displayActivatedEvent) {
        return this.displayActivatedEvents.remove(displayActivatedEvent);
    }

    public List<DisplayActivatedEvent> getDisplayActivatedEvents() {
        return this.displayActivatedEvents;
    }
    //</editor-fold>

    //<editor-fold desc="Display Deactivated Events">
    public void addDisplayDeactivatedEvent(final DisplayDeactivatedEvent displayDeactivatedEvent) {
        this.displayDeactivatedEvents.add(displayDeactivatedEvent);
    }

    public boolean removeDisplayDeactivatedEvent(final DisplayDeactivatedEvent displayDeactivatedEvent) {
        return this.displayDeactivatedEvents.remove(displayDeactivatedEvent);
    }

    public List<DisplayDeactivatedEvent> getDisplayDeactivatedEvents() {
        return this.displayDeactivatedEvents;
    }
    //</editor-fold>

    public EventManager eventManager() {
        return this.eventManager;
    }

    public DisplayManager displayManager() {
        return this.displayManager;
    }
}
