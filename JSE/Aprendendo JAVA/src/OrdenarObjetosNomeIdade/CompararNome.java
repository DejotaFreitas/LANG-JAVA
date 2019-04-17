package OrdenarObjetosNomeIdade;

import java.util.Comparator;

public class CompararNome implements Comparator<Aluno>{
	
	//comparação para utilixação do metodo Colletions.sort();	
	 public int compare(Aluno aluno, Aluno outroAluno) {
		 return aluno.getNome().compareTo(outroAluno.getNome());
	}
		 
		 
}
