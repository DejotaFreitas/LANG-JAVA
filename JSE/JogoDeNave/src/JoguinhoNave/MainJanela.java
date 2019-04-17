package JoguinhoNave;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainJanela extends JFrame{
	
	public MainJanela(){
		add(new Fase());
		setTitle("Joguinho de Nave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		MainJanela janela = new MainJanela();

	}

}
