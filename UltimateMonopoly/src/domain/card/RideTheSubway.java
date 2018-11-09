package domain.card;

import domain.GameController;
import domain.Player;

public class RideTheSubway extends ChanceCard{

	protected RideTheSubway(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String squareName) {
		// TODO Auto-generated method stub
		p.getToken().setLocation(GameController.getInstance().getBoard().getSquareLocationFromName("Subway"));
	}

}
