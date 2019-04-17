package Socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("Conectando-se ao servior...");
		
		Socket cliente = new Socket("127.0.0.1", 9999);
		
		System.out.println("Conectado ao servidor!");
		
		InputStream recebendoDados = cliente.getInputStream();
		OutputStream enviandoDados = cliente.getOutputStream();
		
		BufferedReader recebido = new BufferedReader(new InputStreamReader(recebendoDados));
		PrintStream 	enviado = new PrintStream(enviandoDados);
		
		Scanner s = new Scanner(System.in);
		
		while (true) {
			System.out.println("Digite a Mensagem...");
			String msg = s.nextLine();
			enviado.println(msg);
			
			if ("fim".equalsIgnoreCase(msg)) { break; }
			
			msg = recebido.readLine();
			System.out.println("Mensagem recebida do servidor: "+ msg);
		}
		
		System.out.println("Encerrando conexao...");
		
		recebido.close();
		enviado.close();
		cliente.close();
		
		System.out.println("Cliente desconectado!");
		
	}

}
