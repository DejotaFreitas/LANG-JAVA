package br.com.quicontrole.telas.venda;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VendaPainel extends JPanel {
	//======LAYOUT=============================================================\\

	
	private static ListaProdutos vendaListaProdutos;
	private ListaVenda vendaListaVenda;


	public VendaPainel() {
		vendaListaProdutos = new ListaProdutos();
		vendaListaVenda = new ListaVenda();
		
		setLayout(new BorderLayout());
		add(vendaListaProdutos, BorderLayout.CENTER);
		add(vendaListaVenda, BorderLayout.EAST);
	}
	

	
}
