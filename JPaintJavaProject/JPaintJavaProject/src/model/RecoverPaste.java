package model;

import java.util.ArrayList;

import draw.commands.ICommand;


public class RecoverPaste implements ICommand {

    private static RecoverPaste instance = null;
    private ArrayList<Shape> shapes;
    private Shapes mainList;
    private Drawer draw;

    private RecoverPaste() {
        shapes = new ArrayList<>();
        mainList = Shapes.getShapes();
        draw = new Drawer();
    }

    public static RecoverPaste getSelectedShapeList() {
        if (instance == null)instance = new RecoverPaste();
        return instance;
    }

    public boolean put(Shape shapetoAdd) {
        shapes.add(shapetoAdd);
        return true;
    }

    public ArrayList getArray() { return shapes;}

    @Override
    public void redo() {
        //put back shapes in main shapes list
        for (Shape add : shapes) {
            mainList.put(add);
        }
        draw.DrawShapes();
        shapes.clear();
    }

    @Override
    public void undo() {
        //remove all shapes from main list
        for (Shape add : shapes) {
            mainList.remove(add);
        }
        draw.DrawShapes();
    }


}