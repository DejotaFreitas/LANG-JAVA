package ColletionsClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collection_02_Ultilitarios {

	public static void main(String[] args) {
		
		List<String> s = new ArrayList<>();
		s.add("Manga");
		s.add("Uva");
		s.add("Guaraná");
		s.add("Coco");
		s.add("Açaí");
		s.add("Banana");
		
		//embalha dados de forma aleatoria
		Collections.shuffle(s);
		System.out.println(s);
		
		//ordenar lista em ordem alfabetica
		Collections.sort(s);
		System.out.println(s);
		
		//ordem alfabetica einversa
		Collections.reverse(s);
		System.out.println(s);
		
		//Add varios elementos
		Collections.addAll(s, "Goiaba", "Acerola", "Abacate", "Abacate", "Abacate");
		System.out.println(s);
		
		//quantas vezes um elemento aparece
		System.out.println(Collections.frequency(s, "Abacate"));
		
		//pegar posição d um elemnto
		System.out.println(Collections.binarySearch(s, "Coco"));
		
		
		
		
		

	}

}
