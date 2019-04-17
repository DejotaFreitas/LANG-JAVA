package jplay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;

public final class Keyboard extends InputBase implements KeyListener {
	public static final int ENTER_KEY = 10;
	public static final int ESCAPE_KEY = 27;
	public static final int SPACE_KEY = 32;
	public static final int LEFT_KEY = 37;
	public static final int UP_KEY = 38;
	public static final int RIGHT_KEY = 39;
	public static final int DOWN_KEY = 40;
	public static final int A_KEY = 65;
	public static final int D_KEY = 68;
	public static final int M_KEY = 77;
	public static final int S_KEY = 83;
	private Hashtable keysPressed;

	public Keyboard() {
		this.keysPressed = new Hashtable();

		addKey(38, 0);
		addKey(37, 0);
		addKey(39, 0);
		addKey(40, 0);
		addKey(27, 1);
		addKey(32, 1);
		addKey(10, 1);
		addKey(65, 1);
		addKey(83, 1);
		addKey(68, 1);
		addKey(77, 1);
	}

	public boolean keyDown(int key) {
		if (this.keysPressed.containsKey(Integer.valueOf(key))) {
			InputAction temp = (InputAction) this.keysPressed.get(Integer.valueOf(key));
			return temp.isPressed();
		}
		return false;
	}

	public void addKey(int key) {
		addKey(key, 1);
	}

	public void addKey(int key, int behavior) {
		removeKey(key);
		this.keysPressed.put(Integer.valueOf(key), new InputAction(behavior));
	}

	public void removeKey(int key) {
		this.keysPressed.remove(Integer.valueOf(key));
	}

	public void setBehavior(int key, int behavior) {
		if (this.keysPressed.containsKey(Integer.valueOf(key))) {
			addKey(key, behavior);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (this.keysPressed.containsKey(Integer.valueOf(key))) {
			InputAction temp = (InputAction) this.keysPressed.get(Integer.valueOf(key));
			temp.press();
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (this.keysPressed.containsKey(Integer.valueOf(key))) {
			InputAction temp = (InputAction) this.keysPressed.get(Integer.valueOf(key));
			temp.release();
		}
	}
}
