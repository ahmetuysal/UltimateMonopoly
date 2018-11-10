package domain.square;

import domain.Player;

public class Bonus extends ActionSquare implements Passable {

	public Bonus(String name, String description) {
		super("Bonus", "When a player passes BONUS they collect $250. When a player lands on BONUS they collect"
				+ " $300.");
		
	}

	@Override
	public void passBy(Player player) {
		player.increaseMoney(250);
	}

	@Override
	public void landOn(Player player) {
		player.increaseMoney(300);
		
	}

	
}
