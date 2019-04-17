

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
			//codigo base, onde deve parar
			return 1;
		} else {
			//x*(x-1)*((x-1)-1)...*(1)
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
