package br.com.quicontrole.telas.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class CaixaImagem extends JLabel implements MouseListener {
	private static final long serialVersionUID = 8866272791025546142L;

	public CaixaImagem(String texto) {
		super(texto);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setOpaque(true);
		this.setBackground(new Color(255, 255, 255));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.setBackground(new Color(200, 200, 250));

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(new Color(200, 200, 250));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(new Color(255, 255, 255));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setBackground(new Color(56, 176, 222));

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.setBackground(new Color(255, 255, 255));

	}
	
}
