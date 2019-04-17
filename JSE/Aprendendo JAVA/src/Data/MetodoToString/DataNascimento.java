package Data.MetodoToString;

public class DataNascimento {
	
	private String nome;
	private Data aniversario;
	
	public DataNascimento (String oNome, Data aData){
		nome = oNome;
		aniversario = aData;
	}
	
	public String toString (){
		return String.format("O meu nome é %s e eu nasci em %s.", nome, aniversario);
	}

}
