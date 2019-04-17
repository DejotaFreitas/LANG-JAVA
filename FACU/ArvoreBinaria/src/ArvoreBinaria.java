
public class ArvoreBinaria {

	private No raiz;

	public No getRaiz() {
		return raiz;
	}

	public void add(int valor) {
		if (raiz == null) {
			raiz = new No(valor);
		} else {
			addNo(raiz, valor);
		}
	}

	private void addNo(No no, int valor) {
		if (valor != no.getValor()) {

			if (valor < no.getValor()) {

				if (no.getEsquerda() == null) {
					no.setEsquerda(new No(valor));
				} else {
					addNo(no.getEsquerda(), valor);
				}

			} else if (valor > no.getValor()) {

				if (no.getDireita() == null) {
					no.setDireita(new No(valor));
				} else {
					addNo(no.getDireita(), valor);
				}

			}

		} else {
			System.out.println(valor + " já existe, valores inseridos devem ser únicos!");
		}
	}

	public void remove(int valor) {
		if (raiz != null) {
			removeNo(valor, raiz, null);
		} else {
			System.out.println("Árvore vazia!");
		}

	}

	private void removeNo(int valor, No no, No anterior) {
		if (valor != no.getValor()) {

			if (valor < no.getValor()) {
				if (no.getEsquerda() != null) {
					removeNo(valor, no.getEsquerda(), no);
				} else {
					System.out.println("Valor não encontrado!");
				}

			} else if (valor > no.getValor()) {

				if (no.getDireita() != null) {
					removeNo(valor, no.getDireita(), no);
				} else {
					System.out.println("Valor não encontrado!");
				}

			}

		} else {

			if (no.getEsquerda() == null && no.getDireita() == null) {

				if (no == raiz) {
					raiz = null;
					return;
				}

				if (no.getValor() > anterior.getValor()) {
					anterior.setDireita(null);
				} else {
					anterior.setEsquerda(null);
				}

			} else if (no.getEsquerda() != null ^ no.getDireita() != null) {

				if (no == raiz) {
					if (raiz.getEsquerda() != null) {
						raiz = raiz.getEsquerda();
					} else {
						raiz = raiz.getDireita();
					}
					return;
				}

				if (no.getEsquerda() != null) {

					if (no.getValor() > anterior.getValor()) {
						anterior.setDireita(no.getEsquerda());
					} else {
						anterior.setEsquerda(no.getEsquerda());
					}

				} else {

					if (no.getValor() > anterior.getValor()) {
						anterior.setDireita(no.getDireita());
					} else {
						anterior.setEsquerda(no.getDireita());
					}

				}

			} else if (no.getEsquerda() != null && no.getDireita() != null) {

				if (no.getEsquerda().getDireita() != null) {

					No anteriorAux = no.getEsquerda();
					No aux = no.getEsquerda().getDireita();

					while (aux.getDireita() != null) {
						anteriorAux = aux;
						aux = aux.getDireita();
					}

					no.setValor(aux.getValor());
					if (aux.getEsquerda() != null) {
						anteriorAux.setDireita(aux.getEsquerda());
					} else {
						anteriorAux.setDireita(null);
					}

				} else {

					if (no.getEsquerda().getValor() > anterior.getValor()) {
						anterior.setDireita(no.getEsquerda());
						no.getEsquerda().setDireita(no.getDireita());
					} else {
						anterior.setEsquerda(no.getEsquerda());
						no.getEsquerda().setDireita(no.getDireita());
					}

				}

			}

		}
	}

	public void imprimir() {
		if (raiz != null) {
			imprimirNO(raiz);
		} else {
			System.out.println("Árvore vazia!");
		}
	}

	private void imprimirNO(No no) {
		if (no != null) {
			System.out.println(no.getEsquerda()+"-["+no+"]-"+no.getDireita());
			imprimirNO(no.getEsquerda());
			imprimirNO(no.getDireita());
		}
	}

}
