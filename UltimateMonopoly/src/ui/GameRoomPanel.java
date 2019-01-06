package ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.GameController;
import domain.Token;
import domain.square.Location;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;
import ui.animation.GenericAnimator;

public class GameRoomPanel extends JPanel implements ActionListener, PropertyListener {

	private GameController controller;

	private int frameWidth;
	private int frameHeight;
	private int boardStartX;
	private int squareUnitSize; // Normal squares are 2unit height 1 unit width
	private int tokenSize;
	private int boardLength;

	private TransparentButton rollThreeCard;
	private TransparentButton chanceCard;
	private TransparentButton communityChestCard;
	
	private TransparentButton drawPurple;
	private TransparentButton drawLightBlue;
	private TransparentButton drawPink;
	private TransparentButton drawOrange;
	private TransparentButton drawRed;
	private TransparentButton drawYellow;
	private TransparentButton drawGreen;
	private TransparentButton drawDarkBlue;
	private TransparentButton drawBrown;
	private TransparentButton drawWhite;
	private TransparentButton drawBlack;
	private TransparentButton drawGray;
	private TransparentButton drawLightPink;
	private TransparentButton drawLightGreen;
	private TransparentButton drawLightYellow;
	private TransparentButton drawDarkCyan;
	private TransparentButton drawMaroon;
	private TransparentButton drawDarkGold;
	private TransparentButton drawSalmon;
	private TransparentButton drawClaret;
	
//	private UICard cardImage;
//	private JButton playCardButton;
//	private JButton keepCardButton;
	private CardPanel cardPanel;
	
	private JButton pauseButton;
	
	private List<UIToken> UITokens;
	private GenericAnimator animator;
	
	private PlayButtonPanel playButtons;
	private PlayerPanel playerPanel;
	
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
		// Add generic animator
		animator = new GenericAnimator(this);
		new Thread(animator).start();
		
		squareUnitSize = frameHeight / 17;
		boardStartX = squareUnitSize/10;
		tokenSize = squareUnitSize;
		
		initializePlayButtonsPanel();		
		initializePauseButton();
		initializeCardPanel();
		initializeTokens();
		//cardImageandButtons();
		initCardButtons();
		initBoard();
		initializeTurnOrder();
		// initButtons();
		initializePlayerPanel();
		initColorButtons();
		
		controller.addPropertyListener("isPaused",this);
		
	}

	private void initializeTurnOrder() {
		if (controller.getCurrentPlayerIndex() < 0)
			controller.initTurnOrder();
	}

	private void initializePlayerPanel() {
		int pWidth = frameWidth - 17*squareUnitSize - boardStartX;;
		int pHeight = (int) (frameHeight * 7 / 8.);
		playerPanel = new PlayerPanel(pWidth, pHeight);
		playerPanel.setBounds(frameWidth - pWidth, squareUnitSize, pWidth, pHeight);
		playerPanel.setVisible(true);
		playerPanel.setBackground(this.getBackground());
		add(playerPanel);
	}

	private void initializeCardPanel() {
		int cpWidth = 5*squareUnitSize;
		int cpHeight = cpWidth;
		cardPanel = new CardPanel(cpWidth, cpHeight, this);
		cardPanel.setBounds(6*squareUnitSize,6*squareUnitSize, cpWidth, cpHeight);
		cardPanel.setVisible(false);
		cardPanel.setBackground(this.getBackground());
		add(cardPanel);
	}

	private void initializePlayButtonsPanel() {
		int pbpWidth = frameWidth - 17*squareUnitSize - boardStartX;
		int pbpHeight = frameHeight / 8;
		playButtons = new PlayButtonPanel(pbpWidth, pbpHeight,this);
		playButtons.setBounds(frameWidth - pbpWidth, frameHeight - pbpHeight , pbpWidth, pbpHeight);
		playButtons.setVisible(true);
		playButtons.setBackground(this.getBackground());
		add(playButtons);
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

	private void initColorButtons() {
		drawPurple = new TransparentButton();
		drawLightBlue = new TransparentButton();
		drawPink = new TransparentButton();
		drawOrange = new TransparentButton();
		drawRed = new TransparentButton();
		drawYellow = new TransparentButton();
		drawGreen = new TransparentButton();
		drawDarkBlue = new TransparentButton();
		drawBrown = new TransparentButton();
		drawWhite = new TransparentButton();
		drawBlack = new TransparentButton();
		drawGray = new TransparentButton();
		drawLightPink = new TransparentButton();
		drawLightGreen = new TransparentButton();
		drawLightYellow = new TransparentButton();
		drawDarkCyan = new TransparentButton();
		drawMaroon = new TransparentButton();
		drawDarkGold = new TransparentButton();
		drawSalmon = new TransparentButton();
		drawClaret = new TransparentButton();

		controller.addPropertyListener("hurricaneSquares", drawPurple);
		controller.addPropertyListener("hurricaneSquares", drawLightBlue);
		controller.addPropertyListener("hurricaneSquares", drawPink);
		controller.addPropertyListener("hurricaneSquares", drawOrange);
		controller.addPropertyListener("hurricaneSquares", drawRed);
		controller.addPropertyListener("hurricaneSquares", drawYellow);
		controller.addPropertyListener("hurricaneSquares", drawGreen);
		controller.addPropertyListener("hurricaneSquares", drawDarkBlue);
		controller.addPropertyListener("hurricaneSquares", drawBrown);
		controller.addPropertyListener("hurricaneSquares", drawWhite);
		controller.addPropertyListener("hurricaneSquares", drawBlack);
		controller.addPropertyListener("hurricaneSquares", drawGray);
		controller.addPropertyListener("hurricaneSquares", drawLightPink);
		controller.addPropertyListener("hurricaneSquares", drawLightGreen);
		controller.addPropertyListener("hurricaneSquares", drawLightYellow);
		controller.addPropertyListener("hurricaneSquares", drawDarkCyan);
		controller.addPropertyListener("hurricaneSquares", drawMaroon);
		controller.addPropertyListener("hurricaneSquares", drawDarkGold);
		controller.addPropertyListener("hurricaneSquares", drawSalmon);
		controller.addPropertyListener("hurricaneSquares", drawClaret);
		
		int width = 2*squareUnitSize;
		int height = 5*squareUnitSize/4;
		
		drawPurple.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawPurple.addActionListener(this);
		drawPurple.setActionCommand("drawPurple");
		
		drawLightBlue.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawLightBlue.addActionListener(this);
		drawLightBlue.setActionCommand("drawLightBlue");
		
		drawPink.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawPink.addActionListener(this);
		drawPink.setActionCommand("drawPink");
		
		drawOrange.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawOrange.addActionListener(this);
		drawOrange.setActionCommand("drawOrange");
		
		drawRed.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawRed.addActionListener(this);
		drawRed.setActionCommand("drawRed");
		
		drawYellow.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawYellow.addActionListener(this);
		drawYellow.setActionCommand("drawYellow");
		
		drawGreen.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawGreen.addActionListener(this);
		drawGreen.setActionCommand("drawGreen");
		
		drawDarkBlue.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawDarkBlue.addActionListener(this);
		drawDarkBlue.setActionCommand("drawDarkBlue");
		
		drawBrown.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawBrown.addActionListener(this);
		drawBrown.setActionCommand("drawBrown");
		
		drawWhite.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawWhite.addActionListener(this);
		drawWhite.setActionCommand("drawWhite");
		
		drawBlack.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawBlack.addActionListener(this);
		drawBlack.setActionCommand("drawBlack");
		
		drawGray.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawGray.addActionListener(this);
		drawGray.setActionCommand("drawGray");
		
		drawLightPink.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawLightPink.addActionListener(this);
		drawLightPink.setActionCommand("drawLightPink");
		
		drawLightYellow.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawLightYellow.addActionListener(this);
		drawLightYellow.setActionCommand("drawLightYellow");
		
		drawLightGreen.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawLightGreen.addActionListener(this);
		drawLightGreen.setActionCommand("drawLightGreen");
		
		drawDarkCyan.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawDarkCyan.addActionListener(this);
		drawDarkCyan.setActionCommand("drawDarkCyan");
		
		drawMaroon.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawMaroon.addActionListener(this);
		drawMaroon.setActionCommand("drawMaroon");
		
		drawDarkGold.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawDarkGold.addActionListener(this);
		drawDarkGold.setActionCommand("drawDarkGold");
		
		drawSalmon.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawSalmon.addActionListener(this);
		drawSalmon.setActionCommand("drawSalmon");
		
		drawClaret.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		drawClaret.addActionListener(this);
		drawClaret.setActionCommand("drawPClaret");
		
		this.add(drawPurple);
		this.add(drawLightBlue);
		this.add(drawPink);
		this.add(drawOrange);
		this.add(drawRed);
		this.add(drawYellow);
		this.add(drawGreen);
		this.add(drawDarkBlue);
		this.add(drawBrown);
		this.add(drawWhite);
		this.add(drawBlack);
		this.add(drawGray);
		this.add(drawLightPink);
		this.add(drawLightGreen);
		this.add(drawLightYellow);
		this.add(drawDarkCyan);
		this.add(drawMaroon);
		this.add(drawDarkGold);
		this.add(drawSalmon);
		this.add(drawClaret);		
	}

	private void initCardButtons(){
		rollThreeCard = new TransparentButton();
		chanceCard = new TransparentButton();
		communityChestCard = new TransparentButton();
		
		controller.addPropertyListener("drawRollThreeCard", rollThreeCard);
		controller.addPropertyListener("drawChanceCard", chanceCard);
		controller.addPropertyListener("drawCommunityChestCard", communityChestCard);
		
		int width = 2*squareUnitSize;
		int height = 5*squareUnitSize/4;
		
		rollThreeCard.setBounds( 8*squareUnitSize - squareUnitSize / 3 , 9*squareUnitSize + 11*squareUnitSize / 24, width, height);
		rollThreeCard.addActionListener(this);
		//rollThreeCard.setVisible(true);
		rollThreeCard.setActionCommand("RollThreeCard");
		
		communityChestCard.setBounds( 6*squareUnitSize + 2*squareUnitSize / 5 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		//communityChestCard.setVisible(true);
		communityChestCard.addActionListener(this);
		communityChestCard.setActionCommand("CommunityChestCard");
		
		chanceCard.setBounds( 9*squareUnitSize - squareUnitSize / 4 , 6*squareUnitSize + squareUnitSize / 4, width, height);
		//chanceCard.setVisible(true);
		chanceCard.addActionListener(this);
		chanceCard.setActionCommand("ChanceCard");
		
		
		this.add(rollThreeCard);
		this.add(communityChestCard);
		this.add(chanceCard);
	}

	private void initializePauseButton() {
		int pbtWidth = frameWidth - 30*squareUnitSize - boardStartX;
		int pbtHeight = frameHeight / 32;
		pauseButton = new ObserverButton("Pause Game", true);
		pauseButton.setBounds(frameWidth - pbtWidth, boardStartX, pbtWidth- boardStartX, pbtHeight);
		pauseButton.setVisible(true);
		pauseButton.setBackground(Color.WHITE);
		pauseButton.addActionListener(this);
		add(pauseButton);
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

	private void initializeTokens() {
		UITokens = new ArrayList<>();
		for (Token token : controller.getBoard().getTokens()) {
			UIToken uiToken = new UIToken(token, tokenSize);
			UITokens.add(uiToken);
			setComponentZOrder(uiToken, 0);
			add(uiToken);
			animator.addAnimatable(uiToken);
			TokenLocationChanged(uiToken, token.getLocation(), token.getLocation(), 1);
		}
		repaint();
	}

	public void TokenLocationChanged(UIToken token, Location oldLocation, Location newLocation, double completedRatio) {
		// TODO change with animation
		Point oldCoord = getCoordinate(oldLocation.getLayer(), oldLocation.getIndex());
		Point newCoord = getCoordinate(newLocation.getLayer(), newLocation.getIndex());
		token.setLocation((int) (oldCoord.getX() + completedRatio * (newCoord.getX() - oldCoord.getX())),
				(int)(oldCoord.getY() + completedRatio * (newCoord.getY() - oldCoord.getY())));
		//repaint();
	}
	

	private void resetEverthingUsingGameController() {
		animator.setAnimatorStopped(true);
		controller.refreshPropertyListeners();
		removeAll();
		initializePlayButtonsPanel();		
		initializePauseButton();
		initializeCardPanel();
		initializeTokens();
		initCardButtons();
		initBoard();
		initializeTurnOrder();
		initializePlayerPanel();
		animator.setAnimatorStopped(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "RollThreeCard":
			controller.drawRollThreeCard();
			break;
		case "ChanceCard":
			controller.drawChanceCard();
			break;
		case "CommunityChestCard":
			controller.drawCommunityChestCard();
			break;
		case "Pause Game":
			controller.setPause(true);
			break;
		}
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if(e.getPropertyName().equals("refresh")) {
			if ((boolean) e.getNewValue()) {
				resetEverthingUsingGameController();
			}
		}else if(e.getPropertyName().equals("isPaused")) {
			animator.setAnimatorStopped((boolean) e.getNewValue());
		}
	}

}
