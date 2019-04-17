package visao;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class PainelAcesso extends JPanel implements ActionListener {

	private String usuario = "Dejota";
	private String senha = "0123";
	
	private JTextField campoLogar;
	private JPasswordField campoSenha;
	private JButton bt_logar;

	public PainelAcesso() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		campoLogar = new JTextField();
		campoLogar.setFont(new Font("Verdana", Font.PLAIN, 16));
		campoLogar.setBounds(280, 116, 144, 20);
		campoLogar.addActionListener(this);
		campoLogar.setColumns(10);
		add(campoLogar);

		campoSenha = new JPasswordField();
		campoSenha.setBounds(280, 147, 144, 20);
		campoSenha.addActionListener(this);
		add(campoSenha);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Verdana", Font.BOLD, 16));
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setBounds(197, 116, 73, 14);
		add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 16));
		lblSenha.setBounds(197, 147, 73, 14);
		add(lblSenha);

		bt_logar = new JButton("Acessar");
		//bt_logar.setBackground(new Color(255, 255, 255, 30));
		bt_logar.setBounds(339, 178, 83, 23);
		bt_logar.setForeground(Color.BLACK);
		bt_logar.addActionListener(this);
		add(bt_logar);

		JLabel lb_fundo = new JLabel("");
		lb_fundo.setBounds(0, 0, 1600, 900);
		lb_fundo.setIcon(new ImageIcon(Janela.class.getResource("/imagens/fundoazul.jpg")));
		add(lb_fundo, BorderLayout.CENTER);
		//add(lb_fundo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		campoSenha.requestFocus();
		if (e.getSource() == bt_logar || e.getSource() == campoLogar || e.getSource() == campoSenha) {
			if ((campoLogar.getText().equals(usuario)) && (new String(campoSenha.getPassword()).equals(senha))) {
				setVisible(false);
				Janela.getJanela().setPainel(new PainelPrincipal());
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos");
				campoSenha.setText("");
			}
		}
	}
	
	
	
	

}
