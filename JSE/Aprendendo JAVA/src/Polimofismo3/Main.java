package Polimofismo3;

public class Main {

	public static void main(String[] args) {
		
		Animal desconhecido = new Animal();
		Animal trex = new TRex();
		Animal gato = new Gato();
		Animal elefante = new Elefante();
		
		desconhecido.tipo();
		trex.tipo();
		gato.tipo();
		elefante.tipo();
		
		
		comer(trex, gato);
		
	}

	public static void comer(Animal animalcomendo, Animal animalcomido){
		animalcomendo.tipo();
		System.out.println("...Comendo...");
		animalcomido.tipo();
	}
	
	
}
