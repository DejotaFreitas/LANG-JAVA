package Pilha;


import javax.swing.JOptionPane;

public class MainPilha {

	private static class Pilha {
		int valor;
		Pilha proximo;

	}

	public static void main(String[] args) {

		Pilha topo = null;
		Pilha aux = null;
		Pilha novo = null;
		int chave = 0;
		int busca;
		int cont = 0;

		while (chave != 6) {
			chave = Integer.parseInt(JOptionPane.showInputDialog(	"1 - INSERIR OBJETO, \n" 
																									+ "2 - CONSULTAR PILHA\n"
																									+ "3 - REMOVER DA PILHA,\n" 
																									+ "4 - ESVAZIAR PILHA\n" 
																									+ "5 - MOSTRAR PILHA \n" 
																									+ "6 - SAIR"));
			switch (chave) {
			case 1:
				novo = new Pilha();
				novo.valor = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE O VALOR"));
				novo.proximo = topo;
				topo = novo;
				break;

			case 2:
				aux = topo;
				busca = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual valor deseja buscar?"));
				while (aux != null) {
					if (aux.valor == busca)
						cont++;
					aux = aux.proximo;
				}

				System.out.println("Valor encontrado " + cont + " vez(es).");
				break;

			case 3:
				topo = topo.proximo;
				break;

			case 4:
				if (topo == null) {
					System.out.println("LISTA JÁ ESTÁ VAZIA!");
				} else {
					topo = null;
					System.out.println("LISTA ESVAZIADA!");
				}
				break;

			case 5:
				System.out.println("=================");
				cont = 0;
				aux = topo;
				if (aux == null) {
					System.out.println("LISTA VAZIA!");
				} else {
					do {
						System.out.println(aux.valor);
						aux = aux.proximo;
					} while (aux != null);
				}
				break;

			case 6:
				chave = 6;
				break;

			default:
				break;
			}

		}

	}

}
