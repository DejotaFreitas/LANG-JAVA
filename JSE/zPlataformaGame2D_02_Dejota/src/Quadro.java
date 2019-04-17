import java.awt.image.BufferedImage;

public class Quadro {
	
	private BufferedImage imagem;
	private boolean colisivel;
	
	public Quadro(BufferedImage imagem, boolean colisivel){
		this.imagem = imagem;
		this.colisivel = colisivel;					
	}
	
	public BufferedImage obterImagem_Quadro(){ return imagem; }
	public boolean obterColisivel_Quadro(){ return colisivel; }
	
}
