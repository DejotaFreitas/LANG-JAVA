package trabalho.pilhaAtendimentos;

import trabalho.operacoes.CaixaNormal;
import trabalho.operacoes.CaixaRapido;
import trabalho.operacoes.Gestante;
import trabalho.operacoes.Idoso;
import trabalho.operacoes.Operacao;

public class Atendimento {

	private Operacao operacao;
	private long tempoEspera;

	// Construtor
	public Atendimento(Operacao operacao, long tempoEspera) {
		this.operacao = operacao;
		this.tempoEspera = tempoEspera;
	}

	//get e set
	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public double getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(long tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	/**
	 * Verificae retorna uma string com a categoria da operação
	 * 
	 * @param operacao
	 * @return Texto correspondente a prioridade da operação
	 */
	public String getPrioridade(Operacao operacao) {
		String prioridade = "";
		if (operacao instanceof Gestante) {
			prioridade = "Gestante";
		} else if (operacao instanceof Idoso) {
			prioridade = "Idoso";
		} else if (operacao instanceof CaixaRapido) {
			prioridade = "CaixaRapido";
		} else if (operacao instanceof CaixaNormal) {
			prioridade = "CaixaNormal";
		}
		return prioridade;
	}

	public String toString() {
		return "Operacão: " + this.operacao + 
			" - Prioridade: " + getPrioridade(this.operacao) +
			" - Tempo de Espera: "+ tempoEspera + " segundos";
	}

}
