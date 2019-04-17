package br.com.quicontrole.telas.compra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import br.com.quicontrole.telas.componentes.Cor;

public class CaixaImagem extends JLabel {
	private static final long serialVersionUID = 8866272791025546142L;
	
	private BufferedImage imagem;
	
	public CaixaImagem() {
		super();
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.BOTTOM);
		this.setOpaque(true);
		this.setForeground(Color.BLACK);
		this.setBackground(Cor.AZUL_FUNDO);
		imagem= new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB);
		Graphics g = imagem.createGraphics();
		g.fillRect( 0, 0, 160, 160 );
		g.setColor( Color.WHITE );

	}
	
	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}
	
	//====================================================
	
	
	@Override
	public void paintComponent(Graphics p) {
	    super.paintComponent(p);
	    @SuppressWarnings("unused")
		Graphics2D g2 = (Graphics2D) p;
	    p.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight() , this);
	}

}
