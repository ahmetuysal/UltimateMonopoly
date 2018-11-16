package ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.GameController;
import domain.Token;

public class MenuPanel extends JPanel implements ActionListener, ItemListener {
	
	private MonopolyFrame mainFrame;
	private GameController controller;
	
	//private ArrayList<String> playernameList;
	private int numOfPlayers;
	private int inputtedPlayerNum = 0;
	private JTextField usernameInputTextField;
	
	private JButton newGameButton;
	private JButton quitGameButton;
	private JButton startGameButton;
	private JButton menuButton;
	private JButton continueButton;
	private JLabel ultimateMonopolyLogo;
	
	private Choice numOfPlayerPossibleChoices;
	private Choice possibleTokenChoices;
	private int minPlayerNum = 1;
	private int maxPlayerNum = 6;
	
	private int menuPanelWidth;
	private int menuPanelHeight;
	
	private boolean isPlayersSet = false;
	
	private Image backgroundImage;
	//private Image selectedTokenImage;
	private JLabel selectedTokenImage;
	
	public MenuPanel(int menuPanelWidth, int menuPanelHeight, MonopolyFrame frame){
		try {
			BufferedImage tmp;
			String osName = System.getProperty("os.name").toLowerCase();
	        if(osName.contains("mac")){
	        	tmp = ImageIO.read(new File("images/background.jpg"));
	        } else {
	        	tmp = ImageIO.read(new File("images\\background.jpg"));
	        }
			 
			this.backgroundImage = tmp.getScaledInstance(menuPanelWidth, menuPanelHeight, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.mainFrame = frame;
		this.usernameInputTextField = new JTextField();
		//this.playernameList = new ArrayList<String>();
		this.controller = GameController.getInstance();
	
		setLayout(null);
		this.menuPanelWidth = menuPanelWidth;
		this.menuPanelHeight = menuPanelHeight;
		this.setSize(this.menuPanelWidth, this.menuPanelHeight);
		
		//setBackground(Color.CYAN);
		
		splashScreen();
		
		this.setVisible(true);
	}
	
	public void splashScreen() {
		removeAll();
		ultimateMonopolyLogo();
		this.add(ultimateMonopolyLogo);
		repaint();
	
		new Timer().schedule(new TimerTask() {
			public void run() {
				// TODO Auto-generated method stub
				initialScreen();
			}
		}, 2000);
	}

	//initial screen of the game that contains new game and quit button
	public void initialScreen(){
		//System.out.println("adding buttons");
		removeAll();
		newGameButton();
		quitGameButton();
		//ultimateMonopolyLogo();
		
		//this.add(ultimateMonopolyLogo);
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
	
	private void ultimateMonopolyLogo() {
		if (ultimateMonopolyLogo == null) {
			Image tmp = null;
			try {
				String osName = System.getProperty("os.name").toLowerCase();
		        if(osName.contains("mac")){
		        	tmp = ImageIO.read(new File("./images/logo.png"));
		        } else {
					tmp = ImageIO.read(new File(".\\images\\logo.png"));
		        }
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ultimateMonopolyLogo = new JLabel(new ImageIcon(tmp));
		}
		int width = menuPanelWidth;
		int height = menuPanelHeight;
		
		int x = 0; //(menuPanelWidth - width) / 2 + width/2;
		int y = 0; //(menuPanelHeight - height) / 2;
		
		ultimateMonopolyLogo.setBounds(x, y, width, height);
		ultimateMonopolyLogo.setVisible(true);
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
		int y = (menuPanelHeight - height) / 2 + height/2;

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
	
    public void possibleTokenChoices(){
    	this.possibleTokenChoices = new Choice();
    	
    	int width = menuPanelWidth/10;
		int height = menuPanelHeight/10;
		
		int x = (menuPanelWidth - width) / 2;
		int y = (int) (menuPanelHeight- height) / 2 ;
		
    	this.possibleTokenChoices.setBounds(x,y,width, height);	
    	this.possibleTokenChoices.setSize(width, height);
    	this.possibleTokenChoices.setFont(new Font("Sans",Font.CENTER_BASELINE, menuPanelHeight/60));
    	for(String tokenname : Token.getAvailableTokens()){
    		this.possibleTokenChoices.add(tokenname);
    	}
    	
    	this.possibleTokenChoices.addItemListener(this);
    	
    	this.selectedTokenImage = new JLabel();
    	selectedTokenImage.setBounds((menuPanelWidth - width) / 2 + width/4, y + height/4, width/2, width/2);
    	try {
			Image tmp;
			String osName = System.getProperty("os.name").toLowerCase();
	        if(osName.contains("mac")){
	        	tmp = ImageIO.read(new File("./images/tokens/"+possibleTokenChoices.getItem(0)));
	        } else {
	        	tmp = ImageIO.read(new File(".\\images\\tokens\\"+possibleTokenChoices.getItem(0)));
	        }
			 
			tmp= tmp.getScaledInstance(selectedTokenImage.getWidth(), selectedTokenImage.getHeight(), Image.SCALE_SMOOTH);
			this.selectedTokenImage.setIcon(new ImageIcon(tmp));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	this.selectedTokenImage.setVisible(true);
   
    }
	
	public void nameInputField(){
		this.usernameInputTextField = new JTextField();
		

		int width = menuPanelWidth/8;
		int height = menuPanelHeight/35;
		
		int x = (menuPanelWidth - width) / 2;
		int y = (int) ((menuPanelHeight - 10*height) / 2) ;
		
		this.usernameInputTextField.setBounds(x, y, width, height);
		this.usernameInputTextField.setSize(width, height);
		this.usernameInputTextField.setFont(new Font("Sans", Font.CENTER_BASELINE, menuPanelHeight/60));
		this.usernameInputTextField.setVisible(true);
		
		//this.usernameInputTextField.getSele
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
		case "Continue":
			numOfPlayers = Integer.parseInt(numOfPlayerPossibleChoices.getSelectedItem());
			registerUsers();
			break;
		case "registerUser":
		
			if(controller.registerUser(this.usernameInputTextField.getText(), possibleTokenChoices.getSelectedItem())){
				inputtedPlayerNum++;
				possibleTokenChoices.remove(possibleTokenChoices.getSelectedItem());
				usernameInputTextField.setText("");
				updateTokenImage();
			}
			if(inputtedPlayerNum == numOfPlayers){
				continueButton.setText("Start Game");
				continueButton.setActionCommand("Start Game");
				this.remove(usernameInputTextField);
				this.remove(possibleTokenChoices);
				this.remove(selectedTokenImage);
				repaint();
			}
			break;
		case "Start Game":
			mainFrame.toGameRoomPanel();
			break;
		}
	}
	
	private void registerUser(String nickname, String tokenName) {
		if(controller.registerUser(nickname, tokenName)){
			inputtedPlayerNum++;
			possibleTokenChoices.remove(possibleTokenChoices.getSelectedItem());
			usernameInputTextField.setText("");
		}
		if(inputtedPlayerNum == numOfPlayers){
			continueButton.setText("Start Game");
			continueButton.setActionCommand("Start Game");
			this.remove(usernameInputTextField);
			this.remove(possibleTokenChoices);
			repaint();
		}
	}
	
	private void registerUsers() {
		removeAll();
		nameInputField();
		possibleTokenChoices();
		
		this.add(menuButton);
		this.add(continueButton);
		this.add(usernameInputTextField);
		this.add(this.possibleTokenChoices);
		this.add(selectedTokenImage);
		continueButton.setLocation(continueButton.getX(), menuPanelHeight / 2 + 3*continueButton.getHeight()/2);
		continueButton.setActionCommand("registerUser");
		
		repaint();
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		 g.drawImage(backgroundImage, 0, 0, null);
	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		updateTokenImage();
	
	}
	
	public void updateTokenImage(){
		String fileName = this.possibleTokenChoices.getSelectedItem();
		
		Image tmp = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
	        if(osName.contains("mac")){
	        	tmp = ImageIO.read(new File("./images/tokens/" + fileName));
	        } else {
				tmp = ImageIO.read(new File(".\\images\\tokens\\" + fileName));
	        }
	        tmp = tmp.getScaledInstance(selectedTokenImage.getWidth(), selectedTokenImage.getHeight(), Image.SCALE_SMOOTH);
			this.selectedTokenImage.setIcon(new ImageIcon(tmp));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		repaint();
	}
}
