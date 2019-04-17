package br.com.quicontrole.telas.caixa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.quicontrole.entidades.Caixa;

public class ModeloTabelaCaixa extends AbstractTableModel{
	private static final long serialVersionUID = -4532437066776465119L;
	
	private List<Caixa> linhas;
	private String[] colunas;

	public ModeloTabelaCaixa(List<Caixa> contatos) {
		this.linhas = new ArrayList<>(contatos);
		colunas = new String[] { "Valor Atual", "Movimentação", "Tipo", "Data"};
	}

	public int getRowCount() {
		return linhas.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public String getColumnName(int column) {
		return colunas[column];
	}

	public Object getValueAt(int row, int column) {
		Caixa p = linhas.get(row);
		switch (column) {
		case 0:	return formatarPreco(p.getValor_atual());
		case 1:	return formatarPreco(p.getMovimentacao());
		case 2:	return p.getTipo();
		case 3:	return p.getDia()+"/"+p.getMes()+"/"+p.getAno()+" - "+p.getHora();		
		default: break;
		}
		return "";
	}


	public List<Caixa> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Caixa> linhas) {
		this.linhas = linhas;
	}
	
	private String formatarPreco(BigDecimal valor) {
		DecimalFormat formato = new DecimalFormat("0.00");
		formato.setRoundingMode(RoundingMode.FLOOR);
		return  formato.format(valor);
	}
	
}
