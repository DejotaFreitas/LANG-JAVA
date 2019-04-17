

public class ArrayListSomaNumeros {
public static void main(String[] args) {
	

	System.out.println(soma(2,3,4,5,200));
	
	}

 static double soma (double ... numeros){
	double total = 0;
	for (double n: numeros) {
		total += n;
	}
	return total;
}
}
