package draw.commands;


import model.persistence.ApplicationState;

import model.Shape;
import model.Drawer;
import model.Shapes;
import view.interfaces.IGuiWindow;



public class Create implements ICommand {

    
    private Shapes mainList; private Drawer drawer;
    private Shape shape1;

    public Create(int StartX, int StartY, int EndX, int EndY, ApplicationState State, IGuiWindow window) {
        shape1 = new Shape(StartX, StartY, EndX, EndY, State, window);
        Shapes a = Shapes.getShapes();
        a.put(shape1);
        mainList = Shapes.getShapes();
        drawer = new Drawer();
        
    }

    @Override
    public void redo() {
        mainList.put(shape1);
        drawer.DrawShapes();
//        g1.drawOval(40, 40, 60, 60); //FOR CIRCLE
//        g1.drawRect(80, 30, 200, 200); // FOR SQUARE
//        g1.drawRect(200, 100, 100, 200); // FOR RECT
    }

    @Override
    public void undo() {
        mainList.removeLastShape();
        drawer.DrawShapes();
    }

}