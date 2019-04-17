
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Janela extends JFrame {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Janela().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	// =========================================================================
	public Janela() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true); // tira contornoda janela
		//setAlwaysOnTop(true); //nao da alt-tab
		setResizable(false);
		setContentPane(new Tela());
		pack();
	}

	public void cursorPersonalizado(String caminho) {
		this.setCursor(
				Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon(caminho).getImage(), new Point(0, 0), ""));
	}

}
