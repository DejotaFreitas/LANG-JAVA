package ColletionsClasses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collection_03_Set {
	public static void main(String[] args) {
		
		String [] s = {"Azul", "Azul", "Verde", "Amarelo",
							"Branco", "Branco", "Verde"};
		
		List l = Arrays.asList(s);
		System.out.println(l);
		
		// uma coleção SET nao aceita duplicata de elementos
		Set<String> set = new HashSet<>(l);
		System.out.println(set);
		
		
		
		
	}

}
