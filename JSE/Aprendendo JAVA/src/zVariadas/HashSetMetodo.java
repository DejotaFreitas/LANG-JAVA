package zVariadas;

import java.util.HashSet;
import java.util.Set;

public class HashSetMetodo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		
		Set s = new HashSet();
		s.add("a");
		s.add("a");
		s.add("a");
		s.add(1);
		s.add(1);
		s.add(1);
		s.add(5.6);
		s.add(5.6);
		s.add(5.6);
		
		System.out.println(s.toString());
	}

}
