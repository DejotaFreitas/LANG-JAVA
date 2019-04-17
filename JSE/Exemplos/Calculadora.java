

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame {
	
	//Construtor
	public Calculadora(){
		super("Calculadora");		
		//container
		Container n = new JPanel();
		//gridlayout
		n.setLayout(new GridLayout(4,4,5,5));//4 
		n.add(new Button("7"));
		n.add(new Button("8"));
		n.add(new Button("9"));
		n.add(new Button("/"));
		n.add(new Button("4"));
		n.add(new Button("5"));
		n.add(new Button("6"));
		n.add(new Button("*"));
		n.add(new Button("1"));
		n.add(new Button("2"));
		n.add(new Button("3"));
		n.add(new Button("-"));
		n.add(new Button("0"));
		n.add(new Button("."));
		n.add(new Button("="));
		n.add(new Button("+"));		
		//campo de texto
		JTextField display = new JTextField();
		display.setFont(new Font("serif", Font.PLAIN, 30));
		//adicionando itens criado ao container
		Container c = getContentPane();
		c.add(BorderLayout.NORTH, display);
		c.add(BorderLayout.CENTER, n);
		
		//configuraçao basicas da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fechar no X
		setSize(300, 300); //Dimensoes
		setVisible(true); //se estar visivel
				
	}
	
	public static void main(String[] args) {		
		new Calculadora ();		
	}
}
