

//Software que calacula e classifica seu IMC.

import javax.swing.JOptionPane;

public class IMC {	
	
public static void main(String[] args) {
	
	//"If" ,"Else" e "Else if"
	
	
	//recebendo valores necessarios
	double peso = Double.parseDouble(JOptionPane.showInputDialog("Insisra seu Peso"));
	double altura = Double.parseDouble(JOptionPane.showInputDialog("Insisra sua Altura"));
	
	//calculando indice de massa corporal.
	double imc = peso / (altura*altura);
	
	//pesoMax/(altura*altura) = 25;
	double pesoMax = 25*(altura*altura);
	
	
	
	//calssificando e exibindo mensagem com informação da sua categoria.
	if (imc<20){
		JOptionPane.showMessageDialog(null, "Abaixo do Peso \n IMC: "+ imc );
	}else if(imc>=20 && imc<=25){
		JOptionPane.showMessageDialog(null, "Peso Ideal \n IMC: "+ imc);
	}else if(imc>25 && imc<=30){
		JOptionPane.showMessageDialog(null, "Sobrepeso \n IMC: "+ imc);
	}else if(imc>30 && imc<=35){
		JOptionPane.showMessageDialog(null, "Obesidade Moderada \n IMC: "+ imc);
	}else if(imc>35 && imc<=40){
		JOptionPane.showMessageDialog(null, "Obesidade Servera \n IMC: "+ imc);
	}else if(imc>40 && imc<=50){
		JOptionPane.showMessageDialog(null, "Obesidade Mórbida \n IMC: "+ imc);
	}else{
		JOptionPane.showMessageDialog(null, "Super Obesidade \n IMC: "+ imc);
	}
	
	JOptionPane.showMessageDialog(null, "Seu peso maximo para ter IMC idea eh: "+ pesoMax);
}
}
