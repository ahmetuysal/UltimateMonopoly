package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import domain.GameController;
import domain.Player;

public class PlayerPanel extends JPanel {

	private int panelWidth;
	private int panelHeight;
	
	private GameController controller;

	
		
	public PlayerPanel(int width, int height){
		controller = GameController.getInstance();
		this.panelHeight = height;
		this.panelWidth = width;
		
		
		setSize(width, height);
		setLayout(null);
		setVisible(true);
		
		initLabels();
		
	}
	
	private void initLabels(){
		int x = panelWidth / 20;
		int y = 0;
		int width = panelWidth - 2*x;
		List<Player> players = controller.getPlayerList();
		int height = panelHeight / players.size();
		
		if(height > panelHeight / 10){
			height = panelHeight / 20;
		}
		
		for (int i=0; i<players.size(); i++){
			
			Player player = players.get(i);
			
			
			ObserverLabel moneyLabel = new ObserverLabel(width, height, player.getNickName());
			
			moneyLabel.setBounds(x, y + i*height , width, height);
			moneyLabel.setSize(width, height);
			moneyLabel.setVisible(true);
			
			
			moneyLabel.setFont(new Font("Sans", Font.CENTER_BASELINE, height/2));
			
			
			player.addPropertyListener("money", moneyLabel);
			
			add(moneyLabel);
		}
		
		
	}
	
	
	
	
}
