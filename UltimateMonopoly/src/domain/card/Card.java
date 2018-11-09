package domain.card;

import domain.Player;

public abstract class Card {

	private String name;
	private String description;
	
	public Card(String n, String d){
		this.name = n;
		this.description = d;
	}
	
	
	
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



	public abstract void useCard(Player p, String s);


}
