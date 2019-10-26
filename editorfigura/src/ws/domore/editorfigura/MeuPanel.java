package ws.domore.editorfigura;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

class MeuPanel extends JPanel {

    private Set<Shape> figuras;

    private static final long serialVersionUID = 1L;

    public MeuPanel(LayoutManager layoutManager, Set<Shape> figuras) {
        super(layoutManager,true);
        this.figuras = figuras;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape f : figuras) {
            g2d.draw(f);
        }
    }
}