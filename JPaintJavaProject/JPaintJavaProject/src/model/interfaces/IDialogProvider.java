package model.interfaces;

import model.ShapeColor;
import model.ShapeShading;
import model.ShapeType;
import model.StartAndEndPoint;
import view.interfaces.IDialogChoice;

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ShapeColor> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColor> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShading> getChooseShadingTypeDialog();

    IDialogChoice<StartAndEndPoint> getChooseStartAndEndPointModeDialog();
}
