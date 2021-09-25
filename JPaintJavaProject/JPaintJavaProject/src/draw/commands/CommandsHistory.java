package draw.commands;

import java.util.Stack;

public class CommandsHistory {
	private static Stack<ICommand> undo = new Stack<ICommand>();
	private static Stack<ICommand> redo = new Stack<ICommand>();

	public static void put(ICommand cmd) {
		undo.push(cmd);
		redo.clear();
	}
	public static boolean redo() {
		boolean res = !redo.empty();
		if (res) {
			ICommand c = redo.pop();
			undo.push(c);
			c.redo();
		}
		return res;
	}
	public static boolean undo() {
		boolean res = !undo.empty();
		if (res) {
			ICommand c = undo.pop();
			redo.push(c);
			c.undo();
		}
		return res;
	}



}
