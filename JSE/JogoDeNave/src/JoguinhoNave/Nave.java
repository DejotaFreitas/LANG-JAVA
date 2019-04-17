package JoguinhoNave;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Nave {
	
	private int x , y;
	private int dx, dy;
	private int altura, largura;
	private Image imagem;
	private boolean isVisivel;
	private List<Missel> misseis;
	
	public Nave(){
		ImageIcon referencia = new ImageIcon("res\\nave.gif");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		misseis = new ArrayList<Missel>();
		this.x = 30;
		this.y = 160;
		isVisivel = true;
	}
	
	public void mexer(){
		x += dx;
		y += dy;
		if (this.x<1)
			x = 1;
		if (this.x>462)
			x = 462;
		if (this.y<1)
			y = 1;
		if (this.y>340)
			y = 340;
	}
	
	public List<Missel> getMisseis() {
		return misseis;
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImagem() {
		return imagem;
	}
	
	public void atira(){
		this.misseis.add(new Missel(x+largura,y+altura/2));
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, altura, largura);
	}
	
	//Presinar botão
	public void keyPressed(KeyEvent tecla){
		
		int codigo = tecla.getKeyCode();
		
		if (codigo == KeyEvent.VK_SPACE) {
			atira();
		}
		
		if (codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_W) {
			dy = -2;
		}
		if (codigo == KeyEvent.VK_DOWN || codigo == KeyEvent.VK_S) {
			dy = 2;
		}
		if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
			dx = +2;
		}
		if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
			dx = -2;
		}		
	}
	//soltar tecla
	public void keyReleased(KeyEvent tecla){
		int codigo = tecla.getKeyCode();
		if (codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_W) {
			dy = 0;
		}
		if (codigo == KeyEvent.VK_DOWN || codigo == KeyEvent.VK_S) {
			dy = 0;
		}
		if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
			dx = 0;
		}
		if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
			dx = 0;
		}		
	}
	

}
