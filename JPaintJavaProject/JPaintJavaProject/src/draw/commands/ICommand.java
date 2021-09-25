package draw.commands;

public interface ICommand {

    void undo();

    void redo();
}