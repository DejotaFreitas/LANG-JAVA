package estruturadados.listas.duplamenteencadeada;

public class DNode {
	private Object elemento;
	private DNode ant;
	private DNode prox;
	
	public DNode(DNode ant, DNode prox, Object elemento){
		this.ant = ant;
		this.prox = prox;
		this.elemento = elemento;
	}
	
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public DNode getAnt() {
		return ant;
	}
	public void setAnt(DNode ant) {
		this.ant = ant;
	}
	public DNode getProx() {
		return prox;
	}
	public void setProx(DNode prox) {
		this.prox = prox;
	}
}
