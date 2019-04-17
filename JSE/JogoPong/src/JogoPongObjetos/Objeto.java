package JogoPongObjetos;

import java.awt.Image;

import JogoPongUtil.Colisao2D;
import JogoPongUtil.Vetor2D;

public class Objeto {
	
	private Image image;
	
	private boolean visibilidade;
	private boolean destruicao;
	
	private Vetor2D dimensao = new Vetor2D();
	
	protected Vetor2D direcao = new Vetor2D( 1 , 1 );
	protected Vetor2D posicao = new Vetor2D(); 
	protected Vetor2D velocidade = new Vetor2D();
	
	protected Colisao2D area;
	
	private boolean isColisivel;
	private boolean isNaTela;
	
	public Objeto(){
		
		this.visibilidade = true;
		this.destruicao = false;
		
		this.isColisivel = true;
		this.isNaTela = false;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

	public boolean isDestruicao() {
		return destruicao;
	}

	public void setDestruicao(boolean destruicao) {
		this.destruicao = destruicao;
	}

	public boolean isNaTela() {
		return isNaTela;
	}

	public void setNaTela(boolean isNaTela) {
		this.isNaTela = isNaTela;
	}

	//=======get set manual=========================
	
	public int getAltura() {
		return dimensao.getY();
	}
	
	public int getLargura() {
		return dimensao.getX();
	}

	public void setAltura(int altura) {
		this.dimensao.setY(altura);;
	}
	
	public void setlargura(int altura) {
		this.dimensao.setY(altura);
	}
	
	
	public boolean isEmColisao(Objeto a) {
		
		if ( this == a){
			return false;
		}
		if (!a.isColisivel) {
			return false;
		}
		
		return (this.area.esquerda <= a.area.direita 
				&& a.area.esquerda <= this.area.direita 
				&& this.area.topo <= a.area.base 
				&& a.area.topo <= this.area.base );
	}


	
	

}
