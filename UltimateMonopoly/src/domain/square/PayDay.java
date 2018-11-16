package domain.square;

import domain.GameController;
import domain.Player;

public class PayDay extends Square implements Passable{

	public PayDay() {
		super("PayDay", "When a player passes or lands on PAY DAY they collect $300 if they rolled an odd number" + 
				" or $400 if they rolled an even number. If you move directly to PAY DAY,  (via an ACTION" + 
				" CARD or TRAVEL SPACE) you collect $400, regardless of what you rolled previously. ");
		
	}

	@Override
	public void passBy(Player player) {
		if(GameController.getInstance().getCup().isEven()) {
			player.increaseMoney(400);
		}else {
			player.increaseMoney(300);
		}
	
		
	}

	@Override
	public void landOn(Player player) {
		if(GameController.getInstance().getCup().isEven()) {
			player.increaseMoney(400);
		}else {
			player.increaseMoney(300);
		}
	}
	

}
