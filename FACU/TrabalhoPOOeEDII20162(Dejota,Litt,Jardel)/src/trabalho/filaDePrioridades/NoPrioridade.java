package trabalho.filaDePrioridades;

import trabalho.operacoes.Operacao;

public class NoPrioridade {

	private NoPrioridade anterior;
	private NoPrioridade proximo;
	private Operacao operacao;
	private int prioridade;
	private long tempoInicial;
	private long tempoFinal;
	
	//construtor simples para tirar o rancor do Java
	public NoPrioridade() {	}

	//construtor para criar as sentinelas da fila encadeada
	public NoPrioridade(NoPrioridade anterior, NoPrioridade proximo) {
		this.anterior = anterior;
		this.proximo = proximo;
	}

	//construtor com todos os atributos, exceto o tempoFinal
	public NoPrioridade(NoPrioridade anterior, NoPrioridade proximo, Operacao operacao,
			int prioridade,	long tempoInicial) {
		this.anterior = anterior;
		this.proximo = proximo;
		this.operacao = operacao;
		this.prioridade = prioridade;
		this.tempoInicial = tempoInicial;
	}

	//get e set
	
	public NoPrioridade getAnterior() {
		return anterior;
	}

	public void setAnterior(NoPrioridade anterior) {
		this.anterior = anterior;
	}

	public NoPrioridade getProximo() {
		return proximo;
	}

	public void setProximo(NoPrioridade proximo) {
		this.proximo = proximo;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public long getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(long tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public long getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(long tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

}
