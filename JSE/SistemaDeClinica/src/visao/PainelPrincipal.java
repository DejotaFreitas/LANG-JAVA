package visao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PainelPrincipal extends JPanel {


	public PainelPrincipal() {
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(198, 144, 89, 23);
		add(btnNewButton);
		
		JLabel lb_fundo = new JLabel("");
		lb_fundo.setBounds(0, 0, 1600, 900);
		lb_fundo.setIcon(new ImageIcon(Janela.class.getResource("/imagens/fundoazul.jpg")));
		add(lb_fundo);

	}

}
