package domain.card;


public abstract class CommunityChestCard extends Card {

	protected CommunityChestCard(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
		
	}
	
	public static CommunityChestCard getCard(String n, String d) {
		if(n.equals(null)) return null;
		
		if("Happy Birthday!".equals(n)) {
			return new HappyBirthday(n, d);
		}else if("Game Night!".equals(n)) {
			return new GameNight(n, d);
		}else if("A Moving Experience".equals(n)) {
			return new AMovingExperience(n, d);
		}else if("HOUSE CONDEMNED".equals(n)) {
			return new HouseCondemned(n, d);
		}else if("Elected District Attorney".equals(n)) {
			return new ElectedDistrictAttorney(n, d);
		}else if("Deal Buster".equals(n)) {
			return new DealBuster(n, d);
		}else if("Be Kind, Rewind".equals(n)) {
			return new BeKindRewind(n, d);
		}else if("Pay Hospital Bills".equals(n)) {
			return new PayHospitalBills(n, d);
		}else if("Tornado Hits!".equals(n)) {
			return new TornadoHits(n, d);
		}else if("Share in their Good Fortune".equals(n)) {
			return new ShareInTheirGoodFortune(n, d);
		}else if("The Insider's Edge".equals(n)) {
			return new TheInsidersEdge(n, d);
		}
		
		return null;
		
	}
}
