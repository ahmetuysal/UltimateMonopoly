package domain.square;

import domain.GameController;
import domain.Player;
import domain.die.Cup;
import domain.die.DieValue;

public class SqueezePlay extends Square {

	public SqueezePlay() {
		super("Squeeze Play", "dcp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
		GameController g = GameController.getInstance();
		Cup cup = g.getCup();
		cup.rollTwoRegularDices();
		DieValue[] newValues = cup.getFaceValues();
		int sumRolledValues = newValues[0].getValue() + newValues[1].getValue();
		if(sumRolledValues == 5 || sumRolledValues == 6 || sumRolledValues == 7 || sumRolledValues == 8 || sumRolledValues == 9) {
			for(Player p : g.getPlayerList()){
				if(g.getCurrentPlayer() != p) {
					p.decreaseMoney(50);
				}
			}
			player.increaseMoney(50);
		}
		else if(sumRolledValues == 3 || sumRolledValues == 4 || sumRolledValues == 10 || sumRolledValues == 11) {
			for(Player p : g.getPlayerList()){
				if(g.getCurrentPlayer() != p) {
					p.decreaseMoney(100);
				}
			}
			player.increaseMoney(100);
		}else if(sumRolledValues == 2 || sumRolledValues == 12) {
			for(Player p : g.getPlayerList()){
				if(g.getCurrentPlayer() != p) {
					p.decreaseMoney(200);
				}
			}
			player.increaseMoney(200);
		}
	}

}
