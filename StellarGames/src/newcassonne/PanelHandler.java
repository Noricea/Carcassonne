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

		this.setBorder(BorderFactory.createEmptyBorder(20, 100, 100, 100));
		this.setLayout(new GridLayout(0, 1));

		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("You start off with a single grass tile.");
		sb.append("<br>");
		sb.append("Each time you place a tile, another random tile will appear in its place.");
		sb.append("<br>");
		sb.append("Over time, you will create a unique world, spaning over hundreds of tiles");
		sb.append("<br>");
		sb.append("");
		sb.append("<br>");
		sb.append("The rules are as follows:");
		sb.append("<br>");
		sb.append("1. Tiles must be placed next to each other");
		sb.append("<br>");
		sb.append("2. Place tiles with similar terrain to gain points");
		sb.append("<br>");
		sb.append("3. Have fun!");
		sb.append("</html>");

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
		JLabel score = new JLabel("Score: 0");
		JButton back = new JButton("GO BACK");

		this.setBorder(BorderFactory.createEmptyBorder(20, 100, 100, 100));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		score.setFont(new Font("Germania One", Font.BOLD, 24));
		score.setForeground(Color.WHITE);

		this.add(score, BorderLayout.WEST);
		this.add(back, BorderLayout.EAST);

		this.addKeyListener(new EventHandler());
		this.addMouseListener(new MouseEventHandler());
		back.addActionListener(e -> {
			this.removeAll();
			this.invalidate();
			this.validate();
			showMenu();
		});
	}

	public class EventHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT: {
				// Move left
				break;
			}
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN: {
				// Move down
				break;
			}
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT: {
				// Move right
				break;
			}
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP: {
				// Move up
				break;
			}
			}
		}
	}

	public class MouseEventHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print(true);
	}
}
