package br.com.quicontrole.telas.venda;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JLabel;

import br.com.quicontrole.entidades.Produto;
import br.com.quicontrole.telas.componentes.Cor;

public class CaixaProduto extends JLabel implements MouseListener{
	private static final long serialVersionUID = 8866272791025546142L;
	
	private Produto produto;
	private Image imagem;
	private final Color corFundo = new Color(255, 255, 255);
	private final Color corPassarMouse = Cor.AZUL_FUNDO;
	private final Color corClicar = new Color(200,200,250);
	private final Color corFonte = new Color(0, 0, 0);
	private final Color corFontePassarMause = new Color(255, 255, 255);
	
	public CaixaProduto(Produto produto) {		
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		this.setHorizontalAlignment(JLabel.LEFT);
		this.setVerticalAlignment(JLabel.BOTTOM);
		this.setOpaque(true);
		this.revalidate();
		this.setBackground(corFundo);
		this.setForeground(corFonte);
		addMouseListener(this);
		this.produto = produto;		
		imagem = produto.getImage();
		String nomeProdruto =  produto.getNome();
		String fornecedor = (produto.getFornecedor()!=null?produto.getFornecedor().getNome():"");
		String valorVenda = "R$ "+ formatarPreco(produto.getValor_venda());
		this.setText("<html>"+ nomeProdruto + "<br>" + fornecedor  + "<br>" + valorVenda + "</html>");				
			
	}
	
	private String formatarPreco(BigDecimal valor) {
		DecimalFormat formato = new DecimalFormat("0.00");
		formato.setRoundingMode(RoundingMode.FLOOR);
		return  formato.format(valor);
	}
	
	public CaixaProduto(String texto) {
		super(texto);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.BOTTOM);
		this.setOpaque(true);
		this.setBackground(corFundo);
		this.setForeground(corFonte);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
			addListaVenda();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(corPassarMouse);
		this.setForeground(corFontePassarMause);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(corFundo);
		this.setForeground(corFonte);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setBackground(corClicar);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.setBackground(corFundo);
		this.setForeground(corFonte);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	//================================================
	
	public void addListaVenda(){
		if(this.produto!=null){
			ListaVenda.addProdutoListaVenda(this.produto);
		}
			

	}
	
	@Override
	public void paintComponent(Graphics p) {
	    super.paintComponent(p);
	    @SuppressWarnings("unused")
		Graphics2D g2 = (Graphics2D) p;
	    p.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight()-52 , this);
	 //   if(this.produto!=null)
	 //   p.drawString(this.produto.getQuantidade().toString(), 5, 15);
	}
}
