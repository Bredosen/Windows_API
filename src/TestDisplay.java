import me.window.api.WindowDisplay;
import me.window.api.exceptions.InitializedException;
import me.window.api.types.WindowDisplayType;

public class TestDisplay extends WindowDisplay {
    public TestDisplay(WindowDisplayType windowDisplayType) {
        super(windowDisplayType);
    }

    public static void main(String[] args) {
        new TestDisplay(WindowDisplayType.Static);
    }

    @Override
    public void setup() throws InitializedException {
        displayProperties().setTitle("What up");
        displayProperties().setDisplaySize(1200.0D, 800.0D);
        displayProperties().setBorder(true);
        displayProperties().setResizeable(false);
        displayProperties().setCenterDisplay(true);


        sceneManager().addScene(null);
        sceneManager().setActiveScene("MainScene");

        initialize();
    }


}
