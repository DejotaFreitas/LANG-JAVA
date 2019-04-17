package aula11.exemplo3;

public class UsaConta {
	public static void main(String[] args) {
		Conta c1 = new Conta("1234-5");
		c1.depositar(100);
		c1.exibirSaldo();
		try {
			c1.sacar(100);
			c1.sacar(30);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		c1.exibirSaldo();
		try {
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		c1.exibirSaldo();
		
	}
}





