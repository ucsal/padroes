package ws.domore.editorfigura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ws.domore.editorfigura.enums.EnumFigura;
import ws.domore.editorfigura.factory.FactoryFigura;
import ws.domore.editorfigura.model.Figura;
import ws.domore.editorfigura.model.Quadrado;
import ws.domore.editorfigura.model.Triangulo;
import ws.domore.manager.Constantes;

/**
 *
 * @author mariojp
 */
public class Editor extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String QUADRADO = Constantes.getProp("figura.quadrado");
	private static final String TRIANGULO = Constantes.getProp("figura.triangulo");
	private static final String CIRCULO = Constantes.getProp("figura.circulo");
	
	private static final String VOLTAR = Constantes.getProp("botao.voltar");
	private static final String APAGAR = Constantes.getProp("botao.apagar");
	
	private static final String FIGURAS = Constantes.getProp("titulo.figura");

	
	private JButton botaoQuadrado = new JButton(QUADRADO);
	private JButton botaoCirculo = new JButton(CIRCULO);
	private JButton botaoTriangulo = new JButton(TRIANGULO);
	private JButton botaoLimparUltimoDesenho = new JButton(VOLTAR);
	private JButton botaoApagar = new JButton(APAGAR);


	private EnumFigura selecionado = null;

	private List<Figura> figuras = new ArrayList<Figura>();

	private FactoryFigura factoryFigura = new FactoryFigura();

	// Criando um JPanel com layoutManager null
	private JPanel painel = new MeuPanel(null, figuras);

	public Editor() {
		// ITTULO DA JANELA
		setTitle(FIGURAS);

		// Interface
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridLayout(5, 1));
		botoes.add(botaoQuadrado);
		botoes.add(botaoCirculo);
		botoes.add(botaoTriangulo);
		botoes.add(botaoLimparUltimoDesenho);
		botoes.add(botaoApagar);

		JPanel lateral = new JPanel();
		lateral.add(botoes);

		// Painel lateral
		this.add(BorderLayout.WEST, lateral);
		// centro

		painel.setBackground(Color.WHITE);
		this.add(BorderLayout.CENTER, painel);

		// ACOES
		botaoCirculo.addActionListener(this);
		botaoQuadrado.addActionListener(this);
		botaoTriangulo.addActionListener(this);
		botaoApagar.addActionListener(this);
		botaoLimparUltimoDesenho.addActionListener(this);

		painel.addMouseListener(this);

		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);

		setLocationRelativeTo(null);

		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		if (botao.getText().contains(QUADRADO)) {
			selecionado = EnumFigura.QUADRADO;
		}
		if (botao.getText().contains(CIRCULO)) {
			selecionado = EnumFigura.CIRCULO;
		}
		if (botao.getText().contains(TRIANGULO)) {
			selecionado = EnumFigura.TRIANGULO;
		}
		if (botao.getText().contains(APAGAR)) {
			figuras.clear();
			selecionado = null;
		}
		if (botao.getText().contains(VOLTAR)) {
			selecionado = null;
			if (!figuras.isEmpty()) {
				figuras.remove(figuras.size()-1);
			}
		}
		
		this.painel.updateUI();

	}



	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		figuras.add(factoryFigura.getFigura(x, y, selecionado));

		this.painel.updateUI();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}