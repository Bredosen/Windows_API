package me.window.api.managers;

import me.window.api.WindowDisplay;

public final class UpdateEngine {
    private final WindowDisplay windowDisplay;
    private final long          DIVIDE_FACTOR = 1_000_000_000L;
    private       Thread        engine;
    private       double        deltaTime;
    private       long          lastDeltaTime;

    public UpdateEngine(final WindowDisplay windowDisplay) {
        this.windowDisplay = windowDisplay;
    }

    public void initializeEngine() {
        this.engine = new Thread(() -> {
            while (windowDisplay().shouldRepaint()) {
                windowDisplay().sceneManager().activeScene().update();
                deltaTime     = (double) ((System.nanoTime() - lastDeltaTime) / DIVIDE_FACTOR);
                lastDeltaTime = System.nanoTime();
            }
        });
        engineThread().start();
    }

    public double deltaTime() {
        return this.deltaTime;
    }

    public Thread engineThread() {
        return this.engine;
    }

    public WindowDisplay windowDisplay() {
        return this.windowDisplay;
    }
}
