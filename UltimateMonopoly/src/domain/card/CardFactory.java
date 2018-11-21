package domain.card;

public class CardFactory {

	private static CardFactory instance;

	private CardFactory() {
		
	}
	
	public static synchronized CardFactory getInstance() {
		if(instance == null)
			instance = new CardFactory();
		return instance;
	}
	
	public static Card getCard(String name) {
		if(name == null) 
			return null;
		
			if("Get Out of Jail Free!".equals(name)) {
				return new GetOutofTheJailCard(name, "");
			}else if("Advance to the Pay Corner".equals(name)) {
				return new AdvanceToThePayCorner(name, "");
			}else if("Go To Jail!".equals(name)) {
				return new GoToJail(name, "");
			}else if("Advance to the Nearest Railroad".equals(name)) {
				return new AdvanceToTheNearestRailroad(name, "");
			}else if("Make General Repairs to all your properties.".equals(name)) {
				return new MakeGeneralRepairsToAllYourProperties(name, "");
			}else if("Advance to the Saint Charles Place".equals(name)) {
				return new AdvanceToSaintCharlesPlace(name, "");
			}else if("Holiday Bonus!".equals(name)) {
				return new HolidayBonus(name, "");
			}else if("Buyer's Market!".equals(name)) {
				return new BuyersMarket(name, "");
			}else if("See You In Court!".equals(name)) {
				return new SeeYouInCourt(name, "");
			}else if("Foreclosed Property Sale!".equals(name)) {
				return new ForeClosedPropertySale(name, "");
			}else if("Get Rollin'".equals(name)) {
				return new GetRollin(name, "");
			}else if("Forward Thinker".equals(name)) {
				return new ForwardThinker(name, "");
			}else if("Hurricane makes landfall!".equals(name)) {
				return new HurricaneMakesLandfall(name, "");
			}else if("Property Taxes".equals(name)) {
				return new PropertyTaxes(name, "");
			}else if("Ride the Subway".equals(name)) {
				return new RideTheSubway(name, "");
			}else if("Social Media Fail!".equals(name)) {
				return new SocialMediaFail(name, "");
			}else if("Pay Back!".equals(name)) {
				return new PayBack(name, "");
			}else if("MARDI GRAS!".equals(name)) {
				return new MardiGras(name, "");
			}else if("GPS is not working".equals(name)) {
				return new GPSIsNotWorking(name, "");
			}else if("Zero Dollars Down!".equals(name)) {
				return new ZeroDollarsDown(name, "");
			}else if("Changing Lanes Below".equals(name)) {
				return new ChangingLanesBelow(name, "");
			}else if("Changing Lanes Above".equals(name)) {
				return new ChangingLanesAbove(name, "");
			}
			else if("Happy Birthday!".equals(name)) {
				return new HappyBirthday(name, "");
			}else if("Game Night!".equals(name)) {
				return new GameNight(name, "");
			}else if("A Moving Experience".equals(name)) {
				return new AMovingExperience(name, "");
			}else if("HOUSE CONDEMNED".equals(name)) {
				return new HouseCondemned(name, "");
			}else if("Be Kind, Rewind".equals(name)) {
				return new BeKindRewind(name, "");
			}else if("Pay Hospital Bills".equals(name)) {
				return new PayHospitalBills(name, "");
			}else if("Tornado Hits!".equals(name)) {
				return new TornadoHits(name, "");
			}else if("The Insider's Edge".equals(name)) {
				return new TheInsidersEdge(name, "");
			}
			else if("123".equals(name)) {
				return new RollThreeCard("123","",1,2,3);
			}
			else if("124".equals(name)) {
				return new RollThreeCard("124","",1,2,4);
			}
			else if("125".equals(name)) {
				return new RollThreeCard("125","",1,2,5);				
			}
			else if("126".equals(name)) {
				return new RollThreeCard("126","",1,2,6);
			}
			else if("134".equals(name)) {
				return new RollThreeCard("134","",1,3,4);
			}
			else if("135".equals(name)) {
				return new RollThreeCard("135","",1,3,5);
			}
			else if("136".equals(name)) {
				return new RollThreeCard("136","",1,3,6);
			}
			else if("145".equals(name)) {
				return new RollThreeCard("145","",1,4,5);
			}
			else if("146".equals(name)) {
				return new RollThreeCard("146","",1,4,6);
			}
			else if("156".equals(name)) {
				return new RollThreeCard("156","",1,5,6);
			}
			else if("234".equals(name)) {
				return new RollThreeCard("234","",2,3,4);
			}
			else if("245".equals(name)) {
				return new RollThreeCard("245","",2,4,5);
			}
			else if("246".equals(name)) {
				return new RollThreeCard("246","",2,4,6);
			}
			else if("256".equals(name)) {
				return new RollThreeCard("256","",2,5,6);
			}
			else if("345".equals(name)) {
				return new RollThreeCard("345","",3,4,5);
			}
			else if("346".equals(name)) {
				return new RollThreeCard("346","",3,4,6);
			}
			else if("356".equals(name)) {
				return new RollThreeCard("356","",3,5,6);
			}
			else if("456".equals(name)) {
				return new RollThreeCard("456","",4,5,6);
			}
			else {
				return null;
			}
	}
}
