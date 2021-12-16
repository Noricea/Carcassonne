package Carcassonne;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Draw extends JLabel {

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
			grassTile = ImageIO.read(new File(".\\sprites\\grassTile.png"));
		} catch (IOException e) {
		}

		// forest tiles
		try {
			forestTileN = ImageIO.read(new File(".\\sprites\\forestTileN.png"));
		} catch (IOException e) {
		}
		try {
			forestTileE = ImageIO.read(new File(".\\sprites\\forestTileE.png"));
		} catch (IOException e) {
		}
		try {
			forestTileS = ImageIO.read(new File(".\\sprites\\forestTileS.png"));
		} catch (IOException e) {
		}
		try {
			forestTileW = ImageIO.read(new File(".\\sprites\\forestTileW.png"));
		} catch (IOException e) {
		}

		// field tiles
		try {
			fieldTileN = ImageIO.read(new File(".\\sprites\\fieldTileN.png"));
		} catch (IOException e) {
		}
		try {
			fieldTileE = ImageIO.read(new File(".\\sprites\\fieldTileE.png"));
		} catch (IOException e) {
		}
		try {
			fieldTileS = ImageIO.read(new File(".\\sprites\\fieldTileS.png"));
		} catch (IOException e) {
		}
		try {
			fieldTileW = ImageIO.read(new File(".\\sprites\\fieldTileW.png"));
		} catch (IOException e) {
		}

		// village tiles
		try {
			villageTileN = ImageIO.read(new File(".\\sprites\\villageTileN.png"));
		} catch (IOException e) {
		}
		try {
			villageTileE = ImageIO.read(new File(".\\sprites\\villageTileE.png"));
		} catch (IOException e) {
		}
		try {
			villageTileS = ImageIO.read(new File(".\\sprites\\villageTileS.png"));
		} catch (IOException e) {
		}
		try {
			villageTileW = ImageIO.read(new File(".\\sprites\\villageTileW.png"));
		} catch (IOException e) {
		}

		// Get current Cursor Position
		vc.cursorX = (int) MouseInfo.getPointerInfo().getLocation().x
				- vc.frame.getContentPane().getLocationOnScreen().x - (vc.offsetX % vc.tileSize);
		vc.cursorY = (int) MouseInfo.getPointerInfo().getLocation().y
				- vc.frame.getContentPane().getLocationOnScreen().y - (vc.offsetY % vc.tileSize);

		// Draw scoreboard

		// Draw map
		for (int i = 0; i < vc.mapSize; i++) {
			for (int j = 0; j < vc.mapSize; j++) {
				if (vc.map[i][j] > 0) {
					if (grassTile != null) {
						g.drawImage(grassTile, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, null);

					} else {
						g.setColor(new Color(0, 255, 0));
						g.fillRect((i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, vc.tileSize,
								vc.tileSize);
					}
					switch ((vc.map[i][j] / 1000)) {
					case 2:
						g.drawImage(forestTileN, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, null);
						break;
					case 3:
						g.drawImage(fieldTileN, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, null);
						break;
					case 4:
						g.drawImage(villageTileN, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, null);
						break;
					default:
						break;
					}
					switch ((vc.map[i][j] / 100) % 10) {
					case 2:
						g.drawImage(forestTileE, (i * vc.tileSize) + vc.offsetX + 32, (j * vc.tileSize) + vc.offsetY,
								null);
						break;
					case 3:
						g.drawImage(fieldTileE, (i * vc.tileSize) + vc.offsetX + 32, (j * vc.tileSize) + vc.offsetY,
								null);
						break;
					case 4:
						g.drawImage(villageTileE, (i * vc.tileSize) + vc.offsetX + 32, (j * vc.tileSize) + vc.offsetY,
								null);
						break;
					default:
						break;
					}
					switch ((vc.map[i][j] / 10) % 10) {
					case 2:
						g.drawImage(forestTileS, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY + 32,
								null);
						break;
					case 3:
						g.drawImage(fieldTileS, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY + 32,
								null);
						break;
					case 4:
						g.drawImage(villageTileS, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY + 32,
								null);
						break;
					default:
						break;
					}
					switch ((vc.map[i][j] % 10)) {
					case 2:
						g.drawImage(forestTileW, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, null);
						break;
					case 3:
						g.drawImage(fieldTileW, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, null);
						break;
					case 4:
						g.drawImage(villageTileW, (i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, null);
						break;
					default:
						break;
					}

				} else {
					// Void
					g.setColor(new Color(0, 0, 255));
					g.fillRect((i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, vc.tileSize,
							vc.tileSize);
				}
			}
		}

		// Draw Player Equipment

		if (grassTile != null) {
			g.drawImage(grassTile, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);

		} else {
			g.setColor(new Color(0, 255, 0));
			g.fillRect((vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), vc.tileSize, vc.tileSize);
		}
		switch ((vc.tileID / 1000)) {
		case 2:
			g.drawImage(forestTileN, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		case 3:
			g.drawImage(fieldTileN, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		case 4:
			g.drawImage(villageTileN, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		default:
			break;
		}
		switch ((vc.tileID / 100) % 10) {
		case 2:
			g.drawImage(forestTileE, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize) + 32,
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		case 3:
			g.drawImage(fieldTileE, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize) + 32,
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		case 4:
			g.drawImage(villageTileE, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize) + 32,
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		default:
			break;
		}
		switch ((vc.tileID / 10) % 10) {
		case 2:
			g.drawImage(forestTileS, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize) + 32, null);
			break;
		case 3:
			g.drawImage(fieldTileS, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize) + 32, null);
			break;
		case 4:
			g.drawImage(villageTileS, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize) + 32, null);
			break;
		default:
			break;
		}
		switch ((vc.tileID % 10)) {
		case 2:
			g.drawImage(forestTileW, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		case 3:
			g.drawImage(fieldTileW, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		case 4:
			g.drawImage(villageTileW, (vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
					(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), null);
			break;
		default:
			break;
		}

		// Draw Scoreboard on screen
		g.setColor(new Color(0, 0, 0));
		g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
		g.drawString("Score: " + vc.score, 10, 35);

		vc.timer.setRepeats(true);
		vc.timer.start();
	}

}