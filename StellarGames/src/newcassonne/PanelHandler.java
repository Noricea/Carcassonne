package newcassonne;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class PanelHandler extends JPanel implements ActionListener {
	static final int SCREEN_WIDTH = 1240;
	static final int SCREEN_HEIGHT = 720;
	char direction = 'X';

	Random random;

	PanelHandler() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new EventHandler());
		showMenu();
	}

	public void showMenu() {
		JLabel header = new JLabel("Carcassonne");
		JButton play = new JButton("PLAY GAME");
		JButton help = new JButton("HELP");
		JButton exit = new JButton("EXIT GAME");
		
		this.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		this.setLayout(new GridLayout(0, 1));
		
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setFont(new Font("Germania One", Font.BOLD, 64));
		header.setForeground(Color.WHITE);
		
		this.add(header);
		this.add(play);
		this.add(help);
		this.add(exit);
		
		play.addActionListener(e -> {
			this.removeAll();
			this.invalidate();
			this.validate();
			startGame();
		});
		help.addActionListener(e -> {
			this.removeAll();
			this.invalidate();
			this.validate();
			showHelp();
		});
		exit.addActionListener(e -> {
			System.exit(0);
		});
	}
	
	public void showHelp() {
		JLabel header = new JLabel("Carcassonne");
		JLabel info = new JLabel("Filler Buster");
		JButton back = new JButton("GO BACK");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("Line1");
		sb.append("<br>");
		sb.append("Line2");
		sb.append("<br>");
		sb.append("Line3");
		sb.append("<br>");
		sb.append("Line4");
		sb.append("</html>");
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 100, 100, 100));
		this.setLayout(new GridLayout(0, 1));
		
		header.setFont(new Font("Germania One", Font.BOLD, 64));
		header.setForeground(Color.WHITE);
		
		info.setText(sb.toString());
		info.setForeground(Color.WHITE);
		
		this.add(header);
		this.add(info);
		this.add(back);
		
		back.addActionListener(e -> {
			this.removeAll();
			this.invalidate();
			this.validate();
			showMenu();
		});
	}

	public void startGame() {
		
	}

	public class EventHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print(true);
	}
}
