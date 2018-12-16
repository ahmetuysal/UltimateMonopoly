package domain.square;

import domain.GameController;
import domain.Player;

public class CommunityChest extends Square{

	public CommunityChest() {
		super("Community Chest", "dsp");
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		GameController.getInstance().promptDrawCommunityChestCard();
	}

}
