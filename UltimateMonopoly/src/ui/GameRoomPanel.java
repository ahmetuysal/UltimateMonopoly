package ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JPanel;

import domain.GameController;

public class GameRoomPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	
	private GameController controller;
	
	private int frameWidth;
	private int frameHeight;
	private int squareWidth;
	private int squareHeight;
	private int tokensize;
	
	private List<Image> tokenImages;
	

	
	public GameRoomPanel(int width, int height){
		frameWidth = width;
		frameHeight = height;
		
		setSize(frameWidth, frameHeight);
		setVisible(true);
		setBackground(new Color(175, 231, 204));
		
		squareWidth = ((int) (frameHeight / 8.5) + 1) / 2;
		squareHeight = (int) (frameHeight / 8.5) + 1;
		
		tokensize = squareHeight / 5;
		
		//initBoard();
		//initButtons();
		
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
