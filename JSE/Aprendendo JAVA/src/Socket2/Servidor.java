package Socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Iniciando servidor...");
		
		ServerSocket servidor = new ServerSocket(9999);
		
		System.out.println("Servidor iniciado!");
		
		System.out.println("Aguardando conexao...");
		
		Socket novoCliente = servidor.accept();
		
		System.out.println("Conexao estabelecida!");
		
		InputStream recebendoDados = novoCliente.getInputStream();
		OutputStream enviandoDados = novoCliente.getOutputStream();
		
		BufferedReader recebido = new BufferedReader(new InputStreamReader(recebendoDados));
		PrintStream 	enviado = new PrintStream(enviandoDados);
		
		while (true) {
			String msg = recebido.readLine();			
			System.out.println("Cliente ["+ novoCliente.getLocalAddress().getHostName()+"] Mensagem: "+ msg);
			if ("fim".equalsIgnoreCase(msg)) {	break;	}
			enviado.println(msg);
		}
		
		System.out.println("Encerrando servidor...");
		
		recebido.close();
		enviado.close();
		novoCliente.close();
		servidor.close();	
		
		System.out.println("Servidor encerrado!");
		
	}

}
