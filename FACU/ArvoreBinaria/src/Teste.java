
public class Teste {
	
	public static void main(String[] args) {
		
		ArvoreBinaria a = new ArvoreBinaria();
		a.add(15);
		a.add(20);
		a.add(18);
		a.add(25);
		a.add(16);
		a.add(19);
		a.add(30);
		a.add(17);
		a.add(27);
		a.add(10);
		a.add(6);
		a.add(12);
		a.add(5);
		a.add(9);
		a.add(8);
		a.add(7);
	
		a.imprimir();
		
		System.out.println("======================");
		a.remove(10);
		a.imprimir();
		
		
		
		
		
		
		
		
		
		
	}

}
