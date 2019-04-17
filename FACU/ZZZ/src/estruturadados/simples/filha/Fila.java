package estruturadados.simples.filha;

import estruturadados.Vector;
import estruturadados.simples.No;

public class Fila implements Vector{
	private No ini;
	private No fim;
	private int tam;
	
	public Fila(){
		ini = null;
		fim = null;
		tam = 0;
	}
	
	public void add(Object elemento){
		No novoNo = new No();
		novoNo.setElemento(elemento);
		if (isEmpty()) {
			ini = novoNo;
		}else{
			fim.setProximo(novoNo);
		}
		fim = novoNo;
		tam++;
	}
	
	public Object remove(){
		if (!isEmpty()) {
			Object temp = ini.getElemento();
			ini = ini.getProximo();
			tam--;
			if (isEmpty()) {
				fim = null;
			}
			return temp;
		}else{
			System.out.println("Fila Vazia");
			return null;
		}
	}
	
	public Object frente(){
		if (!isEmpty()) {
			return ini.getElemento();
		}else{
			System.out.println("Fila Vazia");
			return null;
		}
	}
	
	public int size(){
		return tam;
	}
	
	public boolean isEmpty(){
		return tam == 0;
	}
	
	public void imprimir(){
		No aux = ini;
		while(aux != null){
			System.out.print(aux.getElemento() + " ");
			aux = aux.getProximo();
		}
		System.out.println();
	}


	public void clean() {
		ini.setProximo(fim);
		tam = 0;		
	}


	public Object get(int index) {
		No aux = null;
		if (index >= 0 && index < tam) {
			aux = ini;
			for (int i = 0; i != index; i++) {
				aux = aux.getProximo();
			}
		}
		return aux;
	}

	
}
