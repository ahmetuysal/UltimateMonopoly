package domain.square;

import domain.Player;

public class Go extends Square implements Passable {

	public Go() {
		super("Go", "Collect 200 as you pass");
	}

	@Override
	public void passBy(Player player) {
		player.increaseMoney(200);
	}

	@Override
	public void landOn(Player player) {
		player.increaseMoney(200);
	}

}
