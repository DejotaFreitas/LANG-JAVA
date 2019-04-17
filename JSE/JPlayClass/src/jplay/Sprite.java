package jplay;

public class Sprite extends Animation {
	private double mass = 0.5D;
	private double friction = 0.5D;
	private double restitution = 0.5D;

	private float forceX = 0.0F;

	private float forceY = 0.0F;

	private double velocityY = 0.0D;

	public Sprite(String fileName) {
		this(fileName, 1);
	}

	public Sprite(String fileName, int numFrames) {
		super(fileName, numFrames);
		this.velocityY = 0.0D;
	}

	public void moveX(double velocity) {
		moveX(37, 39, velocity);
	}

	public void moveX(int leftKey, int rightKey, double velocity) {
		Keyboard keyboard = Window.getInstance().getKeyboard();
		if ((keyboard.keyDown(leftKey)) && (this.x > 1.0D)) {
			this.x -= velocity;
		}
		if ((keyboard.keyDown(rightKey)) && (this.x + this.width < Window.getInstance().getWidth())) {
			this.x += velocity;
		}
	}

	public void moveY(double velocity) {
		moveY(38, 40, velocity);
	}

	public void moveY(int upKey, int downKey, double velocity) {
		Keyboard keyboard = Window.getInstance().getKeyboard();
		if ((keyboard.keyDown(upKey)) && (this.y > 1.0D)) {
			this.y -= velocity;
		}

		if ((keyboard.keyDown(downKey)) && (this.y + this.height < Window.getInstance().getHeight())) {
			this.y += velocity;
		}
	}

	public void moveTo(double x, double y, double velocity) {
		if ((this.x < x) && (this.x + this.width < Window.getInstance().getWidth())) {
			this.x += velocity;
		} else if (this.x > x) {
			this.x -= velocity;
		}
		if (this.y > y) {
			this.y -= velocity;
		} else if (this.y < y) {
			this.y += velocity;
		}
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public double getVelocityY() {
		return this.velocityY;
	}

	public void setRestitution(double restitution) {
		this.restitution = restitution;
	}

	public double getRestitution() {
		return this.restitution;
	}

	public void setRotation(double rotation) {
		this.rotation = (-rotation);
	}

	public double getRotation() {
		return this.rotation;
	}

	public void setFriction(double friction) {
		this.friction = friction;
	}

	public double getFriction() {
		return this.friction;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getMass() {
		return this.mass;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setAllAttributes(double mass, double friction, double restituion, double rotation) {
		this.mass = mass;
		this.friction = friction;
		this.restitution = restituion;
		this.rotation = rotation;
	}
}
