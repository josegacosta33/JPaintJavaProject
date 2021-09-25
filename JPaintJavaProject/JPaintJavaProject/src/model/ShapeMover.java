package model;

import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;

import java.util.ArrayList;

/*
 *Implements the move functionality on shapes
 */
public class ShapeMover {

    private ArrayList<Shape> selectedlist;
    private int EndX;
    private int EndY;
    private int startX;
    private int startY;
    private int EndXShape;
    private int EndYShape;
    private int X;
    private int Y;
    Drawer drawer;

    public ShapeMover(int StartX, int StartY, int EndX, int EndY, ApplicationState state, IGuiWindow Window) {
        //gets the actively selected shapes
        SelectedShapes selectedShapes = SelectedShapes.getSelectedShapeList();
        selectedlist = selectedShapes.getArray();
        this.EndX = EndX;
        this.EndY = EndY;
        drawer = new Drawer();

        MoveShapes();
    }

    //method that moves the shapes to given coordinates
    public void MoveShapes() {
        for (Shape shape :selectedlist) {
            //get the current position of shape
            startX = shape.getStartPointX();
            startY = shape.getStartPointY();
            EndXShape = shape.getEndPointX();
            EndYShape = shape.getEndPointY();

            //find the change i
            X = (EndXShape-startX);
            Y = (EndYShape-startY);

            //move the shape with the gotten delat
            shape.setStartPointX( Math.abs(EndX) );
            shape.setStartPointY( Math.abs(EndY) ) ;
            shape.setEndPointX(EndX+X);
            shape.setEndPointY(EndY+Y);
        }
        drawer.DrawShapes();
    }


}

//public void keyPressed(KeyEvent e) {
//    int keyCode = e.getKeyCode();
//    if(keyCode == KeyEvent.VK_DOWN) {
//        paddle.yVelocity = -4;
//        System.out.println(paddle.yVelocity);
//    }
//    if(keyCode == KeyEvent.VK_UP) {
//        paddle.yVelocity = 4;
//    }
//    if(keyCode == KeyEvent.VK_RIGHT) {
//        paddle.xVelocity = 4;
//    }
//    if(keyCode == KeyEvent.VK_LEFT) {
//        paddle.xVelocity = -4;
//    }
//}