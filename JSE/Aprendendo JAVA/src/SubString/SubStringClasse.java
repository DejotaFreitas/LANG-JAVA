package SubString;

public class SubStringClasse {
	
	public static void main(String[] args) {
		
		//String a ser analisada
		String Str = new String("Clinica Antonio S/S");
		//Posição do caracter na string
		int pos = Str.indexOf("/");
		//Substring iniciando em 0 até posição do caracter especial
		System.out.println(Str.substring(0,pos ) );
		
		
		
	}

}
