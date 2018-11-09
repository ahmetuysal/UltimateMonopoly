package domain.card;


public abstract class ChanceCard extends Card {
	
	protected ChanceCard(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}
	
	public static ChanceCard getCard(String n, String d) {
		if(n.equals(null)) return null;
		
		if("Get Out of Jail Free!".equals(n)) {
			return new GetOutofTheJailCard(n, d);
		}else if("Advance to the Pay Corner".equals(n)) {
			return new AdvanceToThePayCorner(n, d);
		}else if("Go To Jail!".equals(n)) {
			return new GoToJail(n, d);
		}else if("Advance to the Nearest Railroad".equals(n)) {
			return new AdvanceToTheNearestRailroad(n, d);
		}else if("Make General Repairs to all your properties.".equals(n)) {
			return new MakeGeneralRepairsToAllYourProperties(n, d);
		}else if("Advance to Saint Charles Place".equals(n)) {
			return new AdvanceToSaintCharlesPlace(n, d);
		}else if("Holiday Bonus!".equals(n)) {
			return new HolidayBonus(n, d);
		}else if("Just Say 'NO'!".equals(n)) {
			return new JustSayNo(n, d);
		}else if("Buyer's Market!".equals(n)) {
			return new BuyersMarket(n, d);
		}else if("See You In Court!".equals(n)) {
			return new SeeYouInCourt(n, d);
		}else if("Foreclosed Property Sale!".equals(n)) {
			return new ForeClosedPropertySale(n, d);
		}else if("Get Rollin'".equals(n)) {
			return new GetRollin(n, d);
		}else if("Forward Thinker".equals(n)) {
			return new ForwardThinker(n, d);
		}else if("Hurricane makes landfall!".equals(n)) {
			return new HurricaneMakesLandfall(n, d);
		}else if("Property Taxes".equals(n)) {
			return new PropertyTaxes(n, d);
		}else if("Ride the Subway".equals(n)) {
			return new RideTheSubway(n, d);
		}else if("Social Media Fail!".equals(n)) {
			return new SocialMediaFail(n, d);
		}else if("Pay Back!".equals(n)) {
			return new PayBack(n, d);
		}else if("MARDI GRAS!".equals(n)) {
			return new MardiGras(n, d);
		}else if("GPS is not working".equals(n)) {
			return new GPSIsNotWorking(n, d);
		}else if("Zero Dollars Down!".equals(n)) {
			return new ZeroDollarsDown(n, d);
		}else if("Changing Lanes".equals(n)) {
			return new ChangingLanes(n, d);
		}else if("Changing Lanes".equals(n)) {
			return new ChangingLanes(n, d);
		}
		return null;
	}
}
