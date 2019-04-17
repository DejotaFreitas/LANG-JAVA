import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Jogador {
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private int largura;
	private int altura;
	
	private boolean esquerda;
	private boolean direita;
	private boolean pulando;
	private boolean caindo;
	
	private double velocidadeMovimento;
	private double maximaVelocidadeMovimento;
	private double maximaVelocidadeQueda;
	private double reducaoVelocidade;
	private double alturaPulo;
	private double gravidade;
	
	
	private Mapa mapa;
	
	private boolean topoEsquerda;
	private boolean topoDireita;
	private boolean baixoEsquerda;
	private boolean baixoDireita;
	
	private Animacao animacao;
	private BufferedImage[] desenhoParado;
	private BufferedImage[] desenhoCaminhando;
	private BufferedImage[] desenhoPulando;
	private BufferedImage[] desenhoCaindo;
	private boolean viradoPraEsquerda;
	
	public Jogador (Mapa mapa){
		this.mapa = mapa;
		
		largura = 22;
		altura = 21;
		
		velocidadeMovimento = 0.6;
		maximaVelocidadeMovimento = 4.2;
		maximaVelocidadeQueda = 12;
		reducaoVelocidade = 0.30;
		alturaPulo = -11.0;
		gravidade = 0.64;		
		
		try {
			desenhoParado = new BufferedImage[1];
			desenhoPulando = new BufferedImage[1];
			desenhoCaindo = new BufferedImage[1];
			desenhoCaminhando = new BufferedImage[6];
			
			desenhoParado[0] = ImageIO.read(new File("src/kirbyidle.gif"));
			desenhoPulando[0] = ImageIO.read(new File("src/kirbyjump.gif"));
			desenhoCaindo[0] = ImageIO.read(new File("src/kirbyfall.gif"));
			
			BufferedImage image = ImageIO.read(new File("src/kirbywalk.gif"));
			for (int i = 0; i < desenhoCaminhando.length; i++) {
				desenhoCaminhando [i] = image.getSubimage(i*largura+i, 0, largura, altura);
			}		
		} catch (Exception e) {	}
		
		animacao = new Animacao();
		viradoPraEsquerda = false;
	}
	
		public void definirX_Jogador(int x){ this.x = x; }
		public void definirY_Jogador(int y){ this.y = y; }
		
		public void setLeft(boolean esquerda) { 
			this.esquerda = esquerda;
		}
		public void setRight(boolean direita) {
			this.direita = direita;
		}	
		public void setJumping(boolean pulando) {
			if(!caindo){
			this.pulando = pulando;
		}
	}
	
	private void calculateCorners(double x, double y){
		int esquerdaQuadro = mapa.obterColunaDoQuadro_Mapa((int) (x - largura/2));
		int direitaQuadro = mapa.obterColunaDoQuadro_Mapa((int) (x + largura/2)-1);
		int topoQuadro = mapa.obterLinhaDoQuadro_Mapa((int) (y - altura/2));
		int baixoQuadro = mapa.obterLinhaDoQuadro_Mapa((int) (y + altura/2)-1);
		
		topoEsquerda = mapa.obterColisivelDoQuadro_Mapa(topoQuadro, esquerdaQuadro);
		topoDireita = mapa.obterColisivelDoQuadro_Mapa(topoQuadro, direitaQuadro);
		baixoEsquerda = mapa.obterColisivelDoQuadro_Mapa(baixoQuadro, esquerdaQuadro);
		baixoDireita = mapa.obterColisivelDoQuadro_Mapa(baixoQuadro, direitaQuadro);
		
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	public void atualizar_Jogador (){
		// determine next position
		if(esquerda){
			dx -= velocidadeMovimento;
			if (dx < -maximaVelocidadeMovimento) {
				dx = -maximaVelocidadeMovimento;
			}
		}
		else if(direita){
			dx += velocidadeMovimento;
			if (dx > maximaVelocidadeMovimento) {
				dx = maximaVelocidadeMovimento;
			}
		}
		else{
			if (dx > 0) {
				dx -= reducaoVelocidade;
				if (dx < 0) {
					dx = 0;
				}
			}
			else if (dx < 0){
				dx += reducaoVelocidade;
				if (dx > 0) {
					dx = 0;
				}
			}
		}
		
		if(pulando){
			dy = alturaPulo;
			caindo = true;
			pulando = false;
	
		}
		
		if (caindo) {
			dy += gravidade;
			if (dy > maximaVelocidadeQueda) {
				dy = maximaVelocidadeQueda;
			}
		}else{
			dy = 0;
		}
		
		//check collision
		int colunaAtual = mapa.obterColunaDoQuadro_Mapa((int) x);
		int linhaAtual = mapa.obterLinhaDoQuadro_Mapa((int) y);
		
		double xTemporario = x;
		double yTemporario = y;
		
		calculateCorners(x, y+dy);
		if (dy < 0) {
			if (topoEsquerda || topoDireita) {
				dy = 0;
				yTemporario = linhaAtual * mapa.obterTamanhoQuadro_Mapa() + altura /2;
			}else{
				yTemporario += dy;
			}
		}
		if (dy > 0) {
			if (baixoEsquerda || baixoDireita) {
				dy = 0;
				caindo = false;
				yTemporario = (linhaAtual+1) * mapa.obterTamanhoQuadro_Mapa() - altura /2;
			}else{
				yTemporario += dy;
			}
		}
		
		calculateCorners(x+dx, y);
		if (dx < 0) {
			if (topoEsquerda || baixoEsquerda) {
				dx = 0;
				xTemporario = colunaAtual * mapa.obterTamanhoQuadro_Mapa() + largura /2;
			}else{
				xTemporario += dx;
			}
		}
		if (dx > 0) {
			if (topoDireita || baixoDireita) {
				dx =0;
				xTemporario = (colunaAtual+1.001) * mapa.obterTamanhoQuadro_Mapa() - largura /2;
			}else{
				xTemporario += dx;
			}
		}
		
		if (!caindo) {
			calculateCorners(x, y+1);
			if (!baixoEsquerda && !baixoDireita) {
				caindo = true;
			}
		}
		
		x = xTemporario;
		y = yTemporario;
		
		//move the map		
		mapa.definirX_Mapa((int) (( Tela.LARGURA /2) - x ));
		mapa.definirY_Mapa((int) (( Tela.ALTURA /2) - y ));
		
		//sprite animation
		if (esquerda || direita) {
			animacao.definirQuadrosDaAnimacao(desenhoCaminhando);
			animacao.definirTempoDeEspera_Animacao(100);
		}else{
			animacao.definirQuadrosDaAnimacao(desenhoParado);
			animacao.definirTempoDeEspera_Animacao(-1);
		}
		if (dy < 0) {
			animacao.definirQuadrosDaAnimacao(desenhoPulando);
			animacao.definirTempoDeEspera_Animacao(-1);
		}
		if (dy > 0) {
			animacao.definirQuadrosDaAnimacao(desenhoCaindo);
			animacao.definirTempoDeEspera_Animacao(-1);
		}
		
		animacao.atualizar_Animacao();  
		
		if (dx < 0) {
			viradoPraEsquerda = true;
		}
		if (dx > 0) {
			viradoPraEsquerda = false;
		}
		
	}
	
	public void desenhar_Jogador (Graphics2D g){
		
		int tx = mapa.obterX_Mapa();
		int ty = mapa.obterY_Mapa();
		
		if (viradoPraEsquerda) {
			g.drawImage(
					animacao.obterQuadros_Animacao(),
					(int) (tx + x - largura /2),
					(int) (ty + y - altura /2),
					null);
		}else{
			g.drawImage(
					animacao.obterQuadros_Animacao(),
					(int) (tx + x - largura /2 + largura),
					(int) (ty + y - altura /2),
					-largura,
					altura,
					null);	
			
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
