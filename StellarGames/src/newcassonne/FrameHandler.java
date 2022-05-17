package newcassonne;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class FrameHandler extends JFrame {
	FrameHandler(){

		this.add(new PanelHandler(), BorderLayout.CENTER);
		this.setTitle("Carcassonne");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
