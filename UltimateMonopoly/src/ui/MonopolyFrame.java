package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import domain.GameController;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class MonopolyFrame extends JFrame {

	public MonopolyFrame() {

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Ultimate Monopoly");

		pack();
		setVisible(true);

		Dimension dimension = new Dimension(this.getWidth(), this.getHeight());
		getContentPane().setSize(dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		MenuPanel menuPanel = new MenuPanel(1200, 800, this);
		getContentPane().add(menuPanel);
		validate();
		// menuPanel.repaint();

		setBackground(Color.GRAY);
	}

	public void toGameRoomPanel() {
		getContentPane().removeAll();
		PausedPanel pausedPanel = new PausedPanel(getContentPane().getWidth(), getContentPane().getHeight(), this);
		GameController.getInstance().addPropertyListener("isPaused", pausedPanel);
		getContentPane().add(pausedPanel);
		GameRoomPanel grPanel = new GameRoomPanel(getContentPane().getWidth(), getContentPane().getHeight());
		getContentPane().add(grPanel);
		repaint();
	}

}
