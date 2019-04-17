package ColletionsClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Collection_00_Geral {

	public static void main(String[] args) {

		Collection<String> c = new ArrayList<>();
		//adicionar elemento
		c.add("A");
		c.add("B");
		c.add("C");
		//remover elemento
		c.remove("A");
		//converte coleção em string
		System.out.println(c.toString());
		//olhar se a coleção esta vazia
		System.out.println(c.isEmpty());
		//olhar se tem um elemnto especifico dentro da coleção
		System.out.println(c.contains("B"));
		//olhar tamanho da coleção
		System.out.println(c.size());
		

		//converter array em coleção
		Collection<String> c2 = Arrays.asList("O", "U", "X", "Y", "Z");
		//adicionar, remover e verificar uma coleção a outra
		c.addAll(c2);
		System.out.println(c.toString());
		System.out.println(c.containsAll(c2));
		c.removeAll(c2);
		System.out.println(c.toString());	
		
		//converter coleção em array
		String [] s = c.toArray(new String [c.size()]);
		System.out.println(c.toString());
		
		//limpar coleção
		c.clear();
		System.out.println(c.toString());
		
		
		
		
		
		
		
		
	}

}
