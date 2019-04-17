package zVariadas;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class RelogioRunnable {
	public static void main(String[] args) {
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {  
			public void run() {  
				System.out.println((new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()))));  
		    }  
		 }; 
		 
		    timer.schedule(task, 0,1000);  //  (task, tempoPrimeiraInicialização, IntervaloEntreExecuçoes);
		}  
		
}
