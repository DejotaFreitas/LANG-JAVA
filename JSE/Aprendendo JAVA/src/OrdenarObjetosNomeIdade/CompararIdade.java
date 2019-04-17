package OrdenarObjetosNomeIdade;

import java.util.Comparator;

public class CompararIdade implements Comparator<Aluno> {
	
	//comparação para utilixação do metodo Colletions.sort();
	 public int compare(Aluno aluno, Aluno outroAluno) {
		 
		        if (aluno.getIdade() < outroAluno.getIdade()) {
		            return -1;
		        }
		        if (aluno.getIdade() > outroAluno.getIdade()) {
		            return 1;
		        }
		        return 0;	        
	 }
	 

	 
}