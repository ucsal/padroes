package ws.domore.editorfigura.memento;

import ws.domore.editorfigura.model.Figura;

import java.util.ArrayList;
import java.util.List;

public class Originator {
	
	private List<Figura> state = new ArrayList<>();

	public void setState(List<Figura> state) {
		this.state = new ArrayList<>(state);
	}

	public Memento save() {
        return new Memento(state);
	}

	public void restore(Memento m) {
		this.state = new ArrayList<>(m.getState());
	}

	public List<Figura> getLatestState() {
		return this.state;
	}
}
