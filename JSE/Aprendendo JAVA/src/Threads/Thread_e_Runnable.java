package Threads;

public class Thread_e_Runnable {

	public static void main(String[] args) throws InterruptedException {
	//criar thread
		ClasseThread t = new ClasseThread();
		t.start(); //iniciar threar.

	//criar thread a partir da interface runnable
		ClasseRunnable r = new ClasseRunnable();
		Thread tr = new Thread(r);
		tr.start();


		
		
		System.out.println("Primeira a ser Executado");
		t.join(); //so executa resto do codigo quando a thead especificada for finalizada.
		System.out.println("Executado depois do termino da Thread t");
		tr.join();
		System.out.println("Executado depois do termino da Thread tr");
		t.join();
		tr.join();
		System.out.println("Executado depois do termino da Thread t e tr");
		
	}
}

//======Herdando da Classe Super Thread==============
class ClasseThread extends Thread {

	public void run() {	
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println("Thread = "+i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


//=======Herdando da Interface com mesma função da Thread========
//interface e bom caso a classe ja tenha extenditada de outra classe
class ClasseRunnable implements Runnable {

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1500);
				System.out.println("Runable = "+i);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
