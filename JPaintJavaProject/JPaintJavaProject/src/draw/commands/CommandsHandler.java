package draw.commands;


import model.StartAndEndPoint;
import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;


public class CommandsHandler {

    public CommandsHandler(int StartX, int StartY, int EndX, int EndY, ApplicationState as, IGuiWindow window) {
        Create create;
        Select select;
        Move move;
        System.out.printf("CommandsHandler");
        StartAndEndPoint state = as.getActiveStartAndEndPointMode();
        String State = state.toString();
        switch (State) {
            case "DRAW" : System.out.println(State);
                 create = new Create(StartX, StartY, EndX, EndY, as, window);
                 CommandsHistory.put(create);
                 break;

            case "SELECT" : System.out.println(State);
                 select = new Select(StartX, StartY, EndX, EndY, as, window);
                 break;

            case "MOVE" :  System.out.println(State);
                  move = new Move(StartX, StartY, EndX, EndY, window, as);
                  break;
        }

    }

}
//Light light;
//public LightOffCommand(Light light){
//  this.light = light;