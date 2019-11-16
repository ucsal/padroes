package ws.domore.editorfigura.memento;

import ws.domore.editorfigura.model.Figura;

import java.util.ArrayList;
import java.util.List;

public class Memento {
	private List<Figura> state;

	public Memento(List<Figura> state) {
		this.state = new ArrayList<>(state);
	}

	public List<Figura> getState() {
		return new ArrayList<>(this.state);
	}
}
