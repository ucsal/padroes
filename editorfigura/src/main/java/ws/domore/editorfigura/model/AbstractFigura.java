package ws.domore.editorfigura.model;

import java.awt.Color;
import java.awt.Shape;

public class AbstractFigura implements Figura {
	
	
	private Shape shape; 
		
	private Color corLinha;
	private Color corPreenchiento;
	
	public AbstractFigura(Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public Double getAltura() {
		return this.shape.getBounds().getHeight();
	}
	
	@Override
	public Double getLargura() {
		return this.shape.getBounds().getHeight();
	}
	
	@Override
	public void setSize(Integer largura, Integer altura) {
		this.shape.getBounds().setSize(largura, altura);
	}


	@Override
	public Double getX() {
		return shape.getBounds().getX();
	}
	
	@Override
	public Double getY() {
		return shape.getBounds().getY();
	}
	
	@Override
	public void setLocation(Integer x,Integer y) {
		shape.getBounds().setLocation(x, y);
	}

	
	@Override
	public Color getCorLinha() {
		return corLinha;
	}
	@Override
	public void setCorLinha(Color corLinha) {
		this.corLinha = corLinha;
	}
	@Override
	public Color getCorPreenchiento() {
		return corPreenchiento;
	}
	@Override
	public void setCorPreenchiento(Color corPreenchiento) {
		this.corPreenchiento = corPreenchiento;
	}

	@Override
	public Shape getShape() {
		return this.shape;
	}


}
