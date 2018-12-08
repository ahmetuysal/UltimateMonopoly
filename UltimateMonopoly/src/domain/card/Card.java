package domain.card;

import java.io.Serializable;

import domain.Player;

public class Card implements Serializable{

	private String name;
	private String description;
	
	
	public Card(String name, String description){
		this.name = name;
		this.description = description;
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



	public void useCard(Player player, String s) {
	}


}
