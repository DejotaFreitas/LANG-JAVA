package br.com.quicontrole.telas.componentes;

import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class TabelaScroll extends JScrollPane{
	
	private TabelaPersonalizada tabela;
	
	public TabelaScroll(TableModel modelo) {
		tabela = new TabelaPersonalizada(modelo);
		this.setViewportView(tabela);
		this.setOpaque(false);
		this.getViewport().setBackground(Cor.AZUL_FUNDO);
	}	

	public TabelaPersonalizada getTabela() {
		return tabela;
	}




}
