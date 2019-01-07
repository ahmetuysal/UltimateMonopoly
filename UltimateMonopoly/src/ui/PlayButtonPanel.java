package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import domain.GameController;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;



public class PlayButtonPanel extends JPanel implements ActionListener, PropertyListener {

	private ObserverButton rollDiceButton;
	private ObserverButton buyButton;
	private ObserverButton passTurnButton;
	private ObserverButton buyHouseButton;
	private ObserverButton buyHotelButton;
	private ObserverButton buySkyscraperButton;

	private int panelWidth;
	private int panelHeight;
	
	private boolean rollDiceBeforeStop = false;
	private boolean buyBeforeStop = false;
	private boolean passTurnBeforeStop = false;

	
	private GameController controller;
		
	public PlayButtonPanel(int width, int height, GameRoomPanel grpanel){
		this.controller = GameController.getInstance();
		this.panelHeight = height;
		this.panelWidth = width;
		
		setSize(width, height);
		setLayout(null);
		initDies();
		initButtons();
		
		controller.addPropertyListener("drawCommunityChestCard",this);
		controller.addPropertyListener("drawChanceCard",this);
		controller.addPropertyListener("drawRollThreeCard",this);
	}
	
	private void initDies() {
		int width = panelWidth / 10;
		int height = width;
		
	    UIDie.initializeDieIcons(width);
		UIDie die1 = new UIDie();
		controller.addPropertyListener("die1", die1);
		UIDie die2 = new UIDie();
		controller.addPropertyListener("die2", die2);
		UIDie die3 = new UIDie();
		controller.addPropertyListener("die3", die3);
		
		int diff = width / 4;
		int initx = panelWidth / 3 + 3 * panelWidth / 20;
		int inity = panelHeight/6;

		
		die1.setBounds(initx, inity, width, height);
		die2.setBounds(initx + diff + width, inity, width, height);
		die3.setBounds(initx + 2*(diff + width), inity, width, height);
		
		die1.setVisible(true);
		die2.setVisible(true);
		die3.setVisible(true);
		
		add(die1);
		add(die2);
		add(die3);
	}
	
	private void initButtons(){
		rollDiceButton = new ObserverButton("Roll Dice", false);
		buyButton = new ObserverButton("Buy", true);
		passTurnButton = new ObserverButton("Pass Turn",  true);
		buyHouseButton = new ObserverButton("Buy House",  true);
		buyHotelButton = new ObserverButton("Buy Hotel",  true);
		buySkyscraperButton = new ObserverButton("Buy Skyscraper",  true);

		
		controller.addPropertyListener("changeRoll",rollDiceButton);
		controller.addPropertyListener("buyable",buyButton);
		controller.addPropertyListener("pass", passTurnButton);
		
		controller.addPropertyListener("isTurnFinished", rollDiceButton);
		controller.addPropertyListener("isTurnFinished", passTurnButton);
		controller.addPropertyListener("isTurnFinished", buyButton);
		controller.addPropertyListener("currentLocationBuyable", buyButton);
		
		controller.addPropertyListener("buyHouse", buyHouseButton);
		controller.addPropertyListener("buyHotel", buyHotelButton);
		controller.addPropertyListener("buySkyscraper", buySkyscraperButton);

		
		int width = panelWidth / 5;
		int height = panelHeight / 6;
		
		int initx = 3 * panelWidth / 20;
		int inity = panelHeight / 8 ;
		
		int diff = panelHeight / 8 + height;
		
		rollDiceButton.setBounds(initx - width / 2, inity, width, height);
		buyButton.setBounds(initx - width / 4, inity + diff, width / 2, height);
		passTurnButton.setBounds(initx - width / 2, inity + 2 * diff, width, height);
		
		buyHouseButton.setBounds(initx + 3 * width / 4 - diff, inity, width, height);
		buyHotelButton.setBounds(initx + 3 * width / 4 - diff, inity + diff, width, height);
		buySkyscraperButton.setBounds(initx + 3 * width / 4 - diff, inity + 2 * diff, width, height);

		Font font = new Font("Sans", Font.BOLD, panelHeight / 7);
		
		
		rollDiceButton.setFont(font);
		buyButton.setFont(font);
		passTurnButton.setFont(font);
		
		buyHouseButton.setFont(font);
		buyHotelButton.setFont(font);
		buySkyscraperButton.setFont(font);

		
		rollDiceButton.setBackground(Color.WHITE);
		buyButton.setBackground(Color.WHITE);
		passTurnButton.setBackground(Color.WHITE);
		
		buyHouseButton.setBackground(Color.WHITE);
		buyHotelButton.setBackground(Color.WHITE);
		buySkyscraperButton.setBackground(Color.WHITE);

		
		buyButton.setEnabled(false);
		passTurnButton.setEnabled(false);
		
		buyHouseButton.setEnabled(false);
		buyHotelButton.setEnabled(false);
		buySkyscraperButton.setEnabled(false);

		
		rollDiceButton.setVisible(true);
		buyButton.setVisible(true);
		passTurnButton.setVisible(true);
		
		buyHouseButton.setVisible(true);
		buyHotelButton.setVisible(true);
		buySkyscraperButton.setVisible(true);

		
		rollDiceButton.addActionListener(this);
		buyButton.addActionListener(this);
		passTurnButton.addActionListener(this);
		
		buyHouseButton.addActionListener(this);
		buyHotelButton.addActionListener(this);
		buySkyscraperButton.addActionListener(this);

		
		add(rollDiceButton);
		add(buyButton);
		add(passTurnButton);
		add(buyHouseButton);
		add(buyHotelButton);
		add(buySkyscraperButton);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "Roll Dice":
			System.out.println("rolled");
			controller.playTurn();
			break;
		case "Pass Turn":
			controller.passTurn();
			break;
		case "Buy":
			System.out.println("buy that");
			controller.buyProperty();
			break;
		case "Buy House":
			controller.buildHouse();
			break;
		case "Buy Hotel":
			controller.buildHotel();
			break;
		case "Buy Skyscraper":
			controller.buildSkyscraper();
			break;
		}
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if ((boolean) e.getNewValue()) {
			rollDiceBeforeStop = rollDiceButton.isEnabled();
			rollDiceButton.setEnabled(false);
			buyBeforeStop = buyButton.isEnabled();
			buyButton.setEnabled(false);
			passTurnBeforeStop = passTurnButton.isEnabled();
			passTurnButton.setEnabled(false);
		}
		else {
			rollDiceButton.setEnabled(rollDiceBeforeStop);
			buyButton.setEnabled(buyBeforeStop);
			passTurnButton.setEnabled(passTurnBeforeStop);
		}
		//this.setEnabled((boolean) e.getNewValue());
	}

}
