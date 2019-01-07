package ui;

import java.util.ArrayList;

import javax.swing.JLabel;

import domain.Player;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class ObserverLabel extends JLabel implements PropertyListener {

	private Player player;
	private String infoType;

	public ObserverLabel(int width, int height, Player player, String type) {
		super();
		this.infoType = type;
		this.player = player;
		this.setVisible(true);
		// this.setSize(width,height);
		if(type.equals("playerInfo"))
			onPropertyEvent(new PropertyEvent(this, "playerInfo", player.getTotalMoney(), player.getTotalMoney()));
		else
			onPropertyEvent(new PropertyEvent(this, "properties", player.getTotalMoney(), player.getProperties()));		
		
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		// TODO Auto-generated method stub
		if (infoType.equals("playerInfo")) {
			this.setText("<html>Player: " + player.getNickName() + "<br>Money: $" + e.getNewValue()+"</html>");
		} else if (infoType.equals("properties")) {
			String text = "<html>";
			ArrayList list = (ArrayList) e.getNewValue();
			if (list == null) {
				text += "No properties!";
			}
			else{
				for (int i = 0; i < list.size(); i++) {
					text += list.get(i).toString().replaceAll("\n", "<br>") + "<br><br>";
				}
			}
			text += "</html>";
			this.setText(text);
		}
	}

}
