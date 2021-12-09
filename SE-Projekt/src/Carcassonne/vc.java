package Carcassonne;

import javax.print.attribute.standard.PrinterInfo;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.MouseInfo;

public class vc {
	
	//JFrame
	static JFrame frame;
	static int winWidth = 1920;
	static int winHeight = 1028;
	
	// Player Position on Map
	static int viewX = winWidth / 2;
	static int viewY = winHeight / 2;
	
	static int mapSize = 10;
	static int moveMod = 8;
	
	static int offsetX = 0;
	static int offsetY = 0;
	
	static int cursorX = 0;
	static int cursorY = 0;

	//
	static Timer time;
	static int period = 100;

	// Tile Informations
	enum Terrain {
		grass, forest, village, fields
	};
	static int tileSize = 64;
	static Terrain tSide[];

	static int [][] map = new int [mapSize][mapSize];


	public vc() {
		// TODO Auto-generated constructor stub
	}

}
