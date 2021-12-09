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

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		vc.offsetX += (vc.moveMod * (e.getKeyCode() == 'A' ? 1 : 0)) - (vc.moveMod * (e.getKeyCode() == 'D' ? 1 : 0));
		vc.offsetY += (vc.moveMod * (e.getKeyCode() == 'W' ? 1 : 0)) - (vc.moveMod * (e.getKeyCode() == 'S' ? 1 : 0));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Place tile
		if (e.getButton() == MouseEvent.BUTTON1) {

			int x = (vc.cursorX - vc.offsetX) / vc.tileSize;
			int y = (vc.cursorY - vc.offsetY) / vc.tileSize;

			if (x >= 0 && x < vc.mapSize && y >= 0 && y < vc.mapSize) {
				//Place Tile
				vc.map[x][y] = vc.map[x][y] < 1 ? vc.tileID : vc.map[x][y];
				
				//Check for neighbours here
				
				
				//Assign new tile to mouse
				vc.tileID =
						((vc.rand.nextInt(vc.tileTypes) + 1) * 1000) + //North
						((vc.rand.nextInt(vc.tileTypes) + 1) * 100) + //East
						((vc.rand.nextInt(vc.tileTypes) + 1) * 10) + //South
						(vc.rand.nextInt(vc.tileTypes) + 1);        //West
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
