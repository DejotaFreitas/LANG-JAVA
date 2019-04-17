package ContaBancariaPOO;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
	////////database....
		
		ContaBancaria dejota = new Contas("Dejota", "dj", "0123", 10000.0, true);
		ContaBancaria litt = new Contas("LittBasker", "litt", "123", 25000.0, true);
		ContaBancaria jasher = new Contas("Jasher", "pika", "000", -1000, false);

		
		
		ContaBancaria[] listaContas = {dejota, litt, jasher};
		
	/////////////////////Logando...///////////////////////////////////		
		
		boolean procurandoConta = false;
		int contador = 0;
		boolean continuar = false;

		while(continuar == false){
			
		String nomeConta = JOptionPane.showInputDialog("Nome da Conta \n 0 - para sair" );
		if (nomeConta.equals("0")) {
			continuar=true;
		}
		
		RotuloProcurandoConta:
		for(ContaBancaria conta : listaContas){
			contador++;
			if (conta.getClient().equals(nomeConta)) {
				procurandoConta = true;				

				while (continuar==false) {					
				String usuario =JOptionPane.showInputDialog("Usuário.\n 0 - para sair");
				String senha = JOptionPane.showInputDialog("Senha.\n 0 - para sair");
				if (usuario.equals("0")||senha.equals("0")) {
					continuar=true;
				}
				if (conta.getUsuario().equals(usuario) && conta.getSenha().equals(senha)) {
					while (continuar==false) {
					try {
						int key = Integer.parseInt(JOptionPane.showInputDialog("1 - Ver Extrato \n 2 - sacar \n 3 - deposito\n 4 - Tranferencia \n 5 - Trocar Usuário \n6 - Sair"));
						switch (key) {
						case 1:	
							conta.extrato(conta);
							break;
						case 2:
							double sacar = Double.parseDouble(JOptionPane.showInputDialog("insira valor de saque"));
							conta.sacar(conta, sacar);
							break;
						case 3:
							double deposito = Double.parseDouble(JOptionPane.showInputDialog("insira valor de saque"));
							conta.deposito(conta, deposito);
							break;
						case 4:
							int contadorDestino = 0;
							String destino = JOptionPane.showInputDialog("Insira a conta de destino");
							for(ContaBancaria contaDestino : listaContas){
								contadorDestino++;
								if (contaDestino.getClient().equals(destino)) {
									double valor = Double.parseDouble(JOptionPane.showInputDialog("insira valor de transferencia"));
									conta.tranferencia(conta, contaDestino, valor);
									break;
								}
								if(contadorDestino >= listaContas.length){
									System.out.println("Conta de destino não existe.");
									contadorDestino = 0;									
									}					
								}
							break;
						case 5:	
							contador = 0;
							procurandoConta = false;
							break RotuloProcurandoConta;

						case 6:	
							continuar=true;
							break RotuloProcurandoConta;

						default:JOptionPane.showMessageDialog(null, "Opção Inválida");
							break;
						}
					///////////////////////////catch/////////////////////////////////	
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Opção Inválida");
					}
					//////////////////////////////////////////////////////////
					}
					
				} else {
					System.out.println("Ususário ou senha incorretas");
				}	
				}
			}
				if(contador >= listaContas.length && procurandoConta == false){
				System.out.println("Conta não existe.");
				contador = 0;
				}
			
			}
		
		}
		
	}
	
}
