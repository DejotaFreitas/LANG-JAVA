package Threads;

public class ThreadClasseAnonima {

	public static void main(String[] args) {
		
		//thread simples que so tem metodo de run() para execuar algo sem conflito

		Runnable r1 = new Runnable() {			
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
						System.out.println("Thread = "+i);
					} catch (InterruptedException e) {}

				}			
			}
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
		
	
		//Expressão Lambida
		Runnable r2 = () -> {	
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("Thread = "+i);
				} catch (InterruptedException e) {}
			}				
		};
		
		//Expressão Lambida mas direta
		Thread t2 = new Thread(r1);
		t2.start();

		new Thread ( () -> {	
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("Thread = "+i);
				} catch (InterruptedException e) {}
			}				
		}).start();
			
	}

}
