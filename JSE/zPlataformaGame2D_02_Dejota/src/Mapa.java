import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

public class Mapa {
	
	private int x;
	private int y;
	
	private final int tamanhoTile = 32;
	private int [][] mapa;
	private int larguraDoMapa;
	private int alturaDoMapa;
	
	private BufferedImage tileInteiro;
	private Quadro [][] mapaTiles;
	
//============Construtor======================================================\\
	
	public Mapa(String caminhoDoArquivoTXT){		
		try {			
			//descobrindo e definido tamanho da Matriz do mapa
			larguraDoMapa = descobrindoLargura(caminhoDoArquivoTXT);
			alturaDoMapa = descobrindoAltura(caminhoDoArquivoTXT);			
			mapa = new int [alturaDoMapa] [larguraDoMapa];
			
			//colocando valores do arquivo na matriz
			@SuppressWarnings("resource")
			BufferedReader leitorDoAquivo = new BufferedReader(new FileReader(caminhoDoArquivoTXT));			
			for (int linhas = 0; linhas < alturaDoMapa; linhas++) {
				String linha = leitorDoAquivo.readLine();
				String [] umaLinhaDoMapa = linha.split("\\s+");
				for (int colunas = 0; colunas < larguraDoMapa; colunas++) {
					mapa [linhas][colunas] = Integer.parseInt(umaLinhaDoMapa[colunas]);
				}				
			}			
			
		} catch (Exception e) {}			
	}	


//==================Metodos de Atualizaçao=================================================\\
	public void atualizar_Mapa(){		
		
	}
	
	public void carregarQuadros(String caminhoDaImagem){
		try {
			//auto descobrindo quantidade de tiles e definido a Matriz
			//+1 pq tile tem espaçmentos entre eles.... tirar recomendado
			tileInteiro = ImageIO.read(new File(caminhoDaImagem));
			int quantidadeLinhasTiles = (tileInteiro.getHeight() +1) / (tamanhoTile+1);
			int quantidadeColunasTiles = (tileInteiro.getWidth() +1) / (tamanhoTile+1);
			mapaTiles = new Quadro[quantidadeLinhasTiles][quantidadeColunasTiles];
			
			//colacando Tiles na Matriz
			// tiles tem 1 pixel de espaçamento entre os outros tiles, menos os das bordas
			//tiles nas linhas pares nao tem colisão (0,2,4,6,8,10...)
			BufferedImage subimage;
			for (int yTile = 0; yTile < quantidadeLinhasTiles; yTile++) {
				for (int xTile = 0; xTile < quantidadeColunasTiles; xTile++) {
					subimage = tileInteiro.getSubimage(xTile*tamanhoTile+xTile, yTile*tamanhoTile+yTile, tamanhoTile, tamanhoTile);
					mapaTiles[yTile][xTile] = new Quadro (subimage, ((yTile%2) == 0? false : true));// colidivel se tive na linha par					
				}
			}
		} catch (Exception e) {	}		
	}
	
	public void Desenhar_Mapa(Graphics2D g){
		for (int linhas = 0; linhas < alturaDoMapa; linhas++) {
			for (int colunas = 0; colunas < larguraDoMapa; colunas++) {				
				// sacada de genio
				int linhaColuna = mapa [linhas][colunas];
				int linha = linhaColuna / mapaTiles[0].length;
				int coluna = linhaColuna % mapaTiles[0].length;
				
				g.drawImage(
						mapaTiles[linha][coluna].obterImagem_Quadro(),
						x + colunas * tamanhoTile,
						y + linhas * tamanhoTile,
						null
						);
				
			}
		}
	}
	
//===================Get e Set======================================================\\
	
		public int obterX_Mapa(){ return this.x; }
		public int obterY_Mapa(){ return this.y; }
		public void definirX_Mapa(int x){ this.x = x; }
		public void definirY_Mapa(int y){ this.y = y; }
		
		public int obterColunaDoQuadro_Mapa(int x){return x / tamanhoTile;}	
		public int obterLinhaDoQuadro_Mapa(int y){return y / tamanhoTile;}	
		public int obterQuadro_Mapa(int linha, int colluna){ return mapa[linha][colluna]; }	
		public int obterTamanhoQuadro_Mapa(){ return tamanhoTile; }
		
		public boolean obterColisivelDoQuadro_Mapa(int linha, int colluna){ 
			int lc = mapa [linha][colluna];
			int l = lc / mapaTiles[0].length;
			int c = lc % mapaTiles[0].length;
			return mapaTiles [l][c].obterColisivel_Quadro();
		}
			
//=============Metodos descobrir linas e colunas do arquivo de Texto do mapa===========\\	
		
		private int descobrindoLargura(String caminhoDoArquivo){
			int largura = 0;
			BufferedReader leitorLargura;
			try {
				leitorLargura = new BufferedReader(new FileReader(caminhoDoArquivo));
				String linha = leitorLargura.readLine();
				List <String> larguraMapa = new ArrayList<String>();
				larguraMapa = Arrays.asList(linha.split("\\s+"));
				largura =  larguraMapa.size();					
			} catch (Exception e) {}
			return largura;	
		}		
		
		@SuppressWarnings("unused")
		private int descobrindoAltura(String caminhoDoArquivo){
			int altura = 0;
			BufferedReader leitorAltura;
			String linhaAltura;
			try {
				leitorAltura = new BufferedReader(new FileReader(caminhoDoArquivo));
				while ((linhaAltura = leitorAltura.readLine())  != null)
					altura += 1;
			} catch (Exception e) {}
			return altura;
		}

}
