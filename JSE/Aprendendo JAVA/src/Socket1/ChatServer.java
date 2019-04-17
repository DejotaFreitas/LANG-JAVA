package Socket1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
	
	List<PrintWriter> escritores = new ArrayList<>() ;	
	
	public ChatServer() {
		ServerSocket serve;
		try {
			serve = new ServerSocket(5000);
			while (true) {
				Socket socket = serve.accept();
				new Thread(new EscutaCliente(socket)).start();
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				escritores.add(p);
			}
		} catch (IOException e) {}
	}
	
	private class EscutaCliente implements Runnable{
		Scanner leitor;
		
		public EscutaCliente (Socket socket){
			try {
			leitor = new Scanner(socket.getInputStream());
			} catch (IOException e) {}
		}

		public void run() {
			try {
				String texto;
				while ((texto = leitor.nextLine()) != null) {
					System.out.println(texto);
					encaminharParaTodos(texto);
				}
			} catch (Exception e) {}
		}
		
	}
	
	private void encaminharParaTodos(String texto){
		for (PrintWriter w : escritores) {
			try{
			w.println(texto);
			w.flush();
			}catch(Exception e){}
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
