package Recursao;

public class FatorialRecursao {

	
	public static void main(String[] args) {
		
		// fatorial = 5! = 5*4*3*2*1 = 120
		System.out.println(fatorial(5));
		System.out.println(fatorial2(5));
		
		// combinação de 3 elementos agrupados de 2 em 2.
		System.out.println(combinacao(3, 2));
		
	}
	//metodo fatorial Recursivo
	static long fatorial(long x){
		if (x<=1) {
			return 1;
		} else {
			return x * fatorial(x-1);
		}
	}
	
	//metodo fatorial simples
	static long fatorial2(long x){
		long total = 1;
		for (int i = 2; i <= x; i++) {
			total *=i;
		}
		return total;	
	}
	//metodo combinação usando metodo fatorial
	static long combinacao(long numeroElementos, long deQuantoEmQuanto){		
		long combinacao = fatorial(numeroElementos)/(fatorial(deQuantoEmQuanto)*fatorial((numeroElementos-deQuantoEmQuanto)));
		return combinacao;
	}

}
