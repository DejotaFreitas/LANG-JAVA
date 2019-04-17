package br.com.quicontrole.telas.caixa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.quicontrole.dao.CaixaDAO;
import br.com.quicontrole.dao.CompraDAO;
import br.com.quicontrole.dao.VendaDAO;
import br.com.quicontrole.entidades.Caixa;
import br.com.quicontrole.entidades.Tranzacao;
import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.CampoTextoNumeroFlutuante;
import br.com.quicontrole.telas.componentes.CampoTextoNumeroInteiro;
import br.com.quicontrole.telas.componentes.Data;
import br.com.quicontrole.telas.componentes.Painel;
import br.com.quicontrole.telas.componentes.TabelaScroll;
import br.com.quicontrole.telas.componentes.Texto;

@SuppressWarnings("serial")
public class CaixaPainel extends Painel implements ActionListener, ListSelectionListener {

	private Texto tituloCaixa;

	private Texto valorAtualCaixa;
	private Texto valorAtual;
	private CampoTextoNumeroFlutuante saque;
	private Botao sacar;
	private CampoTextoNumeroFlutuante deposito;
	private Botao depositar;

	private CampoTextoNumeroInteiro dia;
	private CampoTextoNumeroInteiro mes;
	private CampoTextoNumeroInteiro ano;
	private Botao pesquisar;

	private ArrayList<Caixa> listaCaixa;
	private TabelaScroll tabelaCaixa;
	private ModeloTabelaCaixa modeloTabelaCaixa;

	private TabelaScroll tabelaProduto;
	private ModeloTabelaProduto modeloTabelaProduto;
	private ArrayList<Tranzacao> listaProdutos;

	public CaixaPainel() {

		tituloCaixa = new Texto("Controle de Caixa", 20);

		valorAtualCaixa = new Texto("Valor Atual Em Caixa");
		valorAtual = new Texto("R$ ", 50);

		saque = new CampoTextoNumeroFlutuante("R$ Valor do Saque", 9);
		sacar = new Botao("Sacar");

		deposito = new CampoTextoNumeroFlutuante("R$ Valor do Depósito", 9);
		depositar = new Botao("Depositar");

		dia = new CampoTextoNumeroInteiro("Dia...exemplo: 09");
		mes = new CampoTextoNumeroInteiro("Mês...exemplo: 10");
		ano = new CampoTextoNumeroInteiro("Ano...exemplo: 2016");
		pesquisar = new Botao("Pesquisar");

		listaCaixa = new CaixaDAO().listar();
		modeloTabelaCaixa = new ModeloTabelaCaixa(listaCaixa);
		tabelaCaixa = new TabelaScroll(modeloTabelaCaixa);

		listaProdutos = new ArrayList<Tranzacao>();
		modeloTabelaProduto = new ModeloTabelaProduto(listaProdutos);
		tabelaProduto = new TabelaScroll(modeloTabelaProduto);

		// =============================================
		Janela.addComponente(0, 0, 10, 1, 0, 1, this, tituloCaixa, 1, 1, 10, 1);

		Janela.addComponente(1, 0, 3, 1, 1, 0, this, valorAtualCaixa, 5, 1, 5, 1);
		Janela.addComponente(2, 0, 3, 3, 1, 0, this, valorAtual, 5, 1, 5, 1);

		Janela.addComponente(2, 4, 1, 1, 1, 0, this, saque, 5, 1, 5, 1, 1, 5);
		Janela.addComponente(2, 5, 1, 1, 0, 0, this, sacar, 5, 1, 5, 1);
		Janela.addComponente(4, 4, 1, 1, 1, 0, this, deposito, 5, 1, 5, 1, 1, 5);
		Janela.addComponente(4, 5, 1, 1, 0, 0, this, depositar, 5, 1, 5, 1);

		Janela.addComponente(5, 0, 1, 1, 1, 0, this, dia, 20, 1, 1, 1);
		Janela.addComponente(5, 1, 1, 1, 1, 0, this, mes, 20, 1, 1, 1);
		Janela.addComponente(5, 2, 1, 1, 1, 0, this, ano, 20, 1, 1, 1);
		Janela.addComponente(5, 3, 1, 1, 0, 0, this, pesquisar, 20, 1, 1, 1);

		Janela.addComponente(6, 0, 4, 1, 1, 1, this, tabelaCaixa);
		Janela.addComponente(6, 4, 3, 7, 1, 1, this, tabelaProduto);

		// ========Add
		// Event================================================================

		sacar.addActionListener(this);
		depositar.addActionListener(this);
		dia.addActionListener(this);
		mes.addActionListener(this);
		ano.addActionListener(this);
		pesquisar.addActionListener(this);
		tabelaCaixa.getTabela().getSelectionModel().addListSelectionListener(this);

		atualizarCaixaAtual();
	}

	// =====================================================================================================
	private static Caixa caixaAux;

	@Override
	public void valueChanged(ListSelectionEvent e) {

		int linhaSelecionada = tabelaCaixa.getTabela().getSelectedRow();
		if (linhaSelecionada != -1) {
			caixaAux = modeloTabelaCaixa.getLinhas().get(linhaSelecionada);

			if (caixaAux.getTipo().equals("Compra")) {
				listaProdutos = new CompraDAO().pesquisaData(caixaAux.getDia(), caixaAux.getMes(), caixaAux.getAno(),
						caixaAux.getHora());
				modeloTabelaProduto.setLinhas(listaProdutos);
				modeloTabelaProduto.fireTableDataChanged();

			} else if (caixaAux.getTipo().equals("Venda")) {
				listaProdutos = new VendaDAO().pesquisaData(caixaAux.getDia(), caixaAux.getMes(), caixaAux.getAno(),
						caixaAux.getHora());
				modeloTabelaProduto.setLinhas(listaProdutos);
				modeloTabelaProduto.fireTableDataChanged();

			} else {
				listaProdutos.clear();
				modeloTabelaProduto.setLinhas(listaProdutos);
				modeloTabelaProduto.fireTableDataChanged();
			}

		}

	}

	// =========================================================================================================

	public void atualizarTabelaCaixa() {
		modeloTabelaCaixa.setLinhas(new CaixaDAO().listar());
		modeloTabelaCaixa.fireTableDataChanged();
	}

	private String formatarPreco(BigDecimal valor) {
		DecimalFormat formato = new DecimalFormat("0.00");
		formato.setRoundingMode(RoundingMode.FLOOR);
		return formato.format(valor);
	}

	public void atualizarCaixaAtual() {
		CaixaDAO cdao = new CaixaDAO();
		BigDecimal caixaAtual = cdao.ultimoRegistro() != null ? cdao.ultimoRegistro().getValor_atual()
				: new BigDecimal("0.00");
		valorAtual.setText("R$ " + formatarPreco(caixaAtual));
	}

	private void limparCampos() {
		saque.setText("");
		deposito.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == sacar && !saque.getText().equals("") && !deposito.getText().equals(",")) {
					
			CaixaDAO cdao = new CaixaDAO();
			BigDecimal caixaAtual = cdao.ultimoRegistro() != null ? 
					cdao.ultimoRegistro().getValor_atual() : new BigDecimal("0.00");
			BigDecimal saqueTotal = new BigDecimal(saque.getText().replace(",", "."));
			BigDecimal novoCaixaAtual = caixaAtual.subtract(saqueTotal);
			
			Data d = new Data();
			Caixa c = new Caixa();
			c.setValor_atual(novoCaixaAtual);
			c.setMovimentacao(saqueTotal);
			c.setTipo("Saque");
			c.setDia(d.getDia());
			c.setMes(d.getMes());
			c.setAno(d.getAno());
			c.setHora(d.getHora());
			cdao.cadastrar(c);			
			atualizarTabelaCaixa();				
			atualizarCaixaAtual();
			limparCampos();		
			
		} else if (e.getSource() == depositar && !deposito.getText().equals("") && !deposito.getText().equals(",")) {
			
			CaixaDAO cdao = new CaixaDAO();
			BigDecimal caixaAtual = cdao.ultimoRegistro() != null ? 
					cdao.ultimoRegistro().getValor_atual() : new BigDecimal("0.00");
			BigDecimal depositoTotal = new BigDecimal(deposito.getText().replace(",", "."));
			BigDecimal novoCaixaAtual = caixaAtual.add(depositoTotal);
			
			Data d = new Data();
			Caixa c = new Caixa();
			c.setValor_atual(novoCaixaAtual);
			c.setMovimentacao(depositoTotal);
			c.setTipo("Depósito");
			c.setDia(d.getDia());
			c.setMes(d.getMes());
			c.setAno(d.getAno());
			c.setHora(d.getHora());
			cdao.cadastrar(c);			
			atualizarTabelaCaixa();	
			atualizarCaixaAtual();
			limparCampos();		
			
			
		} else if (e.getSource() == pesquisar || e.getSource() == dia || e.getSource() == mes || e.getSource() == ano) {

			listaCaixa = new CaixaDAO().pesquisaData(dia.getText(), mes.getText(), ano.getText());
			modeloTabelaCaixa.setLinhas(listaCaixa);
			modeloTabelaCaixa.fireTableDataChanged();

		}

	}

}
