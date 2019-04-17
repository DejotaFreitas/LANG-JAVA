package jplay;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame {
	public static Window instance;
	private Keyboard keyboard;
	private BufferStrategy buffer;
	private Graphics graphics;
	private long currTime;
	private long lastTime;
	private long totalTime;
	private DisplayMode displayMode;
	private GraphicsDevice device;
	private long timeDelay;

	public Window(int width, int height) {
		this.device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		this.displayMode = new DisplayMode(width, height, 16, 0);
		this.keyboard = new Keyboard();

		addKeyListener(this.keyboard);

		setDefaultCloseOperation(3);
		setSize(width, height);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);

		createBufferStrategy(2);
		this.buffer = getBufferStrategy();

		this.graphics = this.buffer.getDrawGraphics();
		this.currTime = System.currentTimeMillis();
		this.lastTime = 0L;
		this.totalTime = 0L;

		instance = this;
	}

	static Window getInstance() {
		return instance;
	}

	public Keyboard getKeyboard() {
		return this.keyboard;
	}

	public Graphics getGameGraphics() {
		return this.graphics;
	}

	public void update() {
		this.graphics.dispose();
		this.buffer.show();
		Toolkit.getDefaultToolkit().sync();
		this.graphics = this.buffer.getDrawGraphics();
		this.lastTime = this.currTime;
		this.currTime = System.currentTimeMillis();
		this.totalTime += this.currTime - this.lastTime;
	}

	public void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ex) {
			Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public long deltaTime() {
		return this.currTime - this.lastTime;
	}

	public void drawText(String message, int x, int y, Color color) {
		this.graphics.setColor(color);
		this.graphics.drawString(message, x, y);
	}

	public void drawText(String message, int x, int y, Color color, Font font) {
		Graphics2D g2 = (Graphics2D) this.graphics;
		g2.setFont(font);
		g2.setColor(color);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString(message, x, y);
	}

	public void exit() {
		dispose();
		System.exit(0);
	}

	public Cursor createCustomCursor(String imageName) {
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(imageName),
				new Point(), "cursor");
		return cursor;
	}

	public void clear(Color color) {
		this.graphics.setColor(color);
		this.graphics.fillRect(0, 0, getWidth(), getHeight());
	}

	public DisplayMode[] getDisplayMode() {
		return this.device.getDisplayModes();
	}

	public void setDisplayMode(DisplayMode displayMode) {
		if (!isDisplayModeCompatible(displayMode)) {
			JOptionPane.showMessageDialog(null, "Resolução não compatível com display");
		}
	}

	public boolean isDisplayModeCompatible(DisplayMode displayMode2) {
		DisplayMode[] goodModes = this.device.getDisplayModes();
		int i = 0;
		boolean compatible = false;
		while ((!compatible) && (i < goodModes.length)) {
			if ((goodModes[i].getWidth() == this.displayMode.getWidth())
					&& (goodModes[i].getHeight() == this.displayMode.getHeight()))
				compatible = true;
			i++;
		}
		return compatible;
	}

	public void setFullScreen() {
		DisplayMode old = this.device.getDisplayMode();
		super.setIgnoreRepaint(true);
		this.device.setFullScreenWindow(instance);
		try {
			this.device.setDisplayMode(this.displayMode);
		} catch (IllegalArgumentException ex) {
			this.device.setDisplayMode(old);
		}
	}

	public void restoreScreen() {
		this.device.setFullScreenWindow(null);
		super.setLocationRelativeTo(null);
	}

	public void setSize(int width, int height) {
		setResizable(true);
		super.setSize(width, height);
		setDisplayMode(new DisplayMode(width, height, 16, 0));
		super.setLocationRelativeTo(null);
		setResizable(false);
	}

	public void setSize(Dimension d) {
		setSize(d.width, d.height);
	}

	public void display() {
		this.graphics.dispose();
		this.buffer.show();
		Toolkit.getDefaultToolkit().sync();
		this.graphics = this.buffer.getDrawGraphics();
		this.lastTime = this.currTime;
		this.currTime = System.currentTimeMillis();
	}

	private void delay() {
		try {
			Thread.sleep(this.timeDelay);
		} catch (InterruptedException ex) {
			Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
