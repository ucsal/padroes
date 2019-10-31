package ws.domore.editorfigura.model;

import java.awt.Color;
import java.awt.Shape;

public interface Figura {


	Color getCorLinha();

	void setCorLinha(Color corLinha);

	Color getCorPreenchiento();

	void setCorPreenchiento(Color corPreenchiento);

	Double getAltura();

	Double getLargura();

	void setSize(Integer largura, Integer altura);

	Double getX();

	Double getY();

	void setLocation(Integer x, Integer y);

	Shape getShape();

}