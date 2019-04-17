package Singleton;

public class Singleton {

	public static void main(String[] args) {

		Singleton2.getSingleton();

	}
	
}

class Singleton2 {
	
	private static Singleton2 variavel;
	
	public synchronized static Singleton2 getSingleton(){
		if (variavel == null) {
			System.out.println("Variavel Nula");
			variavel = new Singleton2();
		}
		return variavel;		
	}
}