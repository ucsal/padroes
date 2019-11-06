package ws.domore.editorfigura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.Collection;

import javax.swing.JPanel;

import ws.domore.editorfigura.model.Figura;

class MeuPanel extends JPanel {

	private Collection<Figura> figuras;

	public static Color corAtual;

	private static final long serialVersionUID = 1L;

	public MeuPanel(LayoutManager layoutManager, Collection<Figura> figuras) {
		super(layoutManager, true);
		this.figuras = figuras;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for (Figura f : figuras) {
			g2d.setColor(corAtual);
			g2d.draw(f.getShape());
		}
	}

}
