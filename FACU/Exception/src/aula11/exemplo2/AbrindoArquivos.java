package aula11.exemplo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AbrindoArquivos {
	public static void main(String[] args) {
		try{
			abrirArquivo("C:/teste.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
	}

	private static void abrirArquivo(String caminho) throws FileNotFoundException{
		new FileInputStream(caminho);
		
	}
	
}
