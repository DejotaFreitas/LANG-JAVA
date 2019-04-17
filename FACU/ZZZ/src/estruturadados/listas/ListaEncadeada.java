package estruturadados.listas;

import estruturadados.Vector;
import estruturadados.simples.No;

public class ListaEncadeada implements Vector {
	private No inicio;
	private No fim;
	private int tam;

	public No insertFirst(Object elemento) {
		No novoNo = new No(elemento, inicio);
		inicio = novoNo;
		tam++;
		return novoNo;
	}

	public No insertLast(Object elemento) {
		No novoNo = new No(elemento, null);
		fim.setProximo(novoNo);
		fim = novoNo;
		tam++;
		return novoNo;
	}

	public void add(Object elemento) {
		No novoNo = new No(elemento, null);
		fim.setProximo(novoNo);
		fim = novoNo;
		tam++;
	}

	public No getFirst() {
		if (!isEmpty()) {
			return inicio;
		} else {
			System.out.println("Lista Vazia");
			return null;
		}
	}

	public No getLast() {
		if (!isEmpty()) {
			return fim;
		} else {
			System.out.println("Lista Vazia");
			return null;
		}
	}

	public Object remove() {
		if (!isEmpty()) {
			Object temp = inicio.getElemento();
			inicio = inicio.getProximo();
			tam--;
			return temp;
		} else {
			System.out.println("Lista Vazia");
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
		No aux = getFirst();
		while (aux != fim) {
			System.out.print(aux.getElemento() + " ");
			aux = aux.getProximo();
		}
		System.out.println();
	}

	public void clean() {
		inicio.setProximo(fim);
		tam = 0;
	}

	public Object get(int index) {
		No aux = null;
		if (index >= 0 && index < tam) {
			aux = inicio;
			for (int i = 0; i != index; i++) {
				aux = aux.getProximo();
			}
		}
		return aux;
	}
}
