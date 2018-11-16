package domain.square;

import domain.Player;

public class HollandTunnel extends Square{

	public HollandTunnel() {
		super("Holland Tunnel", " When you land on either of the" + 
				" HOLLAND TUNNEL spaces, you must immediately and directly move to the other HOLLAND TUNNEL" + 
				" space. The space is only in play if a player lands on it. Do not use the tunnel if just passing over it." + 
				" Since this is a direct route between tracks, no PAY CORNERS are passed and no salaries collected. ");
	}


	@Override
	public void landOn(Player player) {
		
		
	}

}
