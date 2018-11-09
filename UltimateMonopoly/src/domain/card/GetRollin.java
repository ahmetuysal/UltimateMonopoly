package domain.card;

import domain.GameController;
import domain.Player;

public class GetRollin extends ChanceCard{

	protected GetRollin(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		// TODO Auto-generated method stub
		int loc = GameController.getInstance().getBoard().getSquareIndexFromName("Roll Three");
		p.getToken().setLocation(loc);
	}

}
