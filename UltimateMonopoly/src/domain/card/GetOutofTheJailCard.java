package domain.card;

import domain.GameController;
import domain.Player;

public class GetOutofTheJailCard extends ChanceCard{

	protected GetOutofTheJailCard(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		player.getOutOfJail();
	}

}
