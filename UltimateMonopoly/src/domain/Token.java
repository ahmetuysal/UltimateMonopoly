package domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import domain.square.Location;

public class Token {
	
	private Player player;
	private Location location;
	private String tokenImageName;
	private static List<String> availableTokenNames;
	
	public static void initializeAvailableTokens() {
		
		availableTokenNames = new ArrayList<>();
		File folder = null;
		String osName = System.getProperty("os.name").toLowerCase();
		if(osName.contains("mac")){
			folder = new File("./images/tokens");
		} else {
			folder = new File(".\\images\\tokens");
		}
		File[] files = folder.listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 

		for (File file : files) {
		    if (file.isFile()) {
		    	availableTokenNames.add(file.getName());
		    }
		}
	}
	
	public static boolean isTokenAvailable(String tokenName) {
		return availableTokenNames.contains(tokenName);
	}
	
	public static List<String> getAvailableTokens(){
		return availableTokenNames;
	}
	
	public Token(Player p, Location loc, String tokenImageName) {
		this.player = p;
		this.location = loc;
		this.tokenImageName = tokenImageName;
		availableTokenNames.remove(tokenImageName);
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location loc) {
		this.location = loc;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public String getTokenImageName() {
		return this.tokenImageName;
	}
	
}

