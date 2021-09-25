package model.dialogs;

import model.StartAndEndPoint;
import model.interfaces.IApplicationState;
import view.interfaces.IDialogChoice;

public class ChooseStartAndEndPointModeDialog implements IDialogChoice<StartAndEndPoint> {
    private final IApplicationState applicationState;

    public ChooseStartAndEndPointModeDialog(IApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Start and End Point Mode";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public StartAndEndPoint[] getDialogOptions() {
        return StartAndEndPoint.values();
    }

    @Override
    public StartAndEndPoint getCurrentSelection() {
        return applicationState.getActiveStartAndEndPointMode();
    }
}
