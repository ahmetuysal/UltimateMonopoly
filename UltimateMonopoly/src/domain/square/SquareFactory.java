package domain.square;

import domain.Player;
import domain.square.TitleDeedSquare;
public class SquareFactory {
	
	private static SquareFactory instance;
	public static synchronized SquareFactory getInstance() {
		if(instance == null)
			instance = new SquareFactory();
		return instance;
	}
	
	private SquareFactory() {
		
	}
	
	public static Square getSquare(String type, String name, String description) {
		if(name.equals(null)) return null;
		
		if(type == "Title Deed") {	
			if("Virginia Avenue".equals(name)) {
				return new TitleDeedSquare("Virginia Avenue", "dsc", 160, 12, 60, 80, 500, 700, 900, 1400,TitleDeedSquareColor.PINK);
			}else if("Meditteranian Avenue".equals(name)) {
				return new TitleDeedSquare("Meditteranian Avenue", "dsc", 60, 2, 10, 30, 90, 160, 250, 750,TitleDeedSquareColor.MAROON);
			}else if("Baltic Avenue".equals(name)) {
				return new TitleDeedSquare("Baltic Avenue", "dsc", 60, 4, 20, 60, 180, 320, 450, 900,TitleDeedSquareColor.MAROON);
			}else if("Oriental Avenue".equals(name)) {
				return new TitleDeedSquare("Oriental Avenue", description);
			}else if("Make General Repairs to all your properties.".equals(name)) {
				return new MakeGeneralRepairsToAllYourProperties(name, description);
			}else if("Advance to Saint Charles Place".equals(name)) {
				return new AdvanceToSaintCharlesPlace(name, description);
			}else if("Holiday Bonus!".equals(name)) {
				return new HolidayBonus(name, description);
			}else if("Just Say 'NO'!".equals(name)) {
				return new JustSayNo(name, description);
			}else if("Buyer's Market!".equals(name)) {
				return new BuyersMarket(name, description);
			}else if("See You In Court!".equals(name)) {
				return new SeeYouInCourt(name, description);
			}else if("Foreclosed Property Sale!".equals(name)) {
				return new ForeClosedPropertySale(name, description);
			}else if("Get Rollin'".equals(name)) {
				return new GetRollin(name, description);
			}else if("Forward Thinker".equals(name)) {
				return new ForwardThinker(name, description);
			}else if("Hurricane makes landfall!".equals(name)) {
				return new HurricaneMakesLandfall(name, description);
			}else if("Property Taxes".equals(name)) {
				return new PropertyTaxes(name, description);
			}else if("Ride the Subway".equals(name)) {
				return new RideTheSubway(name, description);
			}else if("Social Media Fail!".equals(name)) {
				return new SocialMediaFail(name, description);
			}else if("Pay Back!".equals(name)) {
				return new PayBack(name, description);
			}else if("MARDI GRAS!".equals(name)) {
				return new MardiGras(name, description);
			}else if("GPS is not working".equals(name)) {
				return new GPSIsNotWorking(name, description);
			}else if("Zero Dollars Down!".equals(name)) {
				return new ZeroDollarsDown(name, description);
			}else if("Changing Lanes".equals(name)) {
				return new ChangingLanesBelow(name, description);
			}else if("Changing Lanes".equals(name)) {
				return new ChangingLanesAbove(name, description);
			}
		}else if(type == "Community Chest Card") {
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
		}
		return null;
	}
	
	
	
}
