package controller;

import draw.commands.CommandsHistory;
import model.Copier;
import model.Delete;
import model.Paste;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;


public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY,() -> Copier.Copy());
        uiModule.addEvent(EventName.PASTE ,() -> {
            new Paste().copyShapes();
        });
        uiModule.addEvent(EventName.UNDO,()-> CommandsHistory.undo());
        uiModule.addEvent(EventName.DELETE,()->new Delete().DeleteShapes());
        uiModule.addEvent(EventName.REDO,() -> CommandsHistory.redo());
    }


}
