package domain.card;

import domain.GameController;
import domain.Player;

public class HurricaneMakesLandfall extends Card {

	protected HurricaneMakesLandfall(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		GameController.getInstance().promptHurricaneSquares();
	}
	

}
