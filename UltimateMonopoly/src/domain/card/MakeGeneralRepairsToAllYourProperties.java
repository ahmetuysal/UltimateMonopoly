package domain.card;

import domain.Player;
import domain.square.OwnableSquare;
import domain.square.TitleDeedSquare;
import domain.square.UtilitySquare;

public class MakeGeneralRepairsToAllYourProperties extends ChanceCard{

	protected MakeGeneralRepairsToAllYourProperties(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		int totalMoney = 0;
		for(OwnableSquare ownable : player.getProperties()) {
			//TODO: add money calculation for cab stand and transit stations
			if(ownable instanceof TitleDeedSquare) {
				int numHouse = ((TitleDeedSquare) ownable).getNumHouses();
				int numHotel =((TitleDeedSquare) ownable).getNumHotels();
				int numSkyScraper = ((TitleDeedSquare) ownable).getNumSkyscrapers();
				totalMoney += 25*numHouse + 100*numHotel+100*numSkyScraper;
			}else if(ownable instanceof UtilitySquare) {
				//if(((UtilitySquare) ownable).getType())) {
					
				//}
			}
		}
		//TODO: decrease money from player!
	}

}
