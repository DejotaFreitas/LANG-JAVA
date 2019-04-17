package Aula01JFrame;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Janela01JFrame {

	public static void main(String[] args) {
		new Janela();
		
	}
	

}

@SuppressWarnings("serial")
class Janela extends JFrame{
	
	public Janela(){
		setTitle("Ying Yang");//Nome da janela
		setVisible(true);//tornar visivel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar quando clica no X
		setSize(700,600);//tamanho
		setLocationRelativeTo(null);//centralizar
		//setExtendedState(Frame.MAXIMIZED_BOTH);//maximizado
		//pack(); usar menor espasso possivel por componente.
		
		//instanciar imagem no icone da barra de titulo.
		Image yinyang = Toolkit.getDefaultToolkit().getImage("src/Aula01JFrame/yinyang.png");
		setIconImage(yinyang);

				
	}
}
