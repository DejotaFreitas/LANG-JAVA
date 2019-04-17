package br.com.quicontrole.telas.componentes;

import java.awt.Font;

import javax.swing.JButton;

public class Botao extends JButton{
	private static final long serialVersionUID = 5543664891735551366L;

	public Botao(String texto) {
		super(texto);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		//this.setBackground(Cor.AZUL_FUNDO);
		//this.setForeground(Color.WHITE);
	}
	

}
