package br.com.quicontrole.telas.componentes;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Painel extends JPanel{
	private static final long serialVersionUID = 2963399436674571751L;

	public Painel() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Cor.AZUL_FUNDO);
		validate();
	}

}
