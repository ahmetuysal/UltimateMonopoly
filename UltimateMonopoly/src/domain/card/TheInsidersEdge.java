package domain.card;

import domain.Player;

public class TheInsidersEdge extends CommunityChestCard {

	protected TheInsidersEdge(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		if(player.getToken().getLocation().getLayer()==0)
			player.increaseMoney(250);
		else if(player.getToken().getLocation().getLayer()==2) {
			if(player.decreaseMoney(50));
			//TODO: add 50 dollars to pool!
		}
			
	}

}
