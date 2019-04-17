package ListaDuplamenteEncadead;

public class UsaListaDuplamenteEncadeada {
	public static void main(String[] args) {
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		lista.insertFirst("A");
		lista.insertLast("B");
		lista.insertFirst("C");
		lista.insertFirst("D");
		lista.insertFirst("E");
		lista.imprimir();
		lista.removeLast();
		lista.imprimir();
		lista.removeFirst();
		lista.imprimir();
		lista.insertAfter(lista.getFirst(), "F");
		lista.imprimir();
		lista.insertBefore(lista.getLast(), "G");
		lista.imprimir();
		lista.insertAfter(lista.getFirst().getProx(), "H");
		System.out.println(lista.size());
		lista.imprimir();
		
	}
}
