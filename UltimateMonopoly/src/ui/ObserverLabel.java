package ui;

import javax.swing.JLabel;

import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class ObserverLabel extends JLabel implements PropertyListener {

	private String playerName;
	
	public ObserverLabel(int width, int height, String playerName){
		super();
		this.playerName = playerName;
		this.setVisible(true);
		this.setSize(width,height);
		this.setText("Player: "+playerName+ "Money: $"+3200);
	}
	
	@Override
	public void onPropertyEvent(PropertyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getNewValue());
		this.setText("Player: " +  playerName + " Money: $" + e.getNewValue());
	}

}
