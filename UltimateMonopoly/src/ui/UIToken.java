package ui;

import java.awt.Container;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.Board;
import domain.Token;
import domain.square.Location;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;
import ui.animation.Animatable;
import ui.animation.Animation;
import ui.animation.TokenMoveAnimation;

public class UIToken extends JLabel implements PropertyListener, Animatable {

	private Location location;
	private LinkedList<Animation> waitingAnimations;

	public UIToken(Token token, int tokenSize) {
		super(getIconFromFileName(token.getTokenImageName(), tokenSize));
		this.setSize(tokenSize, tokenSize);
		this.setLocation(0, 0);
		this.setVisible(true);
		waitingAnimations = new LinkedList<>();
		token.addPropertyListener("location", this);
	}

	public static ImageIcon getIconFromFileName(String fileName, int tokenSize) {
		Image tmp = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			if (osName.contains("mac")) {
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

	public void changeLocation(Location oldLoc, Location newLoc, double completedRatio) {
		Container parent = getParent();
		if (parent != null)
			((GameRoomPanel) getParent()).TokenLocationChanged(this, oldLoc, newLoc, completedRatio);
	}
	

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if (e.getPropertyName().equals("location")) {
			this.location = (Location) e.getNewValue();
			if (Board.isCornerSquare((Location) e.getNewValue()))
				waitingAnimations.addLast(new TokenMoveAnimation(this, (Location) e.getOldValue(), (Location) e.getNewValue(), 0.075));
			else
				waitingAnimations.addLast(new TokenMoveAnimation(this, (Location) e.getOldValue(), (Location) e.getNewValue()));
			// changeLocation((Location) e.getNewValue());
		}
	}

	@Override
	public LinkedList<Animation> getWaitingAnimations() {
		return waitingAnimations;
	}

}
