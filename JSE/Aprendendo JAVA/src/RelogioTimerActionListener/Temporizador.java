package RelogioTimerActionListener;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Temporizador {
	
	public static void main(String[] args) {
		
		new Temporizador().iniciarRelogio(1000, true);
		JOptionPane.showMessageDialog(null, "Click para parar");
		System.exit(0);				
	}

	public void iniciarRelogio(int tempo, boolean son){
		
		class RodarRelogo implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				System.out.println(new Date());
				if (son) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		RodarRelogo e = new RodarRelogo();
		Timer t = new Timer(tempo, e);	
		t.start();
	}

}



