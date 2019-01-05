package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import domain.GameController;
import domain.Player;

public class PlayerPanel extends JPanel {

	private int panelWidth;
	private int panelHeight;
	private JTabbedPane playerInfoPane;
	
	private GameController controller;

	
		
	public PlayerPanel(int width, int height){
		
		controller = GameController.getInstance();
		this.panelHeight = height;
		this.panelWidth = width;
		
		
		setSize(width, height);
		setLayout(null);		
		setVisible(true);

		initPlayerInfos();
		
	}
	
	
	private void initPlayerInfos() {
		playerInfoPane = new JTabbedPane();
		playerInfoPane.setVisible(true);
		playerInfoPane.setBackground(this.getBackground());
		playerInfoPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		playerInfoPane.setBounds(this.getWidth()/8, this.getHeight()/8, 3*this.getWidth()/4, 3*this.getHeight()/4);
		
		List<Player> players = controller.getPlayerList();
		
		for(int i=0; i<players.size(); i++) {
			Player player = players.get(i);
			
			JTabbedPane playerPane = createPlayerTabbedPane(player);
			
			playerInfoPane.addTab(player.getNickName(), playerPane);
			
		}
		
		this.add(playerInfoPane);
	}
	
	
	private JTabbedPane createPlayerTabbedPane(Player player) {
		JTabbedPane pane = new JTabbedPane();
		
		ObserverLabel playerInfo = new ObserverLabel(40,100, player.getNickName(), "playerInfo");
		playerInfo.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel panel = new JPanel(false);
		panel.setLayout(new GridLayout(1,1));
		panel.add(playerInfo);
		
		pane.addTab("Player Info", panel);
		
		ObserverLabel properties = new ObserverLabel(40,100, player.getNickName(), "properties");
		properties.setHorizontalAlignment(JLabel.LEFT);
		properties.setVerticalAlignment(JLabel.TOP);
		
		JPanel panel2 = new JPanel(false);
		panel2.setLayout(new GridLayout(1,1));
		panel2.add(properties);
		
		pane.addTab("Properties", panel2);
		
		player.addPropertyListener("money", playerInfo);
		player.addPropertyListener("properties", properties);
		
		pane.setVisible(true);
		pane.setBackground(this.getBackground());
		
		return pane;
	}
	

	
}
