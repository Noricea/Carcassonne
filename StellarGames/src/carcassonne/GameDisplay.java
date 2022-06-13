package carcassonne;

import java.awt.Color;
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

/**
 * All graphical components that are not GUI are created here.
 * 
 * @author Lisa
 *
 */

public class GameDisplay extends JLabel {
	private static final long serialVersionUID = 1L;

	List<BufferedImage> imageList = new ArrayList<BufferedImage>();
	List<TileSet> tileMap = new ArrayList<TileSet>();
	int cursorTile;

	Vector2D positionOnMap = new Vector2D();
	Vector2D positionOfCursor = new Vector2D();

	/**
	 * Imports the necessary sprites for the various tiles.
	 */

	GameDisplay() {
		try {
			for (int i = 0; i <= 12; i++) {
				imageList.add(ImageIO.read(new File("./src/sprites/" + i + ".png")));
			}
		} catch (IOException e) {

		}

	}

	/**
	 * Creates all tiles.
	 */

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for (int i = 0; i < tileMap.size(); i++) {
			if (imageList.size() > 0) {
				g.drawImage(imageList.get(0), (tileMap.get(i).getX() * imageList.get(0).getHeight()) + positionOnMap.x,
						(tileMap.get(i).getY() * imageList.get(0).getWidth()) + positionOnMap.y, null);

				if (tileMap.get(i).getId() / 1000 != 0) {
					g.drawImage(imageList.get(tileMap.get(i).getId() / 1000 * 4 - 3),
							(tileMap.get(i).getX() * imageList.get(0).getHeight()) + positionOnMap.x,
							(tileMap.get(i).getY() * imageList.get(0).getWidth()) + positionOnMap.y, null);
				}

				if ((tileMap.get(i).getId() / 100) % 10 != 0) {
					g.drawImage(imageList.get((tileMap.get(i).getId() / 100) % 10 * 4 - 2),
							(tileMap.get(i).getX() * imageList.get(0).getHeight()) + positionOnMap.x + 32,
							(tileMap.get(i).getY() * imageList.get(0).getWidth()) + positionOnMap.y, null);
				}

				if ((tileMap.get(i).getId() / 10) % 10 != 0) {
					g.drawImage(imageList.get((tileMap.get(i).getId() / 10) % 10 * 4 - 1),
							(tileMap.get(i).getX() * imageList.get(0).getHeight()) + positionOnMap.x,
							(tileMap.get(i).getY() * imageList.get(0).getWidth()) + positionOnMap.y + 32, null);
				}

				if (tileMap.get(i).getId() % 10 != 0) {
					g.drawImage(imageList.get(tileMap.get(i).getId() % 10 * 4),
							(tileMap.get(i).getX() * imageList.get(0).getHeight()) + positionOnMap.x,
							(tileMap.get(i).getY() * imageList.get(0).getWidth()) + positionOnMap.y, null);
				}
			} else {
				// Void
				System.out.print("No sprites found\n");
				g.setColor(new Color(0, 255, 0));
				g.fillRect((tileMap.get(i).getX() * 64) + positionOnMap.x,
						(tileMap.get(i).getY() * 64) + positionOnMap.y, 64, 64);
			}
		}

		/**
		 * Displays the Tile that the player can place.
		 */
		if (imageList.size() > 0) {
			g.drawImage(imageList.get(0),
					(positionOfCursor.x / imageList.get(0).getHeight()) * imageList.get(0).getHeight()
							+ (positionOnMap.x % imageList.get(0).getHeight()),
					(positionOfCursor.y / imageList.get(0).getWidth()) * imageList.get(0).getWidth()
							+ (positionOnMap.y % imageList.get(0).getWidth()),
					null);
			if (cursorTile / 1000 != 0) {
				g.drawImage(imageList.get(cursorTile / 1000 * 4 - 3),
						(positionOfCursor.x / imageList.get(0).getHeight()) * imageList.get(0).getHeight()
								+ (positionOnMap.x % imageList.get(0).getHeight()),
						(positionOfCursor.y / imageList.get(0).getWidth()) * imageList.get(0).getWidth()
								+ (positionOnMap.y % imageList.get(0).getWidth()),
						null);
			}
			if ((cursorTile / 100) % 10 != 0) {
				g.drawImage(imageList.get((cursorTile / 100) % 10 * 4 - 2),
						(positionOfCursor.x / imageList.get(0).getHeight()) * imageList.get(0).getHeight()
								+ (positionOnMap.x % imageList.get(0).getHeight()) + 32,
						(positionOfCursor.y / imageList.get(0).getWidth()) * imageList.get(0).getWidth()
								+ (positionOnMap.y % imageList.get(0).getWidth()),
						null);
			}
			if ((cursorTile / 10) % 10 != 0) {
				g.drawImage(imageList.get((cursorTile / 10) % 10 * 4 - 1),
						(positionOfCursor.x / imageList.get(0).getHeight()) * imageList.get(0).getHeight()
								+ (positionOnMap.x % imageList.get(0).getHeight()),
						(positionOfCursor.y / imageList.get(0).getWidth()) * imageList.get(0).getWidth()
								+ (positionOnMap.y % imageList.get(0).getWidth()) + 32,
						null);
			}
			if (cursorTile % 10 != 0) {
				g.drawImage(imageList.get(cursorTile % 10 * 4),
						(positionOfCursor.x / imageList.get(0).getHeight()) * imageList.get(0).getHeight()
								+ (positionOnMap.x % imageList.get(0).getHeight()),
						(positionOfCursor.y / imageList.get(0).getWidth()) * imageList.get(0).getWidth()
								+ (positionOnMap.y % imageList.get(0).getWidth()),
						null);
			}
		} else {
			// Void
			System.out.print("No sprites found\n");
			g.setColor(new Color(0, 255, 0));
			g.fillRect((positionOfCursor.x / 64 * 64) + positionOnMap.x % 64, (positionOfCursor.y / 64 * 64) + positionOnMap.y % 64,
					64, 64);
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
}
