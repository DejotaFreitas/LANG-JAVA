package br.com.quicontrole.telas.venda;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.com.quicontrole.dao.ProdutoDAO;
import br.com.quicontrole.entidades.Produto;
import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.CaixaCombo;
import br.com.quicontrole.telas.componentes.CampoTexto;
import br.com.quicontrole.telas.componentes.Cor;
import br.com.quicontrole.telas.componentes.Msg;
import br.com.quicontrole.telas.componentes.Painel;

@SuppressWarnings("serial")
public class ListaProdutos extends Painel implements ActionListener {
	
	private List<Produto> lista;
	private CampoTexto pesquisa;
	private Botao pesquisar;
	private ProdutosImagens produtosImagens;
	private ArrayList<Object> tipoPesquisaLista;
	private CaixaCombo tipoPesquisa;

	public ListaProdutos() {
		tipoPesquisaLista = new ArrayList<>();
		tipoPesquisaLista.add("Nome");
		tipoPesquisaLista.add("Cód. de Barra");
		tipoPesquisa = new CaixaCombo(tipoPesquisaLista);

		pesquisa = new CampoTexto();
		pesquisar = new Botao("Pesquisar");
		produtosImagens = new ProdutosImagens();

		pesquisa.addActionListener(this);
		pesquisar.addActionListener(this);
		// ===============================================

		Janela.addComponente(0, 0, 1, 1, 0, 0, this, tipoPesquisa, 1, 3, 1, 1);
		Janela.addComponente(0, 1, 5, 1, 1, 0, this, pesquisa);
		Janela.addComponente(0, 6, 1, 1, 0, 0, this, pesquisar, 1, 1, 1, 3);

		Janela.addComponente(1, 0, 7, 1, 0, 1, this, produtosImagens);

	}

	private class ProdutosImagens extends JPanel {

		public ProdutosImagens() {
			GridLayout layout = new GridLayout(5, 6);
			layout.setHgap(4);
			layout.setVgap(3);
			setLayout(layout);

			this.setOpaque(true);
			this.setBackground(Cor.AZUL_FUNDO);

			lista = new ProdutoDAO().listarVenda();

			int cont = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 5; j++) {

					if (cont < lista.size()) {
						Produto p = lista.get(cont);
						CaixaProduto cp = new CaixaProduto(p);
						this.add(cp);
					} else {
						this.add(new CaixaProduto("Produto"));
					}
					cont++;
				}

			}
		}

		public ProdutosImagens(List<Produto> lista) {
			GridLayout layout = new GridLayout(5, 6);
			layout.setHgap(4);
			layout.setVgap(3);
			setLayout(layout);

			this.setOpaque(true);
			this.setBackground(Cor.AZUL_FUNDO);

			int cont = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 5; j++) {

					if (cont < lista.size()) {
						Produto p = lista.get(cont);
						CaixaProduto cp = new CaixaProduto(p);
						this.add(cp);
					} else {
						this.add(new CaixaProduto("Produto"));
					}
					cont++;
				}

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == pesquisar || e.getSource() == pesquisa) {

			switch (tipoPesquisa.getSelectedIndex()) {
			case 0:
				lista = new ProdutoDAO().pesquisarNomeVenda(pesquisa.getText());
				produtosImagens.setVisible(false);
				produtosImagens = new ProdutosImagens(lista);
				Janela.addComponente(1, 0, 7, 1, 0, 1, this, produtosImagens);
				produtosImagens.setVisible(true);
				break;

			case 1:
				Produto p = new ProdutoDAO().buscaCodigoBarraVenda(pesquisa.getText());
				if (!pesquisa.getText().equals("") && p != null) {
					ListaVenda.addProdutoListaVenda(p);
					break;
				} else {
					Msg.m("Não foi possível encontrar este produto.");
				}
				break;

			default:
				break;
			}
		}
	}

}
