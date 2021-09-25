package draw;

import model.Shape;

import model.ColorChanger;
import model.ShapeColor;
import model.ShapeShading;
import view.gui.GuiWindow;
import view.interfaces.IGuiWindow;
import java.awt.*;

public class Triangle {

    private int StartX; 
    private int StartY;
    private int EndX; 
    private int EndY;
    private int Width; 
    private int Height;
    private int[] X;
    private int[] Y;
    private IGuiWindow window;
    private ShapeShading shading;
    private ShapeColor primarycolor;
    private ShapeColor secondarycolor;
    
    

    public Triangle(Shape shape) {
        StartX =  shape.getStartPointX();
        StartY = shape.getStartPointY();
        EndX = shape.getEndPointX();
        EndY = shape.getEndPointY();
        X = new int[]{StartX, ( (StartX+EndX ) /2), EndX};
        Y = new int[]{EndY, Math.abs(StartY), EndY};
        Height = (shape.getEndPointX()- shape.getStartPointX());
        Width = (shape.getEndPointY() -shape.getStartPointY());
        shading = shape.getShading();
        window = shape.getGUIwindow();
        primarycolor = shape.getPrimaryColor();
        secondarycolor = shape.getSecondaryColor();
//        
//        int width = (shape.getEndPointX() - shape.getStartPointX());


    }

    public void drawTriangle () {
        Graphics graphics2d = ((GuiWindow) window).getGraphics();
        Graphics2D g1 = (Graphics2D) graphics2d;
        ColorChanger ch = new ColorChanger();

        if (shading == ShapeShading.FILLED_IN) {
            g1.setColor(ch.COLORS(primarycolor));
            g1.fillPolygon(X,Y, 3);
            
        } else if (shading == ShapeShading.OUTLINE) {
            g1.setColor(ch.COLORS(primarycolor));
            g1.setStroke(new BasicStroke(5));
            g1.drawPolygon(X,Y, 3);
            g1.setColor(Color.WHITE);
            g1.fillPolygon(X,Y, 3);

            
            
        } else if (shading == ShapeShading.OUTLINE_AND_FILLED_IN) {
            g1.setColor(ch.COLORS(primarycolor));
            g1.fillPolygon(X,Y, 3);
            g1.setColor(ch.COLORS(secondarycolor));
            g1.setStroke(new BasicStroke(5));
            g1.drawPolygon(X,Y, 3);
        }
    }
}