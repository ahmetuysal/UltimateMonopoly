package domain.square;

import domain.GameController;
import domain.Player;

public class Chance extends Square{

	public Chance() {
		super("Chance", "dsp");
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		GameController.getInstance().promptDrawChanceCard();
	}

}
