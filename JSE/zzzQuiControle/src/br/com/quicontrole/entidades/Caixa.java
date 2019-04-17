package br.com.quicontrole.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Caixa {

	private Integer id_caixa;
	private BigDecimal valor_atual;
	private BigDecimal movimentacao;
	private String tipo;
	private String dia;
	private String mes;
	private String ano;
	private String hora;

	public Caixa() {
	}

	public Integer getId_caixa() {
		return id_caixa;
	}

	public void setId_caixa(Integer id_caixa) {
		this.id_caixa = id_caixa;
	}

	public BigDecimal getValor_atual() {
		return valor_atual;
	}

	public void setValor_atual(BigDecimal valor_atual) {
		this.valor_atual = valor_atual;
	}

	public BigDecimal getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(BigDecimal movimentacao) {
		this.movimentacao = movimentacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	private BigDecimal formatarPreco(BigDecimal d) {
		DecimalFormat f = new DecimalFormat("0.00");
		f.setRoundingMode(RoundingMode.FLOOR);
		String t = f.format(d);
		t = t.replace(",", ".");
		return new BigDecimal(t);
	}

}
