package FilaEncadead;

public class UsaFilaEncadeada {
	public static void main(String[] args) {
		FilaEncadeada fila = new FilaEncadeada();
		fila.enfileirar("A");
		fila.enfileirar("B");
		fila.enfileirar("C");
		fila.enfileirar("D");
		fila.enfileirar("E");
//		fila.desenfileirar();
		fila.imprimir();
		fila.inverter();
		fila.imprimir();
		System.out.println(fila.acharPosicaoDoElemento("F"));
	}
}
