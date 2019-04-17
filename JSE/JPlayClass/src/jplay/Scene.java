package jplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scene {
	private GameImage backDrop;
	private GameImage[] tiles;
	private String[] nameImages;
	private ArrayList tileLayer;
	private ArrayList overlays;
	private int drawStartX = 0;
	private int drawStartY = 0;
	private int centerPositionX;
	private int centerPositionY;
	private boolean movedx;
	private boolean movedy;
	private double xOffset = 0.0D;
	private double yOffset = 0.0D;

	public Scene() {
		this.centerPositionX = (Window.getInstance().getWidth() / 2);
		this.centerPositionY = (Window.getInstance().getHeight() / 2);
	}

	public void loadFromFile(String sceneFile) {
		this.tileLayer = new ArrayList();
		this.overlays = new ArrayList();
		try {
			BufferedReader input = new BufferedReader(new FileReader(new File(sceneFile)));

			String line = input.readLine();
			int numOfTileImages = Integer.parseInt(line, 10);
			this.tiles = new GameImage[numOfTileImages];
			this.nameImages = new String[numOfTileImages + 1];

			for (int i = 0; i < numOfTileImages; i++) {
				line = input.readLine();
				this.tiles[i] = new Sprite(line);
				this.nameImages[i] = line;
			}

			String endTileSet = "%";

			line = input.readLine();

			while (!line.equals(endTileSet)) {
				ArrayList tileLine = new ArrayList();

				String[] tileIndices = line.split(" ");

				for (int i = 0; i < tileIndices.length; i++) {
					TileInfo tileInfo = new TileInfo();
					tileInfo.id = Integer.parseInt(tileIndices[i]);
					tileLine.add(tileInfo);
				}
				this.tileLayer.add(tileLine);

				line = input.readLine();
			}

			line = input.readLine();
			this.backDrop = new GameImage(line);
			this.nameImages[numOfTileImages] = line;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addOverlay(GameObject overlay) {
		this.overlays.add(overlay);
	}

	public void removeOverlay(GameObject overlay) {
		this.overlays.remove(overlay);
	}

	public void setDrawStartPos(int drawStartX, int drawStartY) {
		this.drawStartX = drawStartX;
		this.drawStartY = drawStartY;
	}

	public void draw() {
		Graphics g = Window.getInstance().getGameGraphics();
		Window.getInstance().clear(Color.BLACK);

		int startDrawX = this.drawStartX;
		int startDrawY = this.drawStartY;

		this.backDrop.draw();

		int tileWidth = this.tiles[0].width;
		int tileHeight = this.tiles[0].height;

		int line = 0;
		int drawY = startDrawY;
		do {
			ArrayList tileLine = (ArrayList) this.tileLayer.get(line);

			int drawX = startDrawX;

			for (int c = 0; c < tileLine.size(); drawX += tileWidth) {
				TileInfo tileInfo = (TileInfo) tileLine.get(c);

				if (tileInfo.id != 0) {

					this.tiles[(tileInfo.id - 1)].x = drawX;
					this.tiles[(tileInfo.id - 1)].y = drawY;
					this.tiles[(tileInfo.id - 1)].draw();
				}
				c++;
			}

			drawY += tileHeight;
			line++;
		} while (

		line < this.tileLayer.size());

		for (int i = 0; i < this.overlays.size(); i++) {
			GameImage element = (GameImage) this.overlays.get(i);
			element.draw();
		}
	}

	public TileInfo getTile(int row, int colunm) {
		ArrayList<TileInfo> tileLine = (ArrayList) this.tileLayer.get(row);
		return (TileInfo) tileLine.get(colunm);
	}

	public Vector getTilesFromRect(Point min, Point max) {
		Vector v = new Vector();

		int startDrawX = this.drawStartX;
		int startDrawY = this.drawStartY;

		int tileWidth = this.tiles[0].width;
		int tileHeight = this.tiles[0].height;

		int minLine = max(0, (this.centerPositionY - Window.getInstance().getHeight() / 2) / tileHeight);
		int maxLine = min(this.tileLayer.size(),
				(int) Math.ceil((this.centerPositionY + Window.getInstance().getHeight() / 2) / tileHeight));

		int line = minLine;
		int drawY = startDrawY;
		do {
			ArrayList tileLine = (ArrayList) this.tileLayer.get(line);

			int drawX = startDrawX;

			int minColumn = max(0, (this.centerPositionX - Window.getInstance().getWidth() / 2) / tileWidth);
			int maxColumn = min(tileLine.size(),
					(int) Math.ceil((this.centerPositionX + Window.getInstance().getWidth() / 2.0D) / tileWidth));

			for (int c = minColumn; c < maxColumn; c++) {
				TileInfo tile = (TileInfo) tileLine.get(c);

				tile.width = tileWidth;
				tile.height = tileHeight;

				drawX += tileWidth;
				if ((min.x <= drawX + tileWidth - 1) && (max.x >= tile.x)) {

					if ((min.y <= drawY + tileHeight + 1) && (max.y >= tile.y)) {

						boolean bool = v.add(tile);
					}
				}
			}
			drawY += tileHeight;
			line++;
		} while (

		line < maxLine);

		return v;
	}

	public Vector getTilesFromPosition(Point min, Point max) {
		Vector v = new Vector();

		int tileWidth = this.tiles[0].width;
		int tileHeight = this.tiles[0].height;

		int line = 0;
		int drawY = -(this.centerPositionY - Window.getInstance().getHeight() / 2);
		do {
			ArrayList tileLine = (ArrayList) this.tileLayer.get(line);

			int drawX = -(this.centerPositionX - Window.getInstance().getWidth() / 2);

			for (int c = 0; c < tileLine.size(); c++) {
				TileInfo tile = (TileInfo) tileLine.get(c);

				tile.width = tileWidth;
				tile.height = tileHeight;

				drawX += tileWidth;
				if ((min.x <= drawX + tileWidth - 1) && (max.x >= tile.x)) {

					if ((min.y <= drawY + tileHeight + 1) && (max.y >= tile.y)) {

						boolean bool = v.add(tile);
					}
				}
			}
			drawY += tileHeight;
			line++;
		} while (

		line < this.tileLayer.size());

		return v;
	}

	public void removeTile(int row, int colunm) {
		ArrayList<TileInfo> tileLine = (ArrayList) this.tileLayer.get(row);
		if (colunm < tileLine.size()) {
			tileLine.remove(colunm);
		}
	}

	public void changeTile(int row, int colunm, int newID) {
		ArrayList<TileInfo> tileLine = (ArrayList) this.tileLayer.get(row);
		((TileInfo) tileLine.get(colunm)).id = newID;
	}

	public void saveToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

			out.write(this.tiles.length + "\n");
			for (int i = 0; i < this.tiles.length; i++) {
				out.write(this.nameImages[i] + "\n");
			}
			for (int i = 0; i < this.tileLayer.size(); i++) {
				ArrayList<TileInfo> tileLine = (ArrayList) this.tileLayer.get(i);
				int j = 0;
				for (j = 0; j < tileLine.size() - 1; j++) {
					out.write(((TileInfo) tileLine.get(j)).id + ",");
				}
				out.write(((TileInfo) tileLine.get(j)).id + "\n");
			}

			out.write("%\n");
			out.write(this.nameImages[this.tiles.length]);

			out.close();
		} catch (IOException ex) {
			Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void moveScene(GameObject object) {
		Graphics g = Window.getInstance().getGameGraphics();
		Window.getInstance().clear(Color.BLACK);
		this.xOffset = 0.0D;
		this.yOffset = 0.0D;

		this.backDrop.draw();

		int tileWidth = this.tiles[0].width;
		int tileHeight = this.tiles[0].height;

		double x = object.x - Window.getInstance().getWidth() / 2;
		double y = object.y - Window.getInstance().getHeight() / 2;

		UpdateCenterPosition(x, y);

		int line = 0;
		int drawY = -(this.centerPositionY - Window.getInstance().getHeight() / 2);
		do {
			ArrayList tileLine = (ArrayList) this.tileLayer.get(line);

			int drawX = -(this.centerPositionX - Window.getInstance().getWidth() / 2);

			for (int c = 0; c < tileLine.size(); c++) {
				TileInfo tileInfo = (TileInfo) tileLine.get(c);

				if (tileInfo.id != 0) {
					tileInfo.x = drawX;
					tileInfo.y = drawY;
					this.tiles[(tileInfo.id - 1)].x = drawX;
					this.tiles[(tileInfo.id - 1)].y = drawY;
					this.tiles[(tileInfo.id - 1)].draw();
				}
				drawX += tileWidth;
			}
			drawY += tileHeight;
			line++;
		} while (

		line < this.tileLayer.size());

		for (int i = 0; i < this.overlays.size(); i++) {
			GameImage element = (GameImage) this.overlays.get(i);
			element.draw();
		}
		if (this.movedx)
			this.xOffset = (Window.getInstance().getWidth() / 2 - object.x);
		if (this.movedy) {
			this.yOffset = (Window.getInstance().getHeight() / 2 - object.y);
		}
	}

	private void UpdateCenterPosition(double x, double y) {
		this.centerPositionX = ((int) (this.centerPositionX + x));
		this.centerPositionY = ((int) (this.centerPositionY + y));
		this.movedx = true;
		this.movedy = true;

		int tileWidth = this.tiles[0].width;
		int tileHeight = this.tiles[0].height;

		ArrayList tileLine = (ArrayList) this.tileLayer.get(0);

		if (this.centerPositionX > tileWidth * tileLine.size() - Window.getInstance().getWidth() / 2) {
			this.centerPositionX = (tileWidth * tileLine.size() - Window.getInstance().getWidth() / 2);
			this.movedx = false;
		} else if (this.centerPositionX < Window.getInstance().getWidth() / 2) {
			this.centerPositionX = (Window.getInstance().getWidth() / 2);
			this.movedx = false;
		}

		if (this.centerPositionY > tileHeight * this.tileLayer.size() - Window.getInstance().getHeight() / 2) {
			this.centerPositionY = (tileHeight * this.tileLayer.size() - Window.getInstance().getHeight() / 2);
			this.movedy = false;
		} else if (this.centerPositionY < Window.getInstance().getHeight() / 2) {
			this.centerPositionY = (Window.getInstance().getHeight() / 2);
			this.movedy = false;
		}
	}

	public double getXOffset() {
		return this.xOffset;
	}

	public double getYOffset() {
		return this.yOffset;
	}

	private int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}

	private int min(int a, int b) {
		if (a < b) {
			return a;
		}
		return b;
	}
}
