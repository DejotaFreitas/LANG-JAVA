package encadeadas;

public class No {
	
	private Object elemento;
	private No proximo;
	
	public No(){
	}
	
	public No(Object elemento){
		this.elemento = elemento;
	}
	
	
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
