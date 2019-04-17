package OrdenarObjetosNomeIdade;

import java.util.ArrayList;
import java.util.Collections;

import OrdenarObjetosNomeIdade.Aluno.Sexo;


public class Main {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Xuxa", 23, Sexo.feminino);
		Aluno a2 = new Aluno("Angelica", 21, Sexo.feminino);
		Aluno a3 = new Aluno("Zeka Pagodinho", 22, Sexo.Masculino);
		Aluno a4 = new Aluno("Beka Pagodinnha", 19, Sexo.Masculino);
		
		ArrayList <Aluno> listAlunos = new ArrayList<Aluno>();
		listAlunos.add(a1);
		listAlunos.add(a2);
		listAlunos.add(a3);
		listAlunos.add(a4);
		
		
		CompararIdade compararIdade = new CompararIdade();
		Collections.sort(listAlunos, compararIdade);		
		
		for (Aluno aluno : listAlunos) {
			System.out.printf("nome: %s idade: %d Sexo: %s",
					aluno.getNome(), aluno.getIdade(),
					(aluno.getSexo()==aluno.getSexo().Masculino ? "Masculino" : "Feminino")
					+ "\n");
		}
		
		
		
		CompararNome compararNome = new CompararNome();
		Collections.sort(listAlunos, compararNome);		
		
		for (Aluno aluno : listAlunos) {
			System.out.printf("nome: %s idade: %d Sexo: %s",
					aluno.getNome(), aluno.getIdade(),
					(aluno.getSexo()==aluno.getSexo().Masculino ? "Masculino" : "Feminino")
					+ "\n");
		}
		
		
		
		
		
		
	}

}
