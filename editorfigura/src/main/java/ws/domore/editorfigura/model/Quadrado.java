package ws.domore.editorfigura.model;

import java.awt.geom.Rectangle2D;

public class Quadrado extends AbstractFigura implements Figura {

	public Quadrado(Integer x, Integer y) {
		super(new Rectangle2D.Double(x, y, 10, 10) );
	}

}
