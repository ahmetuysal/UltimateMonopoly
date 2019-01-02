package ui;

import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.Token;
import domain.square.Location;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class UIToken extends JLabel implements PropertyListener {

	private Location location;
	private LinkedList<TokenMoveAnimation> waitingAnimations;

	public UIToken(Token token, int tokenSize) {
		super(getIconFromFileName(token.getTokenImageName(), tokenSize));
		this.setSize(tokenSize, tokenSize);
		this.setLocation(0, 0);
		this.setVisible(true);
		waitingAnimations = new LinkedList<>();
		token.addPropertyListener("location", this);

		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(new Runnable() {
			public void run() {
				if (waitingAnimations != null && !waitingAnimations.isEmpty()) {
					TokenMoveAnimation currentAnim = waitingAnimations.getFirst();
					double ratio = currentAnim.increaseCompletedRate();
					changeLocation(currentAnim.getStartingLocation(), currentAnim.getEndingLocation(), ratio);
					if (ratio >= 1)
						waitingAnimations.removeFirst();
				}
			}

		}, 0, 50, TimeUnit.MILLISECONDS);
	}

	private static ImageIcon getIconFromFileName(String fileName, int tokenSize) {
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

	private void changeLocation(Location oldLoc, Location newLoc, double completedRatio) {
		Container parent = getParent();
		if (parent != null)
			((GameRoomPanel) getParent()).TokenLocationChanged(this, oldLoc, newLoc, completedRatio);
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if (e.getPropertyName().equals("location")) {
			this.location = (Location) e.getNewValue();
			waitingAnimations.addLast(new TokenMoveAnimation((Location) e.getOldValue(), (Location) e.getNewValue()));
			// changeLocation((Location) e.getNewValue());
		}
	}

}
