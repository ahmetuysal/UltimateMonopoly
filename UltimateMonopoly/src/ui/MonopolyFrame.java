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
		
		String osname = System.getProperty("os.name").toLowerCase();

		if (osname.contains("mac os")) {
			getContentPane().setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		} else {
			Dimension dimension = new Dimension(getWidth(), getHeight());
			System.out.println("width: "+getWidth()+" height: "+getHeight());
			getContentPane().setSize(dimension);
		}

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		MenuPanel menuPanel = new MenuPanel(getContentPane().getWidth(), getContentPane().getHeight(), this);
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
