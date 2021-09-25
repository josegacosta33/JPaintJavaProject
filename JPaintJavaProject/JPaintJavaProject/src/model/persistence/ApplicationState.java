package model.persistence;

import model.*;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;
import model.ObservableState;
import model.ObserveState;

import java.util.ArrayList;


public class ApplicationState implements IApplicationState{
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;
    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShading activeShapeShadingType;
    private StartAndEndPoint activeStartAndEndPointMode;
    private ObservableState State;
    private ObserveState Observer;
    private String ShapeChange;
    private String PriColorChange;
    private String SecColorChange;
    private String ShadeChange;
    private SelectedShapes selectedShapes;
    private ArrayList<Shape> selectedShapeArray;


    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
        State = new ObservableState();
        selectedShapes = SelectedShapes.getSelectedShapeList();
        selectedShapeArray = selectedShapes.getArray();
        Obs();
        ShapeChange = "ShapeChange";
        PriColorChange = "PriColorChange";
        SecColorChange = "SecColorChange";
        ShadeChange = "ShadeChange";

    }

    public void Obs() {
        Observer = new ObserveState(State);
        State.addObserver(Observer);
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
        State.uiStateChange(ShapeChange);
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
        State.uiStateChange(PriColorChange);
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
        State.uiStateChange(SecColorChange);

    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
        State.uiStateChange(ShadeChange);

    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShading getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPoint getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }


    private void setDefaults() {
        activeShapeType = ShapeType.Circle;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShading.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPoint.DRAW;
    }
}
