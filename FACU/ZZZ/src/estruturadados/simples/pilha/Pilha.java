package estruturadados.simples.pilha;

import estruturadados.Vector;
import estruturadados.simples.No;

public class Pilha implements Vector {
	private No topo;
	private int tam;

	public void add(Object elemento) {
		No novoNo = new No();
		novoNo.setElemento(elemento);
		novoNo.setProximo(topo);
		topo = novoNo;
		tam++;
	}

	public Object remove() {
		if (!isEmpty()) {
			Object temp = topo.getElemento();
			topo = topo.getProximo();
			tam--;
			return temp;
		} else {
			System.out.println("Pilha Vazia");
			return null;
		}

	}

	public Object top() {
		if (!isEmpty()) {
			return topo.getElemento();
		} else {
			System.out.println("Pilha Vazia");
			return null;
		}
	}

	public boolean isEmpty() {
		return tam == 0;
	}

	public int size() {
		return tam;
	}

	public void imprimir() {
		No aux = topo;

		while (aux != null) {
			System.out.print(aux.getElemento() + " ");
			aux = aux.getProximo();
		}
	}

	public void clean() {
		topo = null;
		tam = 0;
	}

	public Object get(int index) {
		No aux = null;
		if (index >= 0 && index < tam) {
			aux = topo;
			for (int i = 0; i != index; i++) {
				aux = aux.getProximo();
			}
		}
		return aux;
	}

}
