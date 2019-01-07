package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.square.Chance;
import domain.square.CommunityChest;
import domain.square.Location;
import domain.square.OwnableSquare;
import domain.square.Passable;
import domain.square.RailRoad;
import domain.square.Square;
import domain.square.SquareFactory;
import domain.square.TitleDeedSquare;
import domain.square.TitleDeedSquareColor;
import domain.square.UtilitySquare;
import domain.square.UtilitySquareType;

/**
 * Class that represents the real world board in the game.
 * 
 * @overview This class is used for adding squares, adding tokens, getting
 *           squares from their names moving player to another square,building
 *           hotels, houses and skyscrapers.
 * 
 * @author Team Pennybags
 *
 */

public class Board implements Serializable{

	private static final int FIRST_LAYER = 24;
	private static final int SECOND_LAYER = 40;
	private static final int THIRD_LAYER = 56;
	private static final int[] BOARD_SIZE = { FIRST_LAYER, SECOND_LAYER, THIRD_LAYER };

	private List<Square>[] squares;
	private List<Token> tokens;

	public static Location getStartLocation() {
		return new Location(1, 0);
	}

	public Board() {
		squares = (ArrayList<Square>[]) new ArrayList[3];
		squares[0] = new ArrayList<>();
		squares[1] = new ArrayList<>();
		squares[2] = new ArrayList<>();
		tokens = new ArrayList<>();
		addSquares();
	}

	/**
	 * @param token
	 *            Token to add the board.
	 */
	public void addToken(Token token) {
		tokens.add(token);
	}

	private void addSquares() {
		squares[0].add(SquareFactory.getSquare("Squeeze Play").setLocation(new Location(0, 0)));
		squares[0].add(SquareFactory.getSquare("The Embarcadero").setLocation(new Location(0, 1)));
		squares[0].add(SquareFactory.getSquare("Fisherman's Wharf").setLocation(new Location(0, 2)));
		squares[0].add(SquareFactory.getSquare("Telephone Company").setLocation(new Location(0, 3)));
		squares[0].add(SquareFactory.getSquare("Community Chest").setLocation(new Location(0, 4)));
		squares[0].add(SquareFactory.getSquare("Beacon Street").setLocation(new Location(0, 5)));
		squares[0].add(SquareFactory.getSquare("Bonus").setLocation(new Location(0, 6)));
		squares[0].add(SquareFactory.getSquare("Boylston Street").setLocation(new Location(0, 7)));
		squares[0].add(SquareFactory.getSquare("Newbury Street").setLocation(new Location(0, 8)));
		squares[0].add(SquareFactory.getSquare("Transit Station").setLocation(new Location(0, 9)));
		squares[0].add(SquareFactory.getSquare("Fifth Avenue").setLocation(new Location(0, 10)));
		squares[0].add(SquareFactory.getSquare("Madison Avenue").setLocation(new Location(0, 11)));
		squares[0].add(SquareFactory.getSquare("Stock Exchange").setLocation(new Location(0, 12)));
		squares[0].add(SquareFactory.getSquare("Wall Street").setLocation(new Location(0, 13)));
		squares[0].add(SquareFactory.getSquare("Tax Refund").setLocation(new Location(0, 14)));
		squares[0].add(SquareFactory.getSquare("Gas Company").setLocation(new Location(0, 15)));
		squares[0].add(SquareFactory.getSquare("Chance").setLocation(new Location(0, 16)));
		squares[0].add(SquareFactory.getSquare("Florida Avenue").setLocation(new Location(0, 17)));
		squares[0].add(SquareFactory.getSquare("Holland Tunnel").setLocation(new Location(0, 18)));
		squares[0].add(SquareFactory.getSquare("Miami Avenue").setLocation(new Location(0, 19)));
		squares[0].add(SquareFactory.getSquare("Biscayne Avenue").setLocation(new Location(0, 20)));
		squares[0].add(SquareFactory.getSquare("Transit Station").setLocation(new Location(0, 21)));
		squares[0].add(SquareFactory.getSquare("Reverse Direction").setLocation(new Location(0, 22)));
		squares[0].add(SquareFactory.getSquare("Lombard Street").setLocation(new Location(0, 23)));

		squares[1].add(SquareFactory.getSquare("Go").setLocation(new Location(1, 0)));
		squares[1].add(SquareFactory.getSquare("Meditteranian Avenue").setLocation(new Location(1, 1)));
		squares[1].add(SquareFactory.getSquare("Community Chest").setLocation(new Location(1, 2)));
		squares[1].add(SquareFactory.getSquare("Baltic Avenue").setLocation(new Location(1, 3)));
		squares[1].add(SquareFactory.getSquare("Income Tax").setLocation(new Location(1, 4)));
		squares[1].add(SquareFactory.getSquare("Transit Station").setLocation(new Location(1, 5)));
		squares[1].add(SquareFactory.getSquare("Oriental Avenue").setLocation(new Location(1, 6)));
		squares[1].add(SquareFactory.getSquare("Chance").setLocation(new Location(1, 7)));
		squares[1].add(SquareFactory.getSquare("Vermont Avenue").setLocation(new Location(1, 8)));
		squares[1].add(SquareFactory.getSquare("Connecticut Avenue").setLocation(new Location(1, 9)));
		squares[1].add(SquareFactory.getSquare("Jail").setLocation(new Location(1, 10)));
		squares[1].add(SquareFactory.getSquare("St.Charles Place").setLocation(new Location(1, 11)));
		squares[1].add(SquareFactory.getSquare("Electric Company").setLocation(new Location(1, 12)));
		squares[1].add(SquareFactory.getSquare("States Avenue").setLocation(new Location(1, 13)));
		squares[1].add(SquareFactory.getSquare("Virginia Avenue").setLocation(new Location(1, 14)));
		squares[1].add(SquareFactory.getSquare("Pennsylvania Railroad").setLocation(new Location(1, 15)));
		squares[1].add(SquareFactory.getSquare("St.James Place").setLocation(new Location(1, 16)));
		squares[1].add(SquareFactory.getSquare("Community Chest").setLocation(new Location(1, 17)));
		squares[1].add(SquareFactory.getSquare("Tennessee Avenue").setLocation(new Location(1, 18)));
		squares[1].add(SquareFactory.getSquare("New York Avenue").setLocation(new Location(1, 19)));
		squares[1].add(SquareFactory.getSquare("Free Parking").setLocation(new Location(1, 20)));
		squares[1].add(SquareFactory.getSquare("Kentucky Avenue").setLocation(new Location(1, 21)));
		squares[1].add(SquareFactory.getSquare("Chance").setLocation(new Location(1, 22)));
		squares[1].add(SquareFactory.getSquare("Indiana Avenue").setLocation(new Location(1, 23)));
		squares[1].add(SquareFactory.getSquare("Illinois Avenue").setLocation(new Location(1, 24)));
		squares[1].add(SquareFactory.getSquare("Transit Station").setLocation(new Location(1, 25)));
		squares[1].add(SquareFactory.getSquare("Atlantic Avenue").setLocation(new Location(1, 26)));
		squares[1].add(SquareFactory.getSquare("Ventnor Avenue").setLocation(new Location(1, 27)));
		squares[1].add(SquareFactory.getSquare("Water Works").setLocation(new Location(1, 28)));
		squares[1].add(SquareFactory.getSquare("Marvin Gardens").setLocation(new Location(1, 29)));
		squares[1].add(SquareFactory.getSquare("Roll Three").setLocation(new Location(1, 30)));
		squares[1].add(SquareFactory.getSquare("Pacific Avenue").setLocation(new Location(1, 31)));
		squares[1].add(SquareFactory.getSquare("North Carolina Avenue").setLocation(new Location(1, 32)));
		squares[1].add(SquareFactory.getSquare("Community Chest").setLocation(new Location(1, 33)));
		squares[1].add(SquareFactory.getSquare("Pennsylvania Avenue").setLocation(new Location(1, 34)));
		squares[1].add(SquareFactory.getSquare("Short Line").setLocation(new Location(1, 35)));
		squares[1].add(SquareFactory.getSquare("Chance").setLocation(new Location(1, 36)));
		squares[1].add(SquareFactory.getSquare("Park Place").setLocation(new Location(1, 37)));
		squares[1].add(SquareFactory.getSquare("Luxury Tax").setLocation(new Location(1, 38)));
		squares[1].add(SquareFactory.getSquare("Boardwalk").setLocation(new Location(1, 39)));

		squares[2].add(SquareFactory.getSquare("Subway").setLocation(new Location(2, 0)));
		squares[2].add(SquareFactory.getSquare("Lake Street").setLocation(new Location(2, 1)));
		squares[2].add(SquareFactory.getSquare("Community Chest").setLocation(new Location(2, 2)));
		squares[2].add(SquareFactory.getSquare("Nicollet Avenue").setLocation(new Location(2, 3)));
		squares[2].add(SquareFactory.getSquare("Hennepin Avenue").setLocation(new Location(2, 4)));
		squares[2].add(SquareFactory.getSquare("Bus Ticket").setLocation(new Location(2, 5)));
		squares[2].add(SquareFactory.getSquare("Checker Cab Co.").setLocation(new Location(2, 6)));
		squares[2].add(SquareFactory.getSquare("Reading Railroad").setLocation(new Location(2, 7)));
		squares[2].add(SquareFactory.getSquare("Esplanade Avenue").setLocation(new Location(2, 8)));
		squares[2].add(SquareFactory.getSquare("Canal Street").setLocation(new Location(2, 9)));
		squares[2].add(SquareFactory.getSquare("Chance").setLocation(new Location(2, 10)));
		squares[2].add(SquareFactory.getSquare("Cable Company").setLocation(new Location(2, 11)));
		squares[2].add(SquareFactory.getSquare("Magazine Street").setLocation(new Location(2, 12)));
		squares[2].add(SquareFactory.getSquare("Bourbon Street").setLocation(new Location(2, 13)));
		squares[2].add(SquareFactory.getSquare("Holland Tunnel").setLocation(new Location(2, 14)));
		squares[2].add(SquareFactory.getSquare("Auction").setLocation(new Location(2, 15)));
		squares[2].add(SquareFactory.getSquare("Katy Freeway").setLocation(new Location(2, 16)));
		squares[2].add(SquareFactory.getSquare("Westheimer Road").setLocation(new Location(2, 17)));
		squares[2].add(SquareFactory.getSquare("Internet Service Provider").setLocation(new Location(2, 18)));
		squares[2].add(SquareFactory.getSquare("Kirby Drive").setLocation(new Location(2, 19)));
		squares[2].add(SquareFactory.getSquare("Cullen Boulevard").setLocation(new Location(2, 20)));
		squares[2].add(SquareFactory.getSquare("Chance").setLocation(new Location(2, 21)));
		squares[2].add(SquareFactory.getSquare("Black & White Cab Co.").setLocation(new Location(2, 22)));
		squares[2].add(SquareFactory.getSquare("Dekalb Avenue").setLocation(new Location(2, 23)));
		squares[2].add(SquareFactory.getSquare("Community Chest").setLocation(new Location(2, 24)));
		squares[2].add(SquareFactory.getSquare("Andrew Young Intl Boulevard").setLocation(new Location(2, 25)));
		squares[2].add(SquareFactory.getSquare("Decatur Street").setLocation(new Location(2, 26)));
		squares[2].add(SquareFactory.getSquare("Peachtree Street").setLocation(new Location(2, 27)));
		squares[2].add(SquareFactory.getSquare("Pay Day").setLocation(new Location(2, 28)));
		squares[2].add(SquareFactory.getSquare("Randolph Street").setLocation(new Location(2, 29)));
		squares[2].add(SquareFactory.getSquare("Chance").setLocation(new Location(2, 30)));
		squares[2].add(SquareFactory.getSquare("Lake Shore Drive").setLocation(new Location(2, 31)));
		squares[2].add(SquareFactory.getSquare("Wacker Drive").setLocation(new Location(2, 32)));
		squares[2].add(SquareFactory.getSquare("Michigan Avenue").setLocation(new Location(2, 33)));
		squares[2].add(SquareFactory.getSquare("Yellow Cab Co.").setLocation(new Location(2, 34)));
		squares[2].add(SquareFactory.getSquare("B. & O. Railroad").setLocation(new Location(2, 35)));
		squares[2].add(SquareFactory.getSquare("Community Chest").setLocation(new Location(2, 36)));
		squares[2].add(SquareFactory.getSquare("South Temple").setLocation(new Location(2, 37)));
		squares[2].add(SquareFactory.getSquare("West Temple").setLocation(new Location(2, 38)));
		squares[2].add(SquareFactory.getSquare("Trash Collector").setLocation(new Location(2, 39)));
		squares[2].add(SquareFactory.getSquare("North Temple").setLocation(new Location(2, 40)));
		squares[2].add(SquareFactory.getSquare("Temple Square").setLocation(new Location(2, 41)));
		squares[2].add(SquareFactory.getSquare("Go To Jail").setLocation(new Location(2, 42)));
		squares[2].add(SquareFactory.getSquare("South Street").setLocation(new Location(2, 43)));
		squares[2].add(SquareFactory.getSquare("Broad Street").setLocation(new Location(2, 44)));
		squares[2].add(SquareFactory.getSquare("Walnut Street").setLocation(new Location(2, 45)));
		squares[2].add(SquareFactory.getSquare("Community Chest").setLocation(new Location(2, 46)));
		squares[2].add(SquareFactory.getSquare("Market Street").setLocation(new Location(2, 47)));
		squares[2].add(SquareFactory.getSquare("Bus Ticket").setLocation(new Location(2, 48)));
		squares[2].add(SquareFactory.getSquare("Sewage System").setLocation(new Location(2, 49)));
		squares[2].add(SquareFactory.getSquare("Ute Cab Co.").setLocation(new Location(2, 50)));
		squares[2].add(SquareFactory.getSquare("Birthday Gift").setLocation(new Location(2, 51)));
		squares[2].add(SquareFactory.getSquare("Mulholland Drive").setLocation(new Location(2, 52)));
		squares[2].add(SquareFactory.getSquare("Ventura Boulevard").setLocation(new Location(2, 53)));
		squares[2].add(SquareFactory.getSquare("Chance").setLocation(new Location(2, 54)));
		squares[2].add(SquareFactory.getSquare("Rodeo Drive").setLocation(new Location(2, 55)));
	}

	public static int getLayerSize(int layer) {
		return BOARD_SIZE[layer];
	}

	/**
	 * @param location
	 *            Location of the wanted square on the board.
	 * @return Square at the given location.
	 */
	public Square getSquare(Location location) {
		return squares[location.getLayer()].get(location.getIndex());
	}

	/**
	 * 
	 * @param name
	 *            Name of the square.
	 * 
	 * @requires name is not null
	 * @modifies nothing
	 * @effects if a square with name exists returns the location of the square,
	 *          null otherwise.
	 * 
	 * @return if a square with name exists returns the location of the square, null
	 *         otherwise.
	 */

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

	/*public void buildHouse(Player currentPlayer, int houseNum) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if (currentSquare instanceof TitleDeedSquare) {
			((TitleDeedSquare) currentSquare).buyHouse();
		}
	}*/
	
	public void buildHouse(Player currentPlayer) {
	Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
	if (currentSquare instanceof TitleDeedSquare) {
		((TitleDeedSquare) currentSquare).buyHouse();
		}
	}
	
	public boolean houseCheck(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if (currentSquare instanceof TitleDeedSquare) {
			if(((TitleDeedSquare) currentSquare).houseCheck())
				return true;
			}
		return false;
	}
	
	public void buildHotel(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if (currentSquare instanceof TitleDeedSquare) {
			((TitleDeedSquare) currentSquare).buyHotel();
		}
	}
	
	public boolean hotelCheck(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if (currentSquare instanceof TitleDeedSquare) {
			if(((TitleDeedSquare) currentSquare).hotelCheck())
				return true;
			}
		return false;
	}

	public void buildSkyscraper(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if (currentSquare instanceof TitleDeedSquare) {
			((TitleDeedSquare) currentSquare).buySkyScraper();
		}
	}
	
	public boolean skyscraperCheck(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if (currentSquare instanceof TitleDeedSquare) {
			if(((TitleDeedSquare) currentSquare).skyscraperCheck())
				return true;		
			}
		return false;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public boolean movePlayer(Player player, int distance) {
		Token token = player.getToken();
		int dx = player.isReverseDirection() ? -1 : 1;
		int numSquaresInLayer = 0;
		for (int i = 0; i < distance - 1; i++) {
			Location oldLoc = token.getLocation();
			numSquaresInLayer = Board.getLayerSize(oldLoc.getLayer());
			token.setLocation(
					new Location(oldLoc.getLayer(), (oldLoc.getIndex() + dx + numSquaresInLayer) % numSquaresInLayer));
			Square sq = getSquare(token.getLocation());
			if (sq instanceof Passable) {
				((Passable) sq).passBy(player);
			}
		}
		Location oldLoc = token.getLocation();
		numSquaresInLayer = Board.getLayerSize(oldLoc.getLayer());
		token.setLocation(
				new Location(oldLoc.getLayer(), (oldLoc.getIndex() + dx + numSquaresInLayer) % numSquaresInLayer));
		Square sq = getSquare(token.getLocation());
		sq.landOn(player);
		
		if(sq instanceof OwnableSquare) {
			if(!((OwnableSquare) sq).isOwned())
				return true;

		}
		return false;
	}

	public void moveToNextOwnedProperty(Player player) {
		Token token = player.getToken();
		int dx = player.isReverseDirection() ? -1 : 1;
		int numSquaresInLayer = 0;
		while (true) {
			Location oldLoc = token.getLocation();
			numSquaresInLayer = Board.getLayerSize(oldLoc.getLayer());
			token.setLocation(
					new Location(oldLoc.getLayer(), (oldLoc.getIndex() + dx + numSquaresInLayer) % numSquaresInLayer));
			Square sq = getSquare(token.getLocation());
			if (sq instanceof OwnableSquare && ((OwnableSquare) sq).isOwned()) {
				sq.landOn(player);
				break;
			}

			else if (sq instanceof Passable) {
				((Passable) sq).passBy(player);
			}
		}
	}

	/**
	 * 
	 * @param player
	 *            Player that will be moved to next unowned property.
	 * 
	 * @requires player is not null
	 * @modifies <b><tt>this</tt></b>, Token , Player
	 * @effects player's token is moved to the next unowned property according to
	 *          its current location
	 */

	public void moveToNextUnownedProperty(Player player) {
		Token token = player.getToken();
		int dx = player.isReverseDirection() ? -1 : 1;
		int numSquaresInLayer = 0;
		while (true) {
			Location oldLoc = token.getLocation();
			numSquaresInLayer = Board.getLayerSize(oldLoc.getLayer());
			token.setLocation(
					new Location(oldLoc.getLayer(), (oldLoc.getIndex() + dx + numSquaresInLayer) % numSquaresInLayer));

			Square sq = getSquare(token.getLocation());
			if (sq instanceof OwnableSquare && !((OwnableSquare) sq).isOwned()) {
				sq.landOn(player);
				break;
			}

			else if (sq instanceof Passable) {
				((Passable) sq).passBy(player);
			}
		}
	}

	/**
	 * 
	 * @param player
	 *            Player that will be moved to next chance or community chest
	 *            square.
	 * @requires player is not null
	 * @modifies <b><tt>this</tt></b>, Token , Player
	 * @effects player's token is moved to the next Chance or CommunityChest Square
	 *          according to its current location
	 */
	public void moveToNextChanceOrCommunityChestSquare(Player player) {
		Token token = player.getToken();
		int dx = player.isReverseDirection() ? -1 : 1;
		int numSquaresInLayer = 0;
		while (true) {
			Location oldLoc = token.getLocation();
			numSquaresInLayer = Board.getLayerSize(oldLoc.getLayer());
			token.setLocation(
					new Location(oldLoc.getLayer(), (oldLoc.getIndex() + dx + numSquaresInLayer) % numSquaresInLayer));

			Square sq = getSquare(token.getLocation());
			if (sq instanceof Chance || sq instanceof CommunityChest) {
				sq.landOn(player);
				break;
			}

			else if (sq instanceof Passable) {
				((Passable) sq).passBy(player);
			}
		}
	}

	public void moveToTransportationSquare(Player player) {
		Token token = player.getToken();
		int dx = player.isReverseDirection() ? -1 : 1;
		int numSquaresInLayer = 0;
		while (true) {
			Location oldLoc = token.getLocation();
			numSquaresInLayer = Board.getLayerSize(oldLoc.getLayer());
			token.setLocation(
					new Location(oldLoc.getLayer(), (oldLoc.getIndex() + dx + numSquaresInLayer) % numSquaresInLayer));

			Square sq = getSquare(token.getLocation());
			if (sq instanceof RailRoad || (sq instanceof UtilitySquare
					&& ((UtilitySquare) sq).getType() == UtilitySquareType.CAB_COMPANY)) {
				sq.landOn(player);
				break;
			}

			else if (sq instanceof Passable) {
				((Passable) sq).passBy(player);
			}
		}
	}
	
	public void teleport(Player player, Location location) {
		player.getToken().setLocation(location);
		getSquare(location).landOn(player);
	}

	/**
	 * @return the squares
	 */
	public List<Square>[] getSquares() {
		return squares;
	}

	@Override
	public String toString() {
		return "Board [squares=" + Arrays.toString(squares) + ", tokens=" + tokens + "]";
	}

	public boolean repOK() {
		if (squares.equals(null) || squares.length < 0)
			return false;
		if (tokens.equals(null) || tokens.size() < 0)
			return false;
		return true;

	}
	
	public static boolean isCornerSquare(Location loc) {
		if (loc.getLayer() == 0) {
			return loc.getIndex()%6 == 0;
		}
		else if (loc.getLayer() == 1) {
			return loc.getIndex() % 10 == 0;
		}
		else {
			return loc.getIndex() % 14 == 0;
		}
	}
	
	public List<Location> getAllOwnedTitleDeedLocations(){
		List<Location> locations = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < getLayerSize(i); j++) {
				Square currentSq = getSquare(new Location(i,j));
				if(currentSq instanceof TitleDeedSquare) {
					if (((TitleDeedSquare) currentSq).isOwned()) {
						locations.add(currentSq.getLocation());
					}
					
				}
			}
		}
		return locations;
	}

}
