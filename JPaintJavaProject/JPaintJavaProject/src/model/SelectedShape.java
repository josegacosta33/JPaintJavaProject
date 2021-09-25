package model;

import model.persistence.ApplicationState;

import view.interfaces.IGuiWindow;

import java.util.ArrayList;

import javafx.geometry.BoundingBox;

/*
 *checks if a shape is selected
 */
public class SelectedShape {

    private ArrayList<Shape> totalShapeArray;
    private ArrayList<Shape> selectedShapeArray;
    private Boolean found;
    private BoundingBox boundingBox;
    private ApplicationState state;
    private SelectedShapes selectedShapes;

    public SelectedShape(int StartX, int StartY, int EndX, int EndY, ApplicationState state, IGuiWindow guiWindow) {
        int startX = StartX,startY = StartY;
        int endX = EndX,endY = EndY;
        this.state = state;
        //gets the current state
        selectedShapes = SelectedShapes.getSelectedShapeList();
        selectedShapeArray = selectedShapes.getArray();
        Shapes shapes = Shapes.getShapes();
        totalShapeArray = shapes.getArray();

        //check if a shape is found in the boundary
        boolean found = getShape();
        if (!found) {
            selectedShapeArray.clear();
            int x = selectedShapeArray.size();
            System.out.printf("Length of selected list =  %d", x );
        }

    }


    private boolean getShape() {
        boolean found = false;
        for (Shape shape : totalShapeArray) {
            //get the coordinates of the shapes
            int startX = shape.getStartPointX();
            int endX = shape.getEndPointX();
            int startY = shape.getStartPointY();
            int endY = shape.getEndPointY();

            ////
            if (startX != endX || startY != endY) {

                //get the selected bounding ares
                boundingBox = new BoundingBox(Math.min(startX, endX), Math.min(startY,endY), Math.abs(startX-endX), Math.abs(startY-endY));
                double doubleStartX = (double) startX;
                double doubleStartY = (double) startY;
                double doubleEndX = (double) endX;
                double doubleEndY = (double) endY;

                 //check if bounding area has shape
                if (boundingBox.contains(Math.min(doubleStartX, doubleEndX), Math.min(doubleStartY,doubleEndY), Math.abs(doubleStartX-doubleEndX), Math.abs(doubleStartY-doubleEndY))
                        && !selectedShapeArray.contains(shape))
                    selectedShapes.put(shape);

                found = true;
                int x = selectedShapeArray.size();
                System.out.printf("Length of selected list = %d", x );
            }

            if (startX >= startX && endX <= endX && startY >= startY && endY <= endY && !selectedShapeArray.contains(shape)) {
                selectedShapes.put(shape);
                found = true;
                int x = selectedShapeArray.size();
                System.out.printf("Length of selected list =  %d", x );
            }
        }

        return found;
    }

}

//public void mousePressed(MouseEvent e) {
//    if ((_buttonNumber == 0) || (isSelected)) {
//        for(int i=0; i<_storedShapes.size(); i++) {
//            _storedShapes.elementAt(i).contains(e.getPoint());
//            _storedShapes.elementAt(i).setBorderWidth(10);
//            _storedShapes.elementAt(i).setBorderColor(Color.BLACK);
//            isSelected = true;
//        }
//    }
//    else {
//        isSelected = false;