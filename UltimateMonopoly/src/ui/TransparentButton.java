package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class TransparentButton extends JButton implements PropertyListener {
	
	//private boolean isActive;
	public TransparentButton(){
		super();
		this.setBorder(new LineBorder(Color.BLUE, 4));
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setVisible(false);
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		// TODO Auto-generated method stub
		this.setVisible((boolean) e.getNewValue());
	}
	
	
}
