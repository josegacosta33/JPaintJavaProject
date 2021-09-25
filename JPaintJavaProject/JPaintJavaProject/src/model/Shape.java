package model;

import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;

/**
 * The model for  a shape
 */
public class Shape {

    private int StartPointX;
    private int StartPointY;
    private ApplicationState state;
    private IGuiWindow window;
    private ShapeType shape;
    private ShapeColor primarycolor;
    private ShapeColor secondarycolor;
    private ShapeShading shading;
    private int EndPointX;
    private int EndPointY;

    public Shape (int StartX, int StartY, int EndX, int EndY, ApplicationState state, IGuiWindow window) {
        shape = state.getActiveShapeType();
        primarycolor = state.getActivePrimaryColor();
        secondarycolor = state.getActiveSecondaryColor();
        shading = state.getActiveShapeShadingType();
        this.window = window;
        this.state = state;
        StartPointX = StartX;
        StartPointY = StartY;
        EndPointX = EndX;
        EndPointY = EndY;
    }

    //getters and setters
    public IGuiWindow getGUIwindow () { return window;}
    public ApplicationState getState () {return state;}
    public int getStartPointX() { return StartPointX; }
    public int getStartPointY() { return StartPointY; }
    public int getEndPointX() { return EndPointX; }
    public int getEndPointY() { return EndPointY; }
    public ShapeType getShape() { return shape; }
    public ShapeColor getPrimaryColor() { return primarycolor; }
    public ShapeColor getSecondaryColor() { return secondarycolor; }
    public ShapeShading getShading() { return shading; }
    public void setStartPointX (int StartX) {
        StartPointX = StartX;
    }
    public void setStartPointY (int StartY) {
        StartPointY = StartY;
    }
    public void setEndPointX (int EndX) {
        EndPointX = EndX;
    }
    public void setEndPointY (int EndY) {
        EndPointY = EndY;
    }
    public void setShapeType (ShapeType tShape) {
        shape = tShape;
    }
    public void setPrimaryColor (ShapeColor pcShape ) {
        primarycolor= pcShape;
    }
    public void setSecondaryColor (ShapeColor scShape ) {
        secondarycolor = scShape;
    }
    public void setShading (ShapeShading stShape ) {
        shading = stShape;
    }
}