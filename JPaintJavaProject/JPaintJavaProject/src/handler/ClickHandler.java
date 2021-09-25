package handler;

import draw.commands.CommandsHandler;

import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClickHandler extends MouseAdapter {
    ApplicationState state;
    IGuiWindow Window;
    int StartX = 0;
    int StartY = 0;
    int EndX = 0;
    int EndY = 0;


    public ClickHandler(ApplicationState state, IGuiWindow window) {
        this.state = state;
        this.Window = window;
    }

    @Override
    public void mousePressed(MouseEvent g) {
        StartX = g.getX();
        StartY = g.getY();
        System.out.printf("X and Y: %d %d START ", StartX, StartY );
    }

    @Override
    public void mouseReleased(MouseEvent g) {
        EndX = g.getX();
        EndY = g.getY();
        System.out.printf("X and Y: %d %d END", EndX, EndY );
        CommandsHandler cmd = new CommandsHandler(StartX, StartY, EndX, EndY, state, Window);
    }


}
//	public Void answer(InvocationOnMock invocation) {
//		clickHandler = (ClickHandler) invocation.getArguments()[0];
//		return null;
//}
//		}).when(explanationView).addEntryPlayButtonHandler(any(ClickHandler.class));
//
//// when
//			testObj.init();
//			testObj.processEntry(entry);
//			clickHandler.onClick(null);