package br.com.quicontrole.telas.componentes;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CampoTextoMascarado extends JFormattedTextField{
	private static final long serialVersionUID = -624716875291658549L;

	public CampoTextoMascarado(String mascara) {
		this.setFont(new Font("Arial", Font.CENTER_BASELINE,16));
		this.setHorizontalAlignment(JTextField.CENTER);
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
			mask.setPlaceholderCharacter('_');
			mask.setOverwriteMode(true);  
			mask.setValidCharacters("0123456789"); 
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		mask.install(this);
		
	}
	
	public String getTexto(){
		String textoSemMascara = this.getText(); 
		textoSemMascara = textoSemMascara.replace(".",""); 
		textoSemMascara = textoSemMascara.replace("-","");   
		textoSemMascara = textoSemMascara.replace("/",""); 
		textoSemMascara = textoSemMascara.replace("_","");
		return textoSemMascara;
	}

}
