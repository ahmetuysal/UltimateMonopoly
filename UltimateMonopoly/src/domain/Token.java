package domain;

import java.awt.image.BufferedImage;

import domain.square.Location;

public class Token {
	
	private Player player;
	private Location location;
	private BufferedImage bufferedImage;
	
	public Token(Player p, Location loc, BufferedImage img) {
		this.player = p;
		this.location = loc;
		this.bufferedImage = img;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location loc) {
		this.location = loc;
	}
	public void updateOwner(Player p) {
		this.player = p;
	}
}
