package zVariadas;

import java.util.HashMap;

public class HashMapMetodo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		HashMap h = new HashMap();
		h.put("Chave", "o que ta dentro do baú.");
		h.put(1, "um");
		h.put("um", 1);
		
		System.out.println(h.get("Chave"));
		System.out.println(h.get(1));
		System.out.println(h.get("um"));
		
	}

}
