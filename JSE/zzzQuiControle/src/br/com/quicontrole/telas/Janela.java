package br.com.quicontrole.telas;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import br.com.quicontrole.conexao.Conexao;
import br.com.quicontrole.telas.componentes.Cor;

public class Janela extends JFrame {
	private static final long serialVersionUID = 3890079497513055057L;

	public Janela() {
		super("QuiControle");
		this.setBackground(Cor.AZUL_FUNDO);
		this.getContentPane().setBackground(Cor.AZUL_FUNDO);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		String so = System.getProperty("os.name");
		
		if (so.contains("Windows")) {
			this.setSize((int)d.getWidth(), (int)d.getHeight());
			
		} else if (so.contains("Ubunto")){
			this.setSize((int)(d.getWidth() - d.getWidth()/25),
					(int) (d.getHeight() - d.getHeight()/50));
			
		} else {
			this.setSize(950, 650);
		}
		

		addComponente(0, 0, 1, 1, 1, 1, this, new PainelPincipal(), 0, 0, 0, 0);

		
		this.setUndecorated(true);		
		this.setLocationRelativeTo(null);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Conexao.desligarBandoDados();
			}
		});
	}

	// ================================================================================

	public static void addComponente(int linha, int coluna, int celulasLargura, int celulasAltura, double largura,
			double altura, Container container, Component component, int topo, int esquerda, int baixo, int direita) {
		GridBagConstraints gbc = new GridBagConstraints(coluna, linha, celulasLargura, celulasAltura, largura, altura,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(topo, esquerda, baixo, direita), 0, 0);
		container.add(component, gbc);
	}

	public static void addComponente(int linha, int coluna, int celulasLargura, int celulasAltura, double largura,
			double altura, Container container, Component component, int topo, int esquerda, int baixo, int direita,
			int lagurapx, int alturapx) {
		GridBagConstraints gbc = new GridBagConstraints(coluna, linha, celulasLargura, celulasAltura, largura, altura,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(topo, esquerda, baixo, direita),
				lagurapx, alturapx);
		container.add(component, gbc);
	}

	private static final Insets insets = new Insets(1, 1, 1, 1);

	public static void addComponente(int linha, int coluna, int celulasLargura, int celulasAltura, double largura,
			double altura, Container container, Component component) {
		GridBagConstraints gbc = new GridBagConstraints(coluna, linha, celulasLargura, celulasAltura, largura, altura,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		container.add(component, gbc);
	}

	public static void addComponente(int linha, int coluna, int celulasLargura, int celulasAltura, double largura,
			double altura, Container container, Component component, int lagurapx, int alturapx) {
		GridBagConstraints gbc = new GridBagConstraints(coluna, linha, celulasLargura, celulasAltura, largura, altura,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, lagurapx, alturapx);
		container.add(component, gbc);
	}

	private static final Insets insets10 = new Insets(10, 10, 10, 10);

	public static void addComponente10(int linha, int coluna, int celulasLargura, int celulasAltura, double largura,
			double altura, Container container, Component component) {
		GridBagConstraints gbc = new GridBagConstraints(coluna, linha, celulasLargura, celulasAltura, largura, altura,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets10, 0, 0);
		container.add(component, gbc);
	}

}
