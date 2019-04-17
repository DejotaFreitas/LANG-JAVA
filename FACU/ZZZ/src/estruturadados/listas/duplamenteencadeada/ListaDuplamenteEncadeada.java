package estruturadados.listas.duplamenteencadeada;

import estruturadados.Vector;

public class ListaDuplamenteEncadeada implements Vector{
	private DNode inicio;
	private DNode fim;
	private int tam;
	
	public ListaDuplamenteEncadeada(){
		inicio = new DNode(null, null, null);
		fim = new DNode(inicio, null, null);
		inicio.setProx(fim);
		tam = 0;
	}
	
	public DNode insertFirst(Object elemento){
		DNode novoNo = new DNode(inicio, inicio.getProx(), elemento);
		inicio.getProx().setAnt(novoNo);
		inicio.setProx(novoNo);
		tam++;
		return novoNo;
	}
	
	public DNode insertLast(Object elemento){
		DNode novoNo = new DNode(fim.getAnt(), fim, elemento);
		fim.getAnt().setProx(novoNo);
		fim.setAnt(novoNo);
		tam++;
		return novoNo;
	}
	
	public void add(Object elemento){
		DNode novoNo = new DNode(fim.getAnt(), fim, elemento);
		fim.getAnt().setProx(novoNo);
		fim.setAnt(novoNo);
		tam++;
	}

	public DNode getFirst(){
		if (!isEmpty()) {
			return inicio.getProx();
		} else{
			System.out.println("Lista Vazia");
			return null;
		}
	}

	public DNode getLast(){
		if (!isEmpty()) {
			return fim.getAnt();
		} else{
			System.out.println("Lista Vazia");
			return null;
		}
	}
	
	public Object removeFirst(){
		if (!isEmpty()) {
			Object temp = inicio.getProx().getElemento();
			inicio.setProx(inicio.getProx().getProx());
			inicio.getProx().setAnt(inicio);
			tam--;
			return temp;
		}else{
			System.out.println("Lista Vazia");
			return null;
		}
	}
	
	public Object remove(){
		if (!isEmpty()) {
			Object temp = inicio.getProx().getElemento();
			inicio.setProx(inicio.getProx().getProx());
			inicio.getProx().setAnt(inicio);
			tam--;
			return temp;
		}else{
			System.out.println("Lista Vazia");
			return null;
		}
	}
	
	public Object removeLast(){
		if (!isEmpty()) {
			Object temp = fim.getAnt().getElemento();
			fim.setAnt(fim.getAnt().getAnt());
			fim.getAnt().setProx(fim);
			tam--;
			return temp;
		}else{
			System.out.println("Lista Vazia");
			return null;
		}
	}
	
	public Object removeLast2() {
		return remove(getLast());
	}
	
	public DNode insertBefore(DNode no, Object elemento){
		DNode novoNo = new DNode(no.getAnt(), no, elemento);
		no.getAnt().setProx(novoNo);
		no.setAnt(novoNo);
		tam++;
		return novoNo;
	}
	
	
	public DNode insertAfter(DNode no, Object elemento){
		DNode novoNo = new DNode(no, no.getProx(), elemento);
		no.getProx().setAnt(novoNo);
		no.setProx(novoNo);
		tam++;
		return novoNo;
	}
	
	public Object remove(DNode no){
		Object temp = no.getElemento();
		no.getProx().setAnt(no.getAnt());
		no.getAnt().setProx(no.getProx());
		tam--;
		return temp;
	}
	
	public int size(){
		return tam;
	}
	
	public boolean isEmpty(){
		return tam == 0;
	}
	
	public void imprimir(){
		DNode aux = getFirst();
		while(aux != fim){
			System.out.print(aux.getElemento() + " ");
			aux = aux.getProx();
		}
		System.out.println(); 
	}

	public Object get(int pos){
		if (pos >= 0 && pos < size()) {
			if (pos < size() / 2) {
				DNode aux = getFirst();
				for (int i = 0; i < pos; i++) {
					aux = aux.getProx();
				}
				return aux;
			}else{
				DNode aux = getLast();
				for (int i = size() - 1; i > pos; i--) {
					aux = aux.getAnt();
				}
				return aux.getElemento();
			}
		}else{
			System.out.println("Posi��o inv�lida");
			return null;
		}		
	}

	@Override
	public void clean() {
		inicio.setProx(fim);
		fim.setAnt(inicio);
		tam = 0;		
	}
}
