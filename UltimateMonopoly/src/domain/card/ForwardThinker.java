package domain.card;

import domain.Player;

public class ForwardThinker extends ChanceCard{

	protected ForwardThinker(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		// TODO Auto-generated method stub
		p.getToken().setLocation(p.getToken().getLocation()+3);
	}

}
