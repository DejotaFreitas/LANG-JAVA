package Lambida;

import java.util.Arrays;
import java.util.List;

public class ListaDeNumeros {

	public static void main(String[] args) {
		System.out.println("Imprime o quadrado de todos os elementos da lista!");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.forEach(n -> System.out.println(n));
		}

}
