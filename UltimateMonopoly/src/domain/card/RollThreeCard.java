package domain.card;

import java.util.Arrays;

import domain.GameController;
import domain.Player;

public class RollThreeCard extends OwnableCard {

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
		int matched = 0;
		
		for (int i = 0 ; i < 3 ; i++) {
			if(cardValuesAsInteger[i] == Character.getNumericValue(s.charAt(i)))
				matched++;
		}
		
		if (matched == 1) {
			player.increaseMoney(50);
		}
		else if (matched == 2) {
			player.increaseMoney(200);
		}
		else if (matched == 3) {
			if (player.equals(GameController.getInstance().getCurrentPlayer()))
				player.increaseMoney(1500);
			else 
				player.increaseMoney(1000);
		}
		
		player.removeCard(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RollThreeCard [cardValuesAsInteger=" + Arrays.toString(cardValuesAsInteger) + ", owner=" + owner
				+ ", isOwned=" + isOwned + ", name=" + name + ", description=" + description + "]";
	}

}
