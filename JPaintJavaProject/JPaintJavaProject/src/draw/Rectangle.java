package draw;
import model.Shape;
import model.ColorChanger;
import model.ShapeColor;
import model.ShapeShading;
import view.gui.GuiWindow;
import view.interfaces.IGuiWindow;
import java.awt.*;

public class Rectangle {
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShading shading;
    private int StartX; 
    private int StartY;
    private int EndX; 
    private int EndY;
    private IGuiWindow window;


    public Rectangle(Shape shape) {
        int width = (shape.getEndPointX() - shape.getStartPointX());
        int height = (shape.getEndPointY() - shape.getStartPointY());
        window = shape.getGUIwindow();
        primaryColor = shape.getPrimaryColor();
        secondaryColor = shape.getSecondaryColor();
        shading = shape.getShading();
        StartX =  shape.getStartPointX();
        StartY = shape.getStartPointY();
        EndX = shape.getEndPointX();
        EndY = shape.getEndPointY();
    }

    public void drawRectangle () {

        Graphics graphics = ((GuiWindow) window).getGraphics();
        Graphics2D g1 = (Graphics2D) graphics;
        ColorChanger ch = new ColorChanger();

        if (shading == ShapeShading.FILLED_IN) {
            g1.setColor(ch.COLORS(primaryColor));
            g1.fillRect(Math.min(StartX, EndX), Math.min(StartY,EndY), Math.abs(StartX-EndX), Math.abs(StartY-EndY));
        } else if (shading == ShapeShading.OUTLINE) {
            g1.setColor(ch.COLORS(primaryColor));
            g1.setStroke(new BasicStroke(5));
            g1.drawRect(Math.min(StartX, EndX), Math.min(StartY, EndY), Math.abs(StartX - EndX), Math.abs(StartY - EndY));
            g1.setColor(Color.WHITE);
            g1.fillRect(Math.min(StartX, EndX), Math.min(StartY, EndY), Math.abs(StartX - EndX), Math.abs(StartY - EndY));

        } else if (shading == ShapeShading.OUTLINE_AND_FILLED_IN) {
            g1.setColor(ch.COLORS(primaryColor));
            g1.fillRect(Math.min(StartX, EndX), Math.min(StartY,EndY), Math.abs(StartX-EndX), Math.abs(StartY-EndY));
            g1.setColor(ch.COLORS(secondaryColor));
            g1.setStroke(new BasicStroke(5));
            g1.drawRect(Math.min(StartX, EndX), Math.min(StartY,EndY), Math.abs(StartX-EndX), Math.abs(StartY-EndY));
        }
    }
}
//
//		@Override
//		protected void onDraw(Canvas canvas) {
//    			canvas.drawColor(Color.BLUE);
//    			canvas.drawRect(rectangle, paint);
//  }
//}