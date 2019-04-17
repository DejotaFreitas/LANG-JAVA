package br.com.quicontrole.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Tranzacao {
	
	private Integer id;
	private Produto produto;
	private Integer quantidade;
	private BigDecimal total;
	private String dia;
	private String mes;
	private String ano;
	private String hora;
	
	public Tranzacao() {}
	
	public Tranzacao(Produto produto) {
		this.produto = produto;
		quantidade = 1;
	}
	
	public Tranzacao(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public void atualizarTotalVenda() {
		BigDecimal q = new BigDecimal(quantidade.toString());
		BigDecimal p = produto.getValor_venda();
		BigDecimal d = q.multiply(p);
		total = formatarPreco(d);
	}
	
	public void atualizarTotalCompra() {
		BigDecimal q = new BigDecimal(quantidade.toString());
		BigDecimal p = produto.getValor_compra();
		BigDecimal d = q.multiply(p);
		total = formatarPreco(d);
	}

	private BigDecimal formatarPreco(BigDecimal d) {
		DecimalFormat f = new DecimalFormat("0.00");
		f.setRoundingMode(RoundingMode.FLOOR);
		String t = f.format(d);
		t = t.replace(",", ".");
		return new BigDecimal(t);
	}

}
