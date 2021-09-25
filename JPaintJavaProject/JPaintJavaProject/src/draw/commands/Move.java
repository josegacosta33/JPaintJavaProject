package draw.commands;

import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;
import model.ShapeMover;

public class Move {

    public Move(int StartX, int StartY, int EndX, int EndY, IGuiWindow window, ApplicationState State) {
        ShapeMover item = new ShapeMover(StartX, StartY, EndX, EndY, State, window);
    }

}