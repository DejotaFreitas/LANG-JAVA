package br.com.quicontrole.telas.cadastro.produto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.quicontrole.dao.FornecedorDAO;
import br.com.quicontrole.dao.ProdutoDAO;
import br.com.quicontrole.entidades.Fornecedor;
import br.com.quicontrole.entidades.Produto;
import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.CaixaCombo;
import br.com.quicontrole.telas.componentes.CaixaMarcar;
import br.com.quicontrole.telas.componentes.CampoTexto;
import br.com.quicontrole.telas.componentes.CampoTextoNumeroFlutuante;
import br.com.quicontrole.telas.componentes.CampoTextoNumeroInteiro;
import br.com.quicontrole.telas.componentes.Msg;
import br.com.quicontrole.telas.componentes.Painel;
import br.com.quicontrole.telas.componentes.TabelaScroll;
import br.com.quicontrole.telas.componentes.Texto;

@SuppressWarnings("serial")
public class CadastroProduto extends Painel implements ActionListener, ListSelectionListener {

	private Texto cadastroFornecedor;
	private Texto nome;
	private CampoTexto nome2;
	private Texto codigoBarra;
	private CampoTextoNumeroInteiro codigoBarra2;
	private Texto valorCompra;
	private CampoTextoNumeroFlutuante valorCompra2;
	private Texto valorVenda;
	private CampoTextoNumeroFlutuante valorVenda2;
	private Texto fornecedor;
	private CaixaCombo fornecedor2;
	private Texto localEstoque;
	private CampoTexto localEstoque2;
	private Texto desativado;
	private CaixaMarcar desativado2;
	private Texto descricao;
	private CampoTexto descricao2;
	private CaixaImagemProduto imagem;
	private Botao cadastrar;
	private Botao alterar;
	private Botao excluir;
	private Botao limpar;
	private CampoTexto pesquisa;
	private Botao pesquisar;
	private ArrayList<Object> tipoPesquisaLista;
	private CaixaCombo tipoPesquisa;
	private TabelaScroll tabela;
	private ModeloTabelaProduto modelotabela;

	public CadastroProduto() {

		cadastroFornecedor = new Texto("Cadastrar do Fornecedor", 20);

		nome = new Texto("Nome");
		nome2 = new CampoTexto("Nome do Produto", 50);

		codigoBarra = new Texto("Codigo de Barra");
		codigoBarra2 = new CampoTextoNumeroInteiro("codigo de barra", 13);

		valorCompra = new Texto("Valor de Compra");
		valorCompra2 = new CampoTextoNumeroFlutuante("Valor de Compra", 9);

		valorVenda = new Texto("Valor de Venda");
		valorVenda2 = new CampoTextoNumeroFlutuante("Valor de Venda", 9);

		fornecedor = new Texto("Fornecedor");
		fornecedor2 = new CaixaCombo(new FornecedorDAO().listarComboBox());

		localEstoque = new Texto("Local no Estoque");
		localEstoque2 = new CampoTexto("Localizacao do produto no Estoque", 20);

		desativado = new Texto("Desativar Produto");
		desativado2 = new CaixaMarcar("Ocultar");

		descricao = new Texto("Descricao");
		descricao2 = new CampoTexto("Caracteristicas do produto", 255);

		imagem = new CaixaImagemProduto("Imagem do Produto");

		cadastrar = new Botao("Cadastrar");
		alterar = new Botao("Alterar");
		excluir = new Botao("Excluir");
		limpar = new Botao("Limpar");

		pesquisa = new CampoTexto("Insira o texto da pesquisa...");
		pesquisar = new Botao("Pesquisa");

		tipoPesquisaLista = new ArrayList<>();
		tipoPesquisaLista.add("Nome");
		tipoPesquisaLista.add("Cód. de Barra");
		tipoPesquisa = new CaixaCombo(tipoPesquisaLista);

		modelotabela = new ModeloTabelaProduto(new ProdutoDAO().listar());
		tabela = new TabelaScroll(modelotabela);

		// =============================================

		Janela.addComponente(0, 0, 10, 1, 1, 0, this, cadastroFornecedor, 1, 1, 20, 1);

		Janela.addComponente(2, 0, 1, 1, 0, 0, this, nome, 1, 1, 1, 1);
		Janela.addComponente(2, 2, 1, 1, 0, 0, this, valorVenda, 1, 1, 1, 1);
		Janela.addComponente(3, 0, 1, 1, 0, 0, this, codigoBarra, 1, 1, 1, 1);
		Janela.addComponente(3, 2, 1, 1, 0, 0, this, valorCompra, 1, 1, 1, 1);
		Janela.addComponente(4, 0, 1, 1, 0, 0, this, fornecedor, 1, 1, 1, 1);
		Janela.addComponente(4, 2, 1, 1, 0, 0, this, localEstoque, 1, 1, 1, 1);
		Janela.addComponente(5, 0, 1, 1, 0, 0, this, descricao, 1, 1, 1, 1);
		Janela.addComponente(5, 2, 1, 1, 0, 0, this, desativado, 1, 1, 1, 1);

		Janela.addComponente(2, 1, 1, 1, 1, 0, this, nome2, 1, 1, 5, 10, 0, 5);
		Janela.addComponente(2, 3, 1, 1, 1, 0, this, valorVenda2, 1, 1, 5, 10, 0, 5);
		Janela.addComponente(3, 1, 1, 1, 1, 0, this, codigoBarra2, 1, 1, 5, 10, 0, 5);
		Janela.addComponente(3, 3, 1, 1, 1, 0, this, valorCompra2, 1, 1, 5, 10, 0, 5);
		Janela.addComponente(4, 1, 1, 1, 1, 0, this, fornecedor2, 1, 1, 5, 10);
		Janela.addComponente(4, 3, 1, 1, 1, 0, this, localEstoque2, 1, 1, 5, 10, 0, 5);
		Janela.addComponente(5, 1, 1, 1, 1, 0, this, descricao2, 1, 1, 5, 10, 0, 5);
		Janela.addComponente(5, 3, 1, 1, 1, 0, this, desativado2, 1, 1, 5, 10, 0, 2);

		Janela.addComponente(2, 4, 1, 5, 0, 0, this, imagem, 1, 1, 1, 5);

		Janela.addComponente(2, 5, 1, 1, 0, 0, this, cadastrar, 1, 1, 1, 1);
		Janela.addComponente(3, 5, 1, 1, 0, 0, this, alterar, 1, 1, 1, 1);
		Janela.addComponente(4, 5, 1, 1, 0, 0, this, limpar, 1, 1, 1, 1);
		Janela.addComponente(5, 5, 1, 1, 0, 0, this, excluir, 1, 1, 1, 1);

		Janela.addComponente(10, 0, 7, 1, 1, 1, this, tabela, 10, 1, 1, 1);

		Janela.addComponente(11, 0, 1, 1, 0, 0, this, tipoPesquisa);
		Janela.addComponente(11, 1, 4, 1, 1, 0, this, pesquisa);
		Janela.addComponente(11, 5, 1, 1, 0, 0, this, pesquisar);

		// ========Add
		// Event================================================================

		cadastrar.addActionListener(this);
		limpar.addActionListener(this);
		alterar.addActionListener(this);
		excluir.addActionListener(this);
		pesquisa.addActionListener(this);
		pesquisar.addActionListener(this);
		tabela.getTabela().getSelectionModel().addListSelectionListener(this);
	}

	// =====================================================================================================
	private static Produto produtoAux;

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linhaSelecionada = tabela.getTabela().getSelectedRow();
		if (linhaSelecionada != -1) {
			Produto p = modelotabela.getLinhas().get(linhaSelecionada);
			nome2.setText(p.getNome());
			codigoBarra2.setText(p.getCodigo_barra());
			valorCompra2.setText(formatarPreco(p.getValor_compra()));
			valorVenda2.setText(formatarPreco(p.getValor_venda()));
			fornecedor2.getFornecedor((p.getFornecedor() != null ? p.getFornecedor().getId_fornecedor() : 0));
			localEstoque2.setText(p.getLocal_estoque());
			descricao2.setText(p.getDescricao());
			imagem.setImagem(p.getImage());
			imagem.repaint();
			desativado2.setSelected(p.getDesativado());
			produtoAux = p;

		}

	}
	// =========================================================================================================

	private void atualizarTabela() {
		modelotabela.setLinhas(new ProdutoDAO().listar());
		modelotabela.fireTableDataChanged();
	}

	private void limparCampos() {
		nome2.setText("");
		codigoBarra2.setText("");
		valorCompra2.setText("");
		valorVenda2.setText("");
		fornecedor2.getFornecedor(0);
		localEstoque2.setText("");
		descricao2.setText("");
		desativado2.setSelected(false);
		BufferedImage imgTemp = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB);
		Graphics g = imgTemp.createGraphics();
		g.setColor( Color.WHITE );
		g.fillRect( 0, 0, 160, 160 );
		imagem.setImagem(imgTemp);
		imagem.repaint();
	}
	
	private String formatarPreco(BigDecimal valor) {
		DecimalFormat formato = new DecimalFormat("0.00");
		formato.setRoundingMode(RoundingMode.FLOOR);
		return  formato.format(valor);
	}
	
	private BigDecimal formatarDecimal(String valor) {
		DecimalFormat formato = new DecimalFormat("0.00");
		formato.setRoundingMode(RoundingMode.FLOOR);
		valor = valor.replace(",", ".");
		BigDecimal temp = new BigDecimal(valor);
		String texto = formato.format(temp);
		texto = texto.replace(",", ".");
		BigDecimal c = new BigDecimal(texto);
		return c;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cadastrar) {
			if ( verificarCadastroProduto() && verificarCodigoBarraExiteCadastrar() ) {	
				Produto p = new Produto();
				p.setNome(nome2.getText());
				p.setCodigo_barra(codigoBarra2.getText());
				p.setQuantidade(0);				
				p.setValor_compra(formatarDecimal((valorCompra2.getText().equals("") ? "0" : valorCompra2.getText())));
				p.setValor_venda(formatarDecimal((valorVenda2.getText().equals("") ? "0" : valorVenda2.getText())));
				p.setFornecedor((Fornecedor) fornecedor2.getSelectedItem());
				System.out.println();
				p.setLocal_estoque(localEstoque2.getText());
				p.setDescricao(descricao2.getText());
				p.setImagem(imagem.converterArrayByte());
				p.setDesativado(desativado2.isSelected());
				new ProdutoDAO().cadastrar(p);
				atualizarTabela();
				limparCampos();
			}
			
		} else if (e.getSource() == alterar) {

			if (produtoAux != null) {
				if ( verificarCadastroProduto() && verificarCodigoBarraExiteAlterar() ) {
					Produto p = produtoAux;
					p.setNome(nome2.getText());
					p.setCodigo_barra(codigoBarra2.getText());
					p.setValor_compra(formatarDecimal((valorCompra2.getText().equals("") ? "0" : valorCompra2.getText())));
					p.setValor_venda(formatarDecimal((valorVenda2.getText().equals("") ? "0" : valorVenda2.getText())));
					p.setFornecedor((Fornecedor) fornecedor2.getSelectedItem());
					p.setLocal_estoque(localEstoque2.getText());
					p.setDescricao(descricao2.getText());
					p.setImagem((imagem.converterArrayByte()));
					p.setDesativado(desativado2.isSelected());
					new ProdutoDAO().alterar(p);
					atualizarTabela();
					produtoAux = null;
					limparCampos();
				}
			} else {
				Msg.m("Selecione o produto que deseja alterar.");
			}

		} else if (e.getSource() == excluir) {

			if (produtoAux != null) {
				int r = Msg.msn("Excluir " + produtoAux.getNome() + " ?", "Excluir Produto");
				if (r == 0) {
					new ProdutoDAO().excluir(produtoAux);
					atualizarTabela();
					produtoAux = null;
					limparCampos();
				}
			} else {
				Msg.m("Selecione o produto que deseja excluir.");
			}

		} else if (e.getSource() == limpar) {
			limparCampos();
			modelotabela.fireTableDataChanged();

		} else if (e.getSource() == pesquisar || e.getSource() == pesquisa) {

			switch (tipoPesquisa.getSelectedIndex()) {
			case 0:
				modelotabela.setLinhas(new ProdutoDAO().pesquisarListaNome(pesquisa.getText()));
				modelotabela.fireTableDataChanged();
				break;

			case 1:
				modelotabela.setLinhas(new ProdutoDAO().pesquisaListaCodigoBarra(pesquisa.getText()));
				modelotabela.fireTableDataChanged();
				break;

			default:
				break;
			}

		}

	}
	
	
	private boolean verificarCadastroProduto() {
		if(verificarNomeNulo() && verificarValorVendaNulo() &&
				verificarValorCompraNulo() && verificarFornecedorExiste())
			return true;
		return false;
	}
	
	
	private boolean verificarCodigoBarraExiteCadastrar() {
		Produto p = new ProdutoDAO().buscaCodigoBarra(codigoBarra2.getText());
		boolean b = (p != null);
		if (b) {
			Msg.m("Código de Barra já está sendo usado por outro produto.");
		}
		return !b;
	}
	
	private boolean verificarCodigoBarraExiteAlterar() {
		Produto p = new ProdutoDAO().buscaCodigoBarra(codigoBarra2.getText());
		boolean b = (p != null);
		if (b) {
			if (!p.equals(produtoAux)) {				
			Msg.m("Código de Barra já está sendo usado por outro produto.");
			return false;
			}
		}
		return true;
	}
	
	private boolean verificarNomeNulo() {
		boolean b = nome2.getText().equals("");
		if (b) {
			Msg.m("Insira o nome do Produto.");
		}
		return !b;
	}
	
	private boolean verificarValorVendaNulo() {
		boolean b = valorVenda2.getText().equals("");
		if (b) {
			Msg.m("Insira o valor de venda do produto.");
		}
		return !b;
	}
	
	private boolean verificarValorCompraNulo() {
		boolean b = valorCompra2.getText().equals("");
		if (b) {
			Msg.m("Insira o valor de compra do produto.");
		}
		return !b;
	}
	
	private boolean verificarFornecedorExiste() {
		boolean b = fornecedor2.getSelectedItem() == null;
		if (b) {
			Msg.m("Cadastre o fornecedor do produto.");
		}
		return !b;
	}
	
	


}
