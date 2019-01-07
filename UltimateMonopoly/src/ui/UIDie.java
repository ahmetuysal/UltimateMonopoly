package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.die.DieValue;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;
import ui.animation.Animatable;
import ui.animation.Animation;
import ui.animation.DieRotateAnimation;

public class UIDie extends JLabel implements PropertyListener, Animatable {

	private DieValue dieValue;
	private static ImageIcon[] ICONS;
	private static int DIE_SIZE = 50;
	
	
	private double angle = 0;
	private LinkedList<Animation> waitingAnimations;


	public static void initializeDieIcons(int size) {
		DIE_SIZE = size;
		if (ICONS != null)
			return;
		ICONS = new ImageIcon[9];
		Image tmp = null;
		for (int i = 1; i < 9; i++) {
			try {
				String osName = System.getProperty("os.name").toLowerCase();
		        if(osName.contains("mac")){
		        	tmp = ImageIO.read(new File("./images/dieFaces/" + i + ".png"));
		        } else {
					tmp = ImageIO.read(new File(".\\images\\dieFaces\\" + i + ".png"));
		        }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tmp = tmp.getScaledInstance(DIE_SIZE, DIE_SIZE, Image.SCALE_SMOOTH);
			ICONS[i] =  new ImageIcon(tmp);
		}
		
	}
	
	public UIDie() {
		super();
		this.setSize(DIE_SIZE, DIE_SIZE);
		// TODO Auto-generated constructor stub
		this.setIcon(ICONS[0]);
		waitingAnimations = new LinkedList<>();
	}
	
	@Override 
	protected void paintComponent(Graphics g) {
		Graphics2D gx = (Graphics2D) g;
		if (getIcon() != null)
			gx.rotate(Math.toRadians(this.angle), getIcon().getIconWidth()/2,getIcon().getIconHeight()/2);
		super.paintComponent(g);
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}


	@Override
	public void onPropertyEvent(PropertyEvent e) {
		DieValue newVal = (DieValue) e.getNewValue(); 
		this.dieValue = newVal;
		this.setIcon(ICONS[newVal.getValue()]);
		waitingAnimations.add(new DieRotateAnimation(this));
	}

	@Override
	public LinkedList<Animation> getWaitingAnimations() {
		return waitingAnimations;
	}

}
