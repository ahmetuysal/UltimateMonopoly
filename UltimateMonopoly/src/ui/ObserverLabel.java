package ui;

import java.util.ArrayList;

import javax.swing.JLabel;

import domain.square.OwnableSquare;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class ObserverLabel extends JLabel implements PropertyListener {

	private String playerName;
	private String infoType;

	public ObserverLabel(int width, int height, String playerName, String type) {
		super();
		this.infoType = type;
		this.playerName = playerName;
		this.setVisible(true);
		// this.setSize(width,height);
		if(type.equals("playerInfo")) 
			this.setText("<html>Player: " + playerName + "<br>Money: $" + 3200+"</html>");
		else
			this.setText("coming soon...");
		
		
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		// TODO Auto-generated method stub
		if (infoType.equals("playerInfo")) {
			System.out.println(e.getNewValue());
			this.setText("<html>Player: " + playerName + "<br>Money: $" + e.getNewValue()+"</html>");
		} else if (infoType.equals("properties")) {
			System.out.println(e.getNewValue());
			String text = "<html>";
			ArrayList list = (ArrayList) e.getNewValue();
			for (int i = 0; i < list.size(); i++) {
				text += list.get(i).toString().replaceAll("\n", "<br>") + "<br><br>";
			}
			text += "</html>";
			this.setText(text);
		}
	}

}
