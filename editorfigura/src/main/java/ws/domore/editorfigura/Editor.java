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
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ws.domore.editorfigura.builder.ExportadorBuilder;
import ws.domore.editorfigura.builder.ExportadorCSV;
import ws.domore.editorfigura.builder.ExportadorJSON;
import ws.domore.editorfigura.enums.EnumFigura;
import ws.domore.editorfigura.factory.FactoryFigura;
import ws.domore.editorfigura.memento.CareTaker;
import ws.domore.editorfigura.memento.Memento;
import ws.domore.editorfigura.memento.Originator;
import ws.domore.editorfigura.model.Figura;
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

	static Constantes constantes = new Constantes();

	private static final String QUADRADO = constantes.getProp("figura.quadrado");
	private static final String TRIANGULO = constantes.getProp("figura.triangulo");
	private static final String CIRCULO = constantes.getProp("figura.circulo");

	private static final String VOLTAR = constantes.getProp("botao.voltar");
	private static final String APAGAR = constantes.getProp("botao.apagar");
	private static final String ESCOLHER_COR_BORDA = constantes.getProp("botao.cor.borda.escolher");
	private static final String EXPORTAR_JSON = constantes.getProp("botao.exportarjson");
	private static final String EXPORTAR_CSV = constantes.getProp("botao.exportarcsv");


	private static final String FIGURAS = constantes.getProp("titulo.figura");
	private static final String TITULO_JFRAME_COR_BORDA = constantes.getProp("titulo.jcolorchooser.borda");

	private static final String MESSAGE_FIGURA_NAO_SELECIONADA = constantes.getProp("texto.message.figuranaoselecionada");


	private JButton botaoQuadrado = new JButton(QUADRADO);
	private JButton botaoCirculo = new JButton(CIRCULO);
	private JButton botaoTriangulo = new JButton(TRIANGULO);
	private JButton botaoLimparUltimoDesenho = new JButton(VOLTAR);
	private JButton botaoApagar = new JButton(APAGAR);
	private JButton botaoEscolherCorBorda = new JButton(ESCOLHER_COR_BORDA);
	private JButton botaoExportarCSV = new JButton(EXPORTAR_CSV);
	private JButton botaoExportarJSON = new JButton(EXPORTAR_JSON);

	private EnumFigura selecionado = null;

	private Originator originator = new Originator();
	private CareTaker careTaker = new CareTaker();
	private List<Figura> figuras = new ArrayList<Figura>();

	private FactoryFigura factoryFigura = new FactoryFigura();
	
	private ExportadorBuilder builder;

	// Criando um JPanel com layoutManager null
	private JPanel painel = new MeuPanel(null, figuras);

	public Editor() {
		createWindow();
		buttonActions();
		painel.addMouseListener(this);
		save();
		windowConfigs();
	}

	private void windowConfigs() {
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);

		setLocationRelativeTo(null);

		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	private void buttonActions() {
		// ACOES
		botaoCirculo.addActionListener(this);
		botaoQuadrado.addActionListener(this);
		botaoTriangulo.addActionListener(this);
		botaoApagar.addActionListener(this);
		botaoLimparUltimoDesenho.addActionListener(this);
		botaoEscolherCorBorda.addActionListener(this);
		botaoExportarCSV.addActionListener(this);
		botaoExportarJSON.addActionListener(this);

	}

	private void createWindow() {
		// TITULO DA JANELA
		setTitle(FIGURAS);

		// Interface
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridLayout(5, 1));
		botoes.add(botaoQuadrado);
		botoes.add(botaoCirculo);
		botoes.add(botaoTriangulo);
		botoes.add(botaoLimparUltimoDesenho);
		botoes.add(botaoApagar);
		botoes.add(botaoEscolherCorBorda);
		botoes.add(botaoExportarCSV);
		botoes.add(botaoExportarJSON);

		JPanel lateral = new JPanel();
		lateral.add(botoes);

		// Painel lateral
		this.add(BorderLayout.WEST, lateral);

		// Centro
		painel.setBackground(Color.WHITE);
		this.add(BorderLayout.CENTER, painel);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();

		tipoBotaoSelecionado(botao, QUADRADO, EnumFigura.QUADRADO);
		tipoBotaoSelecionado(botao, CIRCULO, EnumFigura.CIRCULO);
		tipoBotaoSelecionado(botao, TRIANGULO, EnumFigura.TRIANGULO);
		limparTela(botao);
		apagarUltimaFigura(botao);
		escolherCorBorda(botao);
		exportarImagem(botao);
		this.painel.updateUI();
	}
	
	
	
	private void exportarImagem(JButton botao) {
		if (botao.getText().contains(EXPORTAR_JSON)) {
			builder = new ExportadorJSON();
			builder.exportar(figuras);
		}else if(botao.getText().contains(EXPORTAR_CSV)){
			builder = new ExportadorCSV();
			builder.exportar(figuras);
		}
	}

	private void apagarUltimaFigura(JButton botao) {
		if (botao.getText().contains(VOLTAR)) {
			selecionado = null;
			restore();
		}
	}

	private void limparTela(JButton botao) {
		if (botao.getText().contains(APAGAR)) {
			figuras.clear();
			save();
			selecionado = null;
		}
	}

	private void escolherCorBorda(JButton botao) {
		if (botao.getText().contains(ESCOLHER_COR_BORDA)) {
			openColorChooser();
		}
	}

	private void openColorChooser() {

		Color c = JColorChooser.showDialog(this, TITULO_JFRAME_COR_BORDA, Color.BLACK);
		MeuPanel.corAtual = c;

	}

	private void tipoBotaoSelecionado(JButton botao, String figura, EnumFigura figuraEnum) {
		if (botao.getText().contains(figura)) {
			selecionado = figuraEnum;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (selecionado == null) {
			JOptionPane.showMessageDialog(null, MESSAGE_FIGURA_NAO_SELECIONADA);
			return;
		}

		figuras.add(factoryFigura.getFigura(x, y, selecionado));

		save();

		this.painel.updateUI();
	}

	private void save() {
		careTaker.add(originator.save());
		originator.setState(figuras);

	}

	private void restore() {
		Memento m = careTaker.get();

		if (m != null) {
			originator.restore(m);
			List<Figura> latestState = originator.getLatestState();

			if (figuras.isEmpty()) {
				figuras.addAll(latestState);
			} else {
				figuras.retainAll(latestState);
			}

			this.painel.updateUI();
		}
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