package br.com.quicontrole.telas.cadastro.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.quicontrole.dao.ClienteDAO;
import br.com.quicontrole.entidades.Cliente;
import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.CaixaCombo;
import br.com.quicontrole.telas.componentes.CampoTexto;
import br.com.quicontrole.telas.componentes.Msg;
import br.com.quicontrole.telas.componentes.Painel;
import br.com.quicontrole.telas.componentes.TabelaScroll;
import br.com.quicontrole.telas.componentes.Texto;

public class CadastroCliente extends Painel implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = -4669569019266700408L;

	private Texto cadastroCliente;
	private Texto nome;
	private CampoTexto nome2;
	private Texto cpf;
	private CampoTexto cpf2;
	private Texto telefone;
	private CampoTexto telefone2;
	private Texto email;
	private CampoTexto email2;
	private Texto endereco;
	private CampoTexto endereco2;
	private Texto descricao;
	private CampoTexto descricao2;
	private Botao cadastrar;
	private Botao alterar;
	private Botao excluir;
	private Botao limpar;
	private CampoTexto pesquisa;
	private Botao pesquisar;
	private ArrayList<Object> tipoPesquisaLista;
	private CaixaCombo tipoPesquisa;
	private TabelaScroll tabela;
	private ModeloTabelaCliente modelotabela;

	public CadastroCliente() {
		cadastroCliente = new Texto("Cadastrar do Cliente", 20);
		nome = new Texto("Nome");
		nome2 = new CampoTexto("Nome do Cliente",50);
		cpf = new Texto("CPF");
		cpf2 = new CampoTexto("CPF do Cliente",20);
		telefone = new Texto("Telefone ");
		telefone2 = new CampoTexto("Telefone do Cliente", 20);
		email = new Texto("Email");
		email2 = new CampoTexto("Email do Cliente", 50);
		endereco = new Texto("Endereço");
		endereco2 = new CampoTexto("Estado, Cidade, Bairro, Endereço, Nº do Fornecedo", 255);
		descricao = new Texto("Descricão");
		descricao2 = new CampoTexto("Descricão do Cliente", 255);
		cadastrar = new Botao("Cadastrar");
		alterar = new Botao("Alterar");
		excluir = new Botao("Excluir");
		limpar = new Botao("Limpar");
		pesquisa = new CampoTexto("Escolha a categoria e pesquise...");
		pesquisar = new Botao("Pesquisar");
		tipoPesquisaLista = new ArrayList<>();
		tipoPesquisaLista.add("Nome");
		tipoPesquisa = new CaixaCombo(tipoPesquisaLista);
		modelotabela = new ModeloTabelaCliente(new ClienteDAO().listar());
		tabela = new TabelaScroll(modelotabela);

		// ================================================================================
		Janela.addComponente(0, 0, 10, 1, 1, 0, this, cadastroCliente, 1, 1, 10, 1);

		Janela.addComponente(2, 0, 1, 1, 0, 0, this, nome, 1, 1, 1, 1);
		Janela.addComponente(2, 2, 1, 1, 0, 0, this, cpf, 1, 1, 1, 1);
		Janela.addComponente(2, 4, 1, 1, 0, 0, this, telefone, 1, 1, 1, 1);
		Janela.addComponente(3, 0, 1, 1, 0, 0, this, email, 1, 1, 1, 1);
		Janela.addComponente(3, 2, 1, 1, 0, 0, this, endereco, 1, 1, 1, 1);
		Janela.addComponente(3, 4, 1, 1, 0, 0, this, descricao, 1, 1, 1, 1);

		Janela.addComponente(2, 1, 1, 1, 1, 0, this, nome2, 1, 1, 1, 1);
		Janela.addComponente(2, 3, 1, 1, 1, 0, this, cpf2, 1, 1, 1, 1);
		Janela.addComponente(2, 5, 1, 1, 1, 0, this, telefone2, 1, 1, 1, 1);
		Janela.addComponente(3, 1, 1, 1, 1, 0, this, email2, 1, 1, 1, 1);
		Janela.addComponente(3, 3, 1, 1, 1, 0, this, endereco2, 1, 1, 1, 1);
		Janela.addComponente(3, 5, 1, 1, 1, 0, this, descricao2, 1, 1, 1, 1);

		Janela.addComponente(2, 6, 1, 1, 0, 0, this, cadastrar, 1, 1, 1, 1);
		Janela.addComponente(3, 6, 1, 1, 0, 0, this, alterar, 1, 1, 1, 1);
		Janela.addComponente(2, 7, 1, 1, 0, 0, this, limpar, 1, 1, 1, 1);
		Janela.addComponente(3, 7, 1, 1, 0, 0, this, excluir, 1, 1, 1, 1);

		Janela.addComponente(10, 0, 10, 1, 1, 1, this, tabela, 10, 1, 1, 1);

		Janela.addComponente(11, 0, 1, 1, 0, 0, this, tipoPesquisa, 1, 1, 1, 1);
		Janela.addComponente(11, 1, 6, 1, 1, 0, this, pesquisa, 1, 1, 1, 1);
		Janela.addComponente(11, 7, 1, 1, 0, 0, this, pesquisar, 1, 1, 1, 1);


		//===============================================================
		cadastrar.addActionListener(this);
		limpar.addActionListener(this);
		alterar.addActionListener(this);
		excluir.addActionListener(this);
		pesquisa.addActionListener(this);
		pesquisar.addActionListener(this);
		tabela.getTabela().getSelectionModel().addListSelectionListener(this);
	}

	private static Cliente clienteAux;

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linhaSelecionada = tabela.getTabela().getSelectedRow();
		if (linhaSelecionada != -1) {
			Cliente c = modelotabela.getLinhas().get(linhaSelecionada);
			nome2.setText(c.getNome());
			cpf2.setText(c.getCpf());
			telefone2.setText(c.getTelefone());
			email2.setText(c.getEmail());
			endereco2.setText(c.getEndereco());
			descricao2.setText(c.getDescricao());
			clienteAux = c;
		}

	}

	private void atualizarTabela() {
		modelotabela.setLinhas(new ClienteDAO().listar());
		modelotabela.fireTableDataChanged();
	}

	private void limparCampos() {
		nome2.setText("");
		cpf2.setText("");
		telefone2.setText("");
		email2.setText("");
		endereco2.setText("");
		descricao2.setText("");
		clienteAux = null;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cadastrar) {
			if (!nome2.getText().equals("")) {
				Cliente f = new Cliente();				
				f.setNome(nome2.getText());
				f.setCpf(cpf2.getText());
				f.setTelefone(telefone2.getText());
				f.setEmail(email2.getText());				
				f.setEndereco(endereco2.getText());
				f.setDescricao(descricao2.getText());
				new ClienteDAO().cadastrar(f);
				limparCampos();
				atualizarTabela();
			}else{
				Msg.m("Insira valores no campo 'Nome'.");
			}
			
			
		} else if (e.getSource() == alterar) {

			if (clienteAux != null) {
				if (!nome2.getText().equals("")) {
					Cliente f = clienteAux;				
					f.setNome(nome2.getText());
					f.setCpf(cpf2.getText());
					f.setTelefone(telefone2.getText());
					f.setEmail(email2.getText());				
					f.setEndereco(endereco2.getText());
					f.setDescricao(descricao2.getText());
					new ClienteDAO().alterar(f);
					limparCampos();	
					atualizarTabela();
				}else{
					Msg.m("Insira valores no campo 'Nome'.");
				}
			} else {
				Msg.m("Selecione o produto que deseja alterar.");
			}

		} else if (e.getSource() == excluir) {

			if (clienteAux != null) {
				int r = Msg.msn("Excluir " + clienteAux.getNome() + " ?", "Excluir Produto");
				if (r == 0) {
					new ClienteDAO().excluir(clienteAux);
					atualizarTabela();
					limparCampos();

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
				modelotabela.setLinhas(new ClienteDAO().pesquisarNome(pesquisa.getText()));
				modelotabela.fireTableDataChanged();
				break;

			default:
				break;
			}

		}

	}

}
