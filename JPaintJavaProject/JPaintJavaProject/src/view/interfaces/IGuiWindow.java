package view.interfaces;

import view.EventName;

import javax.swing.*;
import java.awt.event.KeyListener;

public interface IGuiWindow {
    JButton getButton(EventName eventName);

}
