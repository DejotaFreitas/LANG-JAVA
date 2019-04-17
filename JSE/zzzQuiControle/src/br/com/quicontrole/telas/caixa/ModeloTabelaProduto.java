package br.com.quicontrole.telas.caixa;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.quicontrole.entidades.Tranzacao;

public class ModeloTabelaProduto extends AbstractTableModel{
	private static final long serialVersionUID = -4532437066776465119L;
	
	private List<Tranzacao> linhas;
	private String[] colunas;

	public ModeloTabelaProduto(List<Tranzacao> contatos) {
		this.linhas = new ArrayList<>(contatos);
		colunas = new String[] { "Produto", "Fornecedor", "Quantidade"};
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
		Tranzacao p = linhas.get(row);
		switch (column) {
		case 0:	return p.getProduto();
		case 1:	return p.getProduto().getFornecedor();
		case 2:	return p.getQuantidade();
		default: break;
		}
		return "";
	}


	public List<Tranzacao> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Tranzacao> linhas) {
		this.linhas = linhas;
	}
	
}
