package model;

import java.util.ArrayList;

/**
 * Wrapper for the selected shapes
 */
public class SelectedShapes {

    private static SelectedShapes instance = null;
    private ArrayList<Shape> shapes;

    private SelectedShapes() { shapes = new ArrayList<>(); }

     //get the single instance of selected shapes
    public static SelectedShapes getSelectedShapeList() {
        if (instance == null) instance = new SelectedShapes();
        return instance;
    }

    //adds shape to the list of selected shapes
    public boolean put(Shape shape) {
        shapes.add(shape);
        return true;
    }

    //removes all selected shapes and adds a new list
    public boolean changeArray(ArrayList<Shape> list) {
        shapes = list;
        return true;
    }

    public ArrayList getArray() { return shapes; }

}