package OrdenarObjetosNomeIdade;

import java.util.Comparator;

public class Aluno {
	
	public enum Sexo{
		Masculino,
		feminino;
	}
	
	private String nome;	
	private int idade;
	private Sexo sexo;
	
	public Aluno (String nome, int idade, Sexo sexo){
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	/*
	//Comparando automatica interno a classe, para ordenação
	 
	 //implements da classe
	 public class Aluno implementes Comparable<Aluno>{
	 
	 //Metodos
	//=========Comnparando Numeros=============================================
		public int compareTo(Aluno outroAluno) {
        if (this.idade < outroAluno.idade) {
            return -1;
        }
        if (this.idade > outroAluno.idade) {
            return 1;
        }
        return 0;
    }

	//=========Comparando String=============================================
	@Override
		public int compareTo(Aluno outroAluno) {
	        return this.nome.compareTo(outroAluno.nome);
	}
	*/
	//=======Get e Set===============================================
	
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	

}


