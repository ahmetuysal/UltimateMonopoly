package domain.card;

import domain.Player;

public class GetOutofTheJailCard extends ChanceCard{

	protected GetOutofTheJailCard(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void useCard(Player p, String s) {
		// TODO Auto-generated method stub
		p.setInJail(false);
	}

}
