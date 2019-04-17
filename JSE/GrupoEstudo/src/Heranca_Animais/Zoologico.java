package Heranca_Animais;

public class Zoologico {
	
	Cachorro dog = new Cachorro();
	Cavalo brisa = new Cavalo();
	Preguica angelica = new Preguica();
	
	Animal zoo [] = new Animal [10];
	
	
	public void percorrerjaula (){
		for (Animal a : zoo) {
			a.emitirSom();
			//a.correr();
		}
	}

}

