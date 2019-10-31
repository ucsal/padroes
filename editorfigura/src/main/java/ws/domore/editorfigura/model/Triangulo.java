package ws.domore.editorfigura.model;

import java.awt.geom.Path2D;

public class Triangulo extends AbstractFigura implements Figura {

	public Triangulo(Integer x, Integer y) {
		super(new TriangleShape(x,y));
	}

}

class TriangleShape extends Path2D.Double {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TriangleShape(Integer x, Integer y) {
		moveTo(x, y);
		lineTo(x, y+10);
		lineTo(x+10, y+10);
		closePath();
	}
}