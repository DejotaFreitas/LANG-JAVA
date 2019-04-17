
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sort0 {

	public static void main(String[] args) {
		
		int[] vetor10 = new int[10];		
		int[] vetor50 = new int[50];
		int[] vetor100 = new int[100];


		System.out.println("insertion 10");		
		insertion(vetor10);
		System.out.println("bubble 10");
		bubble(vetor10);
		System.out.println("selection 10");
		selection(vetor10);
		System.out.println();
		
		System.out.println("insertion 50");		
		insertion(vetor50);
		System.out.println("bubble 50");
		bubble(vetor50);
		System.out.println("selection 50");
		selection(vetor50);
		System.out.println();
		
		System.out.println("insertion 100");		
		insertion(vetor100);
		System.out.println("bubble 100");
		bubble(vetor100);
		System.out.println("selection 100");
		selection(vetor100);
		System.out.println();
	}

	
	
	//Metodos Sort
	//=============insertion===========================================================\\	
	public static void insertion(int[] vetor) {
		// Preenchendo Vetor
		Random r = new Random();
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = r.nextInt(100);
		}
		
		//Embaralhar, Ordenar e inverso
		List list = Arrays.asList(vetor);
		Collections.shuffle(list);
		Collections.sort(list);
		Collections.reverse(list);
		// Mostrar Vetor Desordenado
		System.out.println(Arrays.toString(vetor));
		
		// início contagem de tempo
		long inicio = System.nanoTime();

		// ordenando vetor
		int aux;
		for (int i = 1; i < vetor.length; i++) {
			for (int j = i; j > 0; j--) {
				if (vetor[j] < vetor[j - 1]) {
					aux = vetor[j];
					vetor[j] = vetor[j - 1];
					vetor[j - 1] = aux;
				}
			}
		}



		// fim contagem de tempo
		long fim = System.nanoTime();
		long tempo = fim - inicio;
		System.out.println("Tempo: " + tempo);
		
		// Mostrar Vetor Ordenado
		System.out.println(Arrays.toString(vetor));

	}
//================bubble========================================================\\	
	public static void bubble(int[] vetor) {
		// Preenchendo Vetor
		Random r = new Random();
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = r.nextInt(100);
		}
		
		//Embaralhar, Ordenar e inverso
		List list = Arrays.asList(vetor);
		Collections.shuffle(list);
		Collections.sort(list);
		Collections.reverse(list);
		// Mostrar Vetor Desordenado
		System.out.println(Arrays.toString(vetor));

		// início contagem de tempo
		long inicio = System.nanoTime();
						
		// ordenando vetor
		int aux;
		for (int i = vetor.length; i > 1; i--) {
			for (int j = 1; j < i; j++) {
				if (vetor[j] > vetor[j - 1]) {
					aux = vetor[j];
					vetor[j] = vetor[j - 1];
					vetor[j - 1] = aux;
				}
			}
		}
		
		// fim contagem de tempo
		long fim = System.nanoTime();
		long tempo = fim - inicio;
		System.out.println("Tempo: " + tempo);
		
		// Mostrar Vetor Ordenado
		System.out.println(Arrays.toString(vetor));

	}
	//=============Selection===========================================================\\
	public static void selection(int[] vetor) {
		
		// Preenchendo Vetor
		Random r = new Random();
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = r.nextInt(100);
		}
		
		//Embaralhar, Ordenar e inverso
		List list = Arrays.asList(vetor);
		Collections.shuffle(list);
		Collections.sort(list);
		Collections.reverse(list);
		// Mostrar Vetor Desordenado
		System.out.println(Arrays.toString(vetor));
		
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
	//========================================================================\\
}
