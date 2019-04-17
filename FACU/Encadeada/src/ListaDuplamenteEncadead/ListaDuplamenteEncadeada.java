package ListaDuplamenteEncadead;

public class ListaDuplamenteEncadeada {
	private DNode frente;
	private DNode cauda;
	private int tam;
	
	public ListaDuplamenteEncadeada(){
		frente = new DNode(null, null, null);
		cauda = new DNode(frente, null, null);
		frente.setProx(cauda);
		tam = 0;//por crit�rios did�ticos
	}
	
	public DNode insertFirst(Object elemento){
		DNode novoNo = new DNode(frente, frente.getProx(), elemento);
		frente.getProx().setAnt(novoNo);
		frente.setProx(novoNo);
		tam++;
		return novoNo;
	}
	
	public DNode insertLast(Object elemento){
		DNode novoNo = new DNode(cauda.getAnt(), cauda, elemento);
		cauda.getAnt().setProx(novoNo);
		cauda.setAnt(novoNo);
		tam++;
		return novoNo;
	}

	public DNode getFirst(){
		if (!isEmpty()) {
			return frente.getProx();
		} else{
			System.out.println("Lista Vazia");
			return null;
		}
	}

	public DNode getLast(){
		if (!isEmpty()) {
			return cauda.getAnt();
		} else{
			System.out.println("Lista Vazia");
			return null;
		}
	}
	
	public Object removeFirst(){
		if (!isEmpty()) {
			Object temp = frente.getProx().getElemento();
			frente.setProx(frente.getProx().getProx());
			frente.getProx().setAnt(frente);
			tam--;
			return temp;
		}else{
			System.out.println("Lista Vazia");
			return null;
		}
	}
	
	public Object removeLast(){
		if (!isEmpty()) {
			Object temp = cauda.getAnt().getElemento();
			cauda.setAnt(cauda.getAnt().getAnt());
			cauda.getAnt().setProx(cauda);
			tam--;
			return temp;
		}else{
			System.out.println("Lista Vazia");
			return null;
		}
	}
	
	public Object removeLast2(){
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
		while(aux != cauda){
			System.out.print(aux.getElemento() + " ");
			aux = aux.getProx();
		}
		System.out.println(); 
	}
}
