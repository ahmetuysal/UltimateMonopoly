package domain.square;

import domain.GameController;
import domain.Player;

public class CommunityChest extends Square{

	public CommunityChest() {
		super("Community Chest", "dsp");
	}

	@Override
	public void landOn(Player player) {
		System.out.println("ASDHADSHFHD ben merve");
		GameController.getInstance().promptDrawCommunityChestCard();
	}

}
