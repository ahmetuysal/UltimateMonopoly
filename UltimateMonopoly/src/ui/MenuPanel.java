package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.GameController;

public class MenuPanel extends JPanel implements ActionListener {
	
	private MonopolyFrame mainFrame;
	private GameController controller;
	
	private ArrayList<String> playernameList;
	private int numOfPlayers;
	private JButton newGameButton;
	private JButton quitGameButton;
	private JTextField usernameInputTextField;
	
	private int menuPanelWidth;
	private int menuPanelHeight;
	
	public MenuPanel(int menuPanelWidth, int menuPanelHeight){
		this.usernameInputTextField = new JTextField();
		this.playernameList = new ArrayList<String>();
		this.controller = GameController.getInstance();
	
		setLayout(null);
		this.menuPanelWidth = menuPanelWidth;
		this.menuPanelHeight = menuPanelHeight;
		this.setSize(this.menuPanelWidth, this.menuPanelHeight);
		
		
		
		setBackground(Color.CYAN);
		
		initButtons();
		
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "New Game":
			////
			break;
		case "Quit Game":
			controller.quitGame();
			break;
		}
	}
	
	public void initButtons(){
		//System.out.println("adding buttons");
		newGameButton();
		quitGameButton();
		
		this.add(newGameButton);
		this.add(quitGameButton);
	}
	
	public void newGameButton(){
		newGameButton = new JButton("New Game");
		newGameButton.setBackground(Color.WHITE);
		
		int width = menuPanelWidth/5;
		int height = menuPanelHeight/10;
		
		int x = (menuPanelWidth - width) / 2 - width;
		int y = (menuPanelHeight - height) / 2;
		
		newGameButton.setBounds(x, y, width, height);
		newGameButton.setVisible(true);
		newGameButton.addActionListener(this);
		
	}
	
	public void quitGameButton(){
		quitGameButton = new JButton("Quit Game");
		quitGameButton.setBackground(Color.WHITE);
		
		int width = menuPanelWidth/5;
		int height = menuPanelHeight/10;
		
		int x = (menuPanelWidth - width) / 2 + width/2;
		int y = (menuPanelHeight - height) / 2;
		
		quitGameButton.setBounds(x, y, width, height);
		quitGameButton.setVisible(true);
		quitGameButton.addActionListener(this);
	}
	
}
