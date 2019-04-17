
public class CountingSort {
	
public static void main(String[] args) {
		
		int[] desordenado = {7,2,4,3,10,1};
		System.out.println("Vetor Desordenado");
		for (int i = 0; i < desordenado.length; i++) {
			System.out.println(desordenado[i]);
		}
		
		int[] ordenado = ordenacao(desordenado);
		
		System.out.println("Vetor ordenado");
		for (int i = 0; i < ordenado.length; i++) {
			System.out.println(ordenado[i]);
		}
		
	}

	public static int[] ordenacao(int[] array){
		
		int[] r = new int[array.length];
		int min = 0;
		int max = 0;
		
		//setando os valores do maximo e minimo;
		for (int i = 1; i < array.length; i++){
			if(array[i] < min){
				min = array[i];
			}else if (array[i] > max){
				max = array[i];
			}
		}
		
		int[] aux = new int[max-min+1];
		//for para contar os valores;
		for (int i = 0; i < array.length; i++){
			aux[array[i]-min]++;
		}
		
		//for para fazer o agrupamento e alocar os indices;
		aux[0]--;
		for (int i =1; i < aux.length; i++){
			aux[i] = aux[i] + aux[i-1];
		}
		
		System.out.println("Vetor auxiliar");
		for(int i = 0; i < aux.length; i++){
			System.out.println(aux[i]);
		}
		
		
		//for para fazer a distribuição dos valores no vetor ordenado...
		for (int i = array.length-1; i>= 0; i--){
			r[aux[array[i] - min]--] = array[i];
		}
		
				
		return r;
	}
}
