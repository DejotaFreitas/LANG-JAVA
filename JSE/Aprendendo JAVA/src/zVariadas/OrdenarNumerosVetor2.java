package zVariadas;

import java.util.Arrays;

public class OrdenarNumerosVetor2 {

	public static void main(String[] args) {
		
		int[] vetor = {1000, 5, 9,564,55,21,45,32, 3, 8, 4, 6, 7, 2, 1, 3 ,9,1,0};
		//Arrays.sort(vetor);//coloca vetor em ordem crescente
		Arrays.parallelSort(vetor, 0 , 5);//ordem crescente: escolhendo intervalo das posiçoes do vetor.
		System.out.println(Arrays.toString(vetor));
		

		
		
		

	}
}
