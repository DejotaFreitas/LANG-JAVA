


import java.util.ArrayList;
import java.util.Scanner;

public class arraylist {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ArrayList <String> produtos =  new ArrayList<> ();
		Scanner s = new Scanner (System.in);
		System.out.println("Insira od nomes dos produtos, caso contrario digite Fim");
		
		String produto = null;
		
		//equals - Diferecia Maiscula e Menuscula.
		//equalsIgnoreCase - Ignora se é maiuscula oou menuscula.
		while (!"FIM".equalsIgnoreCase(produto = s.nextLine() )) {
			produtos.add(produto);
	}
		System.out.println(produtos.toString());
	}

}
