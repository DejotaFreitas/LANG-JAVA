package zVariadas;

public class MetodosGetSet {
	public static void main(String[] args) {
		//Criando objeto para acessar outra casse
		MetodosGetSet objeto = new MetodosGetSet();
		
		//acesar o valor privado
		System.out.println(objeto.getPrivado());
		
		//modificar valor privado
		objeto.setPrivado(999);
		
		//acesar novamente o valor privado
		System.out.println(objeto.getPrivado());
		
		
	}
	//so pode ser acessado mesma classe, vamos fazer de conta que os metodos de baixo sao em outra classe.
	private int privado;

	public int getPrivado() {
		return privado;
	}

	public void setPrivado(int privado) {
		this.privado = privado;
	}
	
	
	
	
}
