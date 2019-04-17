package trabalho.filaDePrioridades;

import trabalho.imprimivel.Imprimivel;

public class Multa implements Imprimivel{
	//valor total da multa
	private double total;
	//quantidades de multas recebidas
	private int quantidade;
	
	public void addMulta(){
		total += 1000;
		quantidade += 1;
	}
	
	//construtor
	public void addMulta(double valor){
		total += valor;
		quantidade += 1;
	}
	
	//get e set
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//metodo toString
	public String toString() {
		return "Multa: Quantidade: "+quantidade+" - Total: "+total;
	}

	//sobrescrita do metodo imprimir da interface imprimivel
	public void imprimir() {
		System.out.println(this);
	}
	
	

}
