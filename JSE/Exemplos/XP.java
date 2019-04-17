public class XP {
	public static void main(String[] args) {
		
		for (long i = 1, xp = 0; i <= 100; i++) {
			System.out.println("Nivel "+i+" : "+(xp += i)*1000);
		}
		
	}

}
