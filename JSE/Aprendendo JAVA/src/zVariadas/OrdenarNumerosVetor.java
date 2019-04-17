package zVariadas;

import java.util.Arrays;

public class OrdenarNumerosVetor {
	public static void main(String[] args) {

		int[] vetor = {1000, 5, 9,564,55,21,45,32, 3, 8, 4, 6, 7, 2, 1, 3 ,9,1,0};
		
		
		for (int z = 0; z < (vetor.length-1); z++) {
			

			for (int i = 0, j = 1; j < vetor.length; i++, j++) {
				if (vetor[i] > vetor[j]) {
					int temp = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = temp;
				}
			}
			System.out.println("Tentativa "+ z);
			System.out.println(Arrays.toString(vetor));
		}

		System.out.println(Arrays.toString(vetor));
	}

}
