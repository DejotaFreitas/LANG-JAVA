package aula11.exemplo1;

public class FluxoDeExecucao {
	public static void main(String[] args) {
		System.out.println("início main");
		try{
			m1();
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Índice inválido");
		}
		System.out.println("fim main");
	}

	private static void m1() {
		System.out.println("início m1");
		m2();
		System.out.println("fim m1");
	}
	
	private static void m2() {
		System.out.println("início m2");
		int[] array = new int[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
			System.out.print(array[i] + " ");
		}
		
		System.out.println("fim m2");
	}
}





