package atividade_poo;

public class Cachorro extends Animal implements ComportamentoCorrer{

	public void emitirSom() {
		System.out.println("Au au au...");		
	}
	
	public void correr() {
		System.out.println("Cachorro correndo...");
	}

}
