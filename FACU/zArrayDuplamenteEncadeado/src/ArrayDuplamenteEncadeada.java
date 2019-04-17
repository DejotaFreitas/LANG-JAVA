
public class ArrayDuplamenteEncadeada implements Vector {

	private Object[] array;
	private int tam;
	private DNode inicio;
	private DNode fim;

	public ArrayDuplamenteEncadeada(int tam) {
		array = new Object[tam];
		inicio = new DNode(null, null, null);
		fim = new DNode(inicio, null, null);
		inicio.setProx(fim);
	}

	public void inserir(Object elemento, int pos) {
		if (isFull()) {
			dobrarArray();
		}
		if (checkRank(pos, true)) {
			for (int i = tam; i > pos; i--) {
				array[i] = array[i - 1];
			}
			array[pos] = elemento;
			inserirPosicao(elemento, pos);
			tam++;
		} else {
			System.out.println("Posição inválida");
		}
	}

	void dobrarArray() {
		Object[] nArray = new Object[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			nArray[i] = array[i];
		}
		array = nArray;
	}

	public Object consultar(int pos) {
		if (checkRank(pos, false)) {
			return array[pos];
		} else {
			System.out.println("Posição inválida");
			return null;
		}
	}

	public Object remover(int pos) {
		if (checkRank(pos, false)) {
			Object temp = array[pos];
			for (int i = pos; i < tam - 1; i++) {
				array[i] = array[i + 1];
			}
			removePosicao(pos);
			array[tam] = null;
			tam--;
			return temp;
		} else {
			System.out.println("Posição inválida");
			return null;
		}
	}

	public Object trocarElemento(Object elemento, int pos) {
		if (checkRank(pos, false)) {
			Object temp = array[pos];
			array[pos] = elemento;
			return temp;
		} else {
			System.out.println("Posição inválida");
			return null;
		}
	}

	public boolean checkRank(int pos, boolean ehInsercao) {
		if (ehInsercao) {
			return pos >= 0 && pos <= tam;
		} else {
			return pos >= 0 && pos < tam;
		}

	}

	public boolean isFull() {
		return tam == array.length;
	}

	public boolean isEmpty() {
		return tam == 0;
	}

	public int size() {
		return tam;
	}

	private DNode buscaPosicao(int pos) {
		if (checkRank(pos, false)) {
			int meio = size() / 2;
			DNode aux = null;
			aux = inicio.getProx();
			if (pos < meio) {
				for (int i = 0; i != pos; i++) {
					aux = aux.getProx();
				}
				return aux;
			} else {
				aux = fim.getAnt();
				;
				for (int i = size() - 1; i != pos; i--) {
					aux = aux.getAnt();
				}
				return aux;
			}
		}
		return null;
	}

	private void inserirPosicao(Object elemento, int pos) {
		if (isEmpty()) {
			DNode novoNo = new DNode(inicio, fim, elemento);
			inicio.setProx(novoNo);
			fim.setAnt(novoNo);
		} else {
			DNode antigoNo = buscaPosicao(pos);
			if (antigoNo == null) {
				antigoNo = buscaPosicao(pos-1);
				DNode novoNo = new DNode(antigoNo, antigoNo.getProx(), elemento);
				antigoNo.getProx().setAnt(novoNo);
				antigoNo.setProx(novoNo);
			} else {
				DNode novoNo = new DNode(antigoNo.getAnt(), antigoNo, elemento);
				antigoNo.getAnt().setProx(novoNo);
				antigoNo.setAnt(novoNo);
			}
			
		}
	}

	private void removePosicao(int pos) {
		if (!isEmpty()) {
			DNode no = buscaPosicao(pos);
			no.getProx().setAnt(no.getAnt());
			no.getAnt().setProx(no.getProx());
		}
		
	}

	public void imprimirNo() {
		DNode aux = inicio.getProx();
		while (aux != fim) {
			System.out.print(aux.getElemento() + " ");
			aux = aux.getProx();
		}
		System.out.println();
	}

}
