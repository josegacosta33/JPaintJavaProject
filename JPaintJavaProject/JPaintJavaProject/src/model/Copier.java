package model;

import java.util.ArrayList;
/*
 *Class to implement the copy functionality
 */
public class Copier {

    private static SelectedShapes selectedShapes;
     private static ArrayList<Shape> selectedItems;
    private static CopiedShapes copiedShapes;
    private static ArrayList<Shape> copyList;

    //method to facilitate coopying
    public static void Copy() {
        //get the lists from the instances
        selectedShapes = SelectedShapes.getSelectedShapeList();
        copiedShapes = CopiedShapes.getSelectedShapes();
        selectedItems = selectedShapes.getArray();
        copyList = copiedShapes.getArray();

        //set selected items to the copied items list
        copyList = selectedItems;

        //change the list of copied items to the new one
        copiedShapes.changeArray(copyList);

        //coyplist.clear()
    }
}
