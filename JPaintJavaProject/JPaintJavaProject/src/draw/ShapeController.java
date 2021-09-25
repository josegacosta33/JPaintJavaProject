package draw;

import model.Shape;
import model.ShapeShading;
import model.persistence.ApplicationState;
import view.gui.GuiWindow;
import view.interfaces.IGuiWindow;

import java.awt.*;

public class ShapeController {

    private int StartX; 
    private int StartY;
    private int Width; 
    private int Height;
    private IGuiWindow window;
    private ApplicationState state;
    private ShapeShading shading;

    public ShapeController(Shape shape) {
    		StartY = shape.getStartPointY();
        StartX =  shape.getStartPointX();
        state = shape.getState();
        Width = (shape.getEndPointX() - shape.getStartPointX());
        Height = (shape.getEndPointY() - shape.getStartPointY());
        window = shape.getGUIwindow();
        shading= shape.getShading();
        
    }

    public void drawShape () {
        Graphics graphics = ((GuiWindow) window).getGraphics();
        Graphics2D g1 = (Graphics2D) graphics;
        if (shading == ShapeShading.FILLED_IN) {
            g1.setColor(Color.WHITE);
            g1.fillRect(StartX, StartY, Height, Width);
        }
    }
}
