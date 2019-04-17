package ColletionsClasses;

import java.util.ArrayList;
import java.util.List;

public class Collection_01_List {

	public static void main(String[] args) {
		
		// List aceita elementos duplicados
		List<String> l = new ArrayList();
		l.add("A");
		l.add("A");
		l.add("C");
		l.add("D");
		l.add("E");
				
		System.out.println(l.toString());
		
		//recupera valor na posição especifica como array
		System.out.println(l.get(1));
		//redefenir valor na posição especifica
		l.set(1, "B");
		
		//imprimir com for normal
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i)+", ");
		}
		System.out.println();
		
		//retorna posição de elemento
		System.out.println(l.indexOf("E"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
