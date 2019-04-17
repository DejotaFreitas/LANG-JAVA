package br.com.quicontrole.telas.componentes;

import java.awt.Font;

import javax.swing.JCheckBox;

public class CaixaMarcar extends JCheckBox{
	private static final long serialVersionUID = 9139266887188804376L;

		
	public CaixaMarcar(String texto) {
		super(texto);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setOpaque(true);
		this.setBackground(Cor.AZUL_FUNDO);
	
	}
	

}
