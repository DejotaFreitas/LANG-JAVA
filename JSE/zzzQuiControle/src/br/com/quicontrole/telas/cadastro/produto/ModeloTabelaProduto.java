package br.com.quicontrole.telas.cadastro.produto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.quicontrole.entidades.Produto;

public class ModeloTabelaProduto extends AbstractTableModel{
	private static final long serialVersionUID = -4532437066776465119L;
	
	private List<Produto> linhas;
	private String[] colunas;

	public ModeloTabelaProduto(List<Produto> contatos) {
		this.linhas = new ArrayList<>(contatos);
		colunas = new String[] { "Nome", "Código de Barra", "Quantidade", "Valor Compra",
				"Valor Venda", "Fornecedor", "Local no Estoque", "Descricão", "Desativado" };
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
		Produto p = linhas.get(row);
		switch (column) {
		case 0:	return p.getNome();
		case 1:	return p.getCodigo_barra();
		case 2:	return p.getQuantidade();
		case 3:	return formatarPreco(p.getValor_compra());
		case 4:	return formatarPreco(p.getValor_venda());
		case 5:	return p.getFornecedor();
		case 6:	return p.getLocal_estoque();
		case 7:	return p.getDescricao();
		case 8:	return (p.getDesativado()==false?"Não":"Sim");
		default: break;
		}
		return "";
	}


	public List<Produto> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Produto> linhas) {
		this.linhas = linhas;
	}
	
	private String formatarPreco(BigDecimal valor) {
		DecimalFormat formato = new DecimalFormat("0.00");
		formato.setRoundingMode(RoundingMode.FLOOR);
		return  formato.format(valor);
	}
}
