package ArquivosManipular;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainArquivos {

	public static void main(String[] args) throws IOException {
		
		Path caminho = Paths.get("D:/texto.txt");
		Charset utf8 = StandardCharsets.UTF_8;
		
		//escrever em arquivo
		try (BufferedWriter w = Files.newBufferedWriter(caminho, utf8)){
			w.write("Texto 1 ");
			w.write("Texto 2 ");
			w.write("Texto 3 \n");
			w.write("Texto 4 ");
			w.write("Texto 5 ");
		} catch (Exception e) {
			e.printStackTrace();			
		}

	
		try (BufferedReader r = Files.newBufferedReader(caminho, utf8)){
			String linha = null;
			while ((linha = r.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}	
		
		
		
		
		
		/*
		 //abrido arquivo
		BufferedWriter w = Files.newBufferedWriter(caminho, utf8);
		//Gardando Texto a memoria pc
		w.write("Texto 1 ");
		w.write("Texto 2 ");
		w.write("Texto 3 ");
		w.write("Texto 4 ");
		w.write("Texto 5 ");
		//pegando texto e colocando no arquivo
		w.flush();
		//fechando arquivo
		w.close(); 
		 */
				
		
		
	}

}
