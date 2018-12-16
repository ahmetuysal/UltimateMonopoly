package domain.square;

import domain.Player;

public class StockExchange extends Square {

	public StockExchange() {
		super("Stock Exchange", "dsp");
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
	}

}
