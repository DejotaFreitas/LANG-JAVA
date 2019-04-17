
public class vetorComArray implements Vector {

	private Object[] array;
	private int qtdElementos;

	public vetorComArray(int tam) {
		array = new Object[tam];
		qtdElementos = 0;
	}

	public void inserir(Object elemento, int pos) {
		if (isFull()) {
			dobrarArray();
		}
		if (checkRank(pos, true)) {
			for (int i = qtdElementos; i > pos; i--) {
				array[i] = array[i - 1];
			}
			array[pos] = elemento;
			qtdElementos++;
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

	public boolean isFull() {
		return qtdElementos == array.length;
	}

	public boolean checkRank(int pos, boolean ehInsercao) {
		if (ehInsercao) {
			return pos >= 0 && pos <= qtdElementos;
		} else {
			return pos >= 0 && pos < qtdElementos;
		}

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
			for (int i = pos; i < qtdElementos - 1; i++) {
				array[i] = array[i + 1];
			}
			array[qtdElementos] = null;
			qtdElementos--;
			return temp;
		} else {
			System.out.println("Posição inválida");
			return null;
		}
	}

	public Object trocarElemento(Object elemento, int pos) {
		if (checkRank(pos, false)) {
			Object temp = array[pos];
			array[pos]=elemento;
			return temp;
		}else{
			System.out.println("Posição inválida");
			return null;
		}
	}

	public boolean isEmpty() {
		return qtdElementos == 0;
	}

	public int size() {
		return qtdElementos;
	}

}
