package Carcassonne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class KeyHandler implements KeyListener, MouseInputListener, ActionListener {

	@Override
	public void keyTyped(KeyEvent e) {
		//

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Move map with WASD
		vc.offsetX += (vc.moveMod * (e.getKeyCode() == 'A' ? 1 : 0)) - (vc.moveMod * (e.getKeyCode() == 'D' ? 1 : 0));
		vc.offsetY += (vc.moveMod * (e.getKeyCode() == 'W' ? 1 : 0)) - (vc.moveMod * (e.getKeyCode() == 'S' ? 1 : 0));

		// Rotate tile with R
		vc.tileID = ((vc.tileID / 10) + ((vc.tileID % 10) * 1000)) * (e.getKeyCode() == 'R' ? 1 : 0)
				+ (vc.tileID * (e.getKeyCode() == 'R' ? 0 : 1));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Place tile LMB
		if (e.getButton() == MouseEvent.BUTTON1) {

			int x = ((vc.cursorX - vc.offsetX) + (vc.offsetX % vc.tileSize)) / vc.tileSize;
			int y = ((vc.cursorY - vc.offsetY) + (vc.offsetY % vc.tileSize)) / vc.tileSize;

			if (x >= 0 && x < vc.mapSize && y >= 0 && y < vc.mapSize) {
				// Place Tile
				int placed = vc.map[x][y] < 1 ? 1 : 0;
				vc.map[x][y] = vc.map[x][y] < 1 ? vc.tileID : vc.map[x][y];

				// Check for neighbours here NESW
				if (placed == 1) {
					vc.score += ((y > 0 ? ((vc.map[x][y] / 1000) == ((vc.map[x][y - 1] / 10) % 10) ? 1 : 0) : 0)
							+ (x < vc.mapSize - 1 ? (((vc.map[x][y] / 100) % 10) == (vc.map[x + 1][y] % 10) ? 1 : 0)
									: 0)
							+ (y < vc.mapSize - 1 ? (((vc.map[x][y] / 10) % 10) == (vc.map[x][y + 1] / 1000) ? 1 : 0)
									: 0)
							+ (x > 0 ? ((vc.map[x][y] % 10) == ((vc.map[x - 1][y] / 100) % 10) ? 1 : 0) : 0))
							* vc.scoreModifier;
				}

				// Assign new tile to mouse
				if (placed == 1) {
					vc.tileID = ((vc.rand.nextInt(vc.tileTypes) + 1) * 1000) + // North
							((vc.rand.nextInt(vc.tileTypes) + 1) * 100) + // East
							((vc.rand.nextInt(vc.tileTypes) + 1) * 10) + // South
							(vc.rand.nextInt(vc.tileTypes) + 1); // West
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//

	}

	@Override
	public void mouseExited(MouseEvent e) {
		//

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//

	}

}
