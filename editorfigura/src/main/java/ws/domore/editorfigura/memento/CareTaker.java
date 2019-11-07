package ws.domore.editorfigura.memento;

import java.util.Stack;

public class CareTaker {
	//Armazenador
	private Stack<Memento> estados = new Stack<Memento>();
	
	private Originator originator;
	
	public CareTaker(Originator o) {
		this.originator = o;
	}
	//Salvando o estado
    public void saveState() {
    	estados.push(originator.createMemento());
    }
    
    //Restaurando estado
    public void undo() {
    	originator.setMemento(estados.pop());
    }
}
