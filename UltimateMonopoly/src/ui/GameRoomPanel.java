package ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import domain.GameController;

public class GameRoomPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

	private GameController controller;

	private int frameWidth;
	private int frameHeight;
	private int boardStartX;
	private int squareUnitSize; // Normal squares are 2unit height 1 unit width
	private int tokensize;

	private List<Image> tokenImages;

	private static final int FIRST_LAYER = 24;
	private static final int SECOND_LAYER = 40;
	private static final int THIRD_LAYER = 56;
	private static final int[] BOARD_SIZE = { FIRST_LAYER, SECOND_LAYER, THIRD_LAYER };

	public GameRoomPanel(int width, int height) {
		frameWidth = width;
		frameHeight = height;

		setSize(frameWidth, frameHeight);
		setVisible(true);
		setBackground(new Color(175, 231, 204));
		setLayout(null);

		squareUnitSize = frameHeight / 17;
		boardStartX = (frameWidth - 17 * squareUnitSize) / 2;

		initBoard();
		// initButtons();

		addMouseListener(this);
		addMouseMotionListener(this);

	}

	private void initBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < BOARD_SIZE[i]; j++) {
				add(getSquare(i, j));
			}
		}
		
		repaint();
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
	        if(osName.contains("mac")){
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

		int x, y;
		
		if(index < 6 + 4 * layer ) {
			x = 11 + 2 * layer - index;
			y = 11 + 2 * layer;
		}
		else if (index < 12 + 8 * layer) {
			x = 4 - 2 * layer;
			y = 11 + 2 * layer - (index - (6 + 4 * layer));
		}
		else if (index == 12 + 8 * layer) {
			x = 4 - 2 * layer;
			y = 10 + 2 * layer - (index - (6 + 4 * layer));
		}
		else if (index < 18 + 12 * layer) {
			x = 5 - 2 * layer + (index - (12 + 8 * layer)); 
			y = 4 - 2 * layer;
		}
		else if (index == 18 + 12 * layer) {
			x = 11 + 2 * layer;
			y = 4 - 2 * layer;
		}
		else {
			x = 11 + 2 * layer;
			y = 5 - 2 * layer + (index - (18 + 12 * layer));
		}
		
		
//		int x = boardStartX;
//		int y = 0;

		square.setBounds(boardStartX +  x * squareUnitSize, y * squareUnitSize, width, height);
		square.setVisible(true);
		return square;
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
