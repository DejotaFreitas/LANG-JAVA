package trabalho.filaDePrioridades;

import trabalho.excecoes.FilaVazia;
import trabalho.excecoes.FuraoNaFila;
import trabalho.imprimivel.CentralDeImpressao;
import trabalho.imprimivel.Imprimivel;
import trabalho.operacoes.CaixaNormal;
import trabalho.operacoes.CaixaRapido;
import trabalho.operacoes.Gestante;
import trabalho.operacoes.Idoso;
import trabalho.operacoes.Operacao;
import trabalho.pilhaAtendimentos.Atendimento;
import trabalho.pilhaAtendimentos.PilhaAtendimentos;

public class FilaDePrioridades implements Fila, Imprimivel {
	
	//Sentinelas
	private final NoPrioridade inicio;
	private final NoPrioridade fim;
	//Tamanho da fila
	private int tamanho;
	//Pilha para guardar todos que foram desinfilherados (atendidos)
	private PilhaAtendimentos atendidos;
	//Objeto para guardar a o valor e quantidade de multas
	private Multa multas;

	//Construtor
	public FilaDePrioridades() {
		//Instanciando e iniciando os sentielas
		inicio = new NoPrioridade(null, null);
		fim = new NoPrioridade(inicio, null);
		inicio.setProximo(fim);
		//Instanciando a pilha de pessoas que ja foram atendidas
		atendidos = new PilhaAtendimentos();
		//Instanciando a variavel multa
		multas = new Multa();
	}

	/**
	 * Adiciona a operação na fila e aloca na posição correspondete a sua prioridade 
	 * @param operacao
	 */
	public void enfilheirar(Operacao operacao) {
		try {
			//checkPrioridade vai verificar e retorna a prioridade da operação
			//se for um Furão é lançado uma exceção 
			int prioridade = checkPrioridade(operacao);
			//guardar o ultimo da em uma variavel auxiliar
			NoPrioridade aux = fim.getAnterior();
			//verificar a prioridade e percorrer ate chegar na posição correta
			while (prioridade < aux.getPrioridade()) {
				aux = aux.getAnterior();
			}
			//criando o no e definindo os atributos no construtor
			//contrutor (anterior, proximo, operacao, prioridade, momentoMilissegundos)
			NoPrioridade novo = new NoPrioridade(aux, aux.getProximo(), 
					operacao, prioridade,	System.currentTimeMillis());
			//ligando a fila ao novo nó
			aux.getProximo().setAnterior(novo);
			aux.setProximo(novo);
			//incrementando tamanho da fila
			tamanho++;
		} catch (FuraoNaFila e) {
			e.printStackTrace();
		}

	}

	/**
	 *Verificar a operação e retorna a sua prioridade	 
	 * @param operacao
	 * @return Interio correspondente a prioridade da operação
	 * @throws FuraoNaFila será lançada se um furão tentar entrar na fila 
	 */
	public int checkPrioridade(Operacao operacao) throws FuraoNaFila {
		if (operacao instanceof Gestante) {
			return 1;
		} else if (operacao instanceof Idoso) {
			return 2;
		} else if (operacao instanceof CaixaRapido) {
			return 3;
		} else if (operacao instanceof CaixaNormal) {
			return 4;
		} else {
			throw new FuraoNaFila("Furão na fila");
		}		
	}
	
	/**
	 * Remove a operação na da fila
	 * verifica se passou mais de 15 segundos na fila 
	 * e aplicar a multa ao banco
	 * @return Operação removida da vila
	 * @throws FilaVazia será lançada essa exceção se tentar remover de uma fila vazia
	 */
	public Operacao desinfileirar() throws FilaVazia {		
		if (!isEmpty()) {
			//definir o tempo final do obejto que vai ser removido da fila
			inicio.getProximo().setTempoFinal(System.currentTimeMillis());
			//pegar tempo em segundos do nó que sera removido
			long tempoEspera = tempoNaFila(inicio.getProximo());
			//verificar se esperou mais de 15 segundos
			if (tempoEspera > 15) {
				//aplicando multa
				multas.addMulta();
			}
			//guardando o primeiro da fila emuma variavel temporaria
			Operacao temp = inicio.getProximo().getOperacao();
			//adicionando a operacao removida a pilha de relatorio
			atendidos.add(new Atendimento(temp, tempoEspera));
			//removendo o primeiro da fila
			inicio.getProximo().getProximo().setAnterior(inicio);
			inicio.setProximo(inicio.getProximo().getProximo());
			//decremmentando tamanho da fila
			tamanho--;
			return temp;
		} else {
			//lançando exceção caso tente remover elemento de uma fila vazia
			throw new FilaVazia("Fila Vazia");
		}
	}
	
	
	/**
	 * Calcula o tempo final menos o inicial defindos no nó 
	 * e transforma em segundos
	 * @param noPrioridade
	 * @return tempo em segundos(long)
	 */
	private long tempoNaFila(NoPrioridade noPrioridade){
		return (noPrioridade.getTempoFinal()-noPrioridade.getTempoInicial())/1000;
	}
	
	/**
	 * Retorna a primeira elemento da fila
	 * @return operacao
	 */
	public Operacao frente() {
		return inicio.getProximo().getOperacao();
	}

	/**
	 * Verifica se a fila está vazia
	 */
	public boolean isEmpty() {
		return tamanho == 0;
	}

	/**
	 * retorna o tamanho da fila
	 */
	public int size() {
		return tamanho;
	}

	/**
	 * Imprime a fila
	 */
	public void imprimir() {
		if (!isEmpty()) {
			NoPrioridade aux = inicio.getProximo();
			for (int i = 0; i < tamanho; i++) {
				System.out.println((i+1) + "º " + aux.getOperacao() + " - Prioridade " + aux.getPrioridade() + " - Tempo na fila: " + (System.currentTimeMillis()-aux.getTempoInicial())/1000 + " segundos.");
				aux = aux.getProximo();
			}	
		} else {
			System.out.println("Fila vazia.");
		}
		
	}
	
	/**
	 * Imprime o relatorio de todos que ja foram atendidos
	 */
	public void relatorioDeAtendimentos(){
		CentralDeImpressao.impimir(this.atendidos);
	}
	
	/**
	 * Imprime o relatorios de quantidade e valor atual da multa ao banco
	 */
	public void relatorioDeMultas(){
		CentralDeImpressao.impimir(this.multas);
	}

}
