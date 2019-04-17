package br.com.quicontrole.telas.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class CampoTexto extends JTextField{
	private static final long serialVersionUID = 4580457455612586104L;

	private String placeholder;
	
	public CampoTexto() {
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JTextField.CENTER);
	}
	
	public CampoTexto(String placeholder) {
		this.placeholder = placeholder;
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JTextField.CENTER);		
	}
	
	public CampoTexto(String placeholder, int tamanho) {
		this.placeholder = placeholder;
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JTextField.CENTER);
		
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {				
				if(getText().length() >= tamanho){
					evt.consume();	
				}}});
	}
	
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
	@Override
	protected void paintComponent(final Graphics p) {
		super.paintComponent(p);
		
		if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
			return;
		}
		Graphics2D g = (Graphics2D) p;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString(placeholder, this.getInsets().left, p.getFontMetrics().getMaxAscent() + getInsets().top);
	}
	

}
