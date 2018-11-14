package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	private JTextField usernameInputTextField;
	
	private JButton newGameButton;
	private JButton quitGameButton;
	private JButton startGameButton;
	private JButton menuButton;
	
	private int menuPanelWidth;
	private int menuPanelHeight;
	
	private boolean isPlayersSet = false;
	
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
		newGameButton.setFont(new Font("Sans", Font.BOLD, 25));
		
		int width = menuPanelWidth/10;
		int height = menuPanelHeight/15;
		
		int x = (menuPanelWidth - width) / 2 - width;
		int y = (menuPanelHeight - height) / 2;
		
		newGameButton.setBounds(x, y, width, height);
		newGameButton.setVisible(true);
		newGameButton.addActionListener(this);
		
	}
	
	public void quitGameButton(){
		quitGameButton = new JButton("Quit Game");
		quitGameButton.setBackground(Color.WHITE);
		quitGameButton.setFont(new Font("Sans", Font.BOLD, 25));
		
		int width = menuPanelWidth/10;
		int height = menuPanelHeight/15;
		
		int x = (menuPanelWidth - width) / 2 + width/2;
		int y = (menuPanelHeight - height) / 2;
		
		quitGameButton.setBounds(x, y, width, height);
		quitGameButton.setVisible(true);
		quitGameButton.addActionListener(this);
	}

	public void startGameButton(){
		startGameButton = new JButton("Start Game!");
		startGameButton.setBackground(Color.WHITE);
		startGameButton.setFont(new Font("Sans", Font.BOLD, 25));
		
		int width = menuPanelWidth/10;
		int height = menuPanelHeight/15;
		
		int x = (menuPanelWidth - width) / 2 - width;
		int y = (menuPanelHeight - height) / 2 + height;
		
		//startGameButton.setActionCommand("numOfPlayers");
		
		newGameButton.setBounds(x, y, width, height);
		newGameButton.setVisible(true);
		newGameButton.addActionListener(this);
		
	}
	
	public void menuButton(){
		menuButton = new JButton("Menu");
		menuButton.setBackground(Color.WHITE);
		startGameButton.setFont(new Font("Sans", Font.BOLD, 20));
		
		int width = menuPanelWidth/20;
		int height = menuPanelHeight/30;
		
		int x = (menuPanelWidth - width) / 2 - width;
		int y = (menuPanelHeight - height) / 2 + height;
		
		menuButton.setBounds(0, 0, width, height);
		
		menuButton.setVisible(true);
		menuButton.addActionListener(this);
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
		case "Start Game!":
			remove(startGameButton);
			isPlayersSet = true;
			break;
		}
	}
}
