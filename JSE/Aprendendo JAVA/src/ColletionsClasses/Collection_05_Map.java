package ColletionsClasses;

import java.util.HashMap;
import java.util.Map;

public class Collection_05_Map {

	public static void main(String[] args) {
		
		//Map<tipo_Chave, tipoValor> //nao pode existir chaves iguais
		Map <String, String> m = new HashMap<>();
		m.put("BR", "Brasil");
		m.put("JP", "Japão");
		m.put("RU", "Russia");
		m.put("CN", "China");
		m.put("IN", "Índia");		
		System.out.println(m);
		
		//olhar se contem chave ou valor no Map
		System.out.println(m.containsKey("BR"));
		System.out.println(m.containsValue("Brasil"));
		
		//Acessar valor pela chave
		System.out.println(m.get("JP"));
		
		//remover elemento pela chave
		m.remove("RU");
		System.out.println(m);
		
		//retorna todas as chaves no Map
		System.out.println(m.keySet());
		
		

	}

}
