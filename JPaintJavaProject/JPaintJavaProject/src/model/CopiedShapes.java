package model;

import java.util.ArrayList;

/**
 * wrapper for the  list copied shapes
 */
public class CopiedShapes {

    private static CopiedShapes instance = null;
    private ArrayList<Shape> shapes;

    //allow for single instance of class
    private CopiedShapes() { shapes = new ArrayList<>(); }

    //adds shape to the list of copied shapes
    public boolean put(Shape shape) {
        shapes.add(shape);
        return true;
    }

    //changes the copied shapes wit a new set
    public boolean changeArray(ArrayList<Shape> list) {
        shapes = list;
        return true;
    }

     public ArrayList getArray() { return shapes; }

     //called to get the single instance of the copied shapes
    public static CopiedShapes getSelectedShapes() {
        if (instance == null) instance = new CopiedShapes();
        return instance;

    }


}