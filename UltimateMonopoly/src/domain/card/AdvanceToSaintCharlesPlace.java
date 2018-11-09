package domain.card;

import domain.GameController;
import domain.Player;
import domain.square.Location;

public class AdvanceToSaintCharlesPlace extends ChanceCard {

	protected AdvanceToSaintCharlesPlace(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String squareName) {
		// TODO Auto-generated method stub
		Location loc = GameController.getInstance().getBoard().getSquareLocationFromName(squareName);
		p.getToken().setLocation(loc);
	}

}
