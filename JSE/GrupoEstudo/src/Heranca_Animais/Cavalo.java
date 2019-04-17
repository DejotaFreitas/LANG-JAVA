package Heranca_Animais;

public class Cavalo extends Animal implements ComportamentoCorrer{
	
	public void emitirSom (){
		System.out.println("IHRIHRIHRIHRIHRIHRIH!");
	}

	public void correr() {
		System.out.println("Cavalo Corre muito Rapido!!!");
		
	}

}
