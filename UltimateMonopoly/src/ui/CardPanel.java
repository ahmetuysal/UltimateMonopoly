package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import domain.GameController;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class CardPanel extends JPanel implements ActionListener, PropertyListener {
	private JButton playCardButton;
	private JButton keepCardButton;
	private UICard cardImage;

	private int panelWidth;
	private int panelHeight;

	private GameController controller;
	private GameRoomPanel grpanel;

	public CardPanel(int width, int height, GameRoomPanel grpanel) {
		this.controller = GameController.getInstance();
		this.grpanel = grpanel;
		this.panelHeight = height;
		this.panelWidth = width;

		setSize(panelHeight, panelWidth);
		setLayout(null);
		setVisible(false);

		initCardImage();
		initButtons();
	}

	private void initButtons() {
		playCardButton = new JButton("Play Card");
		keepCardButton = new JButton("Keep Card");

		int width = panelWidth / 5;
		int height = panelHeight / 10;

		int diff = panelHeight / 15;
		int x = (panelWidth - width) / 2;
		int y = 17 * panelWidth / 29 + diff;

		playCardButton.setVisible(true);
		playCardButton.setBounds(x, y, width, height);
		playCardButton.setBackground(Color.WHITE);

		playCardButton.addActionListener(this);

		keepCardButton.setVisible(true);
		keepCardButton.setBounds(x, y + (height + diff), width, height);
		keepCardButton.setBackground(Color.WHITE);

		keepCardButton.addActionListener(this);

		add(playCardButton);
		add(keepCardButton);
	}

	private void initCardImage() {
		int width = panelWidth;
		int height = 17 * width / 29;
		cardImage = new UICard(width, height, this);

		controller.addPropertyListener("cardNameChance", cardImage);
		controller.addPropertyListener("cardNameCommunityChest", cardImage);
		controller.addPropertyListener("cardNameRollThree", cardImage);

		controller.addPropertyListener("cardNameChance", this);
		controller.addPropertyListener("cardNameCommunityChest", this);
		controller.addPropertyListener("cardNameRollThree", this);

		cardImage.setBounds(0, 0, width, height);
		cardImage.setBorder(new LineBorder(Color.BLUE, 5));
		add(cardImage);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Play Card":
			controller.playCard();
			this.setVisible(false);
			grpanel.repaint();
			break;
		case "Keep Card":
			controller.keepCard();
			this.setVisible(false);
			grpanel.repaint();
			break;
		}
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if (e.getPropertyName().equals("cardNameRollThree")) {
			keepCardButton.setEnabled(true);
		} else if (e.getPropertyName().equals("cardNameChance")) {
			keepCardButton.setEnabled(false);
		} else if (e.getPropertyName().equals("cardNameCommunityChest")) {
			keepCardButton.setEnabled(false);
		}
	}
}
