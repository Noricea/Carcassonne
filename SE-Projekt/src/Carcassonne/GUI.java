package Carcassonne;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

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

		vc.timer = new Timer(1000/vc.fps, new ActionListener() {
		    public void actionPerformed(ActionEvent event) 
		    {
		      draw.repaint();
		    }
		});
	}
}
