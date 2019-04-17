

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField valor;
	private JTextField resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setTitle("Conversor de Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnConversor = new JButton("Conversor");
		btnConversor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
///////////////////////////////////////////////////////////////////////
				float fahrenheit = Float.parseFloat(valor.getText());
				float celsius = ((fahrenheit-32f)/1.8f);
				resultado.setText(celsius+ " ºC");
///////////////////////////////////////////////////////////////////////
			}
		});
		btnConversor.setFont(new Font("Arial Black", Font.PLAIN, 26));
		contentPane.add(btnConversor, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 5, 5));
		
		JLabel lblFarenhaid = new JLabel("Farenhaid");
		lblFarenhaid.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarenhaid.setFont(new Font("Arial Black", Font.PLAIN, 26));
		panel.add(lblFarenhaid);
		
		valor = new JTextField();
		valor.setHorizontalAlignment(SwingConstants.CENTER);
		valor.setFont(new Font("Arial Black", Font.PLAIN, 26));
		panel.add(valor);
		valor.setColumns(10);
		
		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelsius.setFont(new Font("Arial Black", Font.PLAIN, 26));
		panel.add(lblCelsius);
		
		resultado = new JTextField();
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setFont(new Font("Arial Black", Font.PLAIN, 26));
		panel.add(resultado);
		resultado.setColumns(10);
	}

}
