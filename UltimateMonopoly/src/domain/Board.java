package domain;

import java.util.ArrayList;
import java.util.List;

import domain.square.Location;
import domain.square.Square;
import domain.square.SquareFactory;
import domain.square.TitleDeedSquare;
import domain.square.TitleDeedSquareColor;

public class Board {

	private static final int FIRST_LAYER = 24;
	private static final int SECOND_LAYER = 40;
	private static final int THIRD_LAYER = 56;
	private static final int[] BOARD_SIZE = { FIRST_LAYER, SECOND_LAYER, THIRD_LAYER };

	public static final Location START_LOCATION = new Location(1, 0);
	
	private List<Square>[] squares;
	private List<Token> tokens;

	public Board() {
		squares = (ArrayList<Square>[]) new ArrayList[3];
		squares[0] = new ArrayList<>();
		squares[1] = new ArrayList<>();
		squares[2] = new ArrayList<>();
		tokens = new ArrayList<>();
		addSquares();
	}

	/**
	 * 
	 * @param token
	 *            Token to add the board.
	 */
	public void addToken(Token token) {
		tokens.add(token);
	}

	public void addSquares() {
		squares[0].add(SquareFactory.getSquare("Squeeze Play"));
		squares[0].add(SquareFactory.getSquare("The Embarcadero"));
		squares[0].add(SquareFactory.getSquare("Fisherman's Wharf"));
		squares[0].add(SquareFactory.getSquare("Telephone Company"));
		squares[0].add(SquareFactory.getSquare("Community Chest"));
		squares[0].add(SquareFactory.getSquare("Beacon Street"));
		squares[0].add(SquareFactory.getSquare("Bonus"));
		squares[0].add(SquareFactory.getSquare("Boylston Street"));
		squares[0].add(SquareFactory.getSquare("Newbury Street"));
		squares[0].add(SquareFactory.getSquare("Transit Station"));
//		squares[0].add(SquareFactory.getSquare(str));
//		squares[0].add(SquareFactory.getSquare(str));
//		squares[0].add(SquareFactory.getSquare(str));
//		squares[0].add(SquareFactory.getSquare(str));
//		squares[0].add(SquareFactory.getSquare(str));
//		squares[0].add(SquareFactory.getSquare(str));
//		squares[0].add(SquareFactory.getSquare(str));
//		squares[0].add(SquareFactory.getSquare(str));
//		squares[0].add(SquareFactory.getSquare(str));


	}

	public static int getLayerSize(int layer) {
		return BOARD_SIZE[layer];
	}

	/**
	 * @param layer
	 *            layer of the wanted square, 0 is the outermost layer.
	 * @param location
	 *            Location(index) of the wanted square on the board.
	 * @return Square at the given location.
	 */
	public Square getSquare(Location loc) {
		return squares[loc.getLayer()].get(loc.getIndex());
	}

	public Location getSquareLocationFromName(String name) {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].size(); j++) {
				if (squares[i].get(j).getName().equals(name)) {
					return new Location(i, j);
				}
			}
		}
		return null;
	}
	
	public void buyTitleDeed(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if(currentSquare instanceof TitleDeedSquare) {
			if(!((TitleDeedSquare) currentSquare).isOwned()) {
				currentPlayer.addProperty((TitleDeedSquare) currentSquare);
				currentPlayer.decreaseMoney(((TitleDeedSquare) currentSquare).getPrice());
				((TitleDeedSquare) currentSquare).setOwner(currentPlayer);
				//TODO: ask for any extra implementation is needed??
			}
		}
	}
	
	public void buildHouse(Player currentPlayer, int houseNum) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if(currentSquare instanceof TitleDeedSquare) {
			if(houseNum > -1 && (!(houseNum + ((TitleDeedSquare) currentSquare).getNumHouses() < 1 || ((TitleDeedSquare) currentSquare).getNumHouses() + houseNum > 4))) {
				TitleDeedSquareColor color = ((TitleDeedSquare) currentSquare).getColor();
				int numProperty = color.numProperty(); 
				if(numProperty > 2 && currentPlayer.equals(((TitleDeedSquare) currentSquare).getOwner())) {
					if(numProperty == ((TitleDeedSquare) currentSquare).getOwner().getNumTitleDeedsWithColor(color)) {
						int housePrice = color.homePriceProperty();
						if(currentPlayer.getTotalMoney() > houseNum*housePrice) {
							currentPlayer.decreaseMoney(houseNum*housePrice);
							((TitleDeedSquare) currentSquare).setNumHouses(houseNum);
						}
					}
				}
			}
		}
	}
	
	
	
	public void buildHotel(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if(currentSquare instanceof TitleDeedSquare) {
			TitleDeedSquareColor color = ((TitleDeedSquare) currentSquare).getColor();
			int numProperty = color.numProperty(); 
			if(numProperty > 2 && currentPlayer.equals(((TitleDeedSquare) currentSquare).getOwner())) {
				if(numProperty == ((TitleDeedSquare) currentSquare).getOwner().getNumTitleDeedsWithColor(color)) {
					if(currentPlayer.houseCheckForHotelBuilding(color)) {					
						int hotelPrice = color.hotelPriceProperty();
						if(currentPlayer.getTotalMoney() > hotelPrice) {
							currentPlayer.decreaseMoney(hotelPrice);
							((TitleDeedSquare) currentSquare).setNumHotels(1);
							((TitleDeedSquare) currentSquare).setNumHouses(0);
						}
					}	
				}
			}
		}
	}


	public void buildSkyscraper(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if(currentSquare instanceof TitleDeedSquare) {
			TitleDeedSquareColor color = ((TitleDeedSquare) currentSquare).getColor();
			int numProperty = color.numProperty(); 
			if(numProperty > 2 && currentPlayer.equals(((TitleDeedSquare) currentSquare).getOwner())) {
				if(numProperty == ((TitleDeedSquare) currentSquare).getOwner().getNumTitleDeedsWithColor(color)) {
					if(currentPlayer.hotelCheckForSkyscraperBuilding(color)) {				
						int skyScraperPrice = color.skyScraperPriceProperty();
						if(currentPlayer.getTotalMoney() > skyScraperPrice) {
							currentPlayer.decreaseMoney(skyScraperPrice);
							((TitleDeedSquare) currentSquare).setNumSkyscrapers(1);
							((TitleDeedSquare) currentSquare).setNumHotels(0);
						}
					}
				}
			}
		}
	}
	
}
