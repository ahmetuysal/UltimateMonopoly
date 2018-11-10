package domain.card;

import domain.Player;

public class GoToJail extends ChanceCard{

	protected GoToJail(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		player.goToJail();
	}

}
