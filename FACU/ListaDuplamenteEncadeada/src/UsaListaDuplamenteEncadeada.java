

public class UsaListaDuplamenteEncadeada {
	public static void main(String[] args) {
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		lista.insertFirst("A");
		lista.insertLast("B");
		lista.insertFirst("C");
		lista.insertFirst("D");
		lista.insertFirst("E");		
		lista.insertFirst("X");
		lista.insertFirst("Y");
		lista.imprimir();
		System.out.println(lista.buscaPosicao(2));
		lista.inserirPosicao("Z",2);
		lista.imprimir();
	}
}
