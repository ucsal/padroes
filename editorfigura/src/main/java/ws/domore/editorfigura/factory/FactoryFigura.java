package ws.domore.editorfigura.factory;

import ws.domore.editorfigura.model.AbstractFigura;
import ws.domore.editorfigura.model.Circulo;
import ws.domore.editorfigura.model.Quadrado;
import ws.domore.editorfigura.model.Triangulo;

public class FactoryFigura {
    public AbstractFigura getFigura(Integer x, Integer y, String figura) {
        if (figura.equals("TRIANGULO")) {
            return new Triangulo(x, y);
        }
        if (figura.equals("QUADRADO")) {
            return new Quadrado(x, y);
        }
        if (figura.equals("CIRCULO")) {
            return new Circulo(x, y);
        }

        return null;
    }
}
