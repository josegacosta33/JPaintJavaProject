package draw.commands;

import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;
import model.SelectedShape;

public class Select {

    private SelectedShape shape1;

    public Select(int StartX, int StartY, int EndX, int EndY, ApplicationState State, IGuiWindow window) {
        shape1 = new SelectedShape(StartX, StartY, EndX, EndY, State, window);
    }


}