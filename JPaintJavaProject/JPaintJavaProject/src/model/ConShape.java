package model;

import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.util.ArrayList;

public class ConShape {

    private SelectedShapes selectedShapes;
    private ShapeType ShapeType;private Shape info;
        private ShapeColor secondarycolor;
    private ShapeShading shading;
    private ShapeColor primarycolor;
    private IGuiWindow window;
    private IUiModule uimod;
    private ApplicationState state;
    private ArrayList<Shape> selectedShape;
    private Drawer drawer;



    public ConShape() {
        //get the shapes that have been selected
        selectedShapes = SelectedShapes.getSelectedShapeList();
        selectedShape = selectedShapes.getArray();

        //gets the info of first shape if list not empty
        if (!selectedShape.isEmpty()) info = selectedShape.get(0);
        getInfo();
        drawer = new Drawer();
    }

    /*
      *gets the active state and sets to the conshape
     */
    private void getInfo() {
        if (info != null) {
            state = info.getState();
            ShapeType = state.getActiveShapeType();
            primarycolor = state.getActivePrimaryColor();
            secondarycolor = state.getActiveSecondaryColor();
            shading = state.getActiveShapeShadingType();
        }
    }

    //changes the shape type and redraws it
    //for all the shapes in the list
    public void UpdateShape() {
        for (Shape shape : selectedShape) {
            shape.setShapeType(ShapeType);
        }
        drawer.DrawShapes();
    }
    //The methods below are for updating the shapes
    //update all shapes in the selected list


    //chamges the primary color
    public void UpdatePriColor() {
        for (Shape singleShape : selectedShape) {
            singleShape.setPrimaryColor(primarycolor);
        }
        drawer.DrawShapes();
    }

    //updates the secondary color
    public void UpdateSecColor() {
        for (Shape singleShape : selectedShape) {
            singleShape.setSecondaryColor(secondarycolor);
        }
        drawer.DrawShapes();
    }


    //chnges the typr of shading
    public void UpdateShading() {
        for (Shape singleShape : selectedShape) {
            singleShape.setShading(shading);
        }
        drawer.DrawShapes();
    }
}
