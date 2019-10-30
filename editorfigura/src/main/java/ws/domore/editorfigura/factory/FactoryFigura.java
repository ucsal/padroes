package ws.domore.editorfigura.factory;

import ws.domore.editorfigura.enums.EnumFigura;
import ws.domore.editorfigura.model.AbstractFigura;
import ws.domore.editorfigura.model.Circulo;
import ws.domore.editorfigura.model.Quadrado;
import ws.domore.editorfigura.model.Triangulo;

public class FactoryFigura {
    public AbstractFigura getFigura(Integer x, Integer y, EnumFigura figura) {
        if (figura.equals(EnumFigura.TRIANGULO)) {
            return new Triangulo(x, y);
        }
        if (figura.equals(EnumFigura.QUADRADO)) {
            return new Quadrado(x, y);
        }
        if (figura.equals(EnumFigura.CIRCULO)) {
            return new Circulo(x, y);
        }

        return null;
    }
}
