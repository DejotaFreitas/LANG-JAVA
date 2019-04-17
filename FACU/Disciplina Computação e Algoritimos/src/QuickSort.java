
public class QuickSort {
	
	
	public static void main(String[] args) {

		int[] lista = { 14, 32, 67, 76, 23, 41, 58, 85, 100, 287, 700, 2837, 281, 100 };

		quickSort(lista, 0, lista.length - 1);

		new QuickSort().imprimir(lista);

	}
	
	
	
	
	
	public int[] imprimir(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		return a;
	}

	public static int partition(int a[], int esquerda, int direita) {

		int i = esquerda, j = direita;
		int tmp;
		int pivo = a[(esquerda + direita) / 2];

		while (i <= j) {

			while (a[i] < pivo) {
				i++;
			}
			while (a[j] > pivo) {

				j--;
			}

			if (i <= j) {

				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		}
		;

		return i;
	}

	public static void quickSort(int a[], int esquerda, int direita) {

		int index = partition(a, esquerda, direita);
		if (esquerda < index - 1) {
			quickSort(a, esquerda, index - 1);
		}

		if (index < direita) {
			quickSort(a, index, direita);
		}
	}



}