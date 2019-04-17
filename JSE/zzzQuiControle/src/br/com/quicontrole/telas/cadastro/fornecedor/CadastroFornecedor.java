package br.com.quicontrole.telas.cadastro.fornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.quicontrole.dao.FornecedorDAO;
import br.com.quicontrole.entidades.Fornecedor;
import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.CaixaCombo;
import br.com.quicontrole.telas.componentes.CaixaMarcar;
import br.com.quicontrole.telas.componentes.CampoTexto;
import br.com.quicontrole.telas.componentes.Msg;
import br.com.quicontrole.telas.componentes.Painel;
import br.com.quicontrole.telas.componentes.TabelaScroll;
import br.com.quicontrole.telas.componentes.Texto;

public class CadastroFornecedor extends Painel implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = -4669569019266700408L;

	private Texto cadastroFornecedor;
	private Texto nome;
	private CampoTexto nome2;
	private Texto cnpj;
	private CampoTexto cnpj2;
	private Texto cpf;
	private CampoTexto cpf2;
	private Texto razaosocial;
	private CampoTexto razaoSocial2;
	private Texto escricaoEstadural;
	private CampoTexto inscricaoEstadural2;
	private Texto escricaoMunicipal;
	private CampoTexto inscricaoMunicipal2;
	private Texto telefone;
	private CampoTexto telefone2;
	private Texto email;
	private CampoTexto email2;
	private Texto endereco;
	private CampoTexto endereco2;
	private Texto descricao;
	private CampoTexto descricao2;
	private Texto desativado;
	private CaixaMarcar desativado2;
	private Botao cadastrar;
	private Botao alterar;
	private Botao excluir;
	private Botao limpar;
	private CampoTexto pesquisa;
	private Botao pesquisar;
	private ArrayList<Object> tipoPesquisaLista;
	private CaixaCombo tipoPesquisa;
	private TabelaScroll tabela;
	private ModeloTabelaFornecedor modelotabela;

	public CadastroFornecedor() {
		cadastroFornecedor = new Texto("Cadastrar Fornecedor", 20);
		nome = new Texto("Nome");
		nome2 = new CampoTexto("Nome do Fornecedor",50);
		cnpj = new Texto("CNPJ");
		cnpj2 = new CampoTexto("CNPJ do Fornecedor",20);
		cpf = new Texto("CPF");
		cpf2 = new CampoTexto("CPF, caso especial",20);
		razaosocial = new Texto("Razão Social");
		razaoSocial2 = new CampoTexto("Razão Social do Fornecedor", 100);
		escricaoEstadural = new Texto("Inscrição Estadual");
		inscricaoEstadural2 = new CampoTexto("Inscrição Estadualdo Fornecedor",20);
		escricaoMunicipal = new Texto("Inscrição Municipal");
		inscricaoMunicipal2 = new CampoTexto("Inscrição Municipal do Fornecedor", 20);
		telefone = new Texto("Telefone ");
		telefone2 = new CampoTexto("Telefone do Fornecedor", 20);
		email = new Texto("Email");
		email2 = new CampoTexto("Email do Fornecedor", 50);
		endereco = new Texto("Endereço");
		endereco2 = new CampoTexto("Estado, Cidade, Bairro, Endereço, Nº do Fornecedo", 255);
		descricao = new Texto("Descricão");
		descricao2 = new CampoTexto("Descricão do Fornecedor", 255);
		desativado = new Texto("Desativar Fornecedor");
		desativado2 = new CaixaMarcar("Ocultar");
		cadastrar = new Botao("Cadastrar");
		alterar = new Botao("Alterar");
		excluir = new Botao("Excluir");
		limpar = new Botao("Limpar");
		pesquisa = new CampoTexto("Escolha a categoria e pesquise...");
		pesquisar = new Botao("Pesquisar");
		tipoPesquisaLista = new ArrayList<>();
		tipoPesquisaLista.add("Nome");
		tipoPesquisa = new CaixaCombo(tipoPesquisaLista);
		modelotabela = new ModeloTabelaFornecedor(new FornecedorDAO().listar());
		tabela = new TabelaScroll(modelotabela);

		// ================================================================================
		Janela.addComponente(0, 0, 10, 1, 1, 0, this, cadastroFornecedor, 1, 1, 10, 1);

		Janela.addComponente(2, 0, 1, 1, 0, 0, this, nome, 1, 1, 1, 1);
		Janela.addComponente(2, 2, 1, 1, 0, 0, this, cnpj, 1, 1, 1, 1);
		Janela.addComponente(2, 4, 1, 1, 0, 0, this, cpf, 1, 1, 1, 1);
		Janela.addComponente(3, 0, 1, 1, 0, 0, this, razaosocial, 1, 1, 1, 1);
		Janela.addComponente(3, 2, 1, 1, 0, 0, this, escricaoEstadural, 1, 1, 1, 1);
		Janela.addComponente(3, 4, 1, 1, 0, 0, this, escricaoMunicipal, 1, 1, 1, 1);
		Janela.addComponente(4, 0, 1, 1, 0, 0, this, telefone, 1, 1, 1, 1);
		Janela.addComponente(4, 2, 1, 1, 0, 0, this, email, 1, 1, 1, 1);
		Janela.addComponente(4, 4, 1, 1, 0, 0, this, endereco, 1, 1, 1, 1);
		Janela.addComponente(5, 0, 1, 1, 0, 0, this, descricao, 1, 1, 1, 1);
		Janela.addComponente(5, 4, 1, 1, 0, 0, this, desativado, 1, 1, 1, 1);

		Janela.addComponente(2, 1, 1, 1, 1, 0, this, nome2, 1, 1, 1, 1);
		Janela.addComponente(2, 3, 1, 1, 1, 0, this, cnpj2, 1, 1, 1, 1);
		Janela.addComponente(2, 5, 1, 1, 1, 0, this, cpf2, 1, 1, 1, 1);
		Janela.addComponente(3, 1, 1, 1, 1, 0, this, razaoSocial2, 1, 1, 1, 1);
		Janela.addComponente(3, 3, 1, 1, 1, 0, this, inscricaoEstadural2, 1, 1, 1, 1);
		Janela.addComponente(3, 5, 1, 1, 1, 0, this, inscricaoMunicipal2, 1, 1, 1, 1);
		Janela.addComponente(4, 1, 1, 1, 1, 0, this, telefone2, 1, 1, 1, 1);
		Janela.addComponente(4, 3, 1, 1, 1, 0, this, email2, 1, 1, 1, 1);
		Janela.addComponente(4, 5, 1, 1, 1, 0, this, endereco2, 1, 1, 1, 1);
		Janela.addComponente(5, 1, 3, 1, 1, 0, this, descricao2, 1, 1, 1, 1);
		Janela.addComponente(5, 5, 1, 1, 1, 0, this, desativado2, 1, 1, 1, 1);

		Janela.addComponente(2, 6, 1, 1, 0, 0, this, cadastrar, 1, 1, 1, 1);
		Janela.addComponente(3, 6, 1, 1, 0, 0, this, alterar, 1, 1, 1, 1);
		Janela.addComponente(4, 6, 1, 1, 0, 0, this, limpar, 1, 1, 1, 1);
		Janela.addComponente(5, 6, 1, 1, 0, 0, this, excluir, 1, 1, 1, 1);

		Janela.addComponente(10, 0, 10, 1, 1, 1, this, tabela, 10, 1, 1, 1);

		Janela.addComponente(11, 0, 1, 1, 0, 0, this, tipoPesquisa, 1, 1, 1, 1);
		Janela.addComponente(11, 1, 5, 1, 1, 0, this, pesquisa, 1, 1, 1, 1);
		Janela.addComponente(11, 6, 1, 1, 0, 0, this, pesquisar, 1, 1, 1, 1);

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

	private static Fornecedor fornecedorAux;

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linhaSelecionada = tabela.getTabela().getSelectedRow();
		if (linhaSelecionada != -1) {
			Fornecedor f = modelotabela.getLinhas().get(linhaSelecionada);
			nome2.setText(f.getNome());
			cnpj2.setText(f.getCnpj());
			cpf2.setText(f.getCpf());
			razaoSocial2.setText(f.getRazao_social());
			inscricaoEstadural2.setText(f.getInscricao_estadual());
			inscricaoMunicipal2.setText(f.getInscricao_municipal());
			telefone2.setText(f.getTelefone());
			email2.setText(f.getEmail());
			endereco2.setText(f.getEndereco());
			descricao2.setText(f.getDescricao());
			desativado2.setSelected(f.getDesativado());
			fornecedorAux = f;
		}

	}

	private void atualizarTabela() {
		modelotabela.setLinhas(new FornecedorDAO().listar());
		modelotabela.fireTableDataChanged();
	}

	private void limparCampos() {
		nome2.setText("");
		cnpj2.setText("");
		cpf2.setText("");
		razaoSocial2.setText("");
		inscricaoEstadural2.setText("");
		inscricaoMunicipal2.setText("");
		telefone2.setText("");
		email2.setText("");
		endereco2.setText("");
		descricao2.setText("");
		desativado2.setSelected(false);
		fornecedorAux = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cadastrar) {
			if (!nome2.getText().equals("")) {
				Fornecedor f = new Fornecedor();				
				f.setNome(nome2.getText());
				f.setRazao_social(razaoSocial2.getText());
				f.setCnpj(cnpj2.getText());
				f.setCpf(cpf2.getText());
				f.setInscricao_estadual(inscricaoEstadural2.getText());
				f.setInscricao_municipal(inscricaoMunicipal2.getText());
				f.setTelefone(telefone2.getText());
				f.setEmail(email2.getText());				
				f.setEndereco(endereco2.getText());
				f.setDescricao(descricao2.getText());
				f.setDesativado(desativado2.isSelected());
				new FornecedorDAO().cadastrar(f);
				limparCampos();
				atualizarTabela();
			}else{
				Msg.m("Insira valores no campo 'Nome'.");
			}
			
		} else if (e.getSource() == alterar) {

			if (fornecedorAux != null) {
				if (!nome2.getText().equals("")) {
					Fornecedor f = fornecedorAux;				
					f.setNome(nome2.getText());
					f.setRazao_social(razaoSocial2.getText());
					f.setCnpj(cnpj2.getText());
					f.setCpf(cpf2.getText());
					f.setInscricao_estadual(inscricaoEstadural2.getText());
					f.setInscricao_municipal(inscricaoMunicipal2.getText());
					f.setTelefone(telefone2.getText());
					f.setEmail(email2.getText());				
					f.setEndereco(endereco2.getText());
					f.setDescricao(descricao2.getText());
					f.setDesativado(desativado2.isSelected());
					new FornecedorDAO().alterar(f);
					limparCampos();	
					atualizarTabela();	
				}else{
					Msg.m("Insira valores no campo 'Nome'.");
				}
			} else {
				Msg.m("Selecione o produto que deseja alterar.");
			}

		} else if (e.getSource() == excluir) {

			if (fornecedorAux != null) {
				int r = Msg.msn("Excluir " + fornecedorAux.getNome() + " ?", "Excluir Produto");
				if (r == 0) {
					new FornecedorDAO().excluir(fornecedorAux);
					limparCampos();
					atualizarTabela();
				}
			} else {
				Msg.m("Selecione o fornecedor que deseja excluir.");
			}

		} else if (e.getSource() == limpar) {
			limparCampos();
			modelotabela.fireTableDataChanged();

		} else if (e.getSource() == pesquisar || e.getSource() == pesquisa) {

			switch (tipoPesquisa.getSelectedIndex()) {
			case 0:
				modelotabela.setLinhas(new FornecedorDAO().pesquisarNome(pesquisa.getText()));
				modelotabela.fireTableDataChanged();
				break;

			default:
				break;
			}

		}

	}

}
