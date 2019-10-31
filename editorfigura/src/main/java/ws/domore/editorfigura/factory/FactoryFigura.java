package ws.domore.editorfigura.factory;

import ws.domore.editorfigura.enums.EnumFigura;
import ws.domore.editorfigura.model.AbstractFigura;
import ws.domore.editorfigura.model.Circulo;
import ws.domore.editorfigura.model.Quadrado;
import ws.domore.editorfigura.model.Triangulo;

public class FactoryFigura {


	
    public AbstractFigura getFigura(Integer x, Integer y, EnumFigura figura) {
        switch (figura){
            case TRIANGULO:
                return new Triangulo(x, y);
            case QUADRADO:
                return new Quadrado(x, y);
            case CIRCULO:
                return new Circulo(x, y);
         }
        return null;
    }
}
