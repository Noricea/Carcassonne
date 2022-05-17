package newcassonne;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import oldcassonne.VariableContainer;

public class GameDisplay extends JLabel {

	List<BufferedImage> Image = new ArrayList<BufferedImage>();
	List<TileSet> tileMap = new ArrayList<TileSet>();
	int cursorTile;

	Vector2D positionOnMap = new Vector2D();
	Vector2D positionOfCursor = new Vector2D();
	Vector2D positionOfPlaceableTile = new Vector2D();

	GameDisplay() {
		// Import images from sprites folder
		try {
			for (int i = 0; i <= 12; i++) {
				Image.add(ImageIO.read(new File("./src/sprites/" + i + ".png")));
			}
		} catch (IOException e) {
		}

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Displaying all placed tiles
		for (int i = 0; i < tileMap.size(); i++) {
			g.drawImage(Image.get(0), (tileMap.get(i).getX() * Image.get(0).getHeight()) + positionOnMap.x,
					(tileMap.get(i).getY() * Image.get(0).getWidth()) + positionOnMap.y, null);

			if (tileMap.get(i).getId() / 1000 != 0) {
				g.drawImage(Image.get(tileMap.get(i).getId() / 1000 * 4 - 3),
						(tileMap.get(i).getX() * Image.get(0).getHeight()) + positionOnMap.x,
						(tileMap.get(i).getY() * Image.get(0).getWidth()) + positionOnMap.y, null);
			}

			if ((tileMap.get(i).getId() / 100) % 10 != 0) {
				g.drawImage(Image.get((tileMap.get(i).getId() / 100) % 10 * 4 - 2),
						(tileMap.get(i).getX() * Image.get(0).getHeight()) + positionOnMap.x + 32,
						(tileMap.get(i).getY() * Image.get(0).getWidth()) + positionOnMap.y, null);
			}

			if ((tileMap.get(i).getId() / 10) % 10 != 0) {
				g.drawImage(Image.get((tileMap.get(i).getId() / 10) % 10 * 4 - 1),
						(tileMap.get(i).getX() * Image.get(0).getHeight()) + positionOnMap.x,
						(tileMap.get(i).getY() * Image.get(0).getWidth()) + positionOnMap.y + 32, null);
			}

			if (tileMap.get(i).getId() % 10 != 0) {
				g.drawImage(Image.get(tileMap.get(i).getId() % 10 * 4),
						(tileMap.get(i).getX() * Image.get(0).getHeight()) + positionOnMap.x,
						(tileMap.get(i).getY() * Image.get(0).getWidth()) + positionOnMap.y, null);
			}
		}

		// Displaying cursor tile
		g.drawImage(Image.get(0),
				(positionOfCursor.x / Image.get(0).getHeight()) * Image.get(0).getHeight()
						+ (positionOnMap.x % Image.get(0).getHeight()),
				(positionOfCursor.y / Image.get(0).getWidth()) * Image.get(0).getWidth()
						+ (positionOnMap.y % Image.get(0).getWidth()),
				null);
		if (cursorTile / 1000 != 0) {
			g.drawImage(Image.get(cursorTile / 1000 * 4 - 3),
					(positionOfCursor.x / Image.get(0).getHeight()) * Image.get(0).getHeight()
							+ (positionOnMap.x % Image.get(0).getHeight()),
					(positionOfCursor.y / Image.get(0).getWidth()) * Image.get(0).getWidth()
							+ (positionOnMap.y % Image.get(0).getWidth()),
					null);
		}
		if ((cursorTile / 100) % 10 != 0) {
			g.drawImage(Image.get((cursorTile / 100) % 10 * 4 - 2),
					(positionOfCursor.x / Image.get(0).getHeight()) * Image.get(0).getHeight()
							+ (positionOnMap.x % Image.get(0).getHeight()) + 32,
					(positionOfCursor.y / Image.get(0).getWidth()) * Image.get(0).getWidth()
							+ (positionOnMap.y % Image.get(0).getWidth()),
					null);
		}
		if ((cursorTile / 10) % 10 != 0) {
			g.drawImage(Image.get((cursorTile / 10) % 10 * 4 - 1),
					(positionOfCursor.x / Image.get(0).getHeight()) * Image.get(0).getHeight()
							+ (positionOnMap.x % Image.get(0).getHeight()),
					(positionOfCursor.y / Image.get(0).getWidth()) * Image.get(0).getWidth()
							+ (positionOnMap.y % Image.get(0).getWidth()) + 32,
					null);
		}
		if (cursorTile % 10 != 0) {
			g.drawImage(Image.get(cursorTile % 10 * 4),
					(positionOfCursor.x / Image.get(0).getHeight()) * Image.get(0).getHeight()
							+ (positionOnMap.x % Image.get(0).getHeight()),
					(positionOfCursor.y / Image.get(0).getWidth()) * Image.get(0).getWidth()
							+ (positionOnMap.y % Image.get(0).getWidth()),
					null);
		}
	}

	public void setTileMap(List<TileSet> tileMap) {
		this.tileMap = tileMap;
	}

	public void setCursorTile(int cursorTile) {
		this.cursorTile = cursorTile;
	}

	public void setPositionOnMap(Vector2D positionOnMap) {
		this.positionOnMap = positionOnMap;
	}

	public void setPositionOfCursor(Vector2D positionOfCursor) {
		this.positionOfCursor = positionOfCursor;
	}

	public void setPositionOfPlaceableTile(Vector2D positionOfPlaceableTile) {
		this.positionOfPlaceableTile = positionOfPlaceableTile;
	}
}