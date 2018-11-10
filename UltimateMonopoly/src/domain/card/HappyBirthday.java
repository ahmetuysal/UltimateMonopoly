package domain.card;

import java.util.List;

import domain.GameController;
import domain.Player;

public class HappyBirthday extends CommunityChestCard {

	protected HappyBirthday(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player currentPlayer, String s) {
		// TODO Auto-generated method stub
		List<Player> playerList = GameController.getInstance().getPlayerList();
		for(int i=0;i<playerList.size();i++) {
			if(!playerList.get(i).equals(currentPlayer))
				playerList.get(i).decreaseMoney(10);
		}
		currentPlayer.increaseMoney((playerList.size()-1)*10);
		currentPlayer.getToken().setLocation(GameController.getInstance().getBoard().getSquareLocationFromName("Birthday Gift"));
	}

}
