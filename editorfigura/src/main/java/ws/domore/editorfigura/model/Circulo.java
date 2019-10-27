package ws.domore.editorfigura.model;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Circulo extends AbstractFigura implements Figura {

	public Circulo(Integer x, Integer y) {
		super(new Ellipse2D.Double(x, y, 10, 10));
	}

}
