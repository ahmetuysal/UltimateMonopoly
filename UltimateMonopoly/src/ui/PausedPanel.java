package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.GameController;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class PausedPanel extends JPanel implements PropertyListener, ActionListener, MouseListener {

	private MonopolyFrame mainFrame;
	private GameController controller;
	private JButton resumeButton;
	private JButton saveGameButton;
	private int pausedPanelWidth;
	private int pausedPanelHeight;

	public PausedPanel(int pausedPanelWidth, int pausedPanelHeight, MonopolyFrame frame) {
		super();
		controller = GameController.getInstance();
		this.mainFrame = frame;
		this.pausedPanelWidth = pausedPanelWidth;
		this.pausedPanelHeight = pausedPanelHeight;
		this.setSize(pausedPanelWidth, pausedPanelHeight);
		this.setBackground(new Color(0, 0, 0, 150));
		this.setLayout(null);
		this.setVisible(false);
		addMouseListener(this);
		resumeButton();
		saveGameButton();
	}

	private void resumeButton() {
		int width = pausedPanelWidth / 10;
		int height = pausedPanelHeight / 15;

		int x = (pausedPanelWidth - width) / 2;
		int y = (pausedPanelHeight - height) / 2 - 3 * height / 2;

		resumeButton = new JButton("Resume Game");
		resumeButton.setBounds(x, y, width, height);
		resumeButton.setVisible(true);
		resumeButton.setBackground(Color.WHITE);
		resumeButton.addActionListener(this);
		add(resumeButton);
	}

	private void saveGameButton() {
		int width = pausedPanelWidth / 10;
		int height = pausedPanelHeight / 15;

		int x = (pausedPanelWidth - width) / 2;
		int y = (pausedPanelHeight - height) / 2;

		saveGameButton = new JButton("Save Game");
		saveGameButton.setBounds(x, y, width, height);
		saveGameButton.setVisible(true);
		saveGameButton.setBackground(Color.WHITE);
		saveGameButton.addActionListener(this);
		add(saveGameButton);
	}
	
	private void saveGame() {
		String gameName = JOptionPane.showInputDialog(mainFrame,
				"Enter a name for the you want to save. If there is already a game with that name, that will be overriden. Your name should not include whitespaces!",
				"Game Name", JOptionPane.QUESTION_MESSAGE);
		if (gameName == null) {
		    System.out.println("The user canceled");
		}
		else if (gameName.contains(" ")) {
			System.out.println("The user entered a name with spaces.");
			JOptionPane.showMessageDialog(mainFrame, "You entered a name with spaces, enter another name!", "Game Name", JOptionPane.ERROR_MESSAGE);
			saveGame();
		}
		else {
			if (controller.saveGame(gameName)) {
				JOptionPane.showMessageDialog(mainFrame, "Game is saved.", "Save Game", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(mainFrame, "Game couldn't be saved.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if (e.getPropertyName().equals("isPaused")) {
			System.out.println("Paused panel visibility :" + e.getNewValue().toString());
			this.setVisible((boolean) e.getNewValue());
			mainFrame.repaint();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Resume Game":
			controller.setPause(false);
			break;
		case "Save Game":
			saveGame();
			break;
		}

	}

}
