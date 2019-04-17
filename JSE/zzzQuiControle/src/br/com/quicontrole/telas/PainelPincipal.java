package br.com.quicontrole.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.quicontrole.Inicializar;
import br.com.quicontrole.conexao.Conexao;
import br.com.quicontrole.telas.cadastro.Cadastro;
import br.com.quicontrole.telas.caixa.CaixaPainel;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.Cor;
import br.com.quicontrole.telas.componentes.Painel;
import br.com.quicontrole.telas.compra.CompraPainel;
import br.com.quicontrole.telas.relatorios.RelatorioPainel;
import br.com.quicontrole.telas.venda.VendaPainel;


public class PainelPincipal extends Painel implements ActionListener {
	private static final long serialVersionUID = 1834919923718292245L;
	
	private Botao vendaB;
	private Botao cadastroB;
	private Botao compraB;
	private Botao caixaB;
	private Botao relatorioB;
	private Botao minimizarB;
	private Botao exitB;

	private static JPanel painelAtual;

	// CONSTRUTOR
	public PainelPincipal() {
		this.setBackground(Cor.AZUL_FUNDO);

		// Botoes
		vendaB = new Botao("Vendas");
		cadastroB = new Botao("Cadastros");
		compraB = new Botao("Compras");
		caixaB = new Botao("Caixa");
		relatorioB = new Botao("Relatórios");
		minimizarB = new Botao("-");
		exitB = new Botao("x");
		
		//eventos
		vendaB.addActionListener(this);
		compraB.addActionListener(this);
		cadastroB.addActionListener(this);
		caixaB.addActionListener(this);
		relatorioB.addActionListener(this);
		minimizarB.addActionListener(this);
		exitB.addActionListener(this);		
		
		setPainelAtual(new VendaPainel());

		//organizando componentes
		Janela.addComponente(0, 0, 1, 1, 1, 0, this, vendaB);
		Janela.addComponente(0, 1, 1, 1, 1, 0, this, compraB);
		Janela.addComponente(0, 2, 1, 1, 1, 0, this, cadastroB);
		Janela.addComponente(0, 3, 1, 1, 1, 0, this, caixaB);
		Janela.addComponente(0, 4, 1, 1, 1, 0, this, relatorioB);
		
		Janela.addComponente(0, 5, 1, 1, 0, 0, this, minimizarB);
		Janela.addComponente(0, 6, 1, 1, 0, 0, this, exitB);

		Janela.addComponente10(1, 0, 7, 7, 1, 1, this, getPainelAtual());
		
		
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vendaB) {
			atualizarPainel(new VendaPainel());
			
		} else if (e.getSource() == compraB) {
			atualizarPainel(new CompraPainel());
		
		} else if (e.getSource() == cadastroB) {
			atualizarPainel(new Cadastro());
			
		} else if (e.getSource() == caixaB) {
			atualizarPainel(new CaixaPainel());
			
		} else if (e.getSource() == relatorioB) {
			atualizarPainel(new RelatorioPainel());		
			
		} else if (e.getSource() == minimizarB) {			
			Inicializar.getJanela().setExtendedState(JFrame.ICONIFIED);		

		} else if (e.getSource() == exitB) {
			//int r =Msg.msn("Realmente deseja sair do QuiControle ?", "Sair");
			//if (r == 0){
			Conexao.desligarBandoDados();
			System.exit(0);
			//}

		}		

	}

	// ================================================================================

	private void atualizarPainel(JPanel painel) {
		getPainelAtual().setVisible(false);
		setPainelAtual(painel);
		getPainelAtual().setVisible(true);
		Janela.addComponente10(1, 0, 7, 7, 1, 1, this, getPainelAtual());
	}
	
	// ================================================================================

	public static JPanel getPainelAtual() {
		return painelAtual;
	}

	public static void setPainelAtual(JPanel painelAtual) {
		PainelPincipal.painelAtual = painelAtual;
	}

	
	
}
