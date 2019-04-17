package atividade_poo;

public class Zoologico {

	private Animal[] jaula;
	private int qntAnimais;
	
	public Zoologico() {
		jaula = new Animal[10];
		qntAnimais = 0;
	}

	public void enjaular(Animal animal) {
		if (qntAnimais <= jaula.length) {
			jaula[qntAnimais] = animal;
			qntAnimais++;
		} else {
			System.out.println("Jaulas cheias!");
		}
	}

	public void percorrerJaula() {
		for (int i = 0; i < jaula.length; i++) {
			if (jaula[i] != null) {
				jaula[i].emitirSom();
				if (jaula[i] instanceof ComportamentoCorrer) {
					((ComportamentoCorrer) jaula[i]).correr();
				}
			} else {
				System.out.println("Jaula vazia...");
			}
		}
	}

}
