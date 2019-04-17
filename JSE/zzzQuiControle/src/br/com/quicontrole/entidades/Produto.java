package br.com.quicontrole.entidades;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Produto {

	private Integer id_produto;
	private String nome;
	private String codigo_barra;
	private BigDecimal valor_compra;
	private BigDecimal valor_venda;
	private String local_estoque;
	private Integer quantidade;
	private String descricao;
	private Boolean desativado;
	private Fornecedor fornecedor;
	private byte[] imagem;

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo_barra() {
		return codigo_barra;
	}

	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
	}


	public BigDecimal getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(BigDecimal valor_compra) {
		this.valor_compra = valor_compra;
	}

	public BigDecimal getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(BigDecimal valor_venda) {
		this.valor_venda = valor_venda;
	}

	public String getLocal_estoque() {
		return local_estoque;
	}

	public void setLocal_estoque(String local_estoque) {
		this.local_estoque = local_estoque;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getDesativado() {
		return desativado;
	}

	public void setDesativado(Boolean desativado) {
		this.desativado = desativado;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return this.getNome();
	}

	public ImageIcon getImageIcon() {
		BufferedImage imagetemp = null;
		if (imagem != null) {
			try {
				imagetemp = ImageIO.read(new ByteArrayInputStream(imagem));
			} catch (IOException e) {	}
			return new ImageIcon(imagetemp);
		}
		return null;
	}
	
	public BufferedImage getImage() {
		BufferedImage imagetemp = null;
		if (imagem != null) {
			try {
				imagetemp = ImageIO.read(new ByteArrayInputStream(imagem));
			} catch (IOException e) {	}
			return imagetemp;
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_produto == null) ? 0 : id_produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id_produto == null) {
			if (other.id_produto != null)
				return false;
		} else if (!id_produto.equals(other.id_produto))
			return false;
		return true;
	}
	
	

}