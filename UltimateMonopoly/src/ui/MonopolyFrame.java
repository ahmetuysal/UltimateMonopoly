package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import domain.GameController;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class MonopolyFrame extends JFrame implements ActionListener, PropertyListener {

	//GamePanel gamePanel;
	
	private Image background;
	
	
	public MonopolyFrame(GameController controller){
		GameController.getInstance().addPropertyListener(this);		
		//setLayout(null);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Ultimate Monopoly");

		pack();
		setVisible(true);
		
		Dimension dimension = new Dimension(this.getWidth(),this.getHeight());
		getContentPane().setSize(dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MenuPanel menuPanel = new MenuPanel(getContentPane().getWidth(),getContentPane().getHeight());
		getContentPane().add(menuPanel);
		validate();
		//menuPanel.repaint();
		
		setBackground(Color.GRAY);
		
		//System.out.println(dimension);
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
