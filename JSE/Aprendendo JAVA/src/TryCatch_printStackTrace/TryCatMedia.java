package TryCatch_printStackTrace;

import javax.swing.JOptionPane;

public class TryCatMedia {

	public static void main(String[] args) {
		
		boolean b = true;
		float nota01, nota02, media;
		
		while (b == true) {
			try {
				
			nota01 = Float.parseFloat(JOptionPane.showInputDialog("Insira nota da AP01."));
			nota02 = Float.parseFloat(JOptionPane.showInputDialog("Insira nota da AP02."));
			media = (nota01+nota02)/2;
			
				if (media>=7) {
					JOptionPane.showMessageDialog(null, "Você foi aporvado! média = "+media);
				} else {
					JOptionPane.showMessageDialog(null, "Você foi reporvado! média = "+media+"\n Faça a AP03");
					float nota03 = Float.parseFloat(JOptionPane.showInputDialog("Insira nota da AP03."));
					
					if (nota01 >= nota02 && nota03 >= nota02) {
						media=(nota01+nota03)/2;
					} else if (nota02 >= nota01 && nota03 >= nota01){
						media=(nota02+nota03)/2;
					} else{
						media=(nota01+nota02)/2;
					}
					
					if (media>=7) {
						JOptionPane.showMessageDialog(null, "Você foi aporvado! média = "+media);
					} else {
						JOptionPane.showMessageDialog(null, "Você foi reporvado! média = "+media+"\n Refaça a cadeira.");
					}
		
				}
				b = false;
				
			} catch (Exception e) {
				int r = JOptionPane.showConfirmDialog(null, "Erro: "+e+ "\n Deseja tentar novamente.");

				if (r == 0) {
					//b = true;
				} else if(r == 1) {
					b = false;
				} else{
					System.exit(0);
				}			
			}
			
		}
		
	}

}
