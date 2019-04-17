package JogoPongUtil;

public class Vetor2D {
	
	private int x;
	private int y;
	
	//construtor vazio
	public Vetor2D () {}
	
	//construtor nao vazio
	public Vetor2D (int x, int y) {
		this.x = x;
		this.y = y;
	}
	//metodo seta x e y
	public void setVetor (int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	//get e set
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
