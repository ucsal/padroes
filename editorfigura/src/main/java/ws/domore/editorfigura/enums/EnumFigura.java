package ws.domore.editorfigura.enums;

public enum EnumFigura {
    QUADRADO(1), CIRCULO(2), TRIANGULO(3);

    private final int valor;

    EnumFigura(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }
}
