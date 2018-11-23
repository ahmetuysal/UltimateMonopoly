package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import domain.GameController;

public class PlayButtonPanel extends JPanel implements ActionListener {

	private ObserverButton rollDiceButton;
	private ObserverButton buyButton;
	private ObserverButton passTurnButton;
	
	private int panelWidth;
	private int panelHeight;
	
	private GameController controller;
		
	public PlayButtonPanel(int width, int height, GameRoomPanel grpanel){
		this.controller = GameController.getInstance();
		this.panelHeight = height;
		this.panelWidth = width;
		
		setSize(width, height);
		setLayout(null);
		initDies();
		initButtons();
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
		
		controller.addPropertyListener("isTurnFinished", rollDiceButton);
		controller.addPropertyListener("isTurnFinished", passTurnButton);
		controller.addPropertyListener("isTurnFinished", buyButton);
		controller.addPropertyListener("currentLocationBuyable", buyButton);
		
		int width = panelWidth / 5;
		int height = panelHeight / 6;
		
		int initx = 3 * panelWidth / 20;
		int inity = panelHeight / 8 ;
		
		int diff = panelHeight / 8 + height;
		
		rollDiceButton.setBounds(initx, inity, width, height);
		buyButton.setBounds(initx + width / 4, inity + diff, width / 2, height);
		passTurnButton.setBounds(initx, inity + 2*diff, width, height);
		
		Font font = new Font("Sans", Font.BOLD, panelHeight / 7);
		
		
		rollDiceButton.setFont(font);
		buyButton.setFont(font);
		passTurnButton.setFont(font);
		
		rollDiceButton.setBackground(Color.WHITE);
		buyButton.setBackground(Color.WHITE);
		passTurnButton.setBackground(Color.WHITE);

		
		buyButton.setEnabled(false);
		passTurnButton.setEnabled(false);
		
		rollDiceButton.setVisible(true);
		buyButton.setVisible(true);
		passTurnButton.setVisible(true);
		
		rollDiceButton.addActionListener(this);
		buyButton.addActionListener(this);
		passTurnButton.addActionListener(this);
		
		add(rollDiceButton);
		add(buyButton);
		add(passTurnButton);
		
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
		}
	}

}
