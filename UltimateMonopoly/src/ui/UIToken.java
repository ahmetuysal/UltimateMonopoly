package ui;

import java.awt.Container;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.Token;
import domain.square.Location;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class UIToken extends JLabel implements PropertyListener {

	private Location location;
	
	public UIToken(Token token, int tokenSize) {
		super(getIconFromFileName(token.getTokenImageName(), tokenSize));
		this.setSize(tokenSize, tokenSize);
		this.setLocation(0, 0);
		this.setVisible(true);
		changeLocation(token.getLocation());
		token.addPropertyListener("location", this);
	}
	
	private static ImageIcon getIconFromFileName(String fileName, int tokenSize) {
		Image tmp = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
	        if(osName.contains("mac")){
	        	tmp = ImageIO.read(new File("./images/tokens/" + fileName));
	        } else {
				tmp = ImageIO.read(new File(".\\images\\tokens\\" + fileName));
	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp = tmp.getScaledInstance(tokenSize, tokenSize, Image.SCALE_SMOOTH);
		return new ImageIcon(tmp);
	}
	
	private void changeLocation(Location loc) {
		Location oldLoc = this.location;
		this.location = loc;
		Container parent = getParent();
		if (parent != null)
			((GameRoomPanel)getParent()).TokenLocationChanged(this, oldLoc, location);
	}
	
	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if (e.getPropertyName().equals("location")) {
			changeLocation((Location) e.getNewValue());
			// TODO start animation
		}
	}

}
