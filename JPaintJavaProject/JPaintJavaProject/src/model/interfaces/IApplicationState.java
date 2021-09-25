package model.interfaces;

import model.ShapeColor;
import model.ShapeShading;
import model.ShapeType;
import model.StartAndEndPoint;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShading getActiveShapeShadingType();

    StartAndEndPoint getActiveStartAndEndPointMode();
}
