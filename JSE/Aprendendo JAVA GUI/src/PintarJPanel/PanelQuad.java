package PintarJPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelQuad extends JPanel implements MouseListener {

	private Vector vetPonto;

	private Point p1 = null;
	private Point p2 = null;

	public PanelQuad() {
		setBackground(Color.white);
		addMouseListener(this);
		vetPonto = new Vector();
	}

	public void paint(Graphics g) {
		super.paint(g);

		if (p2 != null) {
			g.drawRect(p1.x, p1.y, 10, 10);
		}
	}

	public void mouseClicked(MouseEvent e) {

		p1 = e.getPoint();
		p2 = e.getPoint();

		repaint();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(500, 500);
		j.setContentPane(new PanelQuad());
		j.setVisible(true);
	}

}
