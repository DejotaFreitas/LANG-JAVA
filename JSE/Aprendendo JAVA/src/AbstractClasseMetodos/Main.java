package AbstractClasseMetodos;

public class Main {

	public static void main(String[] args) {
		
		Gato xaninho = new Gato();
		Animal toto = new Cachorro();
		
		xaninho.beber();
		xaninho.comer();
		xaninho.noaCaiDeCostas();
		
		toto.beber();
		toto.comer();

	}

}
