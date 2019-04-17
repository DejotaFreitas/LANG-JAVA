package br.com.quicontrole.telas.venda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.quicontrole.dao.CaixaDAO;
import br.com.quicontrole.dao.ProdutoDAO;
import br.com.quicontrole.dao.VendaDAO;
import br.com.quicontrole.entidades.Caixa;
import br.com.quicontrole.entidades.Produto;
import br.com.quicontrole.entidades.Tranzacao;
import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.CampoTextoNumeroFlutuante;
import br.com.quicontrole.telas.componentes.CampoTextoNumeroInteiro;
import br.com.quicontrole.telas.componentes.Data;
import br.com.quicontrole.telas.componentes.Msg;
import br.com.quicontrole.telas.componentes.Painel;
import br.com.quicontrole.telas.componentes.TabelaScroll;
import br.com.quicontrole.telas.componentes.Texto;

@SuppressWarnings("serial")
public class ListaVenda extends Painel implements ActionListener, KeyListener, ListSelectionListener {

	private Texto nomeProduto;
	private CampoTextoNumeroInteiro quantidade;
	private Botao alterarQuantidade;

	private static ArrayList<Tranzacao> listaVenda;
	private static ModeloTabelaVenda modeloTabela;
	private static TabelaScroll tabela;

	private Botao excluir;
	private Botao limpar;

	private static Texto valorTotal;
	private static CampoTextoNumeroFlutuante dinheiroCliente;
	private static Texto troco;
	private Botao vender;
	private Botao cancelar;

	private static BigDecimal precoTotal;
	private static BigDecimal precoTroco;

	public ListaVenda() {
		nomeProduto = new Texto("Nome Produto", 16, 30, 10);

		quantidade = new CampoTextoNumeroInteiro("Quantidade");
		alterarQuantidade = new Botao("Alterar Quantidade");

		valorTotal = new Texto("R$ 00,00", 16, 30, 60);

		dinheiroCliente = new CampoTextoNumeroFlutuante("R$ Cliênte", 9, 6, 30);
		troco = new Texto("R$ 0,00", 16, 100, 40);
		vender = new Botao("Efetuar Venda");
		cancelar = new Botao("Cancelar");

		excluir = new Botao("Excluir");
		limpar = new Botao("Limpar lista Produtos");

		listaVenda = new ArrayList<Tranzacao>() {
		};
		modeloTabela = new ModeloTabelaVenda(listaVenda);
		tabela = new TabelaScroll(modeloTabela);

		precoTotal = new BigDecimal("0");
		precoTroco = new BigDecimal("0");

		// ===============================================
		valorTotal.setFont(new Font("Arial", Font.CENTER_BASELINE, 50));
		valorTotal.setOpaque(true);
		valorTotal.setBackground(new Color(0, 255, 255));
		valorTotal.setPlaceholder("Total");
		valorTotal.setPlaceholderFontSize(30);
		troco.setFont(new Font("Arial", Font.CENTER_BASELINE, 35));
		troco.setOpaque(true);
		troco.setBackground(new Color(112, 219, 147));
		troco.setPlaceholder("Troco");
		troco.setPlaceholderFontSize(20);
		dinheiroCliente.setFont(new Font("Arial", Font.CENTER_BASELINE, 35));

		// ===============================================
		dinheiroCliente.addKeyListener(this);
		limpar.addActionListener(this);
		excluir.addActionListener(this);
		alterarQuantidade.addActionListener(this);
		quantidade.addActionListener(this);
		cancelar.addActionListener(this);
		vender.addActionListener(this);
		tabela.getTabela().getSelectionModel().addListSelectionListener(this);

		// ===============================================
		Janela.addComponente(0, 0, 1, 1, 1, 0, this, nomeProduto);
		Janela.addComponente(0, 1, 1, 1, 1, 0, this, quantidade);
		Janela.addComponente(0, 2, 1, 1, 0, 0, this, alterarQuantidade);

		Janela.addComponente(1, 0, 3, 3, 1, 1, this, tabela);

		Janela.addComponente(4, 0, 1, 1, 1, 0, this, excluir);
		Janela.addComponente(4, 1, 2, 1, 1, 0, this, limpar, 1, 1, 1, 1, 0, 5);

		Janela.addComponente(5, 0, 3, 1, 1, 0, this, valorTotal, 1, 1, 1, 1, 0, 40);
		Janela.addComponente(6, 0, 1, 1, 1, 0, this, dinheiroCliente, 1, 1, 1, 1, 0, 35);
		Janela.addComponente(6, 1, 2, 1, 1, 0, this, troco, 1, 1, 1, 1, 1, 35);

		Janela.addComponente(8, 0, 1, 1, 1, 0, this, cancelar, 1, 1, 1, 1, 0, 20);
		Janela.addComponente(8, 1, 2, 1, 1, 0, this, vender, 1, 1, 1, 1, 0, 20);
	}

	public static void addProdutoListaVenda(Produto p) {
		if (p.getQuantidade() > 0) {
			for (Tranzacao venda : listaVenda) {
				if (venda.getProduto().equals(p)) {
					if (p.getQuantidade() > venda.getQuantidade()) {
						venda.setQuantidade(venda.getQuantidade() + 1);
						venda.atualizarTotalVenda();
						atualizar();
						return;
					} else {
						Msg.m(p.getNome() + " está esgotado.");
						return;
					}
				}
			}
			Tranzacao v = new Tranzacao(p);
			v.atualizarTotalVenda();
			listaVenda.add(v);
			atualizar();
		} else {
			Msg.m(p.getNome() + " está esgotado.");
		}
	}

	private static void atualizarTabela() {
		modeloTabela.setLinhas(listaVenda);
		modeloTabela.fireTableDataChanged();
	}

	private static void calcularTroco() {
		if (!dinheiroCliente.getText().equals("") && !dinheiroCliente.getText().equals(",")) {
			String temp = dinheiroCliente.getText();
			temp = temp.replace(",", ".");
			BigDecimal dinheiroCliente = new BigDecimal(temp);
			precoTroco = dinheiroCliente.subtract(precoTotal);
			if (precoTroco.compareTo(new BigDecimal("0.00")) == 0) {
				troco.setForeground(Color.DARK_GRAY);
			} else if (precoTroco.compareTo(new BigDecimal("0.00")) == 1) {
				troco.setForeground(Color.BLACK);
			} else {
				troco.setForeground(Color.RED);
			}
			String s = formatarPreco(precoTroco);

			troco.setText("R$ " + s);
		} else {
			troco.setForeground(Color.DARK_GRAY);
			troco.setText("R$ 0,00");
		}
	}

	private static void atualizarTotal() {
		precoTotal = new BigDecimal("0");
		for (Tranzacao venda : listaVenda) {
			precoTotal = precoTotal.add(venda.getTotal());
		}
		String s = formatarPreco(precoTotal);
		valorTotal.setText("R$ " + s);
	}

	private static String formatarPreco(BigDecimal d) {
		DecimalFormat f = new DecimalFormat("0.00");
		f.setRoundingMode(RoundingMode.FLOOR);
		return f.format(d);
	}

	private static void atualizar() {
		atualizarTotal();
		atualizarTabela();
		calcularTroco();
		vendaAux = null;
	}

	private void limpar() {
		listaVenda.clear();
		dinheiroCliente.setText("");
		quantidade.setText("");
		nomeProduto.setText("Produto");
		atualizar();
	}

	private void vender() {
		if (!listaVenda.isEmpty()) {
			Data d = new Data();
			for (Tranzacao venda : listaVenda) {
				venda.setDia(d.getDia());
				venda.setMes(d.getMes());
				venda.setAno(d.getAno());
				venda.setHora(d.getHora());
			}
			new VendaDAO().cadastrarLista(listaVenda);

			ProdutoDAO pdao = new ProdutoDAO();
			for (Tranzacao venda : listaVenda) {
				venda.getProduto().setQuantidade(venda.getProduto().getQuantidade() - venda.getQuantidade());
				pdao.alterar(venda.getProduto());
			}

			CaixaDAO cdao = new CaixaDAO();
			Caixa c = new Caixa();
			BigDecimal caixaAtual = cdao.ultimoRegistro() != null ? cdao.ultimoRegistro().getValor_atual()
					: new BigDecimal("0.00");
			BigDecimal totalCaixa = precoTotal.add(caixaAtual);
			c.setValor_atual(totalCaixa);
			c.setMovimentacao(precoTotal);
			c.setTipo("Venda");
			c.setDia(d.getDia());
			c.setMes(d.getMes());
			c.setAno(d.getAno());
			c.setHora(d.getHora());
			cdao.cadastrar(c);
			limpar();
			
		}
	}

	private static Tranzacao vendaAux;

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linhaSelecionada = tabela.getTabela().getSelectedRow();
		if (linhaSelecionada != -1) {
			vendaAux = modeloTabela.getLinhas().get(linhaSelecionada);
			quantidade.setText(vendaAux.getQuantidade().toString());
			nomeProduto.setText(vendaAux.getProduto().getNome());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == alterarQuantidade || e.getSource() == quantidade) {

			if (tabela.getTabela().getSelectedRow() != -1) {
				if ((quantidade.getTextNumeroInteiro() <= vendaAux.getProduto().getQuantidade())) {
					vendaAux.setQuantidade(quantidade.getTextNumeroInteiro());
					vendaAux.atualizarTotalVenda();
					atualizar();
				} else {
					Msg.m("Quantidade superou o estoque. \nQuantidade Atual: " + vendaAux.getProduto().getQuantidade());
				}
			} else {
				Msg.m("Selecione o produto que deseja alterar a quantidade.");
			}

		} else if (e.getSource() == limpar) {
			limpar();

		} else if (e.getSource() == excluir) {
			if (vendaAux != null) {
				listaVenda.remove(vendaAux);
				atualizar();
			} else {
				Msg.m("Selecione o item que deseja excluir.");
			}

		} else if (e.getSource() == cancelar) {
			limpar();

		} else if (e.getSource() == vender) {
			vender();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		calcularTroco();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

}
