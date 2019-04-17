package jplay;

public class TileInfo extends GameObject {
	public int id;

	public boolean tileCollision(GameObject object, TileInfo tile) {
		if ((tile.id > 2) && (object.collided(tile))) {
			return true;
		}
		return false;
	}
}
