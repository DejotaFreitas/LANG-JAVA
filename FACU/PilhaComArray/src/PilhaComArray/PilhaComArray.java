package PilhaComArray;

public class PilhaComArray {
	
	private Object[] pilha;
	private int top = -1;

	public PilhaComArray(int tamanho) {
		pilha = new Object[tamanho];
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public boolean isFull() {
		return top >= pilha.length - 1;
	}

	public void push(Object element) {
		if (!isFull()) {
			top += 1;
			pilha[top] = element;
		}else{
			System.out.println("Pilha está cheia!");
		}
	}

	public void remove() {
		if (!isEmpty()) {
			pilha[top] = null;
			top -= 1;
		}else{
			System.out.println("Pilha está vazia!");
		}
	}


	public void showAll() {
		for (int i = top; i >= 0; i--) {
			System.out.println(pilha[i]);
		}
	}

	public void showSize() {
		System.out.println(top + 1);
	}	
	
	public void invetPile() {
		Object[] a = new Object[pilha.length];
		Object[] b = new Object[pilha.length];
		for (int i = top, j = 0; i >= 0; i--, j++)
			a[j] = pilha[i];
		for (int i = top, j = 0; i >= 0; i--, j++)
			b[j] = a[i];
		for (int i = top, j = 0; i >= 0; i--, j++)
			pilha[j] = b[i];
	}

}
