
public class usaVetorComArray {
public static void main(String[] args) {
	
	
	ArrayDuplamenteEncadeada a = new ArrayDuplamenteEncadeada(20);
	a.inserir("a", 0);
	a.inserir("b", 0);
	a.inserir("c", 1);
	a.inserir("d", 1);
	a.inserir("e", 2);
	a.inserir("f", 2);
	
	for (int i = 0; i < a.size(); i++) {
		System.out.print(a.consultar(i)+" ");
	}
	
	System.out.println();
	
	a.imprimirNo();
	
}
}
