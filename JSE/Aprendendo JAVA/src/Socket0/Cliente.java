package Socket0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		//conectando-se ao servidor
		Socket cliente = new Socket("127.0.0.1", 4500);
		
		//mecanismo de envio de dados para servidro
		ObjectOutputStream enviarDados = new ObjectOutputStream(cliente.getOutputStream());
		
		//enviar dados ao servidor
		enviarDados.writeObject("Ola Servidor");
		
		//mecanismo de receber a dados do servidor
		ObjectInputStream dadosRecebidos = new ObjectInputStream(cliente.getInputStream());
		
		//imprimindo dados recebida pelo servidor
		System.out.println(dadosRecebidos.readObject());
		
		//encerrando conecção
		cliente.close();
	}
}
