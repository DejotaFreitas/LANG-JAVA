package GravarLerArquivo_SistemaBanco;

import java.util.ArrayList;

public class MainClasse {
	
	public static void main(String[] args) {

		ArrayList <Conta> c = new ArrayList<Conta>();
		c.add(new Conta(10000,"dj","0123","dejota",1000));
		c.add(new Conta(10001,"dj1","0123","dejota1",2000));
		c.add(new Conta(10002,"dj2","0123","dejota2",3000));
		c.add(new Conta(10003,"dj3","0123","dejota3",4000));
		c.add(new Conta(10004,"dj4","0123","dejota4",5000));
		
		Conta.gravarContas(c);
		
	
		for (Conta conta : Conta.lerContas()) {
			conta.extrato(conta);
		}
		System.out.println("Executou!!!");
		
		Conta.gravarContasSemApagarAnteriores(c);
		
		for (Conta conta : Conta.lerContas()) {
			conta.extrato(conta);
		}
		
		
		System.out.println("Executou!!!");
	}

}
