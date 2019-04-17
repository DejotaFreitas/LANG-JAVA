

import java.awt.image.BufferedImage;

public class Animacao {

	private BufferedImage[] quadros;
	private int quadroAtual;
	
	private long tempoInicial;
	private long tempoDeEspera;
	
	public Animacao(){	}
	
	public void definirQuadrosDaAnimacao(BufferedImage[] quadros){
		this.quadros = quadros;
		if (quadroAtual >= quadros.length) {
			quadroAtual = 0;
		}
	}
	
	public void definirTempoDeEspera_Animacao(long tempoDeEspera){
		this.tempoDeEspera = tempoDeEspera;
	}
	
	public BufferedImage obterQuadros_Animacao(){
		return quadros [quadroAtual];
	}
	
	public void atualizar_Animacao(){		
		if (tempoDeEspera == -1) {	return; }
		
		long tempoCorrido_long = (System.nanoTime() - tempoInicial)/ 1000000;
		if (tempoCorrido_long > tempoDeEspera) {
			quadroAtual++;
			tempoInicial = System.nanoTime();
		}
		if (quadroAtual >= quadros.length) {
			quadroAtual = 0;
		}
	}
	

	
	
}
