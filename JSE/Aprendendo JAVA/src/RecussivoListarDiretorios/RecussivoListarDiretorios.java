package RecussivoListarDiretorios;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RecussivoListarDiretorios {

	public static void main(String[] args) {
		
		listar(Paths.get("D:/zzTI/"));
		System.out.println("Quantidade de Arquivos: "+cont);
	}
	static int cont = 0;
	public static void listar(Path path){

		if (Files.isRegularFile(path)) {
			System.out.println(path.toAbsolutePath());
			cont++;
		} else {
			System.out.println("\n"+path.toAbsolutePath());
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
				for (Path p : stream) {
					listar(p);
					cont++;
				}
			} catch (Exception e) {}
		}
	}
}
