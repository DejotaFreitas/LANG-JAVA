package MetodosFrutas;

public class MetodosFruta {

	private String fruta;
	
	public void setFruta(String nomeFruta){
		fruta = nomeFruta;		
	}
	
	public String getFruta(){
		return fruta;
	}
	
	public void imprimirFruta(){
		System.out.printf("Sua fruta é: %s", getFruta());
	}
	
}
