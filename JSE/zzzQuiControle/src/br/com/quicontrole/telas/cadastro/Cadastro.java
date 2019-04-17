package br.com.quicontrole.telas.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.cadastro.cliente.CadastroCliente;
import br.com.quicontrole.telas.cadastro.fornecedor.CadastroFornecedor;
import br.com.quicontrole.telas.cadastro.produto.CadastroProduto;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.Painel;

@SuppressWarnings("serial")
public class Cadastro extends Painel implements ActionListener {

	private static Painel painelAtual;

	private Botao produto;
	private Botao fornecedor;
	private Botao cliente;

	public Cadastro() {		

		produto = new Botao("Cadastrar Produto");
		fornecedor = new Botao("Cadastrar Fornecedor");
		cliente = new Botao("Cadastrar Cliente");

		produto.addActionListener(this);
		fornecedor.addActionListener(this);
		cliente.addActionListener(this);	

		Janela.addComponente(0, 0, 1, 1, 1, 0, this, produto, 1, 10,1, 5);
		Janela.addComponente(0, 1, 1, 1, 1, 0, this, fornecedor, 1,	5, 1, 5);
		Janela.addComponente(0, 2, 1, 1, 1, 0, this, cliente, 1, 5,	1, 10);

		painelAtual = new CadastroProduto();
		Janela.addComponente10(1, 0, 10, 10, 1, 1, this, painelAtual);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == produto) {
			atualizarPainel(new CadastroProduto());

		} else if (e.getSource() == fornecedor) {
			atualizarPainel(new CadastroFornecedor());

		} else if (e.getSource() == cliente) {
			atualizarPainel(new CadastroCliente());

		}

	}

	private void atualizarPainel(Painel painel) {
		painelAtual.setVisible(false);
		painelAtual = painel;
		painelAtual.setVisible(true);
		Janela.addComponente10(1, 0, 3, 1, 1, 1, this, painelAtual);
	}

}
