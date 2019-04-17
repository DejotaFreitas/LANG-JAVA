package JoguinhoNave;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Inimigo {
	
	private Image imagem;
	private int x , y;
	private int altura, largura;
	private boolean isVisivel;
	private Random inimigoAleatorio;


	private static final int LARGURA_TELA = 500;
	private static final int VELOCIDADE = 1;
	
	public Inimigo(int x, int y){
		this.x = x;
		this.y = y;
		ImageIcon referencia;
		inimigoAleatorio = new Random();
		if (inimigoAleatorio.nextInt(2)==0) {
			referencia = new ImageIcon("res\\inimigo_1.gif");
		} else {
			referencia = new ImageIcon("res\\inimigo_2.gif");
		}
			
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		isVisivel = true;
	}
	
	public void mecher(){
		if (this.x < 0) {
			this.x = LARGURA_TELA;
		} else {
			this.x -= VELOCIDADE;
		}
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public Image getImagem() {
		return imagem;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, altura, largura);		
	}
	
	
}
