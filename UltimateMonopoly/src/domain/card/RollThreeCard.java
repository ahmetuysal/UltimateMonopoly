package domain.card;

import java.util.Arrays;

import domain.Player;

public class RollThreeCard extends Card {

	private int[] cardValuesAsInteger;

	public RollThreeCard(String name, String description, int firstValue, int secondValue, int thirdValue) {
		super(name, description);
		// TODO Auto-generated constructor stub
		cardValuesAsInteger = new int[3];
		cardValuesAsInteger[0] = firstValue;
		cardValuesAsInteger[1] = secondValue;
		cardValuesAsInteger[2] = thirdValue;
		Arrays.sort(cardValuesAsInteger);
	}

	public int[] getCardValues() {
		return cardValuesAsInteger;
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub

	}

}
