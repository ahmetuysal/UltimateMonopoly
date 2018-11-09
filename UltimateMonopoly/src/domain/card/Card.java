package domain.card;

import domain.Player;

public abstract class Card {

	private String name;
	private String description;
	
	public Card(String n, String d){
		this.name = n;
		this.description = d;
	}
	
	
	public abstract void useCard(Player p, String s);


}
