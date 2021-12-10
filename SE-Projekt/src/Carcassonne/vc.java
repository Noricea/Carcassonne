package Carcassonne;

import javax.print.attribute.standard.PrinterInfo;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.MouseInfo;
import java.util.Random;

public class vc {

	// Other
	static Random rand = new Random();
	static int score = 0;
	
	// JFrame
	static JFrame frame;
	static int winWidth = 720;
	static int winHeight = 720;

	// Player Position on Map
	static int viewX = winWidth / 2;
	static int viewY = winHeight / 2;

	static int offsetX = 0;
	static int offsetY = 0;

	static int cursorX = 0;
	static int cursorY = 0;

	// Refresh Rate
	static Timer time;
	static int period = 100;

	// Tile Informations
	static int tileID = 0;
	static int tileTypes = 4;
	static int tileSize = 64;
	
	// Map stuff
	static int mapSize = 10;
	static int moveMod = 8;
	static int[][] map = new int[mapSize][mapSize];
	
	public vc() {

	}

}
