package MetodosFrutas;

import javax.swing.JOptionPane;


public class MetodosFrutaMain {
	public static void main(String[] args) {
		MetodosFruta objeto = new MetodosFruta();
		objeto.setFruta(JOptionPane.showInputDialog("Qual sua Fruta Favorita"));
		objeto.imprimirFruta();
		
	}

}
