package model;


import draw.commands.CommandsHistory;

import model.persistence.*;
import view.interfaces.IGuiWindow;

import java.util.ArrayList;

/**
 * Implements the paste functionality
 */
public class Paste {

    private ShapeColor primarycolor;
    private ShapeColor secondarycolor;
    private ShapeShading shading;
    private IGuiWindow window;
    private ApplicationState state;
    private Shapes mainList;
    private CopiedShapes copyList;
    private ArrayList<Shape> shapelist;
    private Drawer pasteDraw;
    private RecoverPaste recoverList;
    private int StartX; private int StartY;
    private int EndX; private int EndY;
    private int Width; private int Height;


    //gets info of the shape to be copied
    private void getInfo(Shape shape) {
        //get coordinates
        StartX =  shape.getStartPointX();
        StartY = shape.getStartPointY();
        EndX =  shape.getEndPointX();
        EndY = shape.getEndPointY();
        window = shape.getGUIwindow();
        //get shape details
        primarycolor = shape.getPrimaryColor();
        secondarycolor = shape.getSecondaryColor();

        shading = shape.getShading();
        state = shape.getState();
    }

    //copies the shapes in the copied shapes list
    //then duplicates the shapes
    public void copyShapes() {
        mainList = Shapes.getShapes();
        copyList = CopiedShapes.getSelectedShapes();
        shapelist = mainList.getArray();
        ArrayList<Shape> copylist = copyList.getArray();

        pasteDraw = new Drawer();
        recoverList = RecoverPaste.getSelectedShapeList();

        //copy all shapes in list
        for (Shape shape : copylist) {
             getInfo(shape);
            Shape copy = new Shape(StartX, StartY, EndX, EndY, state, window);
            int startX = shape.getStartPointX();
            int endX = shape.getEndPointX();
            copy.setStartPointX(startX + 50);
            copy.setEndPointX(endX + 50);
            //add shape to main shapes
            mainList.put(copy);

            recoverList.put(copy);
            CommandsHistory.put(recoverList);
        }
         DrawShape();
    }

    //activate drawer
    public void DrawShape() { pasteDraw.DrawShapes(); }
}