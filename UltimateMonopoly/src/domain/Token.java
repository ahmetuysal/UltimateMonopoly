package domain;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import domain.square.Location;
import domain.util.Observable;

public class Token extends Observable implements Serializable{
	
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
	
	public Token(Location loc, String tokenImageName) {
		this.location = loc;
		this.tokenImageName = tokenImageName;
		availableTokenNames.remove(tokenImageName);
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location loc) {
		Location oldValue = this.location;
		this.location = loc;
		publishPropertyEvent("location", oldValue, this.location);
	}
	
	
	public String getTokenImageName() {
		return this.tokenImageName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Token [location=" + location + ", tokenImageName=" + tokenImageName + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Token)) {
			return false;
		}
		Token other = (Token) obj;
		if (location == null) {
			if (other.location != null) {
				return false;
			}
		} else if (!location.equals(other.location)) {
			return false;
		}
		if (tokenImageName == null) {
			if (other.tokenImageName != null) {
				return false;
			}
		} else if (!tokenImageName.equals(other.tokenImageName)) {
			return false;
		}
		return true;
	}
	

}

