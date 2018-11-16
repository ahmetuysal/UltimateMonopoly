package domain.square;

import domain.square.TitleDeedSquare;

public class SquareFactory {

	private static SquareFactory instance;

	public static synchronized SquareFactory getInstance() {
		if (instance == null)
			instance = new SquareFactory();
		return instance;
	}

	private SquareFactory() {

	}

	public static Square getSquare(String name) {
		if (name.equals(null))
			return null;

		switch (name) {
		// TitleDeedSquares
		case "Meditteranian Avenue":
			return new TitleDeedSquare("Meditteranian Avenue", "dsc", 60, 2, 10, 30, 90, 160, 250, 750,
					TitleDeedSquareColor.PURPLE);
		case "Baltic Avenue":
			return new TitleDeedSquare("Baltic Avenue", "dsc", 60, 4, 20, 60, 180, 320, 450, 900,
					TitleDeedSquareColor.PURPLE);
		case "Oriental Avenue":
			return new TitleDeedSquare("Oriental Avenue", "dsc", 100, 6, 30, 90, 270, 400, 550, 1050,
					TitleDeedSquareColor.LIGHT_BLUE);
		case "Vermont Avenue":
			return new TitleDeedSquare("Vermont Avenue", "dsc", 100, 6, 30, 90, 270, 400, 550, 1050,
					TitleDeedSquareColor.LIGHT_BLUE);
		case "Connecticut Avenue":
			return new TitleDeedSquare("Connecticut Avenue", "dsc", 120, 8, 40, 100, 300, 450, 600, 1100,
					TitleDeedSquareColor.LIGHT_BLUE);
		case "St.Charles Place":
			return new TitleDeedSquare("St.Charles Place", "dsc", 140, 10, 50, 150, 450, 625, 750, 1250,
					TitleDeedSquareColor.PINK);
		case "States Avenue":
			return new TitleDeedSquare("States Avenue", "dsc", 140, 10, 50, 150, 450, 625, 750, 1250,
					TitleDeedSquareColor.PINK);
		case "Virginia Avenue":
			return new TitleDeedSquare("Virginia Avenue", "dsc", 160, 12, 60, 180, 500, 700, 900, 1400,
					TitleDeedSquareColor.PINK);
		case "St.James Place":
			return new TitleDeedSquare("St.James Place", "dsc", 180, 14, 70, 200, 550, 750, 950, 1450,
					TitleDeedSquareColor.ORANGE);
		case "Tennessee Avenue":
			return new TitleDeedSquare("Tennessee Avenue", "dsc", 180, 14, 70, 200, 550, 750, 950, 1450,
					TitleDeedSquareColor.ORANGE);
		case "New York Avenue":
			return new TitleDeedSquare("New York Avenue", "dsc", 200, 16, 80, 220, 600, 800, 1000, 1500,
					TitleDeedSquareColor.ORANGE);
		case "Kentucky Avenue":
			return new TitleDeedSquare("Kentucky Avenue", "dsc", 220, 18, 90, 250, 700, 875, 1050, 2050,
					TitleDeedSquareColor.RED);
		case "Indiana Avenue":
			return new TitleDeedSquare("Indiana Avenue", "dsc", 220, 18, 90, 250, 700, 875, 1050, 2050,
					TitleDeedSquareColor.RED);
		case "Illinois Avenue":
			return new TitleDeedSquare("Illinois Avenue", "dsc", 240, 20, 100, 300, 750, 925, 1100, 2100,
					TitleDeedSquareColor.RED);
		case "Atlantic Avenue":
			return new TitleDeedSquare("Atlantic Avenue", "dsc", 260, 22, 110, 330, 800, 975, 1150, 2150,
					TitleDeedSquareColor.YELLOW);
		case "Ventnor Avenue":
			return new TitleDeedSquare("Ventnor Avenue", "dsc", 260, 22, 110, 330, 800, 975, 1150, 2150,
					TitleDeedSquareColor.YELLOW);
		case "Marvin Gardens":
			return new TitleDeedSquare("Marvin Gardens", "dsc", 280, 24, 120, 350, 850, 1025, 1200, 2200,
					TitleDeedSquareColor.YELLOW);
		case "Pacific Avenue":
			return new TitleDeedSquare("Pacific Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
					TitleDeedSquareColor.GREEN);
		case "North Carolina Avenue":
			return new TitleDeedSquare("North Carolina Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
					TitleDeedSquareColor.GREEN);
		case "Pennsylvania Avenue":
			return new TitleDeedSquare("Pennsylvania Avenue", "dsc", 320, 28, 150, 450, 1000, 1200, 1400, 2400,
					TitleDeedSquareColor.GREEN);
		case "Park Place":
			return new TitleDeedSquare("Park Place", "dsc", 350, 35, 175, 500, 1100, 1300, 1500, 2500,
					TitleDeedSquareColor.DARK_BLUE);
		case "Boardwalk":
			return new TitleDeedSquare("Boardwalk", "dsc", 400, 50, 200, 600, 1400, 1700, 2000, 3000,
					TitleDeedSquareColor.DARK_BLUE);
		case "Biscayne Avenue":
			return new TitleDeedSquare("Biscayne Avenue", "dsc", 150, 11, 55, 160, 475, 650, 800, 1300,
					TitleDeedSquareColor.BROWN);
		case "Miami Avenue":
			return new TitleDeedSquare("Miami Avenue", "dsc", 130, 9, 45, 120, 350, 500, 700, 1200,
					TitleDeedSquareColor.BROWN);
		case "Florida Avenue":
			return new TitleDeedSquare("Florida Avenue", "dsc", 130, 9, 45, 120, 350, 500, 700, 1200,
					TitleDeedSquareColor.BROWN);
		case "Lombard Street":
			return new TitleDeedSquare("Lombard Street", "dsc", 210, 17, 85, 240, 475, 670, 1025, 1525,
					TitleDeedSquareColor.WHITE);
		case "The Embarcadero":
			return new TitleDeedSquare("The Embarcadero", "dsc", 210, 17, 85, 240, 475, 670, 1025, 1525,
					TitleDeedSquareColor.WHITE);
		case "Fisherman's Wharf":
			return new TitleDeedSquare("Fisherman's Wharf", "dsc", 250, 21, 105, 320, 780, 950, 1125, 1625,
					TitleDeedSquareColor.WHITE);
		case "Beacon Street":
			return new TitleDeedSquare("Beacon Street", "dsc", 330, 30, 160, 470, 1050, 1250, 1500, 2500,
					TitleDeedSquareColor.BLACK);
		case "Boylston Street":
			return new TitleDeedSquare("Boylston Street", "dsc", 330, 30, 160, 470, 1050, 1250, 1500, 2500,
					TitleDeedSquareColor.BLACK);
		case "Newbury Street":
			return new TitleDeedSquare("Newbury Street", "dsc", 380, 40, 185, 550, 1200, 1500, 1700, 2700,
					TitleDeedSquareColor.BLACK);
		case "Fifth Avenue":
			return new TitleDeedSquare("Fifth Avenue", "dsc", 430, 60, 220, 650, 1500, 1800, 2100, 3600,
					TitleDeedSquareColor.GRAY);
		case "Madison Avenue":
			return new TitleDeedSquare("Madison Avenue", "dsc", 430, 60, 220, 650, 1500, 1800, 2100, 3600,
					TitleDeedSquareColor.GRAY);
		case "Wall Street":
			return new TitleDeedSquare("Wall Street", "dsc", 500, 80, 300, 800, 1800, 2200, 2700, 4200,
					TitleDeedSquareColor.GRAY);
		case "Lake Street":
			return new TitleDeedSquare("Lake Street", "dsc", 30, 1, 5, 15, 45, 80, 125, 625,
					TitleDeedSquareColor.LIGHT_PINK);
		case "Nicollet Avenue":
			return new TitleDeedSquare("Nicollet Avenue", "dsc", 30, 1, 5, 15, 45, 80, 125, 625,
					TitleDeedSquareColor.LIGHT_PINK);
		case "Hennepin Avenue":
			return new TitleDeedSquare("Hennepin Avenue", "dsc", 60, 3, 15, 45, 120, 240, 350, 850,
					TitleDeedSquareColor.LIGHT_PINK);
		case "Esplanade Avenue":
			return new TitleDeedSquare("Esplanade Avenue", "dsc", 90, 5, 25, 80, 225, 360, 600, 1000,
					TitleDeedSquareColor.LIGHT_GREEN);
		case "Canal Street":
			return new TitleDeedSquare("Canal Street", "dsc", 90, 5, 25, 80, 225, 360, 600, 1000,
					TitleDeedSquareColor.LIGHT_GREEN);
		case "Magazine Street":
			return new TitleDeedSquare("Magazine Street", "dsc", 120, 8, 40, 100, 300, 450, 600, 1100,
					TitleDeedSquareColor.LIGHT_GREEN);
		case "Bourbon Street":
			return new TitleDeedSquare("Bourbon Street", "dsc", 120, 8, 40, 100, 300, 450, 600, 1100,
					TitleDeedSquareColor.LIGHT_GREEN);
		case "Katy Freeway":
			return new TitleDeedSquare("Katy Freeway", "dsc", 150, 11, 55, 160, 475, 650, 800, 1300,
					TitleDeedSquareColor.LIGHT_YELLOW);
		case "Westheimer Road":
			return new TitleDeedSquare("Westheimer Road", "dsc", 150, 11, 55, 160, 475, 650, 800, 1300,
					TitleDeedSquareColor.LIGHT_YELLOW);
		case "Kirby Drive":
			return new TitleDeedSquare("Kirby Drive", "dsc", 180, 14, 70, 200, 550, 750, 950, 1450,
					TitleDeedSquareColor.LIGHT_YELLOW);
		case "Cullen Boulevard":
			return new TitleDeedSquare("Cullen Boulevard", "dsc", 180, 14, 70, 200, 550, 750, 950, 1450,
					TitleDeedSquareColor.LIGHT_YELLOW);
		case "Dekalb Avenue":
			return new TitleDeedSquare("Dekalb Avenue", "dsc", 210, 17, 85, 240, 670, 840, 1025, 1525,
					TitleDeedSquareColor.DARK_CYAN);
		case "Andrew Young Intl Boulevard":
			return new TitleDeedSquare("Andrew Young Intl Boulevard", "dsc", 210, 17, 85, 240, 670, 840, 1025, 1525,
					TitleDeedSquareColor.DARK_CYAN);
		case "Decatur Street":
			return new TitleDeedSquare("Decatur Street", "dsc", 240, 20, 100, 300, 750, 925, 1100, 1600,
					TitleDeedSquareColor.DARK_CYAN);
		case "Peachtree Street":
			return new TitleDeedSquare("Peachtree Street", "dsc", 240, 20, 100, 300, 750, 925, 1100, 1600,
					TitleDeedSquareColor.DARK_CYAN);
		case "Randolph Street":
			return new TitleDeedSquare("Peachtree Street", "dsc", 270, 23, 115, 345, 825, 1010, 1180, 2180,
					TitleDeedSquareColor.MAROON);
		case "Lake Shore Drive":
			return new TitleDeedSquare("Lake Shore Drive", "dsc", 270, 23, 115, 345, 825, 1010, 1180, 2180,
					TitleDeedSquareColor.MAROON);
		case "Wacker Drive":
			return new TitleDeedSquare("Wacker Drive", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
					TitleDeedSquareColor.MAROON);
		case "Michigan Avenue":
			return new TitleDeedSquare("Michigan Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
					TitleDeedSquareColor.MAROON);
		case "South Temple":
			return new TitleDeedSquare("South Temple", "dsc", 330, 32, 160, 470, 1050, 1250, 1500, 2500,
					TitleDeedSquareColor.DARK_GOLD);
		case "West Temple":
			return new TitleDeedSquare("West Temple", "dsc", 330, 32, 160, 470, 1050, 1250, 1500, 2500,
					TitleDeedSquareColor.DARK_GOLD);
		case "North Temple":
			return new TitleDeedSquare("North Temple", "dsc", 360, 38, 170, 520, 1125, 1425, 1775, 2650,
					TitleDeedSquareColor.DARK_GOLD);
		case "Temple Square":
			return new TitleDeedSquare("Temple Square", "dsc", 360, 38, 170, 520, 1125, 1425, 1775, 2650,
					TitleDeedSquareColor.DARK_GOLD);
		case "South Street":
			return new TitleDeedSquare("South Street", "dsc", 390, 45, 210, 575, 1300, 1600, 1800, 3300,
					TitleDeedSquareColor.SALMON);
		case "Broad Street":
			return new TitleDeedSquare("Broad Street", "dsc", 390, 45, 210, 575, 1300, 1600, 1800, 3300,
					TitleDeedSquareColor.SALMON);
		case "Walnut Street":
			return new TitleDeedSquare("Walnut Street", "dsc", 420, 55, 225, 630, 1450, 1750, 2050, 3550,
					TitleDeedSquareColor.SALMON);
		case "Market Street":
			return new TitleDeedSquare("Market Street", "dsc", 420, 55, 225, 630, 1450, 1750, 2050, 3550,
					TitleDeedSquareColor.SALMON);
		case "Mulholland Drive":
			return new TitleDeedSquare("Mulholland Drive", "dsc", 450, 70, 350, 750, 1600, 1850, 2100, 3600,
					TitleDeedSquareColor.CLARET);
		case "Ventura Boulevard":
			return new TitleDeedSquare("Ventura Boulevard", "dsc", 480, 80, 400, 825, 1800, 2175, 2550, 4050,
					TitleDeedSquareColor.CLARET);
		case "Rodeo Drive":
			return new TitleDeedSquare("Rodeo Drive", "dsc", 510, 90, 450, 900, 2000, 2500, 3000, 4500,
					TitleDeedSquareColor.CLARET);

		// Utility Squares
		case "Telephone Company":
			return new UtilitySquare("Telephone Company", "dsc", 150, UtilitySquareType.UTILITY);
		case "Gas Company":
			return new UtilitySquare("Gas Company", "dsc", 150, UtilitySquareType.UTILITY);
		case "Electric Company":
			return new UtilitySquare("Electric Company", "dsc", 150, UtilitySquareType.UTILITY);
		case "Water Works":
			return new UtilitySquare("Water Works", "dsc", 150, UtilitySquareType.UTILITY);
		case "Cable Company":
			return new UtilitySquare("Cable Company", "dsc", 150, UtilitySquareType.UTILITY);
		case "Internet Service Provider":
			return new UtilitySquare("Internet Service Provider", "dsc", 150, UtilitySquareType.UTILITY);
		case "Trash Collector":
			return new UtilitySquare("Trash Collector", "dsc", 150, UtilitySquareType.UTILITY);
		case "Sewage System":
			return new UtilitySquare("Sewage System", "dsc", 150, UtilitySquareType.UTILITY);

		case "Checker Cab Co.":
			return new UtilitySquare("Checker Cab Co.", "dsc", 300, UtilitySquareType.CAB_COMPANY);
		case "Black & White Cab Co.":
			return new UtilitySquare("Black & White Cab Co.", "dsc", 300, UtilitySquareType.CAB_COMPANY);
		case "Yellow Cab Co.":
			return new UtilitySquare("Yellow Cab Co.", "dsc", 300, UtilitySquareType.CAB_COMPANY);
		case "Ute Cab Co.":
			return new UtilitySquare("Ute Cab Co.", "dsc", 300, UtilitySquareType.CAB_COMPANY);
			
		// Railroads
		case "Transit Station":
			return new TransitStation();
		case "Pennsylvania Railroad":
			return new RailRoad("Pennsylvania Railroad", "dsc", 200);
		case "Short Line":
			return new RailRoad("Short Line", "dsc", 200);
		case "Reading Railroad":
			return new RailRoad("Reading Railroad", "dsc", 200);
		case "B. & O. Railroad":
			return new RailRoad("B. & O. Railroad", "dsc", 200);
			
		// Action Squares
		case "Community Chest":
			return new CommunityChest();
		case "Go":
			return new Go();
		case "Squeeze Play":
			return new SqueezePlay();
		case "Bonus":
			return new Bonus();
		case "Stock Exchange":
			return new StockExchange();
		case "Tax Refund":
			return new TaxRefund();
		case "Chance":
			return new Chance();
		case "Holland Tunnel":
			return new HollandTunnel();
		case "Reverse Direction":
			return new ReverseDirection();
		case "Income Tax":
			return new IncomeTax();
		case "Jail":
			return new Jail();
		case "Free Parking":
			return new FreeParking();
		case "Roll Three":
			return new RollThree();
		case "Luxury Tax":
			return new LuxuryTax();
		case "Subway":
			return new Subway();
		case "Bus Ticket":
			return new BusTicket();
		case "Auction":
			return new Auction();
		case "Pay Day":
			return new PayDay();
		case "Go To Jail":
			return new GoToJail();
		case "Birthday Gift":
			return new BirthdayGift();
		default:
			return null;
		}

	}

}
