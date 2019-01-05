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
		
//		initLabels();
//		addTabbedPane();
		initPlayerInfos();
		
	}
	
	private void initLabels(){
		int x = panelWidth / 20;
		int y = 0;
		int width = panelWidth - 2*x;
		List<Player> players = controller.getPlayerList();
		int height = players.isEmpty()? panelHeight : panelHeight / players.size();
		
		if(height > panelHeight / 10){
			height = panelHeight / 20;
		}
		
		for (int i=0; i<players.size(); i++){
			
			Player player = players.get(i);
			
			
			ObserverLabel moneyLabel = new ObserverLabel(width, height, player.getNickName(), "playerInfo");
			
			moneyLabel.setBounds(x, y + i*height , width, height);
			moneyLabel.setSize(width, height);
			moneyLabel.setVisible(true);
			
			
			moneyLabel.setFont(new Font("Sans", Font.CENTER_BASELINE, height/2));
			
			
			player.addPropertyListener("money", moneyLabel);
			
			add(moneyLabel);
		}
		
		
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
	
	
	
	private void addTabbedPane() {
		playerInfoPane = new JTabbedPane();
		
		JComponent money = makeTextPanel("Money");
		money.setBackground(Color.white);
		playerInfoPane.addTab("Money", null, money, "Does nothing");
		
		JComponent properties = makeTextPanel("Properties");
		playerInfoPane.addTab("Properties", null, properties, "Does Nothing");
		
		JTabbedPane tabbedpane = new JTabbedPane();
		tabbedpane.setVisible(true);
		tabbedpane.setBackground(this.getBackground());
		tabbedpane.addTab("name",null,(JComponent) makeTextPanel("Properties"), "Does nothing");
//		tabbedpane.addTab("money", null, money, "noo");
		
		
		playerInfoPane.addTab("Try1",null,tabbedpane,"Does nothing");
		playerInfoPane.setVisible(true);
		playerInfoPane.setBackground(this.getBackground());
		playerInfoPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		playerInfoPane.setBounds(this.getWidth()/8, this.getHeight()/8, 3*this.getWidth()/4, 3*this.getHeight()/4);
		
		this.add(playerInfoPane);
	}
	
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
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
	
	private JTabbedPane createPropertyTabbedPane(Player player) {
		JTabbedPane pane = new JTabbedPane();
		
		ObserverLabel properties = new ObserverLabel(40,100, player.getNickName(), "properties");
		properties.setHorizontalAlignment(JLabel.LEFT);
		properties.setVerticalAlignment(JLabel.TOP);
		
		JPanel panel2 = new JPanel(false);
		panel2.setLayout(new GridLayout(1,1));
		panel2.add(properties);
		
		pane.addTab("Properties", panel2);
		
		pane.setVisible(true);
		pane.setBackground(this.getBackground());
		
		return pane;
	}
	
	
}
