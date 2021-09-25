package model;

import draw.commands.CommandsHistory;

import java.util.ArrayList;

/**
 * class to implement the deleting
 */
public class Delete {

    private Shapes Shapes2;
    private SelectedShapes selectedShapes;
     private ArrayList<Shape> selectedList;
    private ArrayList<Shape> mainList;
       private Drawer drawer;
    private RecoverDelete recoverDelete2;

    //construct deleting object and get the state
    public Delete() {
        selectedShapes = SelectedShapes.getSelectedShapeList();
        Shapes2 = Shapes.getShapes();
        recoverDelete2 = RecoverDelete.getSelectedShapes();
        selectedList = selectedShapes.getArray();
        mainList = Shapes2.getArray();
        drawer = new Drawer();
    }

    /**
     * method that deletes the shapes
     */
    public void DeleteShapes () {
        //does for all selected items
        selectedList.forEach(item ->{
            mainList.remove(item);
            recoverDelete2.put(item);
            //allow for undo
            CommandsHistory.put(recoverDelete2);
        });

        //change the state of application
       Shapes2.changeArray(mainList);
       selectedList.clear();
       selectedShapes.changeArray(selectedList);
       //redraw with the new lists
       drawer.DrawShapes();
    }


}


