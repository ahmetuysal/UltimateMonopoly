package domain.card;

public class CommunityChestCardFactory {

private static CommunityChestCardFactory instance;
	
	private CommunityChestCardFactory() {}
	
	public static synchronized CommunityChestCardFactory getInstance() {
		if(instance == null)
			instance = new CommunityChestCardFactory();
		return instance;
	}
	
	public static CommunityChestCard getCard(String name, String description) {
		if(name.equals(null)) return null;
		
		if("Happy Birthday!".equals(name)) {
			return new HappyBirthday(name, description);
		}else if("Game Night!".equals(name)) {
			return new GameNight(name, description);
		}else if("A Moving Experience".equals(name)) {
			return new AMovingExperience(name, description);
		}else if("HOUSE CONDEMNED".equals(name)) {
			return new HouseCondemned(name, description);
		}else if("Elected District Attorney".equals(name)) {
			return new ElectedDistrictAttorney(name, description);
		}else if("Deal Buster".equals(name)) {
			return new DealBuster(name, description);
		}else if("Be Kind, Rewind".equals(name)) {
			return new BeKindRewind(name, description);
		}else if("Pay Hospital Bills".equals(name)) {
			return new PayHospitalBills(name, description);
		}else if("Tornado Hits!".equals(name)) {
			return new TornadoHits(name, description);
		}else if("Share in their Good Fortune".equals(name)) {
			return new ShareInTheirGoodFortune(name, description);
		}else if("The Insider's Edge".equals(name)) {
			return new TheInsidersEdge(name, description);
		}
		
		return null;
		
	}
	
}
