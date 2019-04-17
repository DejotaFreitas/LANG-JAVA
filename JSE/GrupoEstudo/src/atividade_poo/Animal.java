package atividade_poo;

public abstract class Animal {
	private String nome;
	private int idade;
	
	public abstract void emitirSom();
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
