package jplay;

public class GameObject {
	public double x;

	public double y;

	public int width;

	public int height;

	protected double rotation = 0.0D;

	public GameObject() {
		this.x = 0.0D;
		this.y = 0.0D;
		this.width = 0;
		this.height = 0;
	}

	public boolean collided(GameObject obj) {
		return Collision.collided(this, obj);
	}
}
