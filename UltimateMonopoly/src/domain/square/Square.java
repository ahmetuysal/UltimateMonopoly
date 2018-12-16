package domain.square;

import java.io.Serializable;

import domain.Player;

public class Square implements Serializable{
	
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Square(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	/**
	 * 
	 * @param player Player who lands on this square.
	 */
	public void landOn(Player player) {
	}
	
}
