package model;

import java.util.ArrayList;

public class BackgroundShapes {
    //holds sinlge instance of class
    private static BackgroundShapes instance = null;
    private ArrayList<Shape> shapes;

    private BackgroundShapes() { shapes = new ArrayList<>();}

    //gets the single instance of class
    public static BackgroundShapes getSelectedShapes() {
        //initializes instance if not available
        if (instance == null) instance = new BackgroundShapes();
        return instance;
    }

    public ArrayList getArray() { return shapes; }

    //adds a new shape to the backgroud shapes
    public boolean put(Shape shape) {
        shapes.add(shape);
        return true;
    }

}