package Heranca_Animais;

public class Cachorro extends Animal implements ComportamentoCorrer{
	
	public void emitirSom (){
		System.out.println("AUAHUAUHAAUH!");	
	}

	public void correr() {
		System.out.println("Cacharro Corre!!!");
	}

}
