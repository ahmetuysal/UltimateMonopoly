package ui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JButton continueButton;
	
	private Choice numOfPlayerPossibleChoices;
	private int minPlayerNum = 1;
	private int maxPlayerNum = 6;
	
	private int menuPanelWidth;
	private int menuPanelHeight;
	
	private boolean isPlayersSet = false;
	
	private Image backgroundImage;
	
	public MenuPanel(int menuPanelWidth, int menuPanelHeight){
		this.backgroundImage = new ImageIcon("images\\background.jpg").getImage();
		this.usernameInputTextField = new JTextField();
		this.playernameList = new ArrayList<String>();
		this.controller = GameController.getInstance();
	
		setLayout(null);
		this.menuPanelWidth = menuPanelWidth;
		this.menuPanelHeight = menuPanelHeight;
		this.setSize(this.menuPanelWidth, this.menuPanelHeight);
		
		//setBackground(Color.CYAN);
		
		initialScreen();
		
		this.setVisible(true);
	}

	//initial screen of the game that contains new game and quit button
	public void initialScreen(){
		//System.out.println("adding buttons");
		removeAll();
		newGameButton();
		quitGameButton();
		
		this.add(newGameButton);
		this.add(quitGameButton);
		
		repaint();
	}
	
	//when new game is clicked, this screen appears for players to specify their names
	public void nextScreen(){
		removeAll();
		menuButton();
		continueButton();
		numOfPlayerPossibleChoices();
		this.add(menuButton);
		this.add(continueButton);
		this.add(numOfPlayerPossibleChoices);
		
		repaint();
		
		
	}
	
	public void newGameButton(){
		newGameButton = new JButton("New Game");
		newGameButton.setBackground(Color.WHITE);
		newGameButton.setFont(new Font("Sans", Font.BOLD, menuPanelHeight/60));
		
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
		quitGameButton.setFont(new Font("Sans", Font.BOLD, menuPanelHeight/60));
		
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
		startGameButton.setFont(new Font("Sans", Font.BOLD, menuPanelHeight/60));
		
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
		menuButton.setFont(new Font("Sans", Font.BOLD, menuPanelHeight/72));
		
		int width = menuPanelWidth/20;
		int height = menuPanelHeight/30;
		
		menuButton.setBounds(0, 0, width, height);
		
		menuButton.setVisible(true);
		menuButton.addActionListener(this);
	}

	public void continueButton(){
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.WHITE);
		continueButton.setFont(new Font("Sans", Font.BOLD, menuPanelHeight/60));
		
		int width = menuPanelWidth/10;
		int height = menuPanelHeight/20;
		
		int x = (menuPanelWidth - width) / 2;
		int y = (menuPanelHeight - height) / 2 + height;

		continueButton.setBounds(x, y, width, height);
		continueButton.setVisible(true);
		continueButton.addActionListener(this);
	}

	public void numOfPlayerPossibleChoices(){
		numOfPlayerPossibleChoices = new Choice();
		
		int width = menuPanelWidth/10;
		int height = menuPanelHeight/10;
		
		int x = (menuPanelWidth - width) / 2;
		int y = (menuPanelHeight - height) / 2 ;
		
		numOfPlayerPossibleChoices.setBounds(x, y, width, height);
		numOfPlayerPossibleChoices.setSize(width,height);
		numOfPlayerPossibleChoices.setFont(new Font("Sans",Font.CENTER_BASELINE, menuPanelHeight/60));
		for(int i = this.minPlayerNum; i<=this.maxPlayerNum; i++){
			numOfPlayerPossibleChoices.add(""+i);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "New Game":
			this.nextScreen();
			break;
		case "Quit Game":
			controller.quitGame();
			break;
		case "Start Game!":
			remove(startGameButton);
			isPlayersSet = true;
			break;
		case "Menu":
			initialScreen();
			break;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		 g.drawImage(backgroundImage, 0, 0, null);
	}
	
}
