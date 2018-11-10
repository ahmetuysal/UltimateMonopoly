package domain.card;

import java.util.List;

import domain.GameController;
import domain.Player;

public class SocialMediaFail extends ChanceCard{

	protected SocialMediaFail(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		List<Player> playerList = GameController.getInstance().getPlayerList();
		for(int i=0;i<playerList.size();i++) {
			Player otherPlayer = playerList.get(i);
			player.decreaseMoney((playerList.size()-1)*50);
			if(!player.equals(otherPlayer))
				otherPlayer.increaseMoney(50);
		}
	}

}
