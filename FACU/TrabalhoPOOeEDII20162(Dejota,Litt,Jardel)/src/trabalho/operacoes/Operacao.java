package trabalho.operacoes;

public abstract class Operacao {
	
	private String dono;

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}
	
	public String toString() {
		return dono;
	}

}
