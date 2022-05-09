package carcassonne;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Draw extends JLabel {
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Import images from sprites folder
		BufferedImage grassTile = null;

		BufferedImage forestTileN = null;
		BufferedImage forestTileE = null;
		BufferedImage forestTileS = null;
		BufferedImage forestTileW = null;

		BufferedImage fieldTileN = null;
		BufferedImage fieldTileE = null;
		BufferedImage fieldTileS = null;
		BufferedImage fieldTileW = null;

		BufferedImage villageTileN = null;
		BufferedImage villageTileE = null;
		BufferedImage villageTileS = null;
		BufferedImage villageTileW = null;

		// grass tile
		try {
			grassTile = ImageIO.read(new File("./sprites/grassTile.png"));
		} catch (IOException e) {
		}

		// forest tiles
		try {
			forestTileN = ImageIO.read(new File("./sprites/forestTileN.png"));
		} catch (IOException e) {
		}
		try {
			forestTileE = ImageIO.read(new File("./sprites/forestTileE.png"));
		} catch (IOException e) {
		}
		try {
			forestTileS = ImageIO.read(new File("./sprites/forestTileS.png"));
		} catch (IOException e) {
		}
		try {
			forestTileW = ImageIO.read(new File("./sprites/forestTileW.png"));
		} catch (IOException e) {
		}

		// field tiles
		try {
			fieldTileN = ImageIO.read(new File("./sprites/fieldTileN.png"));
		} catch (IOException e) {
		}
		try {
			fieldTileE = ImageIO.read(new File("./sprites/fieldTileE.png"));
		} catch (IOException e) {
		}
		try {
			fieldTileS = ImageIO.read(new File("./sprites/fieldTileS.png"));
		} catch (IOException e) {
		}
		try {
			fieldTileW = ImageIO.read(new File("./sprites/fieldTileW.png"));
		} catch (IOException e) {
		}

		// village tiles
		try {
			villageTileN = ImageIO.read(new File("./sprites/villageTileN.png"));
		} catch (IOException e) {
		}
		try {
			villageTileE = ImageIO.read(new File("./sprites/villageTileE.png"));
		} catch (IOException e) {
		}
		try {
			villageTileS = ImageIO.read(new File("./sprites/villageTileS.png"));
		} catch (IOException e) {
		}
		try {
			villageTileW = ImageIO.read(new File("./sprites/villageTileW.png"));
		} catch (IOException e) {
		}

		// Get current Cursor Position
		VariableContainer.cursorX = (int) MouseInfo.getPointerInfo().getLocation().x
				- VariableContainer.frame.getContentPane().getLocationOnScreen().x - (VariableContainer.offsetX % VariableContainer.tileSize);
		VariableContainer.cursorY = (int) MouseInfo.getPointerInfo().getLocation().y
				- VariableContainer.frame.getContentPane().getLocationOnScreen().y - (VariableContainer.offsetY % VariableContainer.tileSize);

		// Draw scoreboard

		// Draw map
		for (int i = 0; i < VariableContainer.mapSize; i++) {
			for (int j = 0; j < VariableContainer.mapSize; j++) {
				if (VariableContainer.map[i][j] > 0) {
					if (grassTile != null) {
						g.drawImage(grassTile, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, null);

					} else {
						g.setColor(new Color(0, 255, 0));
						g.fillRect((i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, VariableContainer.tileSize,
								VariableContainer.tileSize);
					}
					switch ((VariableContainer.map[i][j] / 1000)) {
					case 2:
						g.drawImage(forestTileN, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, null);
						break;
					case 3:
						g.drawImage(fieldTileN, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, null);
						break;
					case 4:
						g.drawImage(villageTileN, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, null);
						break;
					default:
						break;
					}
					switch ((VariableContainer.map[i][j] / 100) % 10) {
					case 2:
						g.drawImage(forestTileE, (i * VariableContainer.tileSize) + VariableContainer.offsetX + 32, (j * VariableContainer.tileSize) + VariableContainer.offsetY,
								null);
						break;
					case 3:
						g.drawImage(fieldTileE, (i * VariableContainer.tileSize) + VariableContainer.offsetX + 32, (j * VariableContainer.tileSize) + VariableContainer.offsetY,
								null);
						break;
					case 4:
						g.drawImage(villageTileE, (i * VariableContainer.tileSize) + VariableContainer.offsetX + 32, (j * VariableContainer.tileSize) + VariableContainer.offsetY,
								null);
						break;
					default:
						break;
					}
					switch ((VariableContainer.map[i][j] / 10) % 10) {
					case 2:
						g.drawImage(forestTileS, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY + 32,
								null);
						break;
					case 3:
						g.drawImage(fieldTileS, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY + 32,
								null);
						break;
					case 4:
						g.drawImage(villageTileS, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY + 32,
								null);
						break;
					default:
						break;
					}
					switch ((VariableContainer.map[i][j] % 10)) {
					case 2:
						g.drawImage(forestTileW, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, null);
						break;
					case 3:
						g.drawImage(fieldTileW, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, null);
						break;
					case 4:
						g.drawImage(villageTileW, (i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, null);
						break;
					default:
						break;
					}

				} else {
					// Void
					g.setColor(new Color(0, 0, 255));
					g.fillRect((i * VariableContainer.tileSize) + VariableContainer.offsetX, (j * VariableContainer.tileSize) + VariableContainer.offsetY, VariableContainer.tileSize,
							VariableContainer.tileSize);
				}
			}
		}

		// Draw Player Equipment

		if (grassTile != null) {
			g.drawImage(grassTile, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);

		} else {
			g.setColor(new Color(0, 255, 0));
			g.fillRect((VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), VariableContainer.tileSize, VariableContainer.tileSize);
		}
		switch ((VariableContainer.tileID / 1000)) {
		case 2:
			g.drawImage(forestTileN, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		case 3:
			g.drawImage(fieldTileN, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		case 4:
			g.drawImage(villageTileN, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		default:
			break;
		}
		switch ((VariableContainer.tileID / 100) % 10) {
		case 2:
			g.drawImage(forestTileE, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize) + 32,
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		case 3:
			g.drawImage(fieldTileE, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize) + 32,
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		case 4:
			g.drawImage(villageTileE, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize) + 32,
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		default:
			break;
		}
		switch ((VariableContainer.tileID / 10) % 10) {
		case 2:
			g.drawImage(forestTileS, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize) + 32, null);
			break;
		case 3:
			g.drawImage(fieldTileS, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize) + 32, null);
			break;
		case 4:
			g.drawImage(villageTileS, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize) + 32, null);
			break;
		default:
			break;
		}
		switch ((VariableContainer.tileID % 10)) {
		case 2:
			g.drawImage(forestTileW, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		case 3:
			g.drawImage(fieldTileW, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		case 4:
			g.drawImage(villageTileW, (VariableContainer.cursorX / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetX % VariableContainer.tileSize),
					(VariableContainer.cursorY / VariableContainer.tileSize) * VariableContainer.tileSize + (VariableContainer.offsetY % VariableContainer.tileSize), null);
			break;
		default:
			break;
		}

		// Draw Scoreboard on screen
		g.setColor(new Color(0, 0, 0));
		g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
		g.drawString("Score: " + VariableContainer.score, 10, 35);

		VariableContainer.timer.setRepeats(true);
		VariableContainer.timer.start();
	}

}