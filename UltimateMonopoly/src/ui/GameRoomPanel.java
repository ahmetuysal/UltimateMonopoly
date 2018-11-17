package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import domain.GameController;
import domain.Token;
import domain.square.Location;

public class GameRoomPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

	private GameController controller;

	private int frameWidth;
	private int frameHeight;
	private int boardStartX;
	private int squareUnitSize; // Normal squares are 2unit height 1 unit width
	private int tokenSize;
	private int boardLength;

	private List<UIToken> UITokens = new ArrayList<>();
	
	private PlayButtonPanel playButtons;
	

	private static final int FIRST_LAYER = 24;
	private static final int SECOND_LAYER = 40;
	private static final int THIRD_LAYER = 56;
	private static final int[] BOARD_SIZE = { FIRST_LAYER, SECOND_LAYER, THIRD_LAYER };

	public GameRoomPanel(int width, int height) {
		controller = GameController.getInstance();
		frameWidth = width;
		frameHeight = height;

		setSize(frameWidth, frameHeight);
		setVisible(true);
		setBackground(new Color(175, 231, 204));
		setLayout(null);

		squareUnitSize = frameHeight / 17;
		boardStartX = squareUnitSize/10;
		tokenSize = squareUnitSize/2;
		
		int pbpWidth = frameWidth - 17*squareUnitSize - boardStartX;
		int pbpHeight = frameHeight / 8;
		playButtons = new PlayButtonPanel(pbpWidth, pbpHeight,this);
		playButtons.setBounds(frameWidth - pbpWidth, frameHeight - pbpHeight , pbpWidth, pbpHeight);
		playButtons.setVisible(true);
		playButtons.setBackground(this.getBackground());
		add(playButtons);
		
		initTokens();
		initBoard();
		// initButtons();

		addMouseListener(this);
		addMouseMotionListener(this);

		Token token = controller.getBoard().getTokens().get(0);
		System.out.println(token);
		
		token.setLocation(new Location(0, 0));
		
		new Timer().schedule(new TimerTask() {
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < BOARD_SIZE[i]; j++) {
						token.setLocation(new Location(i, j));
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}, 2000);
		

	}

	private void initBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < BOARD_SIZE[i]; j++) {
				add(getSquare(i, j));
			}
		}

		add(getMiddle());
		repaint();
	}

	private JLabel getMiddle() {
		Image tmp = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			if (osName.contains("mac")) {
				tmp = ImageIO.read(new File("./images/middle.png"));
			} else {
				tmp = ImageIO.read(new File(".\\images\\middle.png"));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp = tmp.getScaledInstance(5 * squareUnitSize, 5 * squareUnitSize, Image.SCALE_SMOOTH);
		JLabel middle = new JLabel(new ImageIcon(tmp));
		middle.setBounds(6 * squareUnitSize + boardStartX, 6 * squareUnitSize, 5 * squareUnitSize, 5 * squareUnitSize);
		middle.setVisible(true);
		return middle;
	}

	private Point getCoordinate(int layer, int index) {
		int x, y;

		if (index < 6 + 4 * layer) {
			x = 11 + 2 * layer - index;
			y = 11 + 2 * layer;
		} else if (index < 12 + 8 * layer) {
			x = 4 - 2 * layer;
			y = 11 + 2 * layer - (index - (6 + 4 * layer));
		} else if (index == 12 + 8 * layer) {
			x = 4 - 2 * layer;
			y = 10 + 2 * layer - (index - (6 + 4 * layer));
		} else if (index < 18 + 12 * layer) {
			x = 5 - 2 * layer + (index - (12 + 8 * layer));
			y = 4 - 2 * layer;
		} else if (index == 18 + 12 * layer) {
			x = 11 + 2 * layer;
			y = 4 - 2 * layer;
		} else {
			x = 11 + 2 * layer;
			y = 5 - 2 * layer + (index - (18 + 12 * layer));
		}

		return new Point(boardStartX + x * squareUnitSize, y * squareUnitSize);
	}

	private JLabel getSquare(int layer, int index) {
		int width = 0;
		int height = 0;

		if ((layer == 0 && index % 6 == 0) || (layer == 1 && index % 10 == 0) || (layer == 2 && index % 14 == 0)) {
			height = 2 * squareUnitSize;
			width = 2 * squareUnitSize;
		} else if ((layer == 0 && (index < 7 || (index > 11 && index < 19)))
				|| (layer == 1 && (index < 11 || (index > 19 && index < 31)))
				|| (layer == 2 && (index < 15 || (index > 27 && index < 43)))) {
			height = 2 * squareUnitSize;
			width = squareUnitSize;
		} else {
			height = squareUnitSize;
			width = 2 * squareUnitSize;
		}

		Image tmp = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			if (osName.contains("mac")) {
				tmp = ImageIO.read(new File("./images/squares/" + layer + "_" + index + ".png"));
			} else {
				tmp = ImageIO.read(new File(".\\images\\squares\\" + layer + "_" + index + ".png"));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp = tmp.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		JLabel square = new JLabel(new ImageIcon(tmp));

		square.setSize(width, height);
		square.setLocation(getCoordinate(layer, index));
		square.setVisible(true);
		return square;
	}

	private void initTokens() {
		for (Token token : controller.getBoard().getTokens()) {
			UIToken uiToken = new UIToken(token, tokenSize);
			UITokens.add(uiToken);
			setComponentZOrder(uiToken, 0);
			add(uiToken);
			System.out.println(uiToken);
		}
		repaint();
	}

	public void TokenLocationChanged(UIToken token, Location oldLocation, Location newLocation) {
		// TODO change with animation
		token.setLocation(getCoordinate(newLocation.getLayer(), newLocation.getIndex()));
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
