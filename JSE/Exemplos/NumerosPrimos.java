

public class NumerosPrimos {
	public static void main(String[] args) {
		int primo = 0;
		for (int i = 1; i < 101; i++) {
			
			for (int j = 1; j < 100; j++) {
				
				if (i%j==0) {	primo++; }								
			}
			if (primo<=2) {
				System.out.println(i);
			}
			primo = 0;		

		}
	}

}
