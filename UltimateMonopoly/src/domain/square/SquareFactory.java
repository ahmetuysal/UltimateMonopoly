package domain.square;

import domain.Player;
import domain.square.TitleDeedSquare;
import domain.square.ActionSquare;
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
			
			if("Meditteranian Avenue".equals(name)) {
				return new TitleDeedSquare("Meditteranian Avenue", "dsc", 60, 2, 10, 30, 90, 160, 250, 750,TitleDeedSquareColor.MAROON);
			}else if("Baltic Avenue".equals(name)) {
				return new TitleDeedSquare("Baltic Avenue", "dsc", 60, 4, 20, 60, 180, 320, 450, 900,TitleDeedSquareColor.MAROON);
			}else if("Oriental Avenue".equals(name)) {
				return new TitleDeedSquare("Oriental Avenue","dsc", 100, 6, 30, 90, 270, 400, 550, 1050,TitleDeedSquareColor.LIGHT_BLUE);
			}else if("Vermont Avenue".equals(name)) {
				return new TitleDeedSquare("Vermont Avenue","dsc", 100, 6, 30, 90, 270, 400, 550, 1050,TitleDeedSquareColor.LIGHT_BLUE);
			}else if("Conneticut Avenue".equals(name)) {
				return new TitleDeedSquare("Oriental Avenue","dsc", 120, 8, 40, 100, 300, 450, 600, 1100,TitleDeedSquareColor.LIGHT_BLUE);
			}else if("St.Charles Place".equals(name)) {
				return new TitleDeedSquare("St.Charles Place", "dsc", 140, 10, 50, 150, 450, 625, 750, 1250,TitleDeedSquareColor.PINK);
			}else if("States Avenue".equals(name)) {
				return new TitleDeedSquare("States Avenue", "dsc", 140, 10, 50, 150, 450, 625, 750, 1250,TitleDeedSquareColor.PINK);
			}else if("Virginia Avenue".equals(name)) {
				return new TitleDeedSquare("Virginia Avenue", "dsc", 160, 12, 60, 180, 500, 700, 900, 1400,TitleDeedSquareColor.PINK);
			}else if("St.James Place".equals(name)) {
				return new TitleDeedSquare("St.James Place", "dsc", 180, 14, 70, 200, 550, 750, 950, 1450,TitleDeedSquareColor.ORANGE);
			}else if("Tenessee Avenue".equals(name)) {
				return new TitleDeedSquare("Tenessee", "dsc", 180, 14, 70, 200, 550, 750, 950, 1450,TitleDeedSquareColor.ORANGE);
			}else if("New York Avenue".equals(name)) {
				return new TitleDeedSquare("New York Avenue", "dsc", 200, 16, 80, 220, 600, 800, 1000, 1500,TitleDeedSquareColor.ORANGE);
			}else if("Kentucky Avenue".equals(name)) {
				return new TitleDeedSquare("Kentucky Avenue", "dsc", 220, 18, 90, 250, 700, 875, 1050, 2050,TitleDeedSquareColor.RED);
			}else if("Indiana Avenue".equals(name)) {
				return new TitleDeedSquare("Indiana Avenue", "dsc", 220, 18, 90, 250, 700, 875, 1050, 2050,TitleDeedSquareColor.RED);
			}else if("Illinois Avenue".equals(name)) {
				return new TitleDeedSquare("Illinois Avenue", "dsc", 240, 20, 100, 300, 750, 925, 1100, 2100,TitleDeedSquareColor.RED);
			}else if("Atlantic Avenue".equals(name)) {
				return new TitleDeedSquare("Atlantic Avenue", "dsc", 260, 22, 110, 330, 800, 975, 1150, 2150,TitleDeedSquareColor.YELLOW);
			}else if("Ventnor Avenue".equals(name)) {
				return new TitleDeedSquare("Ventnor Avenue", "dsc", 260, 22, 110, 330, 800, 975, 1150, 2150,TitleDeedSquareColor.YELLOW);
			}else if("Marvin Gardens".equals(name)) {
				return new TitleDeedSquare("Marvin Gardens", "dsc", 280, 24, 120, 350, 850, 1025, 1200, 2200,TitleDeedSquareColor.YELLOW);	
			}else if("Pacific Avenue".equals(name)) {
				return new TitleDeedSquare("Pacific Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,TitleDeedSquareColor.GREEN);
			}else if("Carolina Avenue".equals(name)) {
				return new TitleDeedSquare("Carolina Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,TitleDeedSquareColor.GREEN);
			}else if("Pennsylvania Avenue".equals(name)) {
				return new TitleDeedSquare("Pennsylvania Avenue", "dsc", 320, 28, 150, 450, 1000, 1200, 1400, 2400,TitleDeedSquareColor.GREEN);
			}else if("Park Place".equals(name)) {
				return new TitleDeedSquare("Park Place", "dsc", 350, 35, 175, 500, 1100, 1300, 1500, 2500,TitleDeedSquareColor.DARK_BLUE);
			}else if("Boardwalk".equals(name)) {
				return new TitleDeedSquare("Boardwalk", "dsc", 400, 50, 200, 600, 1400, 1700, 2000, 3000,TitleDeedSquareColor.DARK_BLUE);
			}else if("Biscayne Avenue".equals(name)) {
				return new TitleDeedSquare("Biscayne Avenue","dsc", 150, 11, 55, 160, 475, 650, 800, 1300,TitleDeedSquareColor.BROWN);
			}else if("Miami Avenue".equals(name)) {
				return new TitleDeedSquare("Miami Avenue","dsc", 130, 9, 45, 120, 350, 500, 700, 1200,TitleDeedSquareColor.BROWN);
			}else if("Florida Avenue".equals(name)) {
				return new TitleDeedSquare("Florida Avenue","dsc", 130, 9, 45, 120, 350, 500, 700, 1200,TitleDeedSquareColor.BROWN);
			}else if("Lombard Street".equals(name)) {
				return new TitleDeedSquare("Lombard Street","dsc", 210, 17, 85, 240, 475, 670, 1025, 1525,TitleDeedSquareColor.WHITE);
			}else if("The Embarcadero".equals(name)) {
				return new TitleDeedSquare("The Embarcadero","dsc", 210, 17, 85, 240, 475, 670, 1025, 1525,TitleDeedSquareColor.WHITE);
			}else if("Fisherman's Wharf".equals(name)) {
				return new TitleDeedSquare("Fisherman's Wharf","dsc",  250, 21, 105, 320, 780, 950, 1125, 1625,TitleDeedSquareColor.WHITE);
			
			}else if(type == "Action Square") {
			if("Go".equals(name)) {
				return new Go("Go", description);

				
			}
	
		}
		}
		return null;


	}
		
}
