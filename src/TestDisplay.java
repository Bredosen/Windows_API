import me.window.api.WindowDisplay;
import me.window.api.exceptions.InitializedException;
import me.window.api.types.GraphicsRenderType;
import me.window.api.types.WindowDisplayType;

public class TestDisplay extends WindowDisplay {
    public TestDisplay(WindowDisplayType windowDisplayType) {
        super(windowDisplayType);
    }

    public static void main(String[] args) {
        new TestDisplay(WindowDisplayType.Dynamic);
    }

    @Override
    public void setup() throws InitializedException {
        displayProperties().setTitle("What up");
        displayProperties().setDisplaySize(1200.0D, 800.0D);
        displayProperties().setBorder(true);
        displayProperties().setResizeable(false);
        displayProperties().setCenterDisplay(true);
        displayProperties().setManageShutdownManuel(false);

        graphicsProperties().setGraphicsRenderType(GraphicsRenderType.Direct);
        graphicsProperties().setRenderRatio(1.0D);

        sceneManager().addScene(new TestScene("MainScene"));
        sceneManager().setActiveScene("MainScene");

        initialize();

        show();

        while (shouldRepaint()) repaint();

        System.out.println("YEAH!");
    }


}
