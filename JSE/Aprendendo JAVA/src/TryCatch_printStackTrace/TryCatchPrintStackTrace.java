package TryCatch_printStackTrace;

import javax.swing.JOptionPane;

public class TryCatchPrintStackTrace {
	public static void main(String[] args) {
		
		boolean executadoComSucesso = false;
		
		while (executadoComSucesso == false) {
			
			try {
				double nota01 = Double.parseDouble(JOptionPane.showInputDialog("Insira Nota AP1"));
				double nota02 = Double.parseDouble(JOptionPane.showInputDialog("Insira Nota AP2"));
				System.out.println("Média é "+((nota01+nota02)/2));
				executadoComSucesso = true;
				
			} catch (Exception e) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Erro: " + e +
						"\n Deseja Tentar Novamente ?");
				
				if (resposta == JOptionPane.YES_OPTION) {
					executadoComSucesso = false;
				}
				else if (resposta == JOptionPane.NO_OPTION) {
					executadoComSucesso = true;
				}
				else if (resposta == JOptionPane.CANCEL_OPTION) {
					System.exit(0);
				}
				e.printStackTrace();
				
			}
			
		}

		
		
		
		
		
		
	}

}
