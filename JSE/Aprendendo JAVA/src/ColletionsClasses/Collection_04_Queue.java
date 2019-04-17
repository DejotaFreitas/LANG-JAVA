package ColletionsClasses;

import java.util.LinkedList;
import java.util.Queue;

public class Collection_04_Queue {

	public static void main(String[] args) {
		
		//fuciona como uma fila de ordem de chegada
		Queue<String> q = new LinkedList<>();
		q.add("XUXA");
		q.add("Ronaldinho");
		q.add("Ronaldo");
		q.add("Robertos Carlos");
		System.out.println(q);
		
		//mostra o primeiro elemento da fila
		System.out.println(q.peek());
		
		//remover primeiro elemento da fila
		q.poll();
		
		//mostra o primeiro elemento da fila
		System.out.println(q.peek());
		
		//metodos LinkedList
		LinkedList<String> lk = new LinkedList<>();
		
		lk.addFirst("Angelica"); // adiciona ao inicio da fila
		lk.addLast("Xasha"); // adiciona no final da fila
		
		//retorna a primeira e ultima pessoa da fila
		lk.peekFirst();
		lk.peekLast();
		
		//remover a primeira e ultima pessoa da fila
		lk.pollFirst();
		lk.pollLast();
		
		
		
	}
}
