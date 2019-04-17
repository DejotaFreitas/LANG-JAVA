package Heranca;

public class Main {

	public static void main(String[] args) {
		
		Pessoa dejota = new Pessoa();
		dejota.nome = "Dejota";
		
		PessoaFisica dejotaFisico = new PessoaFisica();
		dejotaFisico.cpf = 123456;
		dejotaFisico.rg = 654321;
		
		Aluno dejotaAluno = new Aluno();
		dejotaAluno.instituicao = "IFCE";
		dejotaAluno.matricula = 1234567890;
		
		Pessoa dejotaAluno2 = new PessoaFisica();
		dejotaAluno2.dataNascimento = 19881206;
		
		Pessoa dejotaAluno3 = new Aluno();
		dejotaAluno3.sexo = true;
		
		
	}

}
