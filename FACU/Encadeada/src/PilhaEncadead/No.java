package PilhaEncadead;

public class No {
	private Object elemento;
	private No anterior;
	
	public void setElemento(Object elemento){
		this.elemento = elemento;
	}
	
	public Object getElemento(){
		return elemento;
	}
	
	public void setAnterior(No anterior){
		this.anterior = anterior;
	}
	
	public No getAnterior(){
		return anterior;
	}
}
