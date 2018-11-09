package domain.card;

import java.util.List;

import domain.GameController;
import domain.Player;

public class SocialMediaFail extends ChanceCard{

	protected SocialMediaFail(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		// TODO Auto-generated method stub
		List<Player> playerList = GameController.getInstance().getPlayerList();
		for(int i=0;i<playerList.size();i++) {
			Player player = playerList.get(i);
			p.decreaseMoney((playerList.size()-1)*50);
			if(!p.equals(player))
				player.increaseMoney(50);
		}
	}

}
