package domain;

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

public class Board {

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
		squares[0].add(SquareFactory.getSquare("Fifth Avenue"));
		squares[0].add(SquareFactory.getSquare("Madison Avenue"));
		squares[0].add(SquareFactory.getSquare("Stock Exchange"));
		squares[0].add(SquareFactory.getSquare("Wall Street"));
		squares[0].add(SquareFactory.getSquare("Tax Refund"));
		squares[0].add(SquareFactory.getSquare("Gas Company"));
		squares[0].add(SquareFactory.getSquare("Chance"));
		squares[0].add(SquareFactory.getSquare("Florida Avenue"));
		squares[0].add(SquareFactory.getSquare("Holland Tunnel"));
		squares[0].add(SquareFactory.getSquare("Miami Avenue"));
		squares[0].add(SquareFactory.getSquare("Biscayne Avenue"));
		squares[0].add(SquareFactory.getSquare("Transit Station"));
		squares[0].add(SquareFactory.getSquare("Reverse Direction"));
		squares[0].add(SquareFactory.getSquare("Lombard Street"));

		squares[1].add(SquareFactory.getSquare("Go"));
		squares[1].add(SquareFactory.getSquare("Meditteranian Avenue"));
		squares[1].add(SquareFactory.getSquare("Community Chest"));
		squares[1].add(SquareFactory.getSquare("Baltic Avenue"));
		squares[1].add(SquareFactory.getSquare("Income Tax"));
		squares[1].add(SquareFactory.getSquare("Transit Station"));
		squares[1].add(SquareFactory.getSquare("Oriental Avenue"));
		squares[1].add(SquareFactory.getSquare("Chance"));
		squares[1].add(SquareFactory.getSquare("Vermont Avenue"));
		squares[1].add(SquareFactory.getSquare("Connecticut Avenue"));
		squares[1].add(SquareFactory.getSquare("Jail"));
		squares[1].add(SquareFactory.getSquare("St.Charles Place"));
		squares[1].add(SquareFactory.getSquare("Electric Company"));
		squares[1].add(SquareFactory.getSquare("States Avenue"));
		squares[1].add(SquareFactory.getSquare("Virginia Avenue"));
		squares[1].add(SquareFactory.getSquare("Pennsylvania Railroad"));
		squares[1].add(SquareFactory.getSquare("St.James Place"));
		squares[1].add(SquareFactory.getSquare("Community Chest"));
		squares[1].add(SquareFactory.getSquare("Tennessee Avenue"));
		squares[1].add(SquareFactory.getSquare("New York Avenue"));
		squares[1].add(SquareFactory.getSquare("Free Parking"));
		squares[1].add(SquareFactory.getSquare("Kentucky Avenue"));
		squares[1].add(SquareFactory.getSquare("Chance"));
		squares[1].add(SquareFactory.getSquare("Indiana Avenue"));
		squares[1].add(SquareFactory.getSquare("Illinois Avenue"));
		squares[1].add(SquareFactory.getSquare("Transit Station"));
		squares[1].add(SquareFactory.getSquare("Atlantic Avenue"));
		squares[1].add(SquareFactory.getSquare("Ventnor Avenue"));
		squares[1].add(SquareFactory.getSquare("Water Works"));
		squares[1].add(SquareFactory.getSquare("Marvin Gardens"));
		squares[1].add(SquareFactory.getSquare("Roll Three"));
		squares[1].add(SquareFactory.getSquare("Pacific Avenue"));
		squares[1].add(SquareFactory.getSquare("North Carolina Avenue"));
		squares[1].add(SquareFactory.getSquare("Community Chest"));
		squares[1].add(SquareFactory.getSquare("Pennsylvania Avenue"));
		squares[1].add(SquareFactory.getSquare("Short Line"));
		squares[1].add(SquareFactory.getSquare("Chance"));
		squares[1].add(SquareFactory.getSquare("Park Place"));
		squares[1].add(SquareFactory.getSquare("Luxury Tax"));
		squares[1].add(SquareFactory.getSquare("Boardwalk"));

		squares[2].add(SquareFactory.getSquare("Subway"));
		squares[2].add(SquareFactory.getSquare("Lake Street"));
		squares[2].add(SquareFactory.getSquare("Community Chest"));
		squares[2].add(SquareFactory.getSquare("Nicollet Avenue"));
		squares[2].add(SquareFactory.getSquare("Hennepin Avenue"));
		squares[2].add(SquareFactory.getSquare("Bus Ticket"));
		squares[2].add(SquareFactory.getSquare("Checker Cab Co."));
		squares[2].add(SquareFactory.getSquare("Reading Railroad"));
		squares[2].add(SquareFactory.getSquare("Esplanade Avenue"));
		squares[2].add(SquareFactory.getSquare("Canal Street"));
		squares[2].add(SquareFactory.getSquare("Chance"));
		squares[2].add(SquareFactory.getSquare("Cable Company"));
		squares[2].add(SquareFactory.getSquare("Magazine Street"));
		squares[2].add(SquareFactory.getSquare("Bourbon Street"));
		squares[2].add(SquareFactory.getSquare("Holland Tunnel"));
		squares[2].add(SquareFactory.getSquare("Auction"));
		squares[2].add(SquareFactory.getSquare("Katy Freeway"));
		squares[2].add(SquareFactory.getSquare("Westheimer Road"));
		squares[2].add(SquareFactory.getSquare("Internet Service Provider"));
		squares[2].add(SquareFactory.getSquare("Kirby Drive"));
		squares[2].add(SquareFactory.getSquare("Cullen Boulevard"));
		squares[2].add(SquareFactory.getSquare("Chance"));
		squares[2].add(SquareFactory.getSquare("Black & White Cab Co."));
		squares[2].add(SquareFactory.getSquare("Dekalb Avenue"));
		squares[2].add(SquareFactory.getSquare("Community Chest"));
		squares[2].add(SquareFactory.getSquare("Andrew Young Intl Boulevard"));
		squares[2].add(SquareFactory.getSquare("Decatur Street"));
		squares[2].add(SquareFactory.getSquare("Peachtree Street"));
		squares[2].add(SquareFactory.getSquare("Pay Day"));
		squares[2].add(SquareFactory.getSquare("Randolph Street"));
		squares[2].add(SquareFactory.getSquare("Chance"));
		squares[2].add(SquareFactory.getSquare("Lake Shore Drive"));
		squares[2].add(SquareFactory.getSquare("Wacker Drive"));
		squares[2].add(SquareFactory.getSquare("Michigan Avenue"));
		squares[2].add(SquareFactory.getSquare("Yellow Cab Co."));
		squares[2].add(SquareFactory.getSquare("B. & O. Railroad"));
		squares[2].add(SquareFactory.getSquare("Community Chest"));
		squares[2].add(SquareFactory.getSquare("South Temple"));
		squares[2].add(SquareFactory.getSquare("West Temple"));
		squares[2].add(SquareFactory.getSquare("Trash Collector"));
		squares[2].add(SquareFactory.getSquare("North Temple"));
		squares[2].add(SquareFactory.getSquare("Temple Square"));
		squares[2].add(SquareFactory.getSquare("Go To Jail"));
		squares[2].add(SquareFactory.getSquare("South Street"));
		squares[2].add(SquareFactory.getSquare("Broad Street"));
		squares[2].add(SquareFactory.getSquare("Walnut Street"));
		squares[2].add(SquareFactory.getSquare("Community Chest"));
		squares[2].add(SquareFactory.getSquare("Market Street"));
		squares[2].add(SquareFactory.getSquare("Bus Ticket"));
		squares[2].add(SquareFactory.getSquare("Sewage System"));
		squares[2].add(SquareFactory.getSquare("Ute Cab Co."));
		squares[2].add(SquareFactory.getSquare("Birthday Gift"));
		squares[2].add(SquareFactory.getSquare("Mulholland Drive"));
		squares[2].add(SquareFactory.getSquare("Ventura Boulevard"));
		squares[2].add(SquareFactory.getSquare("Chance"));
		squares[2].add(SquareFactory.getSquare("Rodeo Drive"));

		System.out.println(Arrays.toString(squares));
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
		System.out.println(name);
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].size(); j++) {
				System.out.println(i + " " + j);
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
	
	

	public void buildHotel(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if (currentSquare instanceof TitleDeedSquare) {
			((TitleDeedSquare) currentSquare).buyHotel();
		}
	}

	public void buildSkyscraper(Player currentPlayer) {
		Square currentSquare = this.getSquare(currentPlayer.getToken().getLocation());
		if (currentSquare instanceof TitleDeedSquare) {
			((TitleDeedSquare) currentSquare).buySkyScraper();
		}
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void movePlayer(Player player, int distance) {
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
		System.out.println("Token: " + token.toString());

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

}
