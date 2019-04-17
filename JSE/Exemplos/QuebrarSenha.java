


//Programinha pra descobrira palavra de entrada de 3 letras de a~z em minusculo.

import javax.swing.JOptionPane;

public class QuebrarSenha {
	public static void main(String[] args) {
		
		String kkk [] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","w","y","z"};
		
		String palavra = JOptionPane.showInputDialog("Insira uma palavra de 3 letras de a~z todas em minuculas");
		String senha = "";
		int tentativas = 1;

		for (int i = 0; i < kkk.length && !palavra.equals(senha); i++) {
			for (int j = 0; j < kkk.length && !palavra.equals(senha); j++) {
				for (int k = 0; k < kkk.length && !palavra.equals(senha); k++) {
										
					senha = kkk [i]+kkk [j]+kkk [k];

					
					System.out.println("Numero de Tentativas: "+(tentativas));
					tentativas++;
				}
				
			}
			
		}
		
		System.out.println("A palavra que vc digitou foi: "+senha);
		
	}

}
