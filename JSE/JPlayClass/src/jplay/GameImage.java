package jplay;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

public class GameImage extends GameObject {
	public Image image;

	public GameImage(String fileName) {
		loadImage(fileName);
	}

	public void loadImage(String fileName) {
		ImageIcon icon = new ImageIcon(fileName);
		this.image = icon.getImage();
		this.width = this.image.getWidth(null);
		this.height = this.image.getHeight(null);
	}

	public void draw() {
		Graphics2D g2d = (Graphics2D) Window.getInstance().getGameGraphics();
		AffineTransform tx = new AffineTransform();

		double rot = this.rotation;
		tx.rotate(-rot, this.width / 2, this.height / 2);

		int newy = (int) (this.x * Math.sin(rot) + this.y * Math.cos(rot));
		int newx = (int) (this.x * Math.cos(rot) - this.y * Math.sin(rot));

		g2d.setTransform(tx);

		g2d.drawImage(this.image, newx, newy, this.width, this.height, null);
	}

	public void draw(float f) {
		Graphics2D g2d = (Graphics2D) Window.getInstance().getGameGraphics();
		AffineTransform tx = new AffineTransform();

		AlphaComposite alpha = AlphaComposite.getInstance(3, f);
		g2d.setComposite(alpha);

		double rot = this.rotation;
		tx.rotate(-rot, this.width / 2, this.height / 2);

		int newy = (int) (this.x * Math.sin(rot) + this.y * Math.cos(rot));
		int newx = (int) (this.x * Math.cos(rot) - this.y * Math.sin(rot));

		g2d.setTransform(tx);

		g2d.drawImage(this.image, newx, newy, this.width, this.height, null);

		alpha = AlphaComposite.getInstance(3, 1.0F);
		g2d.setComposite(alpha);
	}

	public void drawPartially(int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2) {
		Window.getInstance().getGameGraphics().drawImage(this.image, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
	}
}
