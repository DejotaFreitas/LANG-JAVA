package LoguinSenha;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoguinSenha extends JFrame implements ActionListener {
	//metodo classe principal
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		LoguinSenha janela = new LoguinSenha();
	
	}
	//login e senha para testar
	private String usuario = "Dejota";
	private String senha = "0123";

	//componentes da janela
	private JButton logar;
	private JButton cancelar;
	private JTextField campoLogar;
	private JPasswordField campoSenha;

	//metodo construtor
	public LoguinSenha() {
		
		//ConfiguraçoesJanela
		super("Tela de Acesso"); // criando janela e add titulo.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar quando clicar no X
		setSize(500, 280);//Diemensoes da janela
		setResizable(false);//desativar botao maximizar		
		setLocationRelativeTo(null);// Centralizar Janela


		
		//criando botões
		// adicionar eventos aos butoes.
		logar = new JButton("Logar");
		logar.addActionListener(this);

		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);

		campoLogar = new JTextField();
		campoLogar.addActionListener(this);

		campoSenha = new JPasswordField();
		campoSenha.addActionListener(this);

		// add componenetes a janela.
		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("Usuário"));
		c.add(campoLogar);
		c.add(new JLabel("Senha"));
		c.add(campoSenha);
		c.add(logar);
		c.add(cancelar);
	
		
		//pack(); //faz componentes utilizarem menor espaço possivel
		setVisible(true);//torna visivel		
		campoLogar.requestFocus(); //voltar curso para campo de usuário
	}

	public void actionPerformed(ActionEvent e) {

		// voltar curso para campo de usuário
		campoLogar.requestFocus();

		// Se clicar em logar, ou apertar Enter campo de usuario ou senha.
		if (e.getSource() == logar || e.getSource() == campoLogar || e.getSource() == campoSenha) {
			
			// Verificar se usuario e senha estao corretos.
			if ((campoLogar.getText().equals(usuario))
					//transformar passowrd ****** em string e compara com senha do usuario.
					&& (new String(campoSenha.getPassword()).equals(senha))) {

				// execução caso loguim e senha corretos
				JOptionPane.showMessageDialog(null,	"Login executado com sucesso");
				
				// Lipando campos login e senha.
				campoLogar.setText("");
				campoSenha.setText("");


			} else {
				JOptionPane.showMessageDialog(null, "Login ou Senha Inválidos");
				// Lipando campos login e senha.
				campoLogar.setText("");
				campoSenha.setText("");

			}

		} else if (e.getSource() == cancelar) {
			// Lipando campos login e senha.
			campoLogar.setText("");
			campoSenha.setText("");

		}

	}

}
