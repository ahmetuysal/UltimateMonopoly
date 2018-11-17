package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import domain.GameController;

public class PlayButtonPanel extends JPanel implements ActionListener {

	private JButton rollDiceButton;
	private JButton buyButton;
	private JButton passTurnButton;
	
	private int panelWidth;
	private int panelHeight;
	
	private GameController controller;
	
	public PlayButtonPanel(int width, int height, GameRoomPanel grpanel){
		this.controller = GameController.getInstance();
		this.panelHeight = height;
		this.panelWidth = width;
		
		setSize(width, height);
		setLayout(null);
		
		initButtons();
	}
	
	private void initButtons(){
		rollDiceButton = new JButton("Roll Dice");
		buyButton = new JButton("Buy");
		passTurnButton = new JButton("Pass Turn");
		
		int width = panelWidth / 5;
		int height = panelHeight / 6;
		
		int initx = (panelWidth - width) / 2;
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
			System.out.println("passss");
			//TODO: controller.passTurn();
			break;
		case "Buy":
			System.out.println("buy that");
			controller.buyTitleDeed();
			break;
		}
	}

}
