package encadeadas;
public class ClasseMain {
	public static void main(String[] args) {
		FilaEncadeada f1 = new FilaEncadeada();
		f1.enfileirar("A");
		f1.enfileirar("B");
		f1.enfileirar("C");
		f1.enfileirar("D");
		f1.enfileirar("E");
		f1.imprimir();
		

		
		FilaEncadeada f2 = new FilaEncadeada();
		f2.enfileirar("Z");
		f2.enfileirar("X");
		f2.enfileirar("Y");
		f2.enfileirar("W");
		f2.enfileirar("T");
		f2.imprimir();
		
		
		f1.inserirCopia(f2);
		f1.imprimir();
		f2.imprimir();
	}
}
