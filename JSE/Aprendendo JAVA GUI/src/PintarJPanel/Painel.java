package PintarJPanel;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Painel extends JPanel{
	public void paintComponent( Graphics g ){
	    super.paintComponent( g );
	    int pixel=0;
	    
	    for(pixel=0 ; pixel <= getHeight() ; pixel += 10){
	        g.drawLine(0, pixel, pixel, getHeight());
	        }

	    for(pixel=getHeight() ; pixel >=0 ; pixel -= 10){
	        g.drawLine(0, pixel, getHeight() - pixel, 0);
	    }
	    
	    for(pixel=0 ; pixel <= getHeight() ; pixel +=10){
	        g.drawLine(getWidth(), pixel, getWidth() - pixel, getHeight());
	    }
	    
	    for(pixel=getHeight() ; pixel >=0 ; pixel -= 10){
	        g.drawLine(getWidth(), pixel, getWidth() - (getHeight() - pixel), 0);
	    }
	    
	}
	
	public static void main(String[] args) {
		JFrame janela = new JFrame("Meu primeiro frame em Java");
		Painel meuPainel = new Painel();
		
		janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		janela.add(meuPainel);
		janela.setSize(600,400);
		janela.setVisible(true);
	}
}