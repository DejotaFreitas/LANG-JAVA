package RelogioTimerActionListener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class RelogioTimerActioListener {

	public static void main(String[] args) {

		MostrarHora e = new MostrarHora();
		//timer executa codgo dentro do metodo actionPerformed.
		Timer t = new Timer(1000, e);
		t.start();
		JOptionPane.showMessageDialog(null, "Click para Parar");
		System.exit(0);
		
	}

}

class MostrarHora implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		Date h = new Date();
		System.out.println(h);
		//Faz son
		Toolkit.getDefaultToolkit().beep();
	}

}