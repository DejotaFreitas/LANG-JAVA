package OrdenarObjetosLambida;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenarObjetosLambida {

	public static void main(String[] args) {
		List<Pessoa> listPessoas = Arrays.asList( new Pessoa("Eduardo", 29),
													new Pessoa("Luiz", 32),
													new Pessoa("Bruna", 26));
		
		System.out.println("Ordenando pessoas pelo nome:");
		Collections.sort(listPessoas, (Pessoa pessoa1, Pessoa pessoa2) -> pessoa1.getNome().compareTo(pessoa2.getNome()));	
		listPessoas.forEach(p -> System.out.println(p.getNome() + " : " + p.getIdade()));
		System.out.println("Ordenando pessoas pela idade:");
		Collections.sort(listPessoas, (Pessoa pessoa1, Pessoa pessoa2) -> pessoa1.getIdade() < pessoa2.getIdade() ? -1 : (pessoa1.getIdade() > pessoa2.getIdade() ? +1 : 0));
		listPessoas.forEach(p -> System.out.println(p.getNome() + " : " + p.getIdade()));
	}
}



	class Pessoa{
		private String nome;
		private int idade;
		
		public Pessoa(String nome, int idade){
			this.nome = nome;
			this.idade = idade;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}
		
}
