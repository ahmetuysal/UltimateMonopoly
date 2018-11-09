package domain;

import java.awt.image.BufferedImage;

public class Token {
	
	private Player player;
	private int location;
	private BufferedImage bufferedImage;
	private int[] layerList = {0, 1, 2};
	private int currentLayer;
	
	public Token(Player p, int loc, BufferedImage img) {
		this.player = p;
		this.location = loc;
		this.bufferedImage = img;
		this.currentLayer = 1;
	}
	
	
	public int getCurrentLayer() {
		return currentLayer;
	}

	public void setCurrentLayer(int newLayer) {
		this.currentLayer = newLayer;
	}


	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int loc) {
		this.location = loc;
	}
	public void updateOwner(Player p) {
		this.player = p;
	}
}
