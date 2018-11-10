package domain.card;

public class ChanceCardFactory {
	
	private static ChanceCardFactory instance;
	
	private ChanceCardFactory() {}
	
	public static synchronized ChanceCardFactory getInstance() {
		if(instance == null)
			instance = new ChanceCardFactory();
		return instance;
	}
	
	public static ChanceCard getCard(String name, String description) {
		if(name.equals(null)) return null;
		
		if("Get Out of Jail Free!".equals(name)) {
			return new GetOutofTheJailCard(name, description);
		}else if("Advance to the Pay Corner".equals(name)) {
			return new AdvanceToThePayCorner(name, description);
		}else if("Go To Jail!".equals(name)) {
			return new GoToJail(name, description);
		}else if("Advance to the Nearest Railroad".equals(name)) {
			return new AdvanceToTheNearestRailroad(name, description);
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
		return null;
	}
}
