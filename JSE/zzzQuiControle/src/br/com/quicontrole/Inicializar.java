package br.com.quicontrole;

import br.com.quicontrole.conexao.BancoDeDadosNaoRelacional;
import br.com.quicontrole.telas.Janela;

public class Inicializar {
	private static Janela janela;

	public static void main(String[] args) {
		BancoDeDadosNaoRelacional.createAllTable();
		janela = new Janela();
	}
	
	
	public static Janela getJanela() {
		return janela;
	}

}
