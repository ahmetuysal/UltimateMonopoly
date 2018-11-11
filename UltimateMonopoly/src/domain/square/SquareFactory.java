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
			if("Virginia Avenue".equals(name)) {
				return new TitleDeedSquare("Virginia Avenue", "dsc", 160, 12, 60, 80, 500, 700, 900, 1400,TitleDeedSquareColor.PINK);
			}else if("Meditteranian Avenue".equals(name)) {
				return new TitleDeedSquare("Meditteranian Avenue", "dsc", 60, 2, 10, 30, 90, 160, 250, 750,TitleDeedSquareColor.MAROON);
			}else if("Baltic Avenue".equals(name)) {
				return new TitleDeedSquare("Baltic Avenue", "dsc", 60, 4, 20, 60, 180, 320, 450, 900,TitleDeedSquareColor.MAROON);
			}else if("Oriental Avenue".equals(name)) {
				return new TitleDeedSquare("Oriental Avenue","dsc", 60, 4, 20, 60, 180, 320, 450, 900,TitleDeedSquareColor.MAROON);

			}
		}else if(type == "Action Square") {
			if("Go".equals(name)) {
				return new Go("Go", description);

			}
	
		}
		return null;


	}
}
