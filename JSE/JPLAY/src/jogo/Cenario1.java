package jogo;

import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 {
	
	private Jogador jogador;
	private Window janela;
	private Scene cena;
	
	
	public Cenario1(Window window){
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("cenario1.scn"));
		jogador = new Jogador(100, 100);
		
		run();
	}

	private void run() {
		while (true) {
			cena.draw();
			jogador.draw();
			jogador.mover();
			janela.update();				
		}
		
	}
	
	
	
	
	
	
	
	
	

}
