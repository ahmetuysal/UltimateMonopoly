package domain.square;

import domain.Player;

public class RailRoad extends OwnableSquare implements Passable {

	public RailRoad(String name, String description, int price) {
		super(name, description, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void passBy(Player player) {
		// Decrease Players layer if even roll
		
	}

}
