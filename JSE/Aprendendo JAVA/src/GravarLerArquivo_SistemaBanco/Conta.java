package GravarLerArquivo_SistemaBanco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Conta {
	
	private int contaID;
	private String loguin;
	private String senha;
	private String cliente;
	private double saldo;
	
	//==Contrutores============================================================
	public Conta (){}
	
	public Conta (int contaID, String loguin, String senha, String cliente, double saldo){
		this.contaID = contaID;
		this.loguin = loguin;
		this.senha = senha;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	//===metodos da Conta======================================================
	public void extrato(Conta conta) {
		System.out.println("Cliente: "+ conta.cliente);
		System.out.println("Saldo: "+ conta.saldo);		
	}

	public synchronized void sacar(Conta conta, double sacar) {
		if (sacar<=conta.saldo) {
			conta.saldo -= sacar;
			System.out.println("Sucesso em saque.");
		} else {
			System.out.println("Saldo Insuficiente.");
		}		
	}

	public synchronized void depositar(Conta conta, double deposito) {
		conta.saldo += deposito;
		System.out.println("Sucesso em depositar.");
	}

	public synchronized void tranferir(Conta conta, double valor, Conta destino) {
		conta.sacar(conta, valor);
		destino.depositar(destino, valor);	
	}
	
	//===Gravar e Ler Contas=========================================
	private static Path caminho = Paths.get("src/GravarLerArquivo_SistemaBanco/contas.txt");
	private static Charset utf8 = StandardCharsets.UTF_8;
	
	public static void gravarContas(ArrayList<Conta> contas){
		try (BufferedWriter w = Files.newBufferedWriter(caminho, utf8)){	
			for (Conta conta : contas) {
				w.write(conta.contaID+ ";"+
						conta.loguin+";"+
						conta.senha+";"+
						conta.cliente+";"+
						conta.saldo+"\n");
			}
		} catch (Exception e) {	}
	}
	
	public static void gravarContasSemApagarAnteriores(ArrayList<Conta> contas){
		String diretorio = "src/GravarLerArquivo_SistemaBanco/contas.txt";
		try (BufferedWriter w = new BufferedWriter(new FileWriter(diretorio, true))){	
			for (Conta conta : contas) {
				w.write(conta.contaID+ ";"+
						conta.loguin+";"+
						conta.senha+";"+
						conta.cliente+";"+
						conta.saldo+"\n");
			}
		} catch (Exception e) {	}
	}
	
	public static ArrayList<Conta> lerContas(){
		ArrayList<Conta> contas = new ArrayList<Conta>();
		try (BufferedReader r = Files.newBufferedReader(caminho, utf8)){
			String linha = null;
			while ((linha = r.readLine()) != null) {
				String[] t = linha.split(";");
				contas.add(new Conta(Integer.parseInt(t[0]),t[1],t[2],t[3],	Double.parseDouble(t[4])));
			}
		} catch (Exception e) { }
		return contas;
	}
	
}
