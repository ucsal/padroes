package ws.domore.editorfigura.memento;

import ws.domore.editorfigura.Editor;

public class Originator {
	
	private String state = Editor.getVoltar();

	
	public Memento createMemento() {
		System.out.println("Salvou estado = " + state);
        return new Memento(state);
	}

	public void setMemento(Memento m) {
		System.out.println("Recumperou estado = " + m.getState());
		this.state = m.getState();
	}
    //exemplos de ações do botão voltar
	public void apagarlinha() {
		this.state = "Linha apagada";
	}
	
	public void voltar() {
		this.state = "Voltando paara o estado anterior. ";
	}

	
}
