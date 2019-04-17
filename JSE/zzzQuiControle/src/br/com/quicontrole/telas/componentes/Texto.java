package br.com.quicontrole.telas.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Texto extends JLabel {
	private static final long serialVersionUID = 8866272791025546142L;
	
	private String placeholder;
	private int placeholderFontSize = 16;

	public Texto(String texto) {
		super(texto);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JLabel.CENTER);
		// this.setForeground(Color.WHITE);
	}

	public Texto(String texto, int fontSize) {
		super(texto);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, fontSize));
		this.setHorizontalAlignment(JLabel.CENTER);
		// this.setForeground(Color.WHITE);
	}
	
	public Texto(String texto, int fontSize, int largura, int altura) {
		super(texto);
		this.setMinimumSize(new Dimension(largura, altura));
		this.setMaximumSize(new Dimension(largura, altura));
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, fontSize));
		this.setHorizontalAlignment(JLabel.CENTER);
		// this.setForeground(Color.WHITE);
	}
	
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
	public void setPlaceholderFontSize(int placeholderFontSize) {
		this.placeholderFontSize = placeholderFontSize;
	}
	
	@Override
	protected void paintComponent(final Graphics p) {
		super.paintComponent(p);
		
		if (placeholder == null || placeholder.length() == 0) {
			return;
		}
		Graphics2D g = (Graphics2D) p;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		g.drawString(placeholder, 0, this.getHeight());
	}



}
