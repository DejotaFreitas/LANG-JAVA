import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {

		int[] vetor = { 5, 6, 2, 8, 2, 4, 45, 2, 9, 12 };

		SelectionSort(vetor);

		System.out.println(Arrays.toString(vetor));

	}

	public static void SelectionSort(int[] vetor) {
		int aux, menor;		
		long inicio = System.nanoTime();		
		for (int i = 0; i < vetor.length; i++) {
			menor = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j] < vetor[menor]) {
					menor = j;
				}
			}
			if (i!=menor) {
				aux = vetor[i];
				vetor[i] = vetor[menor];
				vetor[menor] = aux;
			}
		}
		long fim = System.nanoTime();
		long tempo = fim - inicio;
		System.out.println("Tempo: " + tempo);
		System.out.println(Arrays.toString(vetor));
	}
}
