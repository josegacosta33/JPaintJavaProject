package view.interfaces;

import view.EventName;

import java.awt.event.KeyListener;

public interface IUiModule {
    void addEvent(EventName eventName, IEventCallback command);
    <T> T getDialogResponse(IDialogChoice dialogChoice);

}
