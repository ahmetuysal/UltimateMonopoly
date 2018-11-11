package domain.square;

import domain.Player;

public abstract class Square {
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
public abstract void landOn(Player player);

	
}
