package FilaEncadead;

public class No {
	public No(){
	}
	
	public No(Object elemento){
		this.elemento = elemento;
	}
	
	private Object elemento;
	private No proximo;
	
	public void setElemento(Object elemento){
		this.elemento = elemento;
	}
	
	public Object getElemento(){
		return elemento;
	}
	
	public void setProximo(No anterior){
		this.proximo = anterior;
	}
	
	public No getProximo(){
		return proximo;
	}
}
