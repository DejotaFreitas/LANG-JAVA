package FilaEncadead;

import PilhaEncadead.PilhaEncadeada;

public class FilaEncadeada {
	private No ini;
	private No fim;
	private int tam;
	
	public FilaEncadeada(){
		ini = null;
		fim = null;
		tam = 0;
	}
	
	public void enfileirar(Object elemento){
		//1- Instanciar um objeto do tipo No
		No novoNo = new No();
		//2- inserir o elemento no novoNo
		novoNo.setElemento(elemento);
		if (isEmpty()) {
			//se for o primeiro elemento, ele ser� p in�cio e o fim da fila
			ini = novoNo;
		}else{
			//3- Ligar ou encadear o fim da fila ao novoNo
			fim.setProximo(novoNo);
		}
		//4- Atualizar o novo final da fila
		fim = novoNo;
		//5- Incrementar o tamanho
		tam++;
	}
	
	public Object desenfileirar(){
		if (!isEmpty()) {
			//1- Armazenar o valor a ser removido
			Object temp = ini.getElemento();
			//2- Atualizar o in�cio
			ini = ini.getProximo();
			//3- Decrementar o tamanho
			tam--;
			if (isEmpty()) {
				fim = null;
			}
			//4- retornar o valor armazenado em temp (removido)
			return temp;
		}else{
			System.out.println("Fila Vazia");
			return null;
		}
	}
	
	public Object frente(){
		if (!isEmpty()) {
			//1- retornar o valor armazenado no in�cio
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
	public int acharPosicaoDoElemento(Object elemento){
		int pos = 0;
		No aux = ini;
		while(aux != null){
			if (aux.getElemento().equals(elemento)) {
				return pos;
			}
			aux = aux.getProximo();
			pos++;
		}
		return -1;
	}
	//Criar um m�todo na classe FilaEncadeada para receber uma posi��o por par�metro e retornar o elemento que encontra-se nesta posi��o. Caso a posi��o seja inv�lida, informar ao usu�rio e retornar null.
	public Object acharElementoDaPosicao(int pos){
		if (pos >= size()) {
			System.out.println("Posi��o inv�lida");
			return null;
		}
		No aux = ini;
		for (int i = 0; i < pos; i++) {
			aux = aux.getProximo();
		}
		return aux.getElemento();
	}
	
	//Criar um m�todo para inverter uma FilaEncadeada. Usar uma Pilha para auxiliar na invers�o.
	public void inverter(){
		PilhaEncadeada pilha = new PilhaEncadeada();
		while(!this.isEmpty()){
			pilha.push(this.desenfileirar());
		}
		
		while(!pilha.isEmpty()){
			this.enfileirar(pilha.pop());
		}
	}
	//Criar um m�todo na classe FilaEncadeada para receber uma posi��o por par�metro, remover o n� e  retornar o elemento que estava no n� que encontra-se nesta posi��o. Caso a posi��o seja inv�lida, informar ao usu�rio e retornar null.
	
}
