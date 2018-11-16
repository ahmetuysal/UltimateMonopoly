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
					TitleDeedSquareColor.MAROON);
		case "Baltic Avenue":
			return new TitleDeedSquare("Baltic Avenue", "dsc", 60, 4, 20, 60, 180, 320, 450, 900,
					TitleDeedSquareColor.MAROON);
		case "Oriental Avenue":
			return new TitleDeedSquare("Oriental Avenue", "dsc", 100, 6, 30, 90, 270, 400, 550, 1050,
					TitleDeedSquareColor.LIGHT_BLUE);
		case "Vermont Avenue":
			return new TitleDeedSquare("Vermont Avenue", "dsc", 100, 6, 30, 90, 270, 400, 550, 1050,
					TitleDeedSquareColor.LIGHT_BLUE);
		case "Conneticut Avenue":
			return new TitleDeedSquare("Oriental Avenue", "dsc", 120, 8, 40, 100, 300, 450, 600, 1100,
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
		case "Tenessee Avenue":
			return new TitleDeedSquare("Tenessee", "dsc", 180, 14, 70, 200, 550, 750, 950, 1450,
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
		case "Carolina Avenue":
			return new TitleDeedSquare("Carolina Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
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
		// Utility Squares
		case "Telephone Company":
			return new UtilitySquare("Telephone Company", "dsc", 150, UtilitySquareType.UTILITY);

		case "Transit Station":
			return new TransitStation();

		// Action Squares
		case "Community Chest":
			return new CommunityChest();
		case "Go":
			return new Go();
		case "Squeeze Play":
			return new SqueezePlay();
		case "Bonus":
			return new Bonus();
		default:
			return null;
		}

	}

}
