package main;

import controller.IJPaintController;
import controller.JPaintController;
import handler.ClickHandler;
import model.Shape;
import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import model.BackgroundShapes;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class Main {

    public static void main(String[] args) {

        GuiWindow window = new GuiWindow(new PaintCanvas());
        IUiModule uiModule = new Gui(window);
        ApplicationState state = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, state);
        controller.setup();


        window.addMouseListener  (new ClickHandler(state, window));


        Shape clearback = new Shape (3,59,1300,800, state, window);
        clearback.setShapeType (ShapeType.RECTANGLE);
        clearback.setPrimaryColor (ShapeColor.WHITE);
        BackgroundShapes backShapeList = BackgroundShapes.getSelectedShapes();
        backShapeList.put(clearback);

    }
}

