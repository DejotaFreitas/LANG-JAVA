package br.com.quicontrole.telas.cadastro.produto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.quicontrole.Inicializar;
import br.com.quicontrole.telas.componentes.Cor;
import br.com.quicontrole.telas.componentes.ManipularImagem;

public class CaixaImagemProduto extends JLabel implements MouseListener {
	private static final long serialVersionUID = 8866272791025546142L;
	
	private BufferedImage imagem;
	private String diretorio;
	
	public CaixaImagemProduto(String texto) {
		super(texto);
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
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.setForeground(Color.BLACK);
		carregarImagem();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setForeground(Color.WHITE);


	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setForeground(Color.BLACK);


	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setForeground(Color.BLACK);


	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.setForeground(Color.WHITE);


	}
	
	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}
	
	//====================================================
	
	private void carregarImagem() {
		JFileChooser fc = null;
		if(diretorio != null){
			fc = new JFileChooser(diretorio);
		}else{
			fc = new JFileChooser();
		}
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", 
				"bmp","jpg", "jpeg", "png", "gif"));
		int res = fc.showOpenDialog(Inicializar.getJanela());
		try {
			if (res == JFileChooser.APPROVE_OPTION) {
				File arquivo = fc.getSelectedFile();
				diretorio = arquivo.getAbsolutePath();
				setImagem(ManipularImagem.setImagemDimensao(diretorio, 160, 160));
				repaint();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public byte[] converterArrayByte(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {ImageIO.write(imagem, "png", baos);
		} catch (IOException e1) {e1.printStackTrace();	}
		byte[] imagemTemp = baos.toByteArray();
		return imagemTemp;
	}
	
	
	@Override
	public void paintComponent(Graphics p) {
	    super.paintComponent(p);
	    @SuppressWarnings("unused")
		Graphics2D g2 = (Graphics2D) p;
	    p.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight()-20 , this);
	}

}
