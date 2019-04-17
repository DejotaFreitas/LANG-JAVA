package zVariadas;

import java.io.IOException;

public class LerTeclado {

	public static void main(String[] args) throws IOException {

		while (true) {
	        System.out.println("Pressione uma tecla");
	        int key = System.in.read();
	        System.out.println(key);
		}

	}

}
