package br.com.quicontrole.telas.cadastro.fornecedor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.quicontrole.entidades.Fornecedor;

public class ModeloTabelaFornecedor extends AbstractTableModel{
	private static final long serialVersionUID = -4532437066776465119L;
	
	private List<Fornecedor> linhas;
	private String[] colunas;

	public ModeloTabelaFornecedor(List<Fornecedor> contatos) {
		this.linhas = new ArrayList<>(contatos);
		colunas = new String[] { "Nome", "Razão Social", "CNPJ", "CPF", 
				"Inscrição Estadual", "Inscrição Municipal", "Telefone",
				"Email", "Endereço", "Descricao", "Desativado" };
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
		Fornecedor f = linhas.get(row);
		switch (column) {
		case 0:	return f.getNome();
		case 1:	return f.getRazao_social();
		case 2:	return f.getCnpj();
		case 3:	return f.getCpf();
		case 4:	return f.getInscricao_estadual();
		case 5:	return f.getInscricao_municipal();
		case 6:	return f.getTelefone();
		case 7:	return f.getEmail();
		case 8:	return f.getEndereco();
		case 9:	return f.getDescricao();
		case 10: return (f.getDesativado()==false?"Não":"Sim");
		default: break;
		}
		return "";
	}


	public List<Fornecedor> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Fornecedor> linhas) {
		this.linhas = linhas;
	}
}
