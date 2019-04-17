package br.com.quicontrole.telas.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class CampoTextoNumeroInteiro extends JFormattedTextField implements KeyListener{
	private static final long serialVersionUID = 6241624445093000352L;
	
	private String placeholder;
	private int tamanho = 10;

	public CampoTextoNumeroInteiro(String placeholder) {
		this.placeholder = placeholder;
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JTextField.CENTER);
		addKeyListener(this);

	}

	public CampoTextoNumeroInteiro(String placeholder, int tamanho) {
		this.placeholder = placeholder;
		this.tamanho = tamanho;
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JTextField.CENTER);
		addKeyListener(this);

	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getTextNumeroInteiro() {
		return Integer.parseInt(getText());
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	@Override
	protected void paintComponent(final Graphics pG) {
		super.paintComponent(pG);

		if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
			return;
		}
		Graphics2D g = (Graphics2D) pG;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString(placeholder, getInsets().left, pG.getFontMetrics().getMaxAscent() + getInsets().top);
	}


	@Override
	public void keyTyped(KeyEvent evt) {		
		if (getText().length() < tamanho) {
			String caracteres2 = "1234567890";
			if (!caracteres2.contains(evt.getKeyChar() + ""))
				evt.consume();
		} else {
			evt.consume();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

}
