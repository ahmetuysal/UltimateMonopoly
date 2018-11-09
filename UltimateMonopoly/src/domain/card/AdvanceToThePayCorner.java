package domain.card;

import domain.GameController;
import domain.Player;
import domain.square.Location;

public class AdvanceToThePayCorner extends ChanceCard {

	protected AdvanceToThePayCorner(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		Location location = p.getToken().getLocation();
		// TODO implement this
	}

}
