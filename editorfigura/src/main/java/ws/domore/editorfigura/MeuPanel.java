package ws.domore.editorfigura;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.util.Collection;

import javax.swing.JPanel;

class MeuPanel extends JPanel {

    private Collection<Shape> figuras;

    private static final long serialVersionUID = 1L;

    public MeuPanel(LayoutManager layoutManager, Collection<Shape> figuras) {
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
