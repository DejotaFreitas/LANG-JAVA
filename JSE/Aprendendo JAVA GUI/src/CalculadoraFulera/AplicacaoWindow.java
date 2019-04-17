package CalculadoraFulera;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AplicacaoWindow {

	private JFrame frame;
	private JTextField tf_soma;
	private JTextField tf_menos;
	private JTextField tf_veses;
	private JTextField tf_dividi;
	private JTextField tf_num01;
	private JTextField tf_num02;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacaoWindow window = new AplicacaoWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacaoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSoma = new JButton("Soma");
		btnSoma.setBounds(10, 11, 99, 23);
		frame.getContentPane().add(btnSoma);
		
		JButton btnSubtrao = new JButton("Subtra\u00E7\u00E3o");
		btnSubtrao.setBounds(10, 45, 99, 23);
		frame.getContentPane().add(btnSubtrao);
		
		JButton btnMultiplicao = new JButton("Multiplica\u00E7\u00E3o");
		btnMultiplicao.setBounds(10, 79, 99, 23);
		frame.getContentPane().add(btnMultiplicao);
		
		JButton btnDivisao = new JButton("Divisao");
		btnDivisao.setBounds(10, 113, 99, 23);
		frame.getContentPane().add(btnDivisao);
		
		tf_soma = new JTextField();
		tf_soma.setBounds(119, 12, 86, 20);
		frame.getContentPane().add(tf_soma);
		tf_soma.setColumns(10);
		
		tf_menos = new JTextField();
		tf_menos.setBounds(119, 46, 86, 20);
		frame.getContentPane().add(tf_menos);
		tf_menos.setColumns(10);
		
		tf_veses = new JTextField();
		tf_veses.setBounds(119, 80, 86, 20);
		frame.getContentPane().add(tf_veses);
		tf_veses.setColumns(10);
		
		tf_dividi = new JTextField();
		tf_dividi.setBounds(119, 114, 86, 20);
		frame.getContentPane().add(tf_dividi);
		tf_dividi.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero 01");
		lblNumero.setBounds(290, 15, 62, 14);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblNumero_1 = new JLabel("Numero 02");
		lblNumero_1.setBounds(290, 83, 62, 14);
		frame.getContentPane().add(lblNumero_1);
		
		tf_num01 = new JTextField();
		tf_num01.setBounds(280, 46, 86, 20);
		frame.getContentPane().add(tf_num01);
		tf_num01.setColumns(10);
		
		tf_num02 = new JTextField();
		tf_num02.setBounds(280, 114, 86, 20);
		frame.getContentPane().add(tf_num02);
		tf_num02.setColumns(10);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float num01 = Float.parseFloat(tf_num01.getText());
				float num02 = Float.parseFloat(tf_num02.getText());
				float soma = num01+num02;
				float menos = num01-num02;
				float veses = num01*num02;
				float dividi = num01/num02;
				
				tf_soma.setText(""+soma);
				tf_menos.setText(""+menos);
				tf_veses.setText(""+veses);
				tf_dividi.setText(""+dividi);
			}
		});
		btnExecutar.setBounds(280, 174, 89, 23);
		frame.getContentPane().add(btnExecutar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tf_num01.setText("");
				tf_num02.setText("");
				tf_soma.setText("");
				tf_menos.setText("");
				tf_veses.setText("");
				tf_dividi.setText("");
			}
		});
		btnLimpar.setBounds(119, 174, 89, 23);
		frame.getContentPane().add(btnLimpar);
	}
}
