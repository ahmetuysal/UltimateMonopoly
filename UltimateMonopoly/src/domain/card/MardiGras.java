package domain.card;

import java.util.List;

import domain.GameController;
import domain.Player;
import domain.square.Location;

public class MardiGras extends ChanceCard{

	protected MardiGras(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String squareName) {
		// TODO Auto-generated method stub
		Location loc = GameController.getInstance().getBoard().getSquareLocationFromName("Canal Street");
		List<Player> playerList = GameController.getInstance().getPlayerList();
		for(int i=0;i<playerList.size();i++){
			playerList.get(i).getToken().setLocation(loc);
		}
	}

}
