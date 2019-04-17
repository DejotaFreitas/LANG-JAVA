package br.com.quicontrole.telas.componentes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Moeda2 {

	private String moeda;
	private BigDecimal valor;	
	private static final DecimalFormat f = new DecimalFormat("0.00");
	

	public Moeda2() {
		this.valor = new BigDecimal("0");
		this.moeda = f.format(valor);
		this.valor = new BigDecimal(moeda);
	}

	public Moeda2(String moeda) {
		moeda = moeda.replace(",", ".");
		if (moeda.equals("") || moeda.equals(".")){
			this.valor = new BigDecimal("0.00");
		}else{
			this.valor = new BigDecimal(moeda);
		}
		f.setRoundingMode(RoundingMode.FLOOR);
		this.moeda = f.format(valor);
		this.valor = new BigDecimal(this.moeda.replace(",", "."));
	}

	public void setMoedaValor(String moeda) {
		f.setRoundingMode(RoundingMode.FLOOR);
		this.moeda = f.format(new BigDecimal(moeda));
		this.valor = new BigDecimal(this.moeda.replace(",", "."));
	}
	
	public String getMoeda() {
		return moeda;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return this.moeda;
	}
	
}
