package FramePanelLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame{
	
	JPanel painel;
	JButton butao;
	
	public JanelaPrincipal(){
		super("Nome da Janela");
		
		painel = new JPanel();
		this.add(painel);		
		painel.setLayout(null);
		
		butao = new JButton("Botão");
		painel.add(butao);
		butao.setBounds(100, 100, 70, 25); // (X, Y, Largura, Altura)
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	


}
