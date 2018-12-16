package domain.square;

import domain.GameController;
import domain.Player;

public class RollThree extends Square {

	public RollThree() {
		super("Roll Three", "dsc");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		GameController.getInstance().promptDrawRollThreeCard();		
	}

}
