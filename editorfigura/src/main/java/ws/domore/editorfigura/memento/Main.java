package ws.domore.editorfigura.memento;

public class Main {
	
public static void main(String[] args) {
	
		Originator o = new Originator();
		CareTaker ct = new CareTaker(o);
		
		ct.saveState();
		o.apagarlinha();
		o.voltar();
		ct.saveState();
		ct.undo();
		ct.undo();
	
	}


}
