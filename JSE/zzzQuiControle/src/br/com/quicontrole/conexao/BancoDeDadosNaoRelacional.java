package br.com.quicontrole.conexao;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDeDadosNaoRelacional {


	public static void createAllTable() {
		
		if(!tabelaExite("CLIENTE"))
		criarTabelaCliente();
		
		if(!tabelaExite("FORNECEDOR"))
		criarTabelaFornecedor();
		
		if(!tabelaExite("PRODUTO"))
		criarTabelaProduto();
		
		if(!tabelaExite("VENDA"))
		criarTabelaVenda();
		
		if(!tabelaExite("COMPRA"))
		criarTabelaCompra();
		
		if(!tabelaExite("CAIXA"))
		criarTabelaCaixa();		

	}
	
	public static boolean tabelaExite(String nomeTabela){
		try {
			DatabaseMetaData metadados = Conexao.conectar().getMetaData();
			ResultSet tabela = metadados.getTables(null, null, nomeTabela, null);
			return tabela.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

		public static void executar(String sql) {
		try (PreparedStatement stmt = Conexao.conectar().prepareStatement(sql)) {
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// Msg.msg("Erro executar sql" +e.getMessage());
			 e.printStackTrace();
		}
	}

	public static void criarTabelaCliente() {
		StringBuilder sqls = new StringBuilder();
		sqls.append("CREATE TABLE CLIENTE( ");
		sqls.append("id_cliente INTEGER NOT NULL GENERATED ALWAYS AS ");
		sqls.append("IDENTITY (START WITH 1, INCREMENT BY 1), ");

		sqls.append("nome VARCHAR(50) NOT NULL, ");
		sqls.append("cpf VARCHAR(20), ");
		sqls.append("telefone VARCHAR(20), ");
		sqls.append("email VARCHAR(50), ");
		sqls.append("endereco VARCHAR(255), ");
		sqls.append("descricao VARCHAR(255) ");

		sqls.append(")");

		executar(sqls.toString());
	}
	
	
	public static void criarTabelaFornecedor() {
		StringBuilder sqls = new StringBuilder();
		sqls.append("CREATE TABLE FORNECEDOR( ");
		sqls.append("id_fornecedor INTEGER NOT NULL GENERATED ALWAYS AS ");
		sqls.append("IDENTITY (START WITH 1, INCREMENT BY 1), ");

		sqls.append("nome VARCHAR(50) NOT NULL, ");
		sqls.append("razao_social VARCHAR(100), ");
		sqls.append("cnpj VARCHAR(20), ");
		sqls.append("cpf VARCHAR(20), ");
		sqls.append("inscricao_estadual VARCHAR(20), ");
		sqls.append("inscricao_municipal VARCHAR(20), ");

		sqls.append("telefone VARCHAR(20), ");
		sqls.append("email VARCHAR(50), ");
		sqls.append("endereco VARCHAR(255), ");
		sqls.append("desativado BOOLEAN, ");
		sqls.append("descricao VARCHAR(255) ");
		sqls.append(")");
		
		executar(sqls.toString());

	}

	public static void criarTabelaProduto() {
		StringBuilder sqls = new StringBuilder();
		sqls.append("CREATE TABLE PRODUTO( ");
		sqls.append("id_produto INTEGER NOT NULL GENERATED ALWAYS AS ");
		sqls.append("IDENTITY (START WITH 1, INCREMENT BY 1), ");

		sqls.append("nome VARCHAR(50) NOT NULL, ");
		sqls.append("codigo_barra VARCHAR(20) UNIQUE, ");
		sqls.append("quantidade INTEGER, ");		
		sqls.append("valor_compra DECIMAL(13,2), ");
		sqls.append("valor_venda DECIMAL(13,2), ");
		sqls.append("local_estoque VARCHAR(20), ");
		sqls.append("descricao VARCHAR(255), ");
		sqls.append("imagem BLOB, ");
		sqls.append("desativado BOOLEAN, ");
		sqls.append("fornecedor INTEGER ");
	
		sqls.append(")");

		executar(sqls.toString());
	}

	public static void criarTabelaVenda() {
		StringBuilder sqls = new StringBuilder();
		sqls.append("CREATE TABLE VENDA( ");
		sqls.append("id_venda INTEGER NOT NULL GENERATED ALWAYS AS ");
		sqls.append("IDENTITY (START WITH 1, INCREMENT BY 1), ");

		sqls.append("produto INTEGER, ");		
		sqls.append("quantidade INTEGER, ");
		sqls.append("valor_total DECIMAL(13,2), ");
		sqls.append("dia VARCHAR(20), ");
		sqls.append("mes VARCHAR(20), ");
		sqls.append("ano VARCHAR(20), ");
		sqls.append("hora VARCHAR(20) ");
		
		sqls.append(")");
		executar(sqls.toString());

	}

	public static void criarTabelaCompra() {
		StringBuilder sqls = new StringBuilder();
		sqls.append("CREATE TABLE COMPRA( ");
		sqls.append("id_compra INTEGER NOT NULL GENERATED ALWAYS AS ");
		sqls.append("IDENTITY (START WITH 1, INCREMENT BY 1), ");
		
		sqls.append("produto INTEGER, ");
		sqls.append("quantidade INTEGER, ");
		sqls.append("valor_total DECIMAL(13,2), ");
		sqls.append("dia VARCHAR(20), ");
		sqls.append("mes VARCHAR(20), ");
		sqls.append("ano VARCHAR(20), ");
		sqls.append("hora VARCHAR(20) ");
		
		sqls.append(")");

		executar(sqls.toString());
	}

	public static void criarTabelaCaixa() {
		StringBuilder sqls = new StringBuilder();
		sqls.append("CREATE TABLE CAIXA( ");
		sqls.append("id_caixa INTEGER NOT NULL GENERATED ALWAYS AS ");
		sqls.append("IDENTITY (START WITH 1, INCREMENT BY 1), ");

		sqls.append("valor_atual DECIMAL(13,2), ");
		sqls.append("movimentacao DECIMAL(13,2), ");//saida -200, entrada 200
		sqls.append("tipo VARCHAR(20), ");
		sqls.append("dia VARCHAR(20), ");
		sqls.append("mes VARCHAR(20), ");
		sqls.append("ano VARCHAR(20), ");
		sqls.append("hora VARCHAR(20) ");
		sqls.append(")");

		executar(sqls.toString());

	}



}