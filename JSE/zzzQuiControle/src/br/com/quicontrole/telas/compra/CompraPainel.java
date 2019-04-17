package br.com.quicontrole.telas.compra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.quicontrole.dao.CaixaDAO;
import br.com.quicontrole.dao.CompraDAO;
import br.com.quicontrole.dao.ProdutoDAO;
import br.com.quicontrole.entidades.Caixa;
import br.com.quicontrole.entidades.Produto;
import br.com.quicontrole.entidades.Tranzacao;
import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.CaixaCombo;
import br.com.quicontrole.telas.componentes.CampoTexto;
import br.com.quicontrole.telas.componentes.CampoTextoNumeroInteiro;
import br.com.quicontrole.telas.componentes.Data;
import br.com.quicontrole.telas.componentes.Msg;
import br.com.quicontrole.telas.componentes.Painel;
import br.com.quicontrole.telas.componentes.TabelaScroll;
import br.com.quicontrole.telas.componentes.Texto;

@SuppressWarnings("serial")
public class CompraPainel extends Painel implements ActionListener, KeyListener, ListSelectionListener {

	private Texto tituloEstoque;

	private CaixaImagem imagem;

	private Texto nome;
	private Texto fornecedor;
	private Texto quantidade;
	private Texto valorCompra;

	private Texto quantidadeAComprar;
	private CampoTextoNumeroInteiro quantidadeCompra;
	private Texto totalCompra;
	private Botao comprar;

	private CampoTexto pesquisa;
	private Botao pesquisar;
	private ArrayList<Object> tipoPesquisaLista;
	private CaixaCombo tipoPesquisa;
	private TabelaScroll tabela;
	private ModeloTabela modelotabela;

	public CompraPainel() {

		tituloEstoque = new Texto("Compra de Produtos", 20);

		imagem = new CaixaImagem();

		nome = new Texto("Nome: ");
		fornecedor = new Texto("Fornecedor: ");
		valorCompra = new Texto("Unidade: R$ ");
		quantidade = new Texto("Quantidade: ");

		nome.setHorizontalAlignment(JLabel.LEFT);
		fornecedor.setHorizontalAlignment(JLabel.LEFT);
		valorCompra.setHorizontalAlignment(JLabel.LEFT);
		quantidade.setHorizontalAlignment(JLabel.LEFT);

		quantidadeAComprar = new Texto("Quantidade da Comprar");
		quantidadeCompra = new CampoTextoNumeroInteiro("Quantidade", 9);
		totalCompra = new Texto("Total: R$ ");
		comprar = new Botao("Comprar");

		pesquisa = new CampoTexto("Insira o texto da pesquisa...");
		pesquisar = new Botao("Pesquisa");

		tipoPesquisaLista = new ArrayList<>();
		tipoPesquisaLista.add("Nome");
		tipoPesquisaLista.add("Cód. de Barra");
		tipoPesquisa = new CaixaCombo(tipoPesquisaLista);

		modelotabela = new ModeloTabela(new ProdutoDAO().listarAtivos());
		tabela = new TabelaScroll(modelotabela);

		// =============================================
		Janela.addComponente(0, 0, 4, 1, 0, 1, this, tituloEstoque, 1, 1, 10, 1);

		Janela.addComponente(2, 0, 1, 4, 0, 0, this, imagem, 1, 10, 1, 10);

		Janela.addComponente(2, 2, 1, 1, 0, 0, this, nome, 1, 10, 1, 10);
		Janela.addComponente(3, 2, 1, 1, 0, 0, this, fornecedor, 1, 10, 1, 10);
		Janela.addComponente(4, 2, 1, 1, 0, 0, this, valorCompra, 1, 10, 1, 10);
		Janela.addComponente(5, 2, 1, 1, 0, 0, this, quantidade, 1, 10, 1, 10);

		Janela.addComponente(2, 1, 1, 1, 0, 0, this, quantidadeAComprar, 2, 10, 2, 10);
		Janela.addComponente(3, 1, 1, 1, 0, 0, this, quantidadeCompra, 2, 10, 2, 10, 1, 5);
		Janela.addComponente(4, 1, 1, 1, 0, 0, this, totalCompra, 2, 10, 2, 10);
		Janela.addComponente(5, 1, 1, 1, 0, 0, this, comprar, 2, 10, 2, 10);

		Janela.addComponente(6, 0, 4, 1, 1, 1, this, tabela, 20, 1, 1, 1);
		Janela.addComponente(7, 0, 1, 1, 0, 0, this, tipoPesquisa);
		Janela.addComponente(7, 1, 1, 1, 0, 0, this, pesquisar);
		Janela.addComponente(7, 2, 2, 1, 0, 0, this, pesquisa);

		// ========Add
		// Event================================================================

		comprar.addActionListener(this);
		pesquisa.addActionListener(this);
		pesquisar.addActionListener(this);
		tabela.getTabela().getSelectionModel().addListSelectionListener(this);
		quantidadeCompra.addKeyListener(this);
	}

	// =====================================================================================================
	private static Produto produtoAux;

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linhaSelecionada = tabela.getTabela().getSelectedRow();
		if (linhaSelecionada != -1) {
			Produto p = modelotabela.getLinhas().get(linhaSelecionada);
			nome.setText("Nome: " + p.getNome());
			fornecedor.setText("Fornecedor: " + (p.getFornecedor() != null ? p.getFornecedor().getNome() : ""));
			valorCompra.setText("Unidade: R$ " + formatarPreco(p.getValor_compra()));
			quantidade.setText("Quantidade: " + p.getQuantidade().toString());

			imagem.setImagem(p.getImage());
			imagem.repaint();
			produtoAux = p;
			atualizarTotal();

		}

	}

	// =========================================================================================================
	private String formatarPreco(BigDecimal valor) {
		DecimalFormat formato = new DecimalFormat("0.00");
		formato.setRoundingMode(RoundingMode.FLOOR);
		return formato.format(valor);
	}

	public void atualizarTotal() {
		if (produtoAux != null && !quantidadeCompra.getText().equals("")) {
			BigDecimal q = new BigDecimal(quantidadeCompra.getText());
			BigDecimal p = produtoAux.getValor_compra();
			BigDecimal total = q.multiply(p);
			totalCompra.setText("Total: R$ " + formatarPreco(total));
		}
	}
	
	public BigDecimal valorTotal() {
		BigDecimal total = new BigDecimal("0.00");
		if (produtoAux != null && !quantidadeCompra.getText().equals("")) {
			BigDecimal q = new BigDecimal(quantidadeCompra.getText());
			BigDecimal p = produtoAux.getValor_compra();
			total = q.multiply(p);
		}
		return total;
	}

	private void limparCampos() {
		quantidadeCompra.setText("");
		totalCompra.setText("Total: R$");
		nome.setText("Nome:");
		fornecedor.setText("Fornecedor:");
		valorCompra.setText("Unidade: R$");
		quantidade.setText("Quantidade:");
		BufferedImage imgTemp = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB);
		Graphics g = imgTemp.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 160, 160);
		imagem.setImagem(imgTemp);
		imagem.repaint();
		produtoAux = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == comprar && !quantidadeCompra.getText().equals("")) {
			
			if (produtoAux != null) {
				Tranzacao compra = new Tranzacao(produtoAux, quantidadeCompra.getTextNumeroInteiro());
				compra.atualizarTotalCompra();
				Data d = new Data();
				compra.setDia(d.getDia());
				compra.setMes(d.getMes());
				compra.setAno(d.getAno());
				compra.setHora(d.getHora());			
				new CompraDAO().cadastrar(compra);
				
				compra.getProduto().setQuantidade(compra.getProduto().getQuantidade() + compra.getQuantidade());
				new ProdutoDAO().alterar(compra.getProduto());
				
				CaixaDAO cdao = new CaixaDAO();
				Caixa c = new Caixa();
				BigDecimal caixaAtual = cdao.ultimoRegistro() != null ? 
						cdao.ultimoRegistro().getValor_atual() : new BigDecimal("0.00");
				BigDecimal totalCompra = valorTotal();
				BigDecimal totalCaixa = caixaAtual.subtract(totalCompra);
				c.setValor_atual(totalCaixa);
				c.setMovimentacao(totalCompra);
				c.setTipo("Compra");
				c.setDia(d.getDia());
				c.setMes(d.getMes());
				c.setAno(d.getAno());
				c.setHora(d.getHora());
				cdao.cadastrar(c);
				
				modelotabela.fireTableDataChanged();				
				limparCampos();
			} else {
				Msg.m("Selecione o produto ou insira a quantidade que deseja comprar.");
			}

		} else if (e.getSource() == pesquisar || e.getSource() == pesquisa) {

			switch (tipoPesquisa.getSelectedIndex()) {
			case 0:
				modelotabela.setLinhas(new ProdutoDAO().pesquisarNomeAtivos(pesquisa.getText()));
				modelotabela.fireTableDataChanged();
				break;

			case 1:
				modelotabela.setLinhas(new ProdutoDAO().buscaCodigoBarraAtivos(pesquisa.getText()));
				modelotabela.fireTableDataChanged();
				break;

			default:
				break;
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		atualizarTotal();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

}
