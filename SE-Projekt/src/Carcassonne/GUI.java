package Carcassonne;

import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;

public class GUI {

	public GUI() {
		vc.frame = new JFrame();
		vc.frame.setSize(vc.winWidth, vc.winHeight);
		vc.frame.setTitle("Carcasonne");
		vc.frame.setLayout(null);
		vc.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vc.frame.setResizable(false);
		vc.frame.setVisible(true);
		vc.frame.setLocationRelativeTo(null);
		vc.frame.addKeyListener(new KeyHandler());
		vc.frame.addMouseListener(new KeyHandler());
		vc.frame.requestFocus();

		Draw draw = new Draw();
		draw.setBounds(0, 0, vc.winWidth, vc.winHeight);
		draw.setVisible(true);
		vc.frame.add(draw);
	}
}
