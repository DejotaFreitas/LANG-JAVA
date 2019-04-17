package hashCOde_equal;

import java.util.HashSet;
import java.util.Set;

public class TesteCollection {
	 public static void main(String[] args) {
	        Set<Produto> produtos = new HashSet<>();

	        produtos.add(new Produto(1, "Caderno 96 folhas"));
	        produtos.add(new Produto(2, "Lapis 2B"));
	        produtos.add(new Produto(3, "Borracha"));
	        produtos.add(new Produto(4, "Estojo"));

	        //em algum ponto do programa que você não possui mais
	        //a variável de referência para o objeto que você quer
	        //encontrar na lista
	        Produto p = new Produto(4, "Estojo");
	        System.out.println(produtos.contains(p));
	    }
}
