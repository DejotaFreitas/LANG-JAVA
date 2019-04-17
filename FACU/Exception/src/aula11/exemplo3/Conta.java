package aula11.exemplo3;

public class Conta {
	private String numero;
	private double saldo;
	
	public void depositar(double valor){
		saldo += valor;
	}
	
	public void sacar(double valor) throws SaldoInsuficienteException{
		if (valor <= saldo) {
			saldo -= valor;
		}else{
			throw new SaldoInsuficienteException("Saldo Insuficiente");
		}
	}
	
	public void exibirSaldo(){
		System.out.println("Saldo: R$ " + saldo);
	}
	public Conta(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
