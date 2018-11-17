package ui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.die.DieValue;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class UIDie extends JLabel implements PropertyListener {

	private DieValue dieValue;
	private static ImageIcon[] ICONS;
	private static int DIE_SIZE = 50;
	
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
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		DieValue newVal = (DieValue) e.getNewValue(); 
		this.dieValue = newVal;
		this.setIcon(ICONS[newVal.getValue()]);
	}

}
