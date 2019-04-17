package jplay;

public class InputAction {
	private static final int STATE_RELEASED = 0;

	private static final int STATE_PRESSED = 1;

	private static final int STATE_WAITING_FOR_RELEASE = 2;

	private int behavior;

	private int quantity;

	private int state;

	public InputAction(int behavior) {
		this.behavior = behavior;
		this.state = 0;
		this.quantity = 0;
	}

	public synchronized void setBehavior(int behavior) {
		this.behavior = behavior;
	}

	public synchronized void press() {
		press(1);
	}

	public synchronized void press(int amount) {
		if (this.state != 2) {
			this.quantity += amount;
			this.state = 1;
		}
	}

	public synchronized void release() {
		this.state = 0;
	}

	public synchronized boolean isPressed() {
		return getAmount() != 0;
	}

	public synchronized int getAmount() {
		int quant = this.quantity;
		if (quant != 0) {
			if (this.state == 0) {
				this.quantity = 0;
			} else if (this.behavior == 1) {
				this.state = 2;
				this.quantity = 0;
			}
		}
		return quant;
	}
}
