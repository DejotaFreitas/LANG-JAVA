package visao;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Janela extends JFrame {

	private static Janela janela;

	public void setPainel(JPanel painel) {
		janela.setContentPane(painel);
	}

	public static Janela getJanela() {
		return janela;
	}

	public Janela() {
		setTitle("Sistema Dejota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 600);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Janela.class.getResource("/imagens/surgeon1.png")));
		//setExtendedState(MAXIMIZED_BOTH);
		setContentPane(new PainelAcesso());
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela = new Janela();
					janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
