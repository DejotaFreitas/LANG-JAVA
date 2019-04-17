package trabalho.filaDePrioridades;

import trabalho.excecoes.FilaVazia;
import trabalho.operacoes.Operacao;

public interface Fila {
	
	void enfilheirar(Operacao operacao);	
	Operacao desinfileirar() throws FilaVazia;
	Operacao frente();
	boolean isEmpty();
	int size();

}
