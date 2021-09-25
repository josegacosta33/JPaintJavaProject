package model;
import draw.ShapeController;

import draw.Triangle;
import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;
import draw.Rectangle;
import draw.Circle;

import java.util.ArrayList;

/**
 * class that draws to the background
 */
public class Drawer {
    private ArrayList<Shape> backgroundList;
    private ArrayList<Shape> drawlist;
    private Shapes shapes = Shapes.getShapes();
    private BackgroundShapes backgroundShapes = BackgroundShapes.getSelectedShapes();
    private IGuiWindow window;
    private  ApplicationState state;

    public Drawer() {
        //get the lists to draw
        drawlist = shapes.getArray();
        backgroundList = backgroundShapes.getArray();
        info();
    }

    /**
     * method to actually draw
     */
    public void DrawShapes() {
        //drawss the background shape
        ShapeController background = new ShapeController(backgroundList.get(0));
        background.drawShape();

        //draws all shapes in the list according to shape type
        for ( Shape shape: drawlist ) {
            if (shape.getShape() == ShapeType.Circle) {
                System.out.println( "A CIRCLE/ELLIPSE");
                Circle circle = new Circle(shape);
                circle.draw();
            }else if (shape.getShape() == ShapeType.RECTANGLE) {
                System.out.println( "A RECTANGLE");
                Rectangle rect = new Rectangle(shape);
                rect.drawRectangle();
            }else if (shape.getShape() == ShapeType.TRIANGLE) {
                System.out.println( "A TRIANGLE");
                Triangle tri = new Triangle((shape));
                tri.drawTriangle();
            }

        }

    }

    //gets the shape info and application state
    private void info() {
        if (!drawlist.isEmpty()) {
            Shape info1 = drawlist.get(0);
            this.state = info1.getState();
            this.window = info1.getGUIwindow();
        }
    }
}