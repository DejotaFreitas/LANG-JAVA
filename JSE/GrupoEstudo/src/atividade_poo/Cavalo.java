package atividade_poo;

public class Cavalo extends Animal implements ComportamentoCorrer {

	public void emitirSom() {
		System.out.println("Relinchando...");		
	}
	
	public void correr() {
		System.out.println("Cavalo correndo...");
	}
	
}
