package atividade_poo;

public class Preguica extends Animal implements ComportamentoSubirArvore {

	public void emitirSom() {
		System.out.println("Zzzz zzzZ zZZzz...");		
	}
	
	public void subirArvore() {
		System.out.println("Preguiça subindo na árvore.");
	}

}
