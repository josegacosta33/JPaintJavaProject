package model;

import java.util.ArrayList;
import draw.commands.ICommand;
/*
 *implements the undelete functionality
 */
public class RecoverDelete implements ICommand {

    private ArrayList<Shape> shapes;
    private Shapes mainList;
    private Drawer draw;
    //hold single instance
    private static RecoverDelete instance = null;

    //undo a delete operation
    private RecoverDelete() {
        mainList = Shapes.getShapes();
        shapes = new ArrayList<>();
        draw = new Drawer();
    }

    //get the single instance of the class
    public static RecoverDelete getSelectedShapes() {
        if (instance == null) instance = new RecoverDelete();
        return instance;
    }

    //add to the reecovery list
    public boolean put(Shape shape) {
        shapes.add(shape);
        return true;
    }

    public ArrayList getArray() { return shapes; }

    @Override
    public void redo() {
        //add all shapes in list back to main shapes list
        for (Shape addback : shapes) {
            mainList.remove(addback);
        }
        //redraw all shapes
        draw.DrawShapes();
        shapes.clear();

    }

    @Override
    public void undo() {
        //remove all shapes in list from main shapes list and redraw
        for (Shape add : shapes) {
            mainList.put(add);
        }
        draw.DrawShapes();
    }


}