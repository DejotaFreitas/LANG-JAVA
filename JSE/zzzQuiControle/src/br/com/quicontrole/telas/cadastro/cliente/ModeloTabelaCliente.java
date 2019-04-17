package br.com.quicontrole.telas.cadastro.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.quicontrole.entidades.Cliente;

public class ModeloTabelaCliente extends AbstractTableModel{
	private static final long serialVersionUID = -4532437066776465119L;
	
	private List<Cliente> linhas;
	private String[] colunas;

	public ModeloTabelaCliente(List<Cliente> contatos) {
		this.linhas = new ArrayList<>(contatos);
		colunas = new String[] { "Nome","CPF", "Telefone",
				"Email", "Endereço", "Descricao"};
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
		Cliente c = linhas.get(row);
		switch (column) {
		case 0:	return c.getNome();
		case 1:	return c.getCpf();
		case 2:	return c.getTelefone();
		case 3:	return c.getEmail();
		case 4:	return c.getEndereco();
		case 5:	return c.getDescricao();
		default: break;
		}
		return "";
	}


	public List<Cliente> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Cliente> linhas) {
		this.linhas = linhas;
	}
}
