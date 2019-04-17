package PilhaEncadead;

public class PilhaEncadeada {
	private No topo;
	private int tam;
	
	public void push(Object elemento){
		//1- Intanciar um objeto do tipo No
		No novoNo = new No();
		//2- inserir o elemento no novoNo
		novoNo.setElemento(elemento);
		//3- Ligar ou encadear o novoNo com o antigo topo
		novoNo.setAnterior(topo);
		//4- Atualizar o novo topo
		topo = novoNo;
		//5- Incrementar o tamanho
		tam++;
	}
	
	public Object pop(){
		if (!isEmpty()) {
			//1- Armazenar o valor a ser removido
			Object temp = topo.getElemento();
			//2- Atualizar o topo
			topo = topo.getAnterior();
			//3- Decrementar o tamanho
			tam--;
			//4- retornar o valor armazenado em temp (removido)
			return temp;
		}else{
			System.out.println("Pilha Vazia");
			return null;
		}
		
	}
	
	public Object top(){
		if (!isEmpty()) {
			return topo.getElemento();
		}else{
			System.out.println("Pilha Vazia");
			return null;
		}
	}
	
	public boolean isEmpty(){
		return tam == 0;
	}
	
	public int size(){
		return tam;
	}
	
	public void imprimir(){
		No aux = topo;
		
		while(aux != null){
			System.out.print(aux.getElemento() + " ");
			aux = aux.getAnterior();
		}
	}
	
	
	
	
	
	
	
	
	
}
