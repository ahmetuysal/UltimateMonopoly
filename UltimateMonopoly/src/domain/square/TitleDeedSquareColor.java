package domain.square;

public enum TitleDeedSquareColor {
	PURPLE(2,50,50,50),
	LIGHT_BLUE(3,50,50,50),
	PINK(3,100,100,100),
	ORANGE(3,100,100,100),
	RED(3,150,150,150),
	YELLOW(3,150,150,150),
	GREEN(3,200,200,200),
	DARK_BLUE(2,200,200,200),
	BROWN(3,50,50,50),
	WHITE(3,100,100,100),
	BLACK(3,200,200,200),
	GRAY(3,300,300,300),
	LIGHT_PINK(3,50,50,50),
	LIGHT_GREEN(4,50,50,50),
	DARK_CYAN(4,100,100,100),
	MAROON(4,150,150,150),
	DARK_GOLD(4,200,200,200),
	SALMON(4,250,250,250),
	CLARET(3,300,300,300);
	
	
	

	private int numProperty;
	private int houseCostProperty;
	private int hotelCostProperty;
	private int skyScraperCostProperty;

	private TitleDeedSquareColor(int numProperty, int houseCostProperty, int hotelCostProperty, int skyScraperCostProperty) {
	    this.numProperty = numProperty;
	    this.houseCostProperty = houseCostProperty;
	    this.hotelCostProperty = hotelCostProperty;
	    this.skyScraperCostProperty = skyScraperCostProperty;
	  }

	public int numProperty() {
		return numProperty;
	}

	public int homePriceProperty() {
		return houseCostProperty;
	}

	public int hotelPriceProperty() {
		return hotelCostProperty;
	}
	
	public int skyScraperPriceProperty(){
		return skyScraperCostProperty;
	}
}
