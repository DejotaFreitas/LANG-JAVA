package GarbageCollector_limparMemoria;

import java.util.ArrayList;
import java.util.List;

public class Garbage {
	public static void main(String[] args) {
	// Classe dos metodos de gerenciar memoria
	Runtime r = Runtime.getRuntime();
	
	// memoria maxima 
	//divide /1_048_576 pra tranformar byte em megabyte
	System.out.println("Memoria maxima disposinel: " + r.maxMemory()/1_048_576);
	
	//sobrecarregar memoria
	carregarMemoria();
	
	//mostrar memoria livre
	System.out.println("Memoria não utilizada: " + r.freeMemory()/1_048_576);
	
	//força a limpeza da memoria dos objetos nao ultilizada
	r.runFinalization();
	r.gc();
	
	//mostrar memoria livre
	System.out.println("Memoria não utilizada: " + r.freeMemory()/1_048_576);
	
	}
	
	//metodo pra sobrecarregar a memoria
	public static void carregarMemoria(){
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 100_000; i++) {
			l.add(i);
		}
	}
}
