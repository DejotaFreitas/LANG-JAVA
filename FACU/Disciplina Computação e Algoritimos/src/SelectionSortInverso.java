import java.util.Arrays;

public class SelectionSortInverso {
	public static void main(String[] args) {

		int[] vetor = { 5, 6, 2, 8, 2, 4, 45, 2, 9, 12 };

		SelectionS(vetor);

	}

	public static void SelectionS(int[] vetor) {
		int aux, maior;		
		long inicio = System.nanoTime();		
		for (int i = vetor.length-1; i < 0; i--) {
			maior = i;
			for (int j = i-1; j < 0; j--) {
				if (vetor[j] > vetor[maior]) {
					maior = j;
				}
			}
			if (i!=maior) {
				aux = vetor[i];
				vetor[i] = vetor[maior];
				vetor[maior] = aux;
			}
		}
		long fim = System.nanoTime();
		long tempo = fim - inicio;
		System.out.println("Tempo: " + tempo);
		System.out.println(Arrays.toString(vetor));
	}
}
