package br.com.quicontrole.telas.componentes;

import javax.swing.JOptionPane;

import br.com.quicontrole.Inicializar;

public class Msg {
	

	public static void m(String msg) {
		 JOptionPane.showMessageDialog(Inicializar.getJanela(), msg);
	}
	
	public static int msn(String msg, String tittle) {
		return JOptionPane.showOptionDialog(Inicializar.getJanela(), msg, tittle,
				 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				 null, null, null);
	}
	


}
