package domain;

import java.awt.image.BufferedImage;

public class Token {
	
	private Player player;
	private int location;
	private BufferedImage bufferedImage;
	
	public Token(Player p, int loc, BufferedImage img) {
		this.player = p;
		this.location = loc;
		this.bufferedImage = img;
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
