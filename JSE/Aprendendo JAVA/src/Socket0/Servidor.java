package Socket0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//Criar Servidor
		ServerSocket servidor = new ServerSocket(4500);
		
		//Aguardando alguem conecta-se e aceitar
		Socket novoCliente = servidor.accept();
		
		//mecanismo de receber as mensagens do cliente
		ObjectInputStream recebendoDados =new ObjectInputStream(novoCliente.getInputStream());
		
		//imprimindo dados recebidos
		System.out.println(recebendoDados.readObject());
		
		//responder a mensagem recebida ao  cliente
		ObjectOutputStream enviandoDados = new ObjectOutputStream(novoCliente.getOutputStream());
		
		//enviando dados em resposta ao cliente
		enviandoDados.writeObject("Ola Cliente");
		
		//encenrrando a conecção com cliente e servidor
		novoCliente.close();
		servidor.close();
	}
}
