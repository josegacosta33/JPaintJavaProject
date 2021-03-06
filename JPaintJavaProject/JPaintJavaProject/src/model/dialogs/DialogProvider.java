package model.dialogs;

import model.ShapeColor;
import model.ShapeShading;
import model.ShapeType;
import model.StartAndEndPoint;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IDialogChoice;

public class DialogProvider implements IDialogProvider {
    private final IDialogChoice<ShapeType> chooseShapeDialog;
    private final IDialogChoice<ShapeColor> choosePrimaryColorDialog;
    private final IDialogChoice<ShapeColor> chooseSecondaryColorDialog;
    private final IDialogChoice<ShapeShading> chooseShadingTypeDialog;
    private final IDialogChoice<StartAndEndPoint> chooseStartAndEndPointModeDialog;
    private final IApplicationState applicationState;

    public DialogProvider(IApplicationState applicationState) {
        this.applicationState = applicationState;
        chooseShapeDialog = new ChooseShapeDialog(this.applicationState);
        choosePrimaryColorDialog = new ChoosePrimaryColorDialog(this.applicationState);
        chooseSecondaryColorDialog = new ChooseSecondaryColorDialog(this.applicationState);
        chooseShadingTypeDialog = new ChooseShadingTypeDialog(this.applicationState);
        chooseStartAndEndPointModeDialog = new ChooseStartAndEndPointModeDialog(this.applicationState);
    }

    @Override
    public IDialogChoice<ShapeType> getChooseShapeDialog() {
        return chooseShapeDialog;
    }

    @Override
    public IDialogChoice<ShapeColor> getChoosePrimaryColorDialog() {
        return choosePrimaryColorDialog;
    }

    @Override
    public IDialogChoice<ShapeColor> getChooseSecondaryColorDialog() {
        return chooseSecondaryColorDialog;
    }

    @Override
    public IDialogChoice<ShapeShading> getChooseShadingTypeDialog() {
        return chooseShadingTypeDialog;
    }

    @Override
    public IDialogChoice<StartAndEndPoint> getChooseStartAndEndPointModeDialog() {
        return chooseStartAndEndPointModeDialog;
    }
}
