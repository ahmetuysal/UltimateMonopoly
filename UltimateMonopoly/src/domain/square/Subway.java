package domain.square;

import domain.Player;

public class Subway extends Square {

	public Subway() {
		super("Subway", "When you land on the SUBWAY space you may travel to any space on any board on"
				+ " your next turn. If the property is unowned, you may purchase it from the bank. Since traveling via"
				+ " Subway is a direct route, you do not collect any salary for passing a PAY CORNER (if you choose to"
				+ " move directly to a PAY CORNER from the SUBWAY, you collect the largest amount of salary from that"
				+ " space, regardless of what you rolled previously.) If you have additional moves (MR. MONOPOLY or"
				+ " BUS ICON bonus moves, DOUBLES, or TRAVEL VOUCHERS), you may move immediately to any space"
				+ " on the board follow the directions for that space, and continue your turn from there, going clockwise"
				+ " (no matter what direction you were going previously). ");

	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
	}

}
