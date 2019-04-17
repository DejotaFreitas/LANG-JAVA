/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quicontrole.telas.componentes;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ManipularImagem {
	
	
	public static BufferedImage setImagemDimensao(String caminhoImg, int largura, int altura) {
		try {
			BufferedImage imagem = ImageIO.read(new File(caminhoImg));			
			BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = novaImagem.createGraphics();
			g.drawImage(imagem, 0, 0, largura, altura, null);
			g.dispose();
			return novaImagem;
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	

}
