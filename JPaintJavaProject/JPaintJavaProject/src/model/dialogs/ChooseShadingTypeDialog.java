package model.dialogs;

import model.ShapeShading;
import model.interfaces.IApplicationState;
import view.interfaces.IDialogChoice;

public class ChooseShadingTypeDialog implements IDialogChoice<ShapeShading> {
    private final IApplicationState applicationState;

    public ChooseShadingTypeDialog(IApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shading Type";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public ShapeShading[] getDialogOptions() {
        return ShapeShading.values();
    }

    @Override
    public ShapeShading getCurrentSelection() {
        return applicationState.getActiveShapeShadingType();
    }
}
