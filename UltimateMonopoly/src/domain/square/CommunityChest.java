package domain.square;

import domain.GameController;
import domain.Player;

public class CommunityChest extends Square{

	public CommunityChest() {
		super("Community Chest", "dsp");
	}

	@Override
	public void landOn(Player player) {
		GameController.getInstance().promptDrawCommunityChestCard();
	}

}
