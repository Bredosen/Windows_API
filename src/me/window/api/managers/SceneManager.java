package me.window.api.managers;

import me.window.api.WindowDisplay;
import me.window.api.utilities.Scene;

import java.util.HashSet;

public final class SceneManager {

    private final WindowDisplay  windowDisplay;
    private final HashSet<Scene> sceneMatrix;
    private       Scene          activeScene;

    public SceneManager(final WindowDisplay windowDisplay) {
        this.windowDisplay = windowDisplay;
        this.sceneMatrix   = new HashSet<Scene>();
    }

    public boolean addScene(final Scene scene) {
        scene.inject(windowDisplay());
        return sceneMatrix.add(scene);
    }

    public boolean removeScene(final Scene scene) {
        return sceneMatrix.remove(scene);
    }

    public Scene getScene(final String sceneName) {
        Scene returnScene = null;
        for (final Scene scene : sceneMatrix) if (scene.getSceneName().equals(sceneName)) returnScene = scene;
        return returnScene;
    }

    public void setActiveScene(final String sceneName) {
        final Scene scene = getScene(sceneName);
        if (scene != null) setActiveScene(scene);
        if (windowDisplay().initialized()) scene.reset();
    }

    public void setActiveScene(final Scene scene) {
        this.activeScene = scene;
    }

    public Scene activeScene() {
        return this.activeScene;
    }

    public void loadScenes() {
        for (final Scene scene : sceneMatrix) scene.loadScene();
    }


    /**
     * Returns the sceneMatrix.
     *
     * @return sceneMatrix
     */
    public HashSet<Scene> sceneMatrix() {
        return this.sceneMatrix;
    }

    public WindowDisplay windowDisplay() {
        return this.windowDisplay;
    }
}
