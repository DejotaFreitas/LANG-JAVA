
import javax.swing.JOptionPane;


public class Senha {

	public static void main(String[] args) {
		
		
		String senha = "zxc0123";
		
		String testarSenha = "";
		
		
		while(senha.equals(testarSenha)==false){
			testarSenha=JOptionPane.showInputDialog("Insira  a senha");
			if (senha.equals(testarSenha)==false) {
				JOptionPane.showMessageDialog(null, "Senha Incorreta");
			}
		}
		
		JOptionPane.showMessageDialog(null, "Senha Correta");
	
	}

}
