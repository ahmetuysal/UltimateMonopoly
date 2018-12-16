package domain.card;

import java.io.Serializable;

import domain.Player;

public class Card implements Serializable{

	protected String name;
	protected String description;
	
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [name=" + name + ", description=" + description + "]";
	}

	
	
	
}
