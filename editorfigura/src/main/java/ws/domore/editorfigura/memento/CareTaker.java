package ws.domore.editorfigura.memento;

import java.util.Stack;

public class CareTaker {

	private Stack<Memento> states = new Stack<Memento>();

	public void add(Memento m) {
		states.add(m);
	}

	public Memento get() {
		if (states.size() == 0) {
			return null;
		}
		return states.pop();
	}
}
