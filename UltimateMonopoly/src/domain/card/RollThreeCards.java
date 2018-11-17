package domain.card;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Player;

public class RollThreeCards extends Card {
	
	private List<Integer> cardValuesAsInteger;
	
	public RollThreeCards(String name, String description, int firstValue, int secondValue, int thirdValue) {
		super(name, description);
		// TODO Auto-generated constructor stub
		cardValuesAsInteger = new ArrayList<Integer>();
		cardValuesAsInteger.add(firstValue);
		cardValuesAsInteger.add(secondValue);
		cardValuesAsInteger.add(thirdValue);
		Collections.sort(cardValuesAsInteger);
	}

	public List<Integer> getCardValues(){
		return cardValuesAsInteger;
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		
	}
	

}
