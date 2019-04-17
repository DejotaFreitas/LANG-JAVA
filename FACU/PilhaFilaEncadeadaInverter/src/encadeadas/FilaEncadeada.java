package encadeadas;

public class FilaEncadeada {
	private No ini;
	private No fim;
	private int tam;

	public FilaEncadeada() {
		ini = null;
		fim = null;
		tam = 0;
	}

	public void enfileirar(Object elemento) {
		// 1- Instanciar um objeto do tipo No
		No novoNo = new No();
		// 2- inserir o elemento no novoNo
		novoNo.setElemento(elemento);
		if (isEmpty()) {
			// se for o primeiro elemento, ele ser� p in�cio e o fim da fila
			ini = novoNo;
		} else {
			// 3- Ligar ou encadear o fim da fila ao novoNo
			fim.setProximo(novoNo);
		}
		// 4- Atualizar o novo final da fila
		fim = novoNo;
		// 5- Incrementar o tamanho
		tam++;
	}

	public Object desenfileirar() {
		if (!isEmpty()) {
			// 1- Armazenar o valor a ser removido
			Object temp = ini.getElemento();
			// 2- Atualizar o in�cio
			ini = ini.getProximo();
			// 3- Decrementar o tamanho
			tam--;
			if (isEmpty()) {
				fim = null;
			}
			// 4- retornar o valor armazenado em temp (removido)
			return temp;
		} else {
			System.out.println("Fila Vazia");
			return null;
		}
	}

	public Object frente() {
		if (!isEmpty()) {
			return ini.getElemento();
		} else {
			System.out.println("Fila Vazia");
			return null;
		}
	}

	public int size() {
		return tam;
	}

	public boolean isEmpty() {
		return tam == 0;
	}

	public void imprimir() {
		No aux = ini;
		while (aux != null) {
			System.out.print(aux.getElemento() + " ");
			aux = aux.getProximo();
		}
		System.out.println("\n---------------------");
	}

	public Object procurarElemento(int posicao) {

		if (posicao >= tam) {
			System.out.println("Posicao eh maior que a lista");
			return null;
		}
		No aux = ini;
		int cont = 0;
		while (aux != null) {
			if (posicao == cont) {
				return aux.getElemento();
			}
			aux = aux.getProximo();
			cont++;
		}
		System.out.println("Elemento nao encontrado");
		return null;
	}

	public void inverterFilaComPilha() {
		PilhaEncadeada f = new PilhaEncadeada();
		No aux = ini;
		while (aux != null) {
			f.push(this.desenfileirar());
			aux = aux.getProximo();
		}
		aux = f.top();
		while (aux != null) {
			enfileirar(f.pop());
			aux = aux.getProximo();
		}
	}


	public Object excluirPosicao(int posicao) {
		
		if (posicao >= tam) {
			System.out.println("Posicao eh maior que a lista");
			return null;
		}

		No anterior = ini;
		No aux = ini;
		int cont = 0;
		while (aux != null) {
			if (posicao == cont) {
				Object temp = aux.getElemento();
				if (cont == 0) {
					No temp2 = aux.getProximo();
					anterior.setProximo(temp2.getProximo());
					return temp;
				}
				anterior.setProximo(aux.getProximo());
				return temp;
			}
			anterior = aux;
			aux = aux.getProximo();
			cont++;
		}
		System.out.println("Elemento nao encontrado");
		return null;
	}
	
	
	public void inserirCopia(FilaEncadeada fila){
		for (int i = 0; i < fila.size(); i++) {
			this.enfileirar(fila.procurarElemento(i));
		}
	}
	
	

}
