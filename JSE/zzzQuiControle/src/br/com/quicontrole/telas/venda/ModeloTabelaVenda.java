package br.com.quicontrole.telas.venda;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.quicontrole.entidades.Tranzacao;

public class ModeloTabelaVenda extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	
	private List<Tranzacao> linhas;
	private String[] colunas;

	public ModeloTabelaVenda(List<Tranzacao> itens) {
		this.linhas = new ArrayList<Tranzacao>(itens);
		colunas = new String[] { "Produto", "Quantidade", "Valor Unitario",
				"Valor Total" };
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
		Tranzacao v = linhas.get(row);
		switch (column) {
		case 0:	return v.getProduto().getNome();
		case 1:	return v.getQuantidade();
		case 2:	return formatarPreco(v.getProduto().getValor_venda());
		case 3:	return formatarPreco(v.getTotal());
		default: break;
		}
		
		return null;
	}
	
	public List<Tranzacao> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Tranzacao> linhas) {
		this.linhas = linhas;
	}
	
	private String formatarPreco(BigDecimal valor) {
		DecimalFormat formato = new DecimalFormat("0.00");
		formato.setRoundingMode(RoundingMode.FLOOR);
		return  formato.format(valor);
	}
	
}
