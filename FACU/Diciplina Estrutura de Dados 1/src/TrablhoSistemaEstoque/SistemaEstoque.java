package TrablhoSistemaEstoque;
import javax.swing.JOptionPane;


public class SistemaEstoque {

	public static void main(String[] args) {

		while (true) {
			try {

				int opcao = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n"
						+ " 0 - Cadastrar de produtos CodigoAI\n 1 - Venda de produtos\n"
						+ " 2 - Compra de produtos\n 3 - Cadastrar novo produto\n 4 - Alterar produto\n"
						+ " 5 - Consultar estoque\n 6 - Listar estoque\n 7 - Excluir Produto\n 8 - Sair\n"));

				switch (opcao) {
				// ===========Venda de produtos==============
				case 0:
					Produto.cadastarProdutoCodigoAI();
					break;
				// ===========Venda de produtos==============
				case 1:
					Produto.venderProduto();
					break;
				// ===========Compra de produtos=============
				case 2:
					Produto.comparProduto();
					break;
				// ===========Cadastrar novo===============
				case 3:
					Produto.cadastrarProduto();
					break;
				// ===========Alterar produto================
				case 4:
					Produto.alterarProduto();
					break;
				// ===========Consultar estoque==============
				case 5:
					Produto.buscarProduto();
					break;
				// ===========Listar Estoque===============
				case 6:
					Produto.listarProduto();
					break;

				// ===========Sair======================
				case 7:
					Produto.excluirProduto();
					break;

				// ===========Sair======================
				case 8:
					System.exit(0);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção inválida! \nInsira uma opção corepondente ao menu.");
					break;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro!\nVoltanto ao menu principal...");
			}
		}

	}

	// =========Classe Produto==================================
	
	@SuppressWarnings("unused")
	private static class Produto {
		int codigo;
		String nome;
		int quantidade;
		float preco;
		Produto proximo;
		private static Produto inicio = null;
		private static Produto fim = null;
		private static int codigoAI = 0;

		// =======listarProduto====================================
		
		public static void listarProduto() {
			if (inicio != null) {
				Produto aux = inicio;
				System.out.println();
				while (aux != null) {
					System.out.println(toString(aux));
					aux = aux.proximo;
				}
			} else {
				System.out.println("Estoque vazio.");
			}

		}

		// ========buscarProduto===================================
		public static Produto buscarProduto() {
			try {
				if (inicio == null) {
					JOptionPane.showMessageDialog(null, "Estoque Vazio.");
					return null;
				}
				while (true) {
					int opcao = Integer
							.parseInt(JOptionPane.showInputDialog("1 - Busca por Código.\n2 - Busca por Nome.\n"));
					Produto aux = null;
					switch (opcao) {
					case 1:
						return buscarProdutoCodigo();
					// break;

					case 2:
						return buscarProdutoNome();
					// break;

					default:
						JOptionPane.showMessageDialog(null, "Opção inválida! \nInsira uma opção corepondente ao menu.");
						break;
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro!\nVoltanto ao menu principal...");
			}
			return null;
		}

		// ========buscarProduto===================================
		public static Produto buscarProdutoNome() {
			try {
				String nome = JOptionPane.showInputDialog("Digite o NOME do Produto.");
				Produto aux = inicio;
				while (aux != null) {
					if (aux.nome.equals(nome)) {
						System.out.println("Produto Encontrado!");
						System.out.println(toString(aux));
						return aux;
					}
					aux = aux.proximo;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro!\nVoltanto ao menu principal...");
			}
			System.out.println("Produto não encontrado");
			return null;
		}

		// ========buscarProdutoCodigo===================================
		public static Produto buscarProdutoCodigo() {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite a CÓDIGO do Produto"));
				Produto aux = inicio;
				while (aux != null) {
					if (aux.codigo == codigo) {
						System.out.println("Produto Encontrado!");
						System.out.println(toString(aux));
						return aux;
					}
					aux = aux.proximo;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro!\nVoltanto ao menu principal...");
			}
			System.out.println("Produto não encontrado");
			return null;
		}

		// ==========comparProduto=================================
		public static void comparProduto() {
			Produto produto = buscarProduto();
			if (produto == null) {
				int n = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o Produro?", "Aviso!",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					cadastarProdutoCodigoAI();
				}
			} else {
				produto.quantidade += Integer.parseInt(
						JOptionPane.showInputDialog("Digite a QUANTIDADE de " + produto.nome + " deseja comprar."));
				System.out.println(toString(produto));
				System.out.println("Comprado com sucesso.");

			}
		}

		// ==========comparProduto=================================
		public static void venderProduto() {
			Produto produto = buscarProduto();
			if (produto == null) {
				int n = JOptionPane.showConfirmDialog(null, "Deseja cadastar o Produro?", "Aviso!",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					cadastarProdutoCodigoAI();				
				}
			} else {
				int qnt = Integer.parseInt(
						JOptionPane.showInputDialog("Digite a QUANTIDADE de " + produto.nome + " deseja vender."));
				if (qnt <= produto.quantidade) {
					produto.quantidade -= qnt;
					System.out.println("Vendido com sucesso.");
					System.out.println(toString(produto));
				} else {
					JOptionPane.showMessageDialog(null, "Quantidade insuficiente!");
					System.out.println("Quantidade insuficiente!");
					System.out.println(toString(produto));
				}
			}
		}
		
		private static int gerarCodigo(){
			codigoAI += 1;			
			Produto aux = inicio;
			while (aux != null) {
				if (aux.codigo == codigoAI) {
					return gerarCodigo();
				}
				aux = aux.proximo;
			}			
			return codigoAI;			
		}
		
		public static void cadastarProdutoCodigoAI(){
			
			
			String nomeCadastro = JOptionPane.showInputDialog("Digite o NOME do Produto.");
			int quantidadeCadastro = Integer.parseInt(JOptionPane.showInputDialog("Digite a QUANTIDADE do Produto."));
			float precoCadastro = Float.parseFloat(JOptionPane.showInputDialog("Digite o PREÇO do Produto."));
			int codigoCadastro = gerarCodigo();
						
			Produto produto = new Produto();
			produto.codigo = codigoCadastro;
			produto.nome = nomeCadastro;
			produto.quantidade = quantidadeCadastro;
			produto.preco = precoCadastro;

			if (inicio == null) {
				inicio = produto;
				fim = produto;
				produto.proximo = null;
			} else {
				fim.proximo = produto;
				fim = produto;
				fim.proximo = null;
			}
			
		}

		// ===========registrarProduto================================
		public static void cadastrarProduto() {
			int codigoCadastro = Integer.parseInt(JOptionPane.showInputDialog("Digite a CÓDIGO do Produto."));
			Produto aux = inicio;
			while (aux != null) {
				if (aux.codigo == codigoCadastro) {
					int n3 = JOptionPane.showConfirmDialog(null,
							"Código de Produto ja existe. \nDeseja Inserir um novo CÓDIGO?", "Aviso!",
							JOptionPane.YES_NO_OPTION);
					if (n3 == 0)
						cadastrarProduto();
					return;
				}
				aux = aux.proximo;
			}
			
			String nomeCadastro = JOptionPane.showInputDialog("Digite o NOME do Produto.");
			int quantidadeCadastro = Integer.parseInt(JOptionPane.showInputDialog("Digite a QUANTIDADE do Produto."));
			float precoCadastro = Float.parseFloat(JOptionPane.showInputDialog("Digite o PREÇO do Produto."));
			
			Produto produto = new Produto();
			produto.codigo = codigoCadastro;
			produto.nome = nomeCadastro;
			produto.quantidade = quantidadeCadastro;
			produto.preco = precoCadastro;

			if (inicio == null) {
				inicio = produto;
				fim = produto;
				produto.proximo = null;
			} else {
				fim.proximo = produto;
				fim = produto;
				fim.proximo = null;
			}
		}

		// ===========================================
		public static void alterarProduto() {
			Produto produto = buscarProduto();
			if (produto != null) {
				int num = Integer.parseInt(
						JOptionPane.showInputDialog("1 - Alterar NOME do Produto.\n2 - Alterar PREÇO do Produto."));
				if (num == 1) {
					produto.nome = JOptionPane.showInputDialog("Digite o novo NOME do Produto.");
					System.out.println(toString(produto));
					System.out.println("Produto aterado com sucesso.");
				} else if (num == 2) {
					produto.preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o novo PREÇO do Produto."));
					System.out.println(toString(produto));
					System.out.println("Produto aterado com sucesso.");
				} else {
					System.out.println("Opção Inválida");
				}
			}

		}

		// ===========================================
		public static void excluirProduto() {
			Produto produto = buscarProduto();
			if (produto != null) {
				Produto anterior = null;
				Produto aux = inicio;
				while (aux != null) {
					if (aux == produto) {
						if (aux == inicio) {
							inicio = inicio.proximo;
							System.out.println("Excluido com sucesso.");
							return;
						} else {
							anterior.proximo = aux.proximo;
							System.out.println("Excluido com sucesso.");
							return;
						}
					}
					anterior = aux;
					aux = aux.proximo;

				}
			}
		}
		
		// ===========================================
		private static String toString(Produto produto){
			return String.format("Código: %d, Nome: %s, Quantidade: %d, Preço: R$ %.2f", produto.codigo,
					produto.nome, produto.quantidade, produto.preco);
		}

	}

}
