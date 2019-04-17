package br.com.quicontrole.telas.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class CampoTextoNumeroFlutuante extends JFormattedTextField implements KeyListener {
	private static final long serialVersionUID = -325342519276157288L;

	private String placeholder;
	private int tamanho;
	private String texto;

	public CampoTextoNumeroFlutuante(String placeholder, int tamanho) {
		this.placeholder = placeholder;
		this.setTamanho(tamanho);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JTextField.CENTER);
		addKeyListener(this);

	}
	
	public CampoTextoNumeroFlutuante(String placeholder, int tamanho, int largura, int altura) {
		this.placeholder = placeholder;
		this.setTamanho(tamanho);
		this.setMinimumSize(new Dimension(largura, altura));	
		this.setMaximumSize(new Dimension(largura, altura));
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JTextField.CENTER);
		addKeyListener(this);

	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
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
	public void keyTyped(KeyEvent e) {

		texto = getText();

		String textTemp = texto.replace(",", "");

		if (getText().indexOf(",") == -1 && textTemp.length() < this.tamanho && textTemp.length() > 0) {
			if (!"1234567890,".contains(e.getKeyChar() + ""))
				e.consume();

		} else if (getText().indexOf(",") == -1 && textTemp.length() < this.tamanho) {
			if (!"1234567890".contains(e.getKeyChar() + ""))
				e.consume();

		} else if (getText().indexOf(",") > -1 && textTemp.length() < this.tamanho) {
			if (!"1234567890".contains(e.getKeyChar() + ""))
				e.consume();

		} else if (getText().indexOf(",") == -1 && textTemp.length() == this.tamanho) {
			if (!",".contains(e.getKeyChar() + ""))
				e.consume();

		} else {
			e.consume();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (getText().indexOf(",") > -1) {
			String temp = this.getText();
			String depoisVirgula = temp.substring(temp.indexOf(","), temp.length() - 1);
			if (depoisVirgula.length() > 2) {
				setText(texto);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (getText().indexOf(",") > -1) {
			String temp = this.getText();
			String depoisVirgula = temp.substring(temp.indexOf(","), temp.length() - 1);
			if (depoisVirgula.length() > 2) {
				setText(texto);
			}
		}

	}

}
