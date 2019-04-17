package TrabalhoDeListaEncadeada;

import javax.swing.JOptionPane;

public class CriandoLista {



	public static void main(String[] args) {
		
		// criando variáveis que receberam as posiçoes da lista, para ordena-la
		// inicializadas como null para verifica se a lista está vazia
		Lista inicio = null;
		Lista fim = null;
		Lista aux;
		Lista anterior;
		Lista novo;

		// loop para inseriar quantos elementos quantas vezes forem necessários.
		while (true) {
			
				//try catch pra previnir que programa para de executar caso ocorra erros
			try {
				// menu de seleção da função que deseja executar
				String chave = JOptionPane.showInputDialog(
						" Digite: \n 0 - Inserir no início da lista."
						+ " \n 1 - Inserir no final da lista."
						+ " \n 2 - Inserir na segunda posição da lista."
						+ " \n 3 - Imprimir a lista."
						+ " \n 4 - Para sair do programa.");
				
				//execucando de acordo com chave selecionada
				switch (chave) {
				
				//inserindo no início da lista
				case "0":
					//instaciando objeto novo
					novo = new Lista();
					
					//definindo nome e salário do objeto novo					
					novo.nome = JOptionPane.showInputDialog("Digite o NOME.");
					novo.salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o SAlÁRIO."));
					
					//SE se a lista estiver vazia faça isso, SE NÂO faça isso 
					if (inicio == null) {
						inicio = novo;
						fim = novo;
						novo.proximo = null;
					}else{
						novo.proximo = inicio;
						inicio = novo;						
					}
					break;
					
					//inserindo no fim da lista
				case "1":
					//instaciando objeto novo
					novo = new Lista();
					
					//definindo nome e salário do objeto novo					
					novo.nome = JOptionPane.showInputDialog("Digite o NOME.");
					novo.salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o SAlÁRIO."));
					
					//SE se a lista estiver vazia faça isso, SE NÂO faça isso 
					if (inicio == null) {
						inicio = novo;
						fim = novo;
						novo.proximo = null;
					}else{
						fim.proximo = novo;
						fim = novo;
						fim.proximo = null;
					}
					break;
					
					//inserindo na segunda posição da lista
				case "2":
					//instaciando objeto novo
					novo = new Lista();
					
					//definindo nome e salário do objeto novo					
					novo.nome = JOptionPane.showInputDialog("Digite o NOME.");
					novo.salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o SAlÁRIO."));
					
					//SE se a lista estiver vazia faça isso, SE NÂO faça isso 
					if (inicio == null) {
						inicio = novo;
						fim = novo;
						novo.proximo = null;
					}else{
						anterior = inicio.proximo;
						inicio.proximo = novo;
						novo.proximo = anterior;
					}
					break;
					
				case "3":
					//percorrendo e imprimindo lista
					System.out.println("Imprimmindo Lista...");
					aux = inicio;
					while (aux != null) {
						System.out.println("Nome: "+ aux.nome + " Salário: "+ aux.salario);
						aux = aux.proximo;
					}
					break;
					
				case "4":
					//ecerrando pragrama
					System.exit(0); 
					break;
	
				default:
					JOptionPane.showMessageDialog(null, "Numero inválido, use os valores indicados no menu.");
					break;
				}
			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valor inserido no salário é inválido ou ocorreu allgum erro, tente novamente.");
			}

		}

	}

}
