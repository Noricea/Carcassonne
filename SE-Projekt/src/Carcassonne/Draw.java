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
		// TODO Auto-generated constructor stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		BufferedImage grassTile = null;

		try {
			grassTile = ImageIO.read(new File(
					".\\sprites\\grassTile.png"));
		} catch (IOException e) {

		}

		vc.cursorX = (int) MouseInfo.getPointerInfo().getLocation().x
				- vc.frame.getContentPane().getLocationOnScreen().x - (vc.offsetX % vc.tileSize);
		vc.cursorY = (int) MouseInfo.getPointerInfo().getLocation().y
				- vc.frame.getContentPane().getLocationOnScreen().y - (vc.offsetY % vc.tileSize);

		g.setColor(new Color(155, 0, 255));

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
				} else {
					g.setColor(new Color(0, 0, 255));
					g.fillRect((i * vc.tileSize) + vc.offsetX, (j * vc.tileSize) + vc.offsetY, vc.tileSize,
							vc.tileSize);
				}
			}
		}

		// Draw Player Equipment
		g.setColor(new Color(120, 0, 255));
		g.fillRect((vc.cursorX / vc.tileSize) * vc.tileSize + (vc.offsetX % vc.tileSize),
				(vc.cursorY / vc.tileSize) * vc.tileSize + (vc.offsetY % vc.tileSize), vc.tileSize, vc.tileSize);

		vc.timer.setRepeats(true);
		vc.timer.start();
	}

}