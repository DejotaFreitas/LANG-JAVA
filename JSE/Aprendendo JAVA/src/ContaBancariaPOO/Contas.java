package ContaBancariaPOO;

public class Contas extends ContaBancaria{
	
	
		Contas(String client, String usuario, String senha, double saldo, boolean tipoConta) {
		super(client, usuario, senha, saldo, tipoConta);
			}

		void extrato(ContaBancaria client) {		
		System.out.println("Cliente: "+ client.getClient() );
		System.out.println("Saldo: "+ client.getSaldo());
		System.out.println("Tipo de Conta: "+ (client.getTipoConta() == true ? "Corrente":"Poupança"));
		
	}
	
	void sacar(ContaBancaria client, double sacar) {
		if (client.getSaldo()>=sacar) {
			client.setSaldo (client.getSaldo()-sacar);
		} else {
			System.out.println("Saldo Insuficiente.");
		}		
	}

	void deposito(ContaBancaria client, double deposito) {
		client.setSaldo (client.getSaldo()+deposito);
	}
	

	void tranferencia(ContaBancaria client, ContaBancaria destino, double valor) {
		client.sacar(client, valor);
		destino.deposito(destino, valor);	
		
	}

}
