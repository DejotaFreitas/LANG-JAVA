package Data.MetodoToString;

public class DataMain {
	public static void main(String[] args) {
		
		Data obj1 = new Data(6, 12, 1988);		
		DataNascimento obj2 = new DataNascimento("Dejota", obj1);
		System.out.println(obj2);
		
	}

}
