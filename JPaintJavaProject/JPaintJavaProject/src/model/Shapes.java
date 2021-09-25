package model;
import java.util.ArrayList;
import draw.commands.ICommand;


public class Shapes implements ICommand {

    //holds single instance
    private static Shapes instance = null;

    private ArrayList<Shape> shapes;

    private Shapes() {
        shapes = new ArrayList<>();
    }

    //get the single instance
    public static Shapes getShapes() {
        //create if not initilaize
        if (instance == null)instance = new Shapes();
        return instance;

    }

    //add a new shape to the main list
    public boolean put(Shape shape) {
        shapes.add(shape);

        //draws the new shape
        Drawer newShape = new Drawer();
        newShape.DrawShapes();
        return true;
    }

    public boolean changeArray(ArrayList<Shape> list) {
        shapes = list;
        return true;
    }

    public ArrayList getArray() { return shapes; }

    //removes the last shape to be added
    public void removeLastShape(){
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
        }else{
            System.out.println("All shapes are removed");
        }
    }

    //remove the given shape
    public void remove(Shape shape) { shapes.remove(shape); }

    @Override
    public void undo() {}

    @Override
    public void redo() {}
}