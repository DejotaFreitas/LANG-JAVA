

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tela extends JPanel implements Runnable, KeyListener {

	public static final int LARGURA = (int) ( Toolkit.getDefaultToolkit().getScreenSize().getWidth() );
	public static final int ALTURA = (int) ( Toolkit.getDefaultToolkit().getScreenSize().getHeight() );
	
	private Thread thread;
	private boolean executando;
	
	private BufferedImage imagem;
	private Graphics2D graphics2D;
	
	private int frames = 40;
	private int FPS = (1000 / frames);
	
	private Mapa mapa;
	private Jogador jogador;
	
	public Tela (){
		super();
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify(){
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		addKeyListener(this);
	}
	
	
	
	
	public void run() {	
		
		inicializar_Tela();
		
		long tempoInicial;
		long tempoEspera;
		
		while(executando){
			tempoInicial = System.nanoTime();
			
			atualizar_Tela();
			reproduzirDesenhos();
			desenhar();
			
			tempoEspera = FPS - ((System.nanoTime() - tempoInicial) / 1000000);
			
			try {
				Thread.sleep(tempoEspera);
			} catch (Exception e) {	}
			
		}
	}
	
	private void inicializar_Tela(){
		executando = true;
		imagem = new BufferedImage( LARGURA, ALTURA, BufferedImage.TYPE_INT_RGB);
		graphics2D = (Graphics2D) imagem.getGraphics();
		
		mapa = new Mapa("src/mapa.txt");
		mapa.carregarQuadros("src/tileset.gif");
		
	
		jogador = new Jogador (mapa);
		jogador.definirX_Jogador(100);
		jogador.definirY_Jogador(300);
	}
	
	private void atualizar_Tela (){
		mapa.atualizar_Mapa();
		jogador.atualizar_Jogador();		
	}
	
	private void reproduzirDesenhos (){
		
		graphics2D.setColor(Color.BLACK);
		graphics2D.fillRect(0, 0, LARGURA, ALTURA);
		
		mapa.Desenhar_Mapa(graphics2D);		
		jogador.desenhar_Jogador(graphics2D);
	}
	
	private void desenhar (){
		Graphics g2 = getGraphics();
		g2.drawImage(imagem, 0, 0, null);
		g2.dispose();		
	}
	
	public void keyTyped(KeyEvent key) {
				
	}

	public void keyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		
		if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
			jogador.setLeft(true);
		}
		if (code == KeyEvent.VK_RIGHT|| code == KeyEvent.VK_D) {
			jogador.setRight(true);
		}
		if (code == KeyEvent.VK_UP ||code == KeyEvent.VK_SPACE || code == KeyEvent.VK_W) {
			jogador.setJumping(true);
		}		
		if (code == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent key) {
		int code = key.getKeyCode();
			
		if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
			jogador.setLeft(false);
		}
		if (code == KeyEvent.VK_RIGHT|| code == KeyEvent.VK_D) {
			jogador.setRight(false);
		}		
	}

}
