


//Joguinho de advinhar qual numero de 0 a 100 saiu e quantidade de tentantivas gastas.

import javax.swing.JOptionPane;

public class AdvinharNumero {

	public static void main(String[] args) {

		//gerar numero aleatorio de 0 a 100
		int num = (int)(Math.random()*100);

		//variaveis de numero que vai inserido e numero de tantativas gasta.
		int num2 = 0;
		int i = 1;
		
		//Verificação se numero que vc inseriu é Maior ou Menor que numero aleatorio gerado.
		for (; num!=num2; i++) {
			
			num2 = Integer.parseInt(JOptionPane.showInputDialog("Tentativa "+i+" : Insira o Numero"));
			if (num>num2) {
				JOptionPane.showMessageDialog(null,"Tentativa "+i+" : Escolha um numero Maior");
			}else if (num<num2) {
					JOptionPane.showMessageDialog(null, "Tentativa "+i+" : Escolha um numero Menor");
				}
			}
		

			JOptionPane.showMessageDialog(null, "Tentativa "+i+" : Numero Correto!!!");
		
		
			
		}
	
}
