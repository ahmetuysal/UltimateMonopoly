package domain.card;

import java.util.List;

import domain.Player;

public abstract class Card {

	private String name;
	private String description;
	private List<Card> chanceCardList;
	private List<Card> communityChestCardList;
	
	public Card(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public void addChanceCards() {
		chanceCardList.add(CardFactory.getCard("Chance Card", "Advance to the Pay Corner"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Go To Jail!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Advance to the Nearest Railroad"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Make General Repairs to all your properties."));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Get Out of Jail Free!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Advance to the Saint Charles Place"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Holiday Bonus!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Just Say 'NO'!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Buyer's Market!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "See You In Court!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Foreclosed Property Sale!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Get Rollin'"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Forward Thinker"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Hurricane makes landfall!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Property Taxes"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Ride the Subway"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Social Media Fail!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Pay Back!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "MARDI GRAS!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "GPS is not working"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Zero Dollars Down!"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Changing Lanes Below"));
		chanceCardList.add(CardFactory.getCard("Chance Card", "Changing Lanes Above"));

	}
	
	public void addCommunityChestCards() {
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "Happy Birthday!"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "Game Night!"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "A Moving Experience"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "HOUSE CONDEMNED"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "Elected District Attorney"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "Deal Buster"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "Be Kind, Rewind"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "Pay Hospital Bills"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "Tornado Hits!"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "Share in their Good Fortune"));
		communityChestCardList.add(CardFactory.getCard("Community Chest Card", "The Insider's Edge"));
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



	public abstract void useCard(Player player, String s);


}
