package GridBagLayout;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Exemplo1 extends JFrame {

	public Exemplo1() {
		super("Exemplo1");

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();		

		GridBagConstraints cons = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		c.setLayout(layout);

		cons.weightx = 1;
		cons.weighty = 1;

		cons.anchor = GridBagConstraints.CENTER;

		cons.fill = GridBagConstraints.HORIZONTAL;

		
		
		cons.insets = new Insets(1, 1, 1, 1);
		
		/*
		 * cons.weighty = 1; 
		 * cons.weightx = 0.25; 
		 * c.add(new JButton("Esquerda"),* cons);
		 * 
		 * cons.weighty = 1; 
		 * cons.weightx = 0.75; 
		 * c.add(new JButton("Direita"), cons);
		 */

		
		
		cons.gridy = 0;
		cons.gridx = 0;
		c.add(new JButton("Esquerda"), cons);
		
		cons.gridy = 0;
		cons.gridx = 1;
		c.add(new JButton("Meio"), cons);

		cons.gridy = 0;
		cons.gridx = 2;
		c.add(new JButton("Direita"), cons);
		
		cons.gridy = 1;
		cons.gridx = 1;
		c.add(new JButton("Centro"), cons);

		cons.gridy = 2;
		cons.gridx = 0;
		c.add(new JButton("Esquerda"), cons);

		cons.gridy = 2;
		cons.gridx = 2;
		c.add(new JButton("Direita"), cons);
		
		//se alarga ate fim da janela nao importando quantos quadros
        cons.gridwidth = GridBagConstraints.REMAINDER;
        cons.gridy = 3;
		cons.gridx = 0;
		c.add(new JButton("Direita"), cons);

		this.setSize(600, 450);
		
		  

	}
	

	public static void main(String[] args) {
		Exemplo1 exe = new Exemplo1();
		exe.setVisible(true);
		;

	}
}