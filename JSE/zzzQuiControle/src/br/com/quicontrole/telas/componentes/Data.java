package br.com.quicontrole.telas.componentes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	private Date data;

	public Data() {
		data = new Date();
	}

	public String getAno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(data);
	}

	public String getMes() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(data);
	}

	public String getDia() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(data);
	}

	public String getHora() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(data);
	}
/*
	public String getData() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(data);
	}
*/
}
