package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import domain.GameController;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class MonopolyFrame extends JFrame implements ActionListener, PropertyListener {

	//GamePanel gamePanel;
	
	public MonopolyFrame(GameController controller){
		GameController.getInstance().addPropertyListener(this);
		setLayout(null);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		pack();
		setVisible(true);
		
		Dimension dimension = new Dimension(this.getWidth(),this.getHeight());
		getContentPane().setSize(dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MenuPanel menuPanel = new MenuPanel(getContentPane().getWidth(),getContentPane().getHeight());
		getContentPane().add(menuPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
